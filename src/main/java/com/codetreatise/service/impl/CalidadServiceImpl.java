package com.codetreatise.service.impl;

import com.codetreatise.bean.Calidad;
import com.codetreatise.repository.CalidadRepository;
import com.codetreatise.service.CalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalidadServiceImpl implements CalidadService {
	
	@Autowired
	private CalidadRepository CalidadRepository;
	
	@Override
	public Calidad save(Calidad entity) {
		return CalidadRepository.save(entity);
	}

	@Override
	public Calidad update(Calidad entity) {
		return CalidadRepository.save(entity);
	}

	@Override
	public void delete(Calidad entity) {
		CalidadRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		CalidadRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Calidad find(Long id) {
		return CalidadRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Calidad> findAll() {
		return CalidadRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Calidad> Calidads) {
		CalidadRepository.deleteInBatch(Calidads);
	}
	
}
