/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.devpredator.tiendamusicalentities.entities.SubGenero;

/**
 * @author DevPredator
 * DAO que contiene el CRUD para las transacciones con Spring JPA hacia la tabla de subgenero.
 */
public interface SubGeneroDAO extends PagingAndSortingRepository<SubGenero, Long> {
	/**
	 * Metodo que permite consultar con SpringJPA los subgeneros de un genero seleccionado.
	 * @param idGenero {@link Long} identificador del genero.
	 * @return {@link List} lista de subgeneros consultados.
	 */
	@Query("SELECT sb FROM SubGenero sb WHERE sb.genero.idGenero = :idGenero")
	List<SubGenero> findAllByGenero(@Param("idGenero") Long idGenero);
}
