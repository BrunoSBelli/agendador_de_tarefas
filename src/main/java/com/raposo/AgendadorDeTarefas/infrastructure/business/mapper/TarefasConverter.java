package com.raposo.AgendadorDeTarefas.infrastructure.business.mapper;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTO;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
