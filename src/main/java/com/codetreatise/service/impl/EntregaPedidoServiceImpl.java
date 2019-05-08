package com.codetreatise.service.impl;

import com.codetreatise.bean.EntregaPedido;
import com.codetreatise.repository.EntregaPedidoRepository;
import com.codetreatise.service.EntregaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaPedidoServiceImpl implements EntregaPedidoService {
	
	@Autowired
	private EntregaPedidoRepository entregaPedidoRepository;
	
	@Override
	public EntregaPedido save(EntregaPedido entity) {
		return entregaPedidoRepository.save(entity);
	}

	@Override
	public EntregaPedido update(EntregaPedido entity) {
		return entregaPedidoRepository.save(entity);
	}

	@Override
	public void delete(EntregaPedido entity) {
		entregaPedidoRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		entregaPedidoRepository.delete(Math.toIntExact(id));
	}

	@Override
	public EntregaPedido find(Long id) {
		return entregaPedidoRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<EntregaPedido> findAll() {
		return entregaPedidoRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<EntregaPedido> tipos) {
		entregaPedidoRepository.deleteInBatch(tipos);
	}
	
}
