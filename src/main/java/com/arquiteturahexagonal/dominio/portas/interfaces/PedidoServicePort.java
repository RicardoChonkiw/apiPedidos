package com.arquiteturahexagonal.dominio.portas.interfaces;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;

public interface PedidoServicePort {

    Pedido criarPedido(PedidoDTO pedidoDTO);

    StatusEnum consultaStatus(String codigo) ;
}
