package com.arquiteturahexagonal.infraestrutura.adaptadores.consumer;

import com.arquiteturahexagonal.infraestrutura.adaptadores.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RecebePedidoConsumer {

    @Autowired
    private PedidoRepository pedidoRepository;

    @KafkaListener(topics = "tp-pedido-transportadora", groupId = "pedidos")
    public void receive(String codigo){
        pedidoRepository.atualizar(codigo);
    }
}
