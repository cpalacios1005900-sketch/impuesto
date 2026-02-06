package com.cpalacios.impuesto.mapper;



import java.util.List;
import java.util.stream.Collectors;

import com.cpalacios.impuesto.dto.ImpuestoResponseDTO;
import com.cpalacios.impuesto.entity.ImpuestoEntity;

public final class ImpuestoMapper {



    public static ImpuestoResponseDTO toDto(ImpuestoEntity entity) {
        if (entity == null) {
            return null;
        }

        return ImpuestoResponseDTO.builder()
                .sticker(entity.getSticker())
                .fechaMovimiento(entity.getFechaMovimiento())
                .fechaRecaudo(entity.getFechaRecaudo())
                .tipoHorario(entity.getTipoHorario())
                .nroId(entity.getNroId())
                .nroForm(entity.getNroForm())
                .valor(entity.getValor())
                .build();
    }

    public static List<ImpuestoResponseDTO> toDtoList(List<ImpuestoEntity> entities) {
        return entities.stream()
                .map(ImpuestoMapper::toDto)
                .collect(Collectors.toList());
    }
}

