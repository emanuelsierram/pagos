package com.emanuelsierra.springboot.backend.apirest.models.services.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanuelsierra.springboot.backend.apirest.models.dao.IPagoDao;
import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;

@Service
public class PagoServiceImpl implements IPagoService {

	@Autowired //Injectar el PagoDao
	private IPagoDao pagoDao;

	@Override
	@Transactional(readOnly = true) //Lectura
	
	public List<Pago> findAll() {
		return (List<Pago>) pagoDao.findAll();
	}
	
	@Override
	@Transactional
	public Pago save(Pago pago) {	
		return pagoDao.save(pago);
	}
	
	@Override
	@Transactional(readOnly = true) //Lectura
	public Pago findById(String id) {
		return pagoDao.findById(id).orElse(null);
	}
	
	
}
