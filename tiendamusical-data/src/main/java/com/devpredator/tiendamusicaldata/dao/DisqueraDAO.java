/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.devpredator.tiendamusicalentities.entities.Disquera;

/**
 * @author DevPredator
 * Clase que representa el DAO para el CRUD hacia la tabla de disqueras.
 */
public interface DisqueraDAO extends PagingAndSortingRepository<Disquera, Long> {

}
