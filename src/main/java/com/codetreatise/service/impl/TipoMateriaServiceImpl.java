package com.codetreatise.service.impl;

import com.codetreatise.bean.TipoMateria;
import com.codetreatise.repository.TipoMateriaRepository;
import com.codetreatise.service.TipoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMateriaServiceImpl implements TipoMateriaService {
	
	@Autowired
	private TipoMateriaRepository tipoMateriaRepository;
	
	@Override
	public TipoMateria save(TipoMateria entity) {
		return tipoMateriaRepository.save(entity);
	}

	@Override
	public TipoMateria update(TipoMateria entity) {
		return tipoMateriaRepository.save(entity);
	}

	@Override
	public void delete(TipoMateria entity) {
		tipoMateriaRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		tipoMateriaRepository.delete(Math.toIntExact(id));
	}

	@Override
	public TipoMateria find(Long id) {
		return tipoMateriaRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<TipoMateria> findAll() {
		return tipoMateriaRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<TipoMateria> tipos) {
		tipoMateriaRepository.deleteInBatch(tipos);
	}
	
}
