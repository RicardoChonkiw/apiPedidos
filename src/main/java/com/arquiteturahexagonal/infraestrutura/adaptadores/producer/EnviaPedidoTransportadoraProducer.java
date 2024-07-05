package com.arquiteturahexagonal.infraestrutura.adaptadores.producer;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.portas.interfaces.EnviaPedidoFilaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviaPedidoTransportadoraProducer implements EnviaPedidoFilaPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(Pedido pedido) {
        kafkaTemplate.send("tp-pedido-transportadora", pedido.getCodigo());
    }
}
