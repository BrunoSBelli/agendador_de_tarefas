package com.raposo.AgendadorDeTarefas.infrastructure.business.mapper;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTO;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateDeTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
