package com.arquiteturahexagonal.infraestrutura.adaptadores.repositories;

import com.arquiteturahexagonal.infraestrutura.adaptadores.entidades.PedidoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SpringPedidoRepository extends MongoRepository<PedidoEntity, String> {
}
