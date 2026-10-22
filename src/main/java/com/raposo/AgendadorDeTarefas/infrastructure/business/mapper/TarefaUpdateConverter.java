package com.raposo.AgendadorDeTarefas.infrastructure.business.mapper;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTORecord;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateDeTarefas(TarefasDTORecord dto, @MappingTarget TarefasEntity entity);
}
