package com.arquiteturahexagonal.dominio.portas.interfaces;

import com.arquiteturahexagonal.dominio.Pedido;

public interface EnviaPedidoFilaPort {

    void send(Pedido pedido);
}
