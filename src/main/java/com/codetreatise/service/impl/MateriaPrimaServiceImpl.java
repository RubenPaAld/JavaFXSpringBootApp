package com.codetreatise.service.impl;

import com.codetreatise.bean.MateriaPrima;
import com.codetreatise.repository.MateriaPrimaRepository;
import com.codetreatise.service.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaPrimaServiceImpl implements MateriaPrimaService {
	
	@Autowired
	private MateriaPrimaRepository materiaPrimaRepository;
	
	@Override
	public MateriaPrima save(MateriaPrima entity) {
		return materiaPrimaRepository.save(entity);
	}

	@Override
	public MateriaPrima update(MateriaPrima entity) {
		return materiaPrimaRepository.save(entity);
	}

	@Override
	public void delete(MateriaPrima entity) {
		materiaPrimaRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		materiaPrimaRepository.delete(Math.toIntExact(id));
	}

	@Override
	public MateriaPrima find(Long id) {
		return materiaPrimaRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<MateriaPrima> findAll() {
		return materiaPrimaRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<MateriaPrima> tipos) {
		materiaPrimaRepository.deleteInBatch(tipos);
	}
	
}
