/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.dto.AlbumTopTenDTO;

/**
 * @author DevPredator
 * Interface que contiene los metodos de la logica de negocio de los albums.
 */
public interface AlbumService {
	/**
	 * Metodo que permite consultar la lista de albums en el top ten de mas vendidos.
	 * @return {@link List} lista de top ten albums vendidos
	 */
	List<AlbumTopTenDTO> consultarAlbumsTopTen();
}
