package com.arquiteturahexagonal.infraestrutura.configuracao;

import com.arquiteturahexagonal.dominio.adaptadores.services.PedidoServiceImp;
import com.arquiteturahexagonal.dominio.portas.interfaces.PedidoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import com.arquiteturahexagonal.infraestrutura.adaptadores.producer.EnviaPedidoTransportadoraProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    PedidoServicePort pedidoService(PedidoRepositoryPort pedidoRepositoryPort, EnviaPedidoTransportadoraProducer enviaPedidoTransportadoraAdapter) {
        return new PedidoServiceImp(pedidoRepositoryPort,enviaPedidoTransportadoraAdapter);
    }
}