package com.codetreatise.repository;

import com.codetreatise.bean.EntregaPedido;
import com.codetreatise.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaPedidoRepository extends JpaRepository<EntregaPedido, Integer> {

}
