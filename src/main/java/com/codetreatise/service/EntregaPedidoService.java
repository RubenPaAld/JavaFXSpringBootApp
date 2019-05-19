package com.codetreatise.service;

import com.codetreatise.bean.EntregaPedido;
import com.codetreatise.bean.Pedido;
import com.codetreatise.bean.Tipo;
import com.codetreatise.generic.GenericService;

import java.util.List;

public interface EntregaPedidoService extends GenericService<EntregaPedido> {
    public List<EntregaPedido> getEntregas(Pedido pedido);
}
