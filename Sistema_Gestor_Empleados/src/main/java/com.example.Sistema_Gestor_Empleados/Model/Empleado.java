package com.example.Sistema_Gestor_Empleados.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre completo es obligatorio")
  @Column(name = "nombre_completo", nullable = false)
  private String nombreCompleto;

  @NotBlank(message = "El puesto es obligatorio")
  @Column(nullable = false)
  private String puesto;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EstadoAsistencia estado = EstadoAsistencia.AUSENTE;

  public enum EstadoAsistencia {
    PRESENTE,
    AUSENTE
  }
}
