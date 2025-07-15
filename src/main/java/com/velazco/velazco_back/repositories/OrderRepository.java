package com.velazco.velazco_back.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.velazco.velazco_back.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

  @EntityGraph(attributePaths = { "details", "details.product", "attendedBy" })
  Page<Order> findByStatus(Order.OrderStatus status, Pageable pageable);

  List<Order> findByStatusAndDateBefore(Order.OrderStatus status, LocalDateTime date);

  @Query("""
      SELECT o FROM Order o
      WHERE o.status = :status
      AND (:orderId IS NULL OR o.id = :orderId)
      AND (:clientName IS NULL OR LOWER(o.clientName) LIKE LOWER(CONCAT('%', :clientName, '%')))
      """)
  Page<Order> findByStatusAndOptionalFilters(
      @Param("status") Order.OrderStatus status,
      @Param("orderId") Long orderId,
      @Param("clientName") String clientName,
      Pageable pageable);

  @Query("""
          SELECT
            DATE(o.date) AS saleDate,
            p.name AS productName,
            d.quantity AS quantity,
            d.unitPrice AS unitPrice,
            (d.quantity * d.unitPrice) AS subtotal,
            o.id AS orderId
          FROM Order o
          JOIN o.details d
          JOIN d.product p
          WHERE o.status = :status
      """)
  List<Object[]> findDetailedDeliveredSales(@Param("status") Order.OrderStatus status);

  @Query("""
          SELECT
            DATE(o.date) AS deliveryDate,
            o.id AS orderId,
            p.name AS productName,
            d.quantity AS quantity,
            d.unitPrice AS unitPrice,
            (d.quantity * d.unitPrice) AS subtotal
          FROM Order o
          JOIN o.details d
          JOIN d.product p
          WHERE o.status = :status
      """)
  List<Object[]> findDeliveredOrderDetailsForWeek(@Param("status") Order.OrderStatus status);

  @Query("""
          SELECT
              p.name,
              SUM(d.quantity),
              SUM(d.quantity * d.unitPrice)
          FROM Order o
          JOIN o.details d
          JOIN d.product p
          WHERE o.status = :status
            AND o.date BETWEEN :startOfMonth AND :endOfMonth
          GROUP BY p.name
          ORDER BY SUM(d.quantity) DESC
      """)
  List<Object[]> findTopSellingProductsOfMonth(
      @Param("status") Order.OrderStatus status,
      @Param("startOfMonth") LocalDateTime startOfMonth,
      @Param("endOfMonth") LocalDateTime endOfMonth);

  @Query("""
          SELECT o.attendedBy.id, o.attendedBy.name, COUNT(o.id) as ventas,
                 COALESCE(SUM(od.unitPrice * od.quantity),0) as monto
          FROM Order o
          JOIN o.details od
          WHERE o.attendedBy.role.id = 2
            AND o.status = 'ENTREGADO'
            AND MONTH(o.date) = MONTH(CURRENT_DATE)
            AND YEAR(o.date) = YEAR(CURRENT_DATE)
          GROUP BY o.attendedBy.id, o.attendedBy.name
          ORDER BY monto DESC
      """)
  List<Object[]> findTopVendedoresDelMes();

  @Query("""
          SELECT o.attendedBy.id, o.attendedBy.name,
                 COUNT(o.id) as ventas,
                 COALESCE(SUM(od.unitPrice * od.quantity), 0) as total
          FROM Order o
          JOIN o.details od
          WHERE o.attendedBy.role.id = 3
            AND o.status = 'ENTREGADO'
            AND MONTH(o.date) = MONTH(CURRENT_DATE)
            AND YEAR(o.date) = YEAR(CURRENT_DATE)
          GROUP BY o.attendedBy.id, o.attendedBy.name
          ORDER BY total DESC
      """)
  List<Object[]> findTopCajerosDelMes();

}
