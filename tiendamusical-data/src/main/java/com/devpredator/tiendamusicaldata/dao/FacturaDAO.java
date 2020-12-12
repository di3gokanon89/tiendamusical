/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Factura;
import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author DevPredator
 * Interface que define los metodos para realizar el CRUD de la tabla de factura.
 */
public interface FacturaDAO extends PagingAndSortingRepository<Factura, Long> {
	/**
	 * Metodo que permite consultar la lista de facturas de la persona que ha realizado compras.
	 * @param persona {@link Persona} objeto que contiene la persona en sesion.
	 * @return {@link Factura} lista de facturas de la persona.
	 */
	List<Factura> findAllByPersona(Persona persona);
}
