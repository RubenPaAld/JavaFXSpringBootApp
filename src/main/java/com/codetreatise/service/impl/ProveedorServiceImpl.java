package com.codetreatise.service.impl;

import com.codetreatise.bean.Proveedor;
import com.codetreatise.repository.ProveedorRepository;
import com.codetreatise.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public Proveedor save(Proveedor entity) {
		return proveedorRepository.save(entity);
	}

	@Override
	public Proveedor update(Proveedor entity) {
		return proveedorRepository.save(entity);
	}

	@Override
	public void delete(Proveedor entity) {
		proveedorRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		proveedorRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Proveedor find(Long id) {
		return proveedorRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Proveedor> findAll() {
		return proveedorRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Proveedor> Proveedors) {
		proveedorRepository.deleteInBatch(Proveedors);
	}
	
}
