/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.PersonaDAO;
import com.devpredator.tiendamusicalentities.entities.Factura;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.FacturaService;
import com.devpredator.tiendamusicalservices.service.InfoPersonalService;
import com.paypal.orders.Order;

/**
 * @author DevPredator
 * Clase que implementa los metodos de la logica de negocio de informacion personal
 */
@Service
public class InfoPersonalServiceImpl implements InfoPersonalService {

	@Autowired
	private PersonaDAO personaDAOImpl;
	
	@Override
	public Persona actualizarPersona(Persona persona) {
		persona.setFechaActualizacion(LocalDateTime.now());
		
		return this.personaDAOImpl.save(persona);
	}


}
