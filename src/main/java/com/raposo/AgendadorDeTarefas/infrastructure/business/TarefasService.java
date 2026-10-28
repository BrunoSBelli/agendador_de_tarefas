package com.raposo.AgendadorDeTarefas.infrastructure.business;

import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTORecord;
import com.raposo.AgendadorDeTarefas.infrastructure.business.mapper.TarefaUpdateConverter;
import com.raposo.AgendadorDeTarefas.infrastructure.business.mapper.TarefasConverter;
import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import com.raposo.AgendadorDeTarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.raposo.AgendadorDeTarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.raposo.AgendadorDeTarefas.infrastructure.repository.TarefasRepository;
import com.raposo.AgendadorDeTarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final TarefaUpdateConverter tarefaUpdateConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTORecord gravarTarefa(String token, TarefasDTORecord dto) {

        String email = jwtUtil.extractUsername(token.substring(7));

        TarefasDTORecord dtoFinal = new TarefasDTORecord(null, dto.nomeTarefa(), dto.descricao(), LocalDateTime.now(), dto.dataEvento(), email, null, StatusNotificacaoEnum.PENDENTE);

        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dtoFinal);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }

    public List<TarefasDTORecord> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {

        return tarefaConverter.ParaListaTarefasDTORecord(
                tarefasRepository.findBydataEventoBetweenAndStatusNotificacaoEnum(dataInicial, dataFinal, StatusNotificacaoEnum.PENDENTE)
        );
    }

    public List<TarefasDTORecord> buscaTarefasAgendadasPorEmail(String token) {
        String email = jwtUtil.extractUsername(token.substring(7));

        return tarefaConverter.ParaListaTarefasDTORecord(
                tarefasRepository.findByEmailUsuario(email)
        );
    }

    public void deletaTarefaPorId(String id) {
        try {
            tarefasRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao deletar tarefa por id " + id, e.getCause());
        }
    }

    public TarefasDTORecord alteraStatus(StatusNotificacaoEnum status, String id) {

        try {

            TarefasEntity entity = tarefasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada! " + id));

            entity.setStatusNotificacaoEnum(status);
            return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado! " + id, e.getCause());
        }

    }

    public TarefasDTORecord alteraTarefa(String id, TarefasDTORecord dto) {

        try {

            TarefasEntity entity = tarefasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada! " + id));

            tarefaUpdateConverter.updateDeTarefas(dto, entity);

            return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado! " + id, e.getCause());
        }


    }

}
