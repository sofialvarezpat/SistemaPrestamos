package com.example.prestamos.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Data
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id (PK)

    @NotBlank(message = "El responsable es obligatorio")
    private String responsable;

    @NotNull(message = "La fecha de préstamo es obligatoria")
    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "Debe prestar al menos 1 unidad") // Regla de negocio del documento
    private Integer cantidad;

    // Relación 1:N (herramienta_id FK): Muchos préstamos pertenecen a una herramienta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;
}
