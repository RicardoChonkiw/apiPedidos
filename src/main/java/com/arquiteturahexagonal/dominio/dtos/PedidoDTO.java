package com.arquiteturahexagonal.dominio.dtos;

import com.arquiteturahexagonal.dominio.enums.StatusEnum;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PedidoDTO {
    private String cliente;
    private Integer[] produtos;

    public PedidoDTO(String cliente, Integer[] produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public String getCliente() {
        return cliente;
    }

    public Integer[] getProdutos() {
        return produtos;
    }

}
