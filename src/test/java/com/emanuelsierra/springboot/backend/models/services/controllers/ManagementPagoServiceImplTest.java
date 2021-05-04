package com.emanuelsierra.springboot.backend.models.services.controllers;


import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;
import com.emanuelsierra.springboot.backend.apirest.models.services.controllers.IManagementPago;


import org.springframework.beans.factory.annotation.Autowired;



import static org.junit.jupiter.api.Assertions.*;


class ManagementPagoServiceImplTest {

    @Autowired
    private IManagementPago pagoService;


    
    void testPagoValidationsCuotaCompleto() {
        Pago pago =  new Pago();
 
        pago.setDocumentoIdentificacionArrendatario("12324");
        pago.setCodigoInmueble("123A");
        pago.setFechaPago("03/03/2021");
        pago.setValorPagado("1000000.0");

        String responseExpected = "gracias por pagar todo tu arriendo";
        String responseReceived = pagoService.pagoResponse(pago);


        assertEquals(responseExpected, responseReceived);
    }

    
    void testPagoValidationPagoParcial() {
    	  Pago pago =  new Pago();
    	  
          pago.setDocumentoIdentificacionArrendatario("123245");
          pago.setCodigoInmueble("123B");
          pago.setFechaPago("07/03/2021");
          pago.setValorPagado("800000");

          String responseExpected = "“gracias por tu abono, sin embargo recuerda que te hace falta pagar $ 200000.0";
          String responseReceived = pagoService.pagoResponse(pago);


          assertEquals(responseExpected, responseReceived);
    }

    
    void testPagoValidationPagoRestanteCompleto() {
    	 Pago pago =  new Pago();
   	  
         pago.setDocumentoIdentificacionArrendatario("123245");
         pago.setCodigoInmueble("123B");
         pago.setFechaPago("11/03/2021");
         pago.setValorPagado("200000");

         String responseExpected = "Gracias por pagar todo tu arriendo";
         String responseReceived = pagoService.pagoResponse(pago);
         assertEquals(responseExpected, responseReceived);

    }

}