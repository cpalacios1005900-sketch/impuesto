package com.cpalacios.impuesto.dto;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImpuestoResponseDTO {

    private Long sticker;
    private LocalDate fechaMovimiento;
    private LocalDate fechaRecaudo;
    private String tipoHorario;
    private BigDecimal nroId;
    private BigDecimal nroForm;
    private BigDecimal valor;
}
