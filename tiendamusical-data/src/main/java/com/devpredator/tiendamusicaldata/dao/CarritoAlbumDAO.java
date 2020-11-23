/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author DevPredator
 * Interface que implementa los metodos genericos para el CRUD con SPRING JPA hacia la tabla de carrito_album
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {

}