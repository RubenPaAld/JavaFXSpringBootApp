package com.codetreatise.service.impl;

import com.codetreatise.bean.Cadena;
import com.codetreatise.repository.CadenaRepository;
import com.codetreatise.service.CadenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadenaServiceImpl implements CadenaService {
	
	@Autowired
	private CadenaRepository cadenaRepository;
	
	@Override
	public Cadena save(Cadena entity) {
		return cadenaRepository.save(entity);
	}

	@Override
	public Cadena update(Cadena entity) {
		return cadenaRepository.save(entity);
	}

	@Override
	public void delete(Cadena entity) {
		cadenaRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		cadenaRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Cadena find(Long id) {
		return cadenaRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Cadena> findAll() {
		return cadenaRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Cadena> cadenas) {
		cadenaRepository.deleteInBatch(cadenas);
	}
	
}
