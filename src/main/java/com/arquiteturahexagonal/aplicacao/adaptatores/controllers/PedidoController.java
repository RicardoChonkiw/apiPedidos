package com.arquiteturahexagonal.aplicacao.adaptatores.controllers;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;
import com.arquiteturahexagonal.dominio.portas.interfaces.PedidoServicePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    Pedido criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoServicePort.criarPedido(pedidoDTO);
    }

    @GetMapping(value = "/{codigo}")
    StatusEnum consultaStatus(@PathVariable String codigo) {
        return pedidoServicePort.consultaStatus(codigo);
    }
}