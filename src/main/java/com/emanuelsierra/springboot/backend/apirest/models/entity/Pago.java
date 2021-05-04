package com.emanuelsierra.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pagos")
public class Pago implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@Column(nullable = false, length = 200)
	private String documentoIdentificacionArrendatario;
	@Column(nullable = false, unique = true, length = 190)
	private String codigoInmueble;
	@Column(nullable = false)
	private String valorPagado;
	@Column(nullable = false)
   // @Temporal(TemporalType.DATE)
	private String fechaPago;

	public String getDocumentoIdentificacionArrendatario() {
		return documentoIdentificacionArrendatario;
	}

	public void setDocumentoIdentificacionArrendatario(String documentoIdentificacionArrendatario) {
		this.documentoIdentificacionArrendatario = documentoIdentificacionArrendatario;
	}

	public String getCodigoInmueble() {
		return codigoInmueble;
	}

	public void setCodigoInmueble(String codigoInmueble) {
		this.codigoInmueble = codigoInmueble;
	}

	public String getValorPagado() {
		return valorPagado;
	}

	public void setValorPagado(String valorPagado) {
		this.valorPagado = valorPagado;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}



	
	
}
