package com.arquiteturahexagonal.dominio;

import com.arquiteturahexagonal.dominio.dtos.PedidoDTO;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String cliente;
    private Integer[] produtos;
    private StatusEnum status;

    public Pedido() {
    }

    public Pedido(String codigo, String cliente, Integer[] produtos, StatusEnum status) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = status;
    }

    public Pedido(PedidoDTO pedidoDTO) {
        this.cliente = pedidoDTO.getCliente();
        this.produtos = pedidoDTO.getProdutos();
    }

    public void consultaEstoque(StatusEnum status) {
        this.status = status;
    }

    public PedidoDTO toPedidoDTO() {
        return new PedidoDTO(this.cliente, this.produtos);
    }
}
