package com.emanuelsierra.springboot.backend.apirest.models.services.controllers;

import java.util.List;

import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;

public interface IManagementPago {
	
	public Pago guardarPago(Pago pago);
	public String pagoResponse(Pago pago);
	public Double pagoTotal(Pago pago);
	public List<Pago> buscarPago();

}
