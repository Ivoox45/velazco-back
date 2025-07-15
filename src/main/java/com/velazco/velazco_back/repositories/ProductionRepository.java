package com.velazco.velazco_back.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.velazco.velazco_back.model.Production;

public interface ProductionRepository extends JpaRepository<Production, Long> {

  List<Production> findProductionsByProductionDate(LocalDate date);

  List<Production> findByStatusIn(List<Production.ProductionStatus> statuses);

  List<Production> findByStatus(Production.ProductionStatus status);

  boolean existsByProductionDate(LocalDate productionDate);

  @Query("""
          SELECT p.assignedTo.id, p.assignedTo.name, COUNT(p.id) as ordenes,
                 COALESCE(SUM(pd.producedQuantity), 0) as unidades,
                 COALESCE(AVG(
                   CASE WHEN pd.producedQuantity >= pd.requestedQuantity THEN 100.0
                        ELSE (pd.producedQuantity * 100.0 / NULLIF(pd.requestedQuantity,0)) END
                 ), 0) as eficiencia
          FROM Production p
          JOIN p.details pd
          WHERE p.status = 'COMPLETO' OR p.status = 'INCOMPLETO'
          GROUP BY p.assignedTo.id, p.assignedTo.name
          ORDER BY eficiencia DESC
      """)
  List<Object[]> findTopProductores();
}