package com.codetreatise.repository;

import com.codetreatise.bean.Calidad;
import com.codetreatise.bean.EntregaPedido;
import com.codetreatise.bean.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaPedidoRepository extends JpaRepository<EntregaPedido, Integer> {

    List<EntregaPedido> findByPedido(Pedido pedido);
}
