package com.raposo.AgendadorDeTarefas.infrastructure.business.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.raposo.AgendadorDeTarefas.infrastructure.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record TarefasDTORecord(

        String id,
        String nomeTarefa,
        String descricao,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime dataCriacao,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime dataEvento,
        String emailUsuario,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime dataAlteracao,
        StatusNotificacaoEnum statusNotificacaoEnum){

}



