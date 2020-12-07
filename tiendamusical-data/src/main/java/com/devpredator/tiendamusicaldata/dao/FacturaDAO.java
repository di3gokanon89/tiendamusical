/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Factura;

/**
 * @author DevPredator
 * Interface que define los metodos para realizar el CRUD de la tabla de factura.
 */
public interface FacturaDAO extends PagingAndSortingRepository<Factura, Long> {

}
