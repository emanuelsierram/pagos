package com.emanuelsierra.springboot.backend.models.services.controllers;



import org.springframework.beans.factory.annotation.Autowired;


import com.emanuelsierra.springboot.backend.apirest.models.services.controllers.IValidatePago;


import static org.junit.jupiter.api.Assertions.*;


class ValidatePagoTest {

    @Autowired
    private IValidatePago validatePago;

    
    void testFechaCalendarValid() {
        int day = 16;
        int month = 10;
        int year = 2020;
        String fecha = day+"/"+month+"/"+year;
        Boolean isFechaValid = validatePago.validateFecha(fecha);
        assertTrue(isFechaValid);
    }
    
 
    void testFechaCalendarInvalid() {
        int day = 16;
        int month = 20;
        int year = 2020;
        String fecha = day+"/"+month+"/"+year;
        Boolean isFechaValid = validatePago.validateFecha(fecha);
        assertTrue(isFechaValid);
    }


   
    void testFechaFormatValid() {
        int day = 16;
        int month = 10;
        int year = 2020;
        String fecha = day+"/"+month+"/"+year;
        Boolean isFechaValid = validatePago.validateFechaFormat(fecha);
        assertFalse(isFechaValid);
    }

  
    void testFechaFormatInvalid() {
        int day = 25;
        int month = 10;
        int year = 2015;
        String fecha = day+"-"+month+"-"+year;
        Boolean isFechaFormatValid = validatePago.validateFechaFormat(fecha);
        assertTrue(isFechaFormatValid);
    }


    void testValuePagoValid() {
        Double pago = 500000.0;
        Boolean isValid = validatePago.validateValorPagado(pago);

        assertTrue(isValid);

    }
    

 
    void testValuePagoInvalid() {
        Double pago = 2000000.0;
        Boolean isValid = validatePago.validateValorPagado(pago);

        assertTrue(isValid);
        
        pago = 0.0;
        isValid = validatePago.validateValorPagado(pago);

        assertTrue(isValid);
        

    }
    

   
    void testAlphaNumeric() {
        String codigoInmuebleValid = "1322Aa";
        String codigoInmuebleInvalid2 = "245*as";
        assertTrue(validatePago.validateCodigoInmueble(codigoInmuebleValid));
        assertFalse(validatePago.validateCodigoInmueble(codigoInmuebleInvalid2));
    }
    
 
    void testNumeric() {
        String documentoIdentificacionValid = "12345";
        String documentoIdentificacionInvalid2 = "1236a";
        assertTrue(validatePago.validateDocumentoIdentificacionArrendatario(documentoIdentificacionValid));
        assertFalse(validatePago.validateDocumentoIdentificacionArrendatario(documentoIdentificacionInvalid2));
    }
    


    
    void testDayPair() {
      
        String fecha1 = "12/04/2020";
        String fecha2 = "12/04/2020";
        assertTrue(validatePago.validateDay(fecha1));
        assertFalse(validatePago.validateDay(fecha2));
    }


}