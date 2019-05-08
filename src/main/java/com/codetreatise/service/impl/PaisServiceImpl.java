package com.codetreatise.service.impl;

import com.codetreatise.bean.Pais;
import com.codetreatise.repository.PaisRepository;
import com.codetreatise.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisRepository paisRepository;

	@Override
	public Pais save(Pais entity) {
		return paisRepository.save(entity);
	}

	@Override
	public Pais update(Pais entity) {
		return paisRepository.save(entity);
	}

	@Override
	public void delete(Pais entity) {
		paisRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		paisRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Pais find(Long id) {
		return paisRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Pais> Paiss) {
		paisRepository.deleteInBatch(Paiss);
	}
	
}
