package com.codetreatise.service.impl;

import com.codetreatise.bean.Cadena;
import com.codetreatise.bean.Color;
import com.codetreatise.repository.CadenaRepository;
import com.codetreatise.repository.ColorRepository;
import com.codetreatise.service.CadenaService;
import com.codetreatise.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Override
	public Color save(Color entity) {
		return colorRepository.save(entity);
	}

	@Override
	public Color update(Color entity) {
		return colorRepository.save(entity);
	}

	@Override
	public void delete(Color entity) {
		colorRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		colorRepository.delete(Math.toIntExact(id));
	}

	@Override
	public Color find(Long id) {
		return colorRepository.findOne(Math.toIntExact(id));
	}

	@Override
	public List<Color> findAll() {
		return colorRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Color> colores) {
		colorRepository.deleteInBatch(colores);
	}
	
}
