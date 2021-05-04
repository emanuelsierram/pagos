package com.emanuelsierra.springboot.backend.apirest.models.services.repository;

import java.util.List;

import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;

public interface IPagoService {
	

public List<Pago> findAll();
public Pago save(Pago pago);	
public Pago findById(String id);

}
