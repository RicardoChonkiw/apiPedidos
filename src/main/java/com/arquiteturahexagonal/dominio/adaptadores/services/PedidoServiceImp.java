package com.arquiteturahexagonal.dominio.adaptadores.services;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;
import com.arquiteturahexagonal.dominio.portas.interfaces.PedidoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import com.arquiteturahexagonal.infraestrutura.adaptadores.producer.EnviaPedidoTransportadoraProducer;
import org.bson.types.ObjectId;

public class PedidoServiceImp implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepository;
    private final EnviaPedidoTransportadoraProducer enviaPedidoTransportadoraAdapter;

    public PedidoServiceImp(PedidoRepositoryPort pedidoRepository, EnviaPedidoTransportadoraProducer enviaPedidoTransportadoraAdapter) {
        this.pedidoRepository = pedidoRepository;
        this.enviaPedidoTransportadoraAdapter = enviaPedidoTransportadoraAdapter;
    }

    @Override
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        var pedido = new Pedido(new ObjectId().toString(),pedidoDTO.getCliente(),pedidoDTO.getProdutos(),StatusEnum.AGUARDANDO_ENVIO);
        pedidoRepository.salvar(pedido);
        enviaPedidoTransportadoraAdapter.send(pedido);
        return pedido;
    }

    @Override
    public StatusEnum consultaStatus(String codigo)  {
        return this.pedidoRepository.buscarPeloCodigo(codigo);
    }
}