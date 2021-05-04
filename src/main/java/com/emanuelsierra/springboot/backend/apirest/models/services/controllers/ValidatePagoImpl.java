package com.emanuelsierra.springboot.backend.apirest.models.services.controllers;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;

@Service
public class ValidatePagoImpl implements IValidatePago {
	
	 
	 @Override
	    public Boolean validateFechaFormat(String fecha) {
	        Pattern pat = Pattern.compile("^([0][1-9]|[12][0-9]|3[01])(\\/)([0][1-9]|[1][0-2])\\2(\\d{4})");
	        Matcher mat = pat.matcher(fecha);
	        return mat.find();
	    }

	@Override
	public boolean validateDocumentoIdentificacionArrendatario(String id) {
		 
		try {
			Integer.parseInt(id);
			return false;
		} catch (NumberFormatException nfe){
			return true;
		}
	}
	
	@Override
	public boolean isNumberValorPagado(String number){ 
		try {
			Integer.parseInt(number);
			return false;
		} catch (NumberFormatException nfe){
			return true;
		}
	}

	@Override
	public Boolean validateCodigoInmueble(String codigo) {
		// TODO Auto-generated method stub
		 Pattern pat = Pattern.compile("^[0-9a-zA-Z]+$");
	        Matcher mat = pat.matcher(codigo);
	        return mat.find();
		
	}

	@Override
	public Boolean validateFecha(String fecha) {
		
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    sdf.setLenient(false);
		    return sdf.parse(fecha, new ParsePosition(0)) != null;
		
	}
	
	@Override
	public Boolean validateValorPagado(Double valor) {
	        return valor>=1 && valor <= 1000000.0;
	}
	
	

    @Override
    public Boolean validateDay(String fecha) {   	
        String[] fechaParts = fecha.split("/");
        int day = Integer.parseInt(fechaParts[0]);
        return (day%2==0);
    }

	
	@Override
	public String validateResponse(Pago pago) {
		 String response="";
	         if(pago.getDocumentoIdentificacionArrendatario() == null || pago.getCodigoInmueble() == null || pago.getValorPagado() == null || pago.getFechaPago()== null ){
	            response = "No puede haber campos nulos";
	            return response;
	        }else { 
	        	
	        if(validateDocumentoIdentificacionArrendatario(pago.getDocumentoIdentificacionArrendatario()))	{
	        	response = "El Documento de Identificacion Arrendatario debe ser solo numerico";
	        	return response;
	        }
	        
	        if(isNumberValorPagado(pago.getValorPagado())) {
	        	 response = "El valor pagado debe ser numerico";
	                return response;
	        }
	        	
	        
	        if(!validateCodigoInmueble(pago.getCodigoInmueble())){
	                response = "El codgigo Inmueble  debe ser Alfanumerico";
	                return response;
	        }

	        if(!validateFechaFormat(pago.getFechaPago())){
	            response = "Formato de fecha incorrecto";
	            return response;
	        }
	        
	        if(!validateFecha(pago.getFechaPago())) {
	        	 response = "La fecha no es valida";
	
	        }
	        
            else if(validateDay(pago.getFechaPago())){
	            response = "lo siento pero no se puede recibir el pago por decreto de administración";
	            return response;
	        }

	        if(!validateValorPagado(Double.parseDouble(pago.getValorPagado()))){
	            response = "El valor debe estar entre 1 y 1000000";
	            return response;
	        }
	        
	        }     

	        return response;	
		
		

	}
	


	

	


}
