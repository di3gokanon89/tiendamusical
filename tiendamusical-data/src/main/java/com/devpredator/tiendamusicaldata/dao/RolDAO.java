/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Rol;

/**
 * @author DevPredator
 * Interface que contiene los metodos del CRUD con SPRING JPA para la tabla de rol.
 */
public interface RolDAO extends PagingAndSortingRepository<Rol, Long> {

}
