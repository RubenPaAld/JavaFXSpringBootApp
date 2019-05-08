package com.codetreatise.service.impl;

import com.codetreatise.bean.TipoTransporte;
import com.codetreatise.repository.TipoTransporteRepository;
import com.codetreatise.service.TipoTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTransporteServiceImpl implements TipoTransporteService {

	@Autowired
	private TipoTransporteRepository tipoTransporteRepository;

	@Override
	public TipoTransporte save(TipoTransporte entity) {
		return tipoTransporteRepository.save(entity);
	}

	@Override
	public TipoTransporte update(TipoTransporte entity) {
		return tipoTransporteRepository.save(entity);
	}

	@Override
	public void delete(TipoTransporte entity) {
		tipoTransporteRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		tipoTransporteRepository.delete(Math.toIntExact(id));
	}

	@Override
	public TipoTransporte find(Long id) {
		return tipoTransporteRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<TipoTransporte> findAll() {
		return tipoTransporteRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<TipoTransporte> tipos) {
		tipoTransporteRepository.deleteInBatch(tipos);
	}
	
}
