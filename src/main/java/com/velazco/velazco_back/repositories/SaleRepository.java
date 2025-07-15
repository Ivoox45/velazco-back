package com.velazco.velazco_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.velazco.velazco_back.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

  @Query("""
          SELECT s.cashier.id, s.cashier.name, COUNT(s.id) as ventas,
                 SUM(s.totalAmount) as monto,
                 COALESCE(AVG(s.totalAmount),0) as promedio
          FROM Sale s
          WHERE s.cashier.role.id = 2
          GROUP BY s.cashier.id, s.cashier.name
          ORDER BY monto DESC
      """)
  List<Object[]> findTopVendedores();
}