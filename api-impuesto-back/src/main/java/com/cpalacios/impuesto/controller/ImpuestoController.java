package com.cpalacios.impuesto.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cpalacios.impuesto.dto.ImpuestoResponseDTO;
import com.cpalacios.impuesto.service.ImpuestoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/impuestos")
@RequiredArgsConstructor
public class ImpuestoController {

    private final ImpuestoService impuestoService;

    @GetMapping
    public ResponseEntity<List<ImpuestoResponseDTO>> consultarPorFechaMovimiento(
    		@DateTimeFormat(pattern = "dd/MM/yyyy")
            LocalDate fechaMovimiento) {

        return ResponseEntity.ok(
                impuestoService.obtenerPorFechaMovimiento(fechaMovimiento)
        );
    }
}
