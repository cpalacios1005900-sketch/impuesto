package com.cpalacios.impuesto.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cpalacios.impuesto.dto.ImpuestoResponseDTO;
import com.cpalacios.impuesto.exception.BusinessException;
import com.cpalacios.impuesto.mapper.ImpuestoMapper;
import com.cpalacios.impuesto.repository.ImpuestoRepository;
import com.cpalacios.impuesto.service.ImpuestoService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpuestoServiceImpl implements ImpuestoService {

	private final ImpuestoRepository impuestoRepository;

	@Override
	public List<ImpuestoResponseDTO> obtenerPorFechaMovimiento(LocalDate fechaMovimiento) {

		try {
			return ImpuestoMapper.toDtoList(impuestoRepository.findByFechaMovimiento(fechaMovimiento));
		} catch (Exception e) {
			throw new BusinessException("No se logro consultar las transacciones");
		}

	}
}