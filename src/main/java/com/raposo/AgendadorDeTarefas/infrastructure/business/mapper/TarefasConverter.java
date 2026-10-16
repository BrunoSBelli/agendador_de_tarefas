package com.raposo.AgendadorDeTarefas.infrastructure.business.mapper;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTO;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> dto);

    List<TarefasDTO> ParaListaTarefasDTO(List<TarefasEntity> entity);
}
