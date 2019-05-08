package com.codetreatise.service.impl;

import com.codetreatise.bean.Entrega;
import com.codetreatise.repository.EntregaRepository;
import com.codetreatise.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServiceImpl implements EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Override
	public Entrega save(Entrega entity) {
		return entregaRepository.save(entity);
	}

	@Override
	public Entrega update(Entrega entity) {
		return entregaRepository.save(entity);
	}

	@Override
	public void delete(Entrega entity) {
		entregaRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		entregaRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Entrega find(Long id) {
		return entregaRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Entrega> findAll() {
		return entregaRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Entrega> Entregas) {
		entregaRepository.deleteInBatch(Entregas);
	}
	
}
