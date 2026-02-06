package com.cpalacios.impuesto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Table(name = "impuestos", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImpuestoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "sticker", nullable = false)
    private Long sticker;

    @NotNull
    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDate fechaMovimiento;

    @NotNull
    @Column(name = "fecha_recaudo", nullable = false)
    private LocalDate fechaRecaudo;

    @Size(max = 1)
    @Column(name = "tipo_horario", length = 1)
    private String tipoHorario;

    @Column(name = "nro_id", precision = 15, scale = 0)
    private BigDecimal nroId;

    @Column(name = "nro_form")
    private BigDecimal nroForm;

    @Column(name = "valor", precision = 15, scale = 0)
    private BigDecimal valor;
}