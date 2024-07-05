package com.arquiteturahexagonal.infraestrutura.adaptadores.entidades;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Setter
public class PedidoEntity {

    @Id
    private String id;
    private String cliente;
    private Integer[] produtos;
    private StatusEnum status;

    public PedidoEntity() {
    }

    public PedidoEntity(Pedido pedido) {
        this.id = pedido.getCodigo();
        this.cliente = pedido.getCliente();
        this.produtos = pedido.getProdutos();
        this.status = pedido.getStatus();
    }

}
