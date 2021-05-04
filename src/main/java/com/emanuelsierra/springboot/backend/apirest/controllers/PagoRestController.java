package com.emanuelsierra.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;
import com.emanuelsierra.springboot.backend.apirest.models.services.controllers.IManagementPago;
import com.emanuelsierra.springboot.backend.apirest.models.services.controllers.IValidatePago;

@CrossOrigin(origins= {"http://localhost:4200"}) //Lista de dominios permitidos - ACCESO para enviar y recibir datos
@RestController
@RequestMapping("/api")
public class PagoRestController {

	
	@Autowired
	private IValidatePago validatePago;
	@Autowired
    private IManagementPago pagoManagementService;
	
	
	@GetMapping("/pagos")
public List<Pago> index(){
	return pagoManagementService.buscarPago();
	
}
	@Transactional
	@PostMapping("/pagos")
	public ResponseEntity<?> create( @RequestBody Pago pago) {
		Pago pagoNew=null;
		Map<String, Object> response = new HashMap<>();
		
		/*if(result.hasErrors()) {
		
		//Covertir el flujo a String y regresarlo a tipo list con el Collectors
		List<String> errors = result.getFieldErrors().stream().map(err -> "El campo "+err.getField()+" "+err.getCode()).collect(Collectors.toList());
		
		response.put("errors", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST); 
		}*/
		
		
		String message=validatePago.validateResponse(pago);
		
		if(message!="") {
			response.put("mensaje", message);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		else {	
			String messageExit= pagoManagementService.pagoResponse(pago);
			
			try {
				pagoNew = pagoManagementService.guardarPago(pago);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar el insert en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 		
			}	
		response.put("mensaje", messageExit);
		response.put("pago", pagoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
	}
	
	
	
	
}
