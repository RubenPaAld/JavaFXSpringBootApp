package com.codetreatise.service.impl;

import com.codetreatise.bean.Campana;
import com.codetreatise.repository.CampanaRepository;
import com.codetreatise.service.CampanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampanaServiceImpl implements CampanaService {
	
	@Autowired
	private CampanaRepository CampanaRepository;
	
	@Override
	public Campana save(Campana entity) {
		return CampanaRepository.save(entity);
	}

	@Override
	public Campana update(Campana entity) {
		return CampanaRepository.save(entity);
	}

	@Override
	public void delete(Campana entity) {
		CampanaRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		CampanaRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Campana find(Long id) {
		return CampanaRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Campana> findAll() {
		return CampanaRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Campana> campanas) {
		CampanaRepository.deleteInBatch(campanas);
	}
	
}
