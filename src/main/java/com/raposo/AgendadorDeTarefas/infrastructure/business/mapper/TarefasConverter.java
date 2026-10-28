package com.raposo.AgendadorDeTarefas.infrastructure.business.mapper;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTORecord;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTORecord dto);

    TarefasDTORecord paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTORecord> dto);

    List<TarefasDTORecord> ParaListaTarefasDTORecord(List<TarefasEntity> entity);
}
