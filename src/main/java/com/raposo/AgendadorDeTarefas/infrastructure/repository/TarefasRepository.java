package com.raposo.AgendadorDeTarefas.infrastructure.repository;

import com.raposo.AgendadorDeTarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {



}
