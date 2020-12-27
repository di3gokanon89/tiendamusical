/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Nacionalidad;

/**
 * @author DevPredator
 * DAO que contiene el CRUD para las transacciones con Spring JPA hacia la tabla de nacionalidad.
 */
public interface NacionalidadDAO extends PagingAndSortingRepository<Nacionalidad, Long> {

}
