/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.entities.Artista;
import com.devpredator.tiendamusicalentities.entities.Genero;
import com.devpredator.tiendamusicalentities.entities.Nacionalidad;
import com.devpredator.tiendamusicalentities.entities.SubGenero;

/**
 * @author DevPredator.
 * Interface que contiene los metodos de logica de negocio para la administracion de artistas.
 */
public interface AdminArtistasService {
	/**
	 * Metodo que permite consultar la lista de artistas.
	 * @return {@link Artista} listado de artistas consultados.
	 */
	List<Artista> consultarArtistas();
	/**
	 * Metodo que permite consultar el listado de nacionalidades.
	 * @return {@link List} lista de nacionalidades consultadas.
	 */
	List<Nacionalidad> consultarNacionalidades();
	/**
	 * Metodo que permite consultar el listado de generos.
	 * @return {@link List} lista de generos consultados.
	 */
	List<Genero> consultarGeneros();
	/**
	 * Metodo que permite consultar el listado de subGeneros.
	 * @param idGenero {@link Long} identificador del genero seleccionado.
	 * @return {@link List} lista de subGeneros consultados.
	 */
	List<SubGenero> consultarSubGeneroPorGenero(Long idGenero);
	/**
	 * Metodo que permite guardar un artista en la base de datos.
	 * @param artista {@link Artista} objeto artista a guardar o actualizar.
	 * @return {@link Artista} artista guardado.
	 */
	Artista guardarArtista(Artista artista);
}
