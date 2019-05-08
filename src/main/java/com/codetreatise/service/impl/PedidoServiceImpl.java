package com.codetreatise.service.impl;

import com.codetreatise.bean.Pedido;
import com.codetreatise.repository.PedidoRepository;
import com.codetreatise.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido save(Pedido entity) {
		return pedidoRepository.save(entity);
	}

	@Override
	public Pedido update(Pedido entity) {
		return pedidoRepository.save(entity);
	}

	@Override
	public void delete(Pedido entity) {
		pedidoRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		pedidoRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Pedido find(Long id) {
		return pedidoRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Pedido> tipos) {
		pedidoRepository.deleteInBatch(tipos);
	}
	
}
