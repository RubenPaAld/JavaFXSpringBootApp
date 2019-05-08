package com.codetreatise.service.impl;

import com.codetreatise.bean.Destino;
import com.codetreatise.repository.DestinoRepository;
import com.codetreatise.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoServiceImpl implements DestinoService {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@Override
	public Destino save(Destino entity) {
		return destinoRepository.save(entity);
	}

	@Override
	public Destino update(Destino entity) {
		return destinoRepository.save(entity);
	}

	@Override
	public void delete(Destino entity) {
		destinoRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		destinoRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Destino find(Long id) {
		return destinoRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Destino> findAll() {
		return destinoRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Destino> destinos) {
		destinoRepository.deleteInBatch(destinos);
	}
	
}
