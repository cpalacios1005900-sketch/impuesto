package com.cpalacios.impuesto.service;



import java.time.LocalDate;
import java.util.List;

import com.cpalacios.impuesto.dto.ImpuestoResponseDTO;


public interface ImpuestoService {

	List<ImpuestoResponseDTO> obtenerPorFechaMovimiento(LocalDate fechaMovimiento);
}
