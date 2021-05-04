package com.emanuelsierra.springboot.backend.apirest.models.services.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;
import com.emanuelsierra.springboot.backend.apirest.models.services.repository.IPagoService;
@Service
public class ManagementPagoServiceImpl implements IManagementPago{

	@Autowired 
	private IPagoService pagoService;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Pago> buscarPago() {
		return pagoService.findAll();
	}

	
	@Override
	@Transactional
	public Double pagoTotal(Pago pago) {
		Pago actualPago=pagoService.findById(pago.getDocumentoIdentificacionArrendatario());
		Double abono=Double.parseDouble(pago.getValorPagado());
		if(actualPago!= null){
			 if(Double.parseDouble(pago.getValorPagado())<1000000.0) {
				 abono = Double.parseDouble(pago.getValorPagado())+Double.parseDouble(actualPago.getValorPagado());
				 return abono;
		        }
			 else return 1000000.0;     
		}
        else
        	return abono;
              		
	}
	@Override
	@Transactional
	public Pago guardarPago(Pago pago) {
		// TODO Auto-generated method stub	
		Double valorPago=pagoTotal(pago);
		if(valorPago<=1000000.0)
		pago.setValorPagado(Double.toString(valorPago));
		else
			pago.setValorPagado("1000000.0");
		
		return pagoService.save(pago);
	}
	

	@Override
	
	public String pagoResponse(Pago pago) {	 
		String response = "";
		if(pagoTotal(pago)==1000000.0)
			response = "gracias por pagar todo tu arriendo";
	    else if(pagoTotal(pago)>1000000.0)
	    	response = "gracias por pagar todo tu arriendo, se decuelven $ ".concat(Double.toString(pagoTotal(pago)-1000000.0));
	    else
	    	response = "gracias por tu abono, sin embargo, recuerda que te hace falta pagar $ ".concat(Double.toString(1000000.0-pagoTotal(pago)));
		
		return response;
	}
	
	
	
	
	
	

}
