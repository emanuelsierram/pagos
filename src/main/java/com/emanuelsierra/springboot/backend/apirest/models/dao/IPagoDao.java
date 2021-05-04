package com.emanuelsierra.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.emanuelsierra.springboot.backend.apirest.models.entity.Pago;

public interface IPagoDao  extends CrudRepository<Pago, String>{

}
