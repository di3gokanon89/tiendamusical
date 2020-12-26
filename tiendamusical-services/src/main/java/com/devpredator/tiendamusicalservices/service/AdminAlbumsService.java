/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.entities.Album;
import com.devpredator.tiendamusicalentities.entities.Artista;
import com.devpredator.tiendamusicalentities.entities.Disquera;

/**
 * @author DevPredator
 * Interface que permite realiza la logica de negocio para la administracion de albums.
 */
public interface AdminAlbumsService {
	/**
	 * Metodo que permite consultar el catalogo de disqueras.
	 * @return {@link List} lista de disqueras
	 */
	List<Disquera> consultarDisqueras();
	/**
	 * Metodo que permite consultar el catalogo de artistas.
	 * @return {@link List} lista de artistas
	 */
	List<Artista> consultarArtistas();
	/**
	 * Metodo que permite guardar un album.
	 * @param album {@link Album} objeto a guardar el album.
	 * @return {@link Album} album guardado.
	 */
	Album guardarAlbum(Album album);
	
}
