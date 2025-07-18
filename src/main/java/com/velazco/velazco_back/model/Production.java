package com.velazco.velazco_back.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produccion", indexes = @Index(name = "idx_fecha_produccion", columnList = "fecha_produccion"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Production {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fecha_produccion", nullable = false)
  private LocalDate productionDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado", nullable = false, length = 20)
  private ProductionStatus status;

  @ManyToOne
  @JoinColumn(name = "asignado_por", nullable = false)
  private User assignedBy;

  @ManyToOne
  @JoinColumn(name = "asignado_a", nullable = false)
  private User assignedTo;

  @Column(name = "comentarios", columnDefinition = "TEXT")
  private String comments;

  @OneToMany(mappedBy = "production", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REMOVE }, orphanRemoval = true)
  private List<ProductionDetail> details;

  public static enum ProductionStatus {
    PENDIENTE, EN_PROCESO, COMPLETO, INCOMPLETO
  }
}
