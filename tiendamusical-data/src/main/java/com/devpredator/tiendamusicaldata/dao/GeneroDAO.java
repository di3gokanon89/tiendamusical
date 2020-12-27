/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Genero;

/**
 * @author DevPredator
 * DAO que contiene el CRUD para las transacciones con Spring JPA hacia la tabla de genero.
 */
public interface GeneroDAO extends PagingAndSortingRepository<Genero, Long> {

}
