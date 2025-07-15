package com.velazco.velazco_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.velazco.velazco_back.model.Dispatch;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
  @Query("""
          SELECT d.dispatchedBy.id, d.dispatchedBy.name, COUNT(d.id) as entregas,
                 COALESCE(AVG(CASE WHEN d.deliveryDate <= o.date THEN 100.0 ELSE 80.0 END), 0) as puntualidad,
                 COALESCE(SUM(od.quantity), 0) as distancia
          FROM Dispatch d
          JOIN d.order o
          JOIN o.details od
          GROUP BY d.dispatchedBy.id, d.dispatchedBy.name
          ORDER BY entregas DESC
      """)
  List<Object[]> findTopEntregadores();
}