package com.raposo.AgendadorDeTarefas.infrastructure.controller;


import com.raposo.AgendadorDeTarefas.infrastructure.business.DTO.TarefasDTO;
import com.raposo.AgendadorDeTarefas.infrastructure.business.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasControlller {


    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto, @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

}
