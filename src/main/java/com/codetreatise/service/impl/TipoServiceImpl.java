package com.codetreatise.service.impl;

import com.codetreatise.bean.Tipo;
import com.codetreatise.repository.TipoRepository;
import com.codetreatise.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public Tipo save(Tipo entity) {
		return tipoRepository.save(entity);
	}

	@Override
	public Tipo update(Tipo entity) {
		return tipoRepository.save(entity);
	}

	@Override
	public void delete(Tipo entity) {
		tipoRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		tipoRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Tipo find(Long id) {
		return tipoRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Tipo> findAll() {
		return tipoRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Tipo> tipos) {
		tipoRepository.deleteInBatch(tipos);
	}
	
}
