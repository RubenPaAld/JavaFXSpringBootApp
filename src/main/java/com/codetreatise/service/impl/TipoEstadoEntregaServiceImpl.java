package com.codetreatise.service.impl;

import com.codetreatise.bean.TipoEstadoEntrega;
import com.codetreatise.repository.TipoEstadoEntregaRepository;
import com.codetreatise.service.TipoEstadoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEstadoEntregaServiceImpl implements TipoEstadoEntregaService {

	@Autowired
	private TipoEstadoEntregaRepository tipoEstadoEntregaRepository;

	@Override
	public TipoEstadoEntrega save(TipoEstadoEntrega entity) {
		return tipoEstadoEntregaRepository.save(entity);
	}

	@Override
	public TipoEstadoEntrega update(TipoEstadoEntrega entity) {
		return tipoEstadoEntregaRepository.save(entity);
	}

	@Override
	public void delete(TipoEstadoEntrega entity) {
		tipoEstadoEntregaRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		tipoEstadoEntregaRepository.delete(Math.toIntExact(id));
	}

	@Override
	public TipoEstadoEntrega find(Long id) {
		return tipoEstadoEntregaRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<TipoEstadoEntrega> findAll() {
		return tipoEstadoEntregaRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<TipoEstadoEntrega> tipos) {
		tipoEstadoEntregaRepository.deleteInBatch(tipos);
	}
	
}
