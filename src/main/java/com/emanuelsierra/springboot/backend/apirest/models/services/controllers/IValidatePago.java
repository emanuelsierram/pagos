package com.emanuelsierra.springboot.backend.apirest.models.services.controllers;


import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;

public interface IValidatePago {
	
	
	public Boolean validateFechaFormat(String fecha);
	public boolean validateDocumentoIdentificacionArrendatario(String id);
	boolean isNumberValorPagado(String number);
	public Boolean validateCodigoInmueble(String codigo);
	public Boolean validateFecha(String fecha);
	public Boolean validateValorPagado(Double valor);
	public Boolean validateDay(String fecha); 
    public String validateResponse(Pago pago);

}
