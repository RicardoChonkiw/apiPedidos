package com.arquiteturahexagonal.infraestrutura.adaptadores.repositories;

import com.arquiteturahexagonal.dominio.Pedido;
import com.arquiteturahexagonal.dominio.enums.StatusEnum;
import com.arquiteturahexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import com.arquiteturahexagonal.infraestrutura.adaptadores.entidades.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepository implements PedidoRepositoryPort {

    @Autowired
    private SpringPedidoRepository springPedidoRepository;

    @Override
    public StatusEnum buscarPeloCodigo(String codigo) {
        var pedidoEntity = springPedidoRepository.findById(codigo);

        if (pedidoEntity.isPresent())
            return pedidoEntity.get().getStatus();

        throw new RuntimeException("Pedido não existe");

    }

    @Override
    public void salvar(Pedido pedido) {
        PedidoEntity pedidoEntity;
        pedidoEntity = new PedidoEntity(pedido);
        this.springPedidoRepository.insert(pedidoEntity);
    }

    @Override
    public void atualizar(String codigo) {
        var pedidoEntity = springPedidoRepository.findById(codigo);
        pedidoEntity.get().setStatus(StatusEnum.ENVIADO_TRANSPORTADORA);
        springPedidoRepository.save(pedidoEntity.get());
    }
}
