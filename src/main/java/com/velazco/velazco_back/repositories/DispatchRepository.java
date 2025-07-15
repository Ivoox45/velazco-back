package com.velazco.velazco_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.velazco.velazco_back.model.Dispatch;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
  @Query("""
          SELECT d.dispatchedBy.id, d.dispatchedBy.name, COUNT(d.id) as entregas
          FROM Dispatch d
          WHERE d.dispatchedBy.role.id = 5
          GROUP BY d.dispatchedBy.id, d.dispatchedBy.name
          ORDER BY entregas DESC
      """)
  List<Object[]> findTopEntregadores();

}