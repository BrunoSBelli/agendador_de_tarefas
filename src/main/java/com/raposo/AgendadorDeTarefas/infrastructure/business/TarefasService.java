package com.raposo.AgendadorDeTarefas.infrastructure.business;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTO;
import com.raposo.AgendadorDeTarefas.infrastructure.business.mapper.TarefasConverter;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import com.raposo.AgendadorDeTarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.raposo.AgendadorDeTarefas.infrastructure.repository.TarefasRepository;
import com.raposo.AgendadorDeTarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){

        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);

        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);


        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
