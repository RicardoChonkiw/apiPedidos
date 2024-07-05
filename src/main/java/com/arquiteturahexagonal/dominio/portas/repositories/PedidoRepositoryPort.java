package com.arquiteturahexagonal.dominio.portas.repositories;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;

public interface PedidoRepositoryPort {

    StatusEnum buscarPeloCodigo(String codigo);

    void salvar(Pedido pedido);

    void atualizar(String codigo);
}
