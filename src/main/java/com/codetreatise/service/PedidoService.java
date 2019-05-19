package com.codetreatise.service;

import com.codetreatise.bean.*;
import com.codetreatise.generic.GenericService;
import com.codetreatise.parameters.EntregaParameters;
import com.codetreatise.parameters.PedidoParameters;
import com.codetreatise.utils.Constantes;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService extends GenericService<Pedido> {

    List<Pedido> findByCriteria(PedidoParameters p, EntregaParameters e);
}
