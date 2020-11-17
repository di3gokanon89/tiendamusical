/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao.impl;

import java.util.List;

import com.devpredator.tiendamusicaldata.common.CommonDAO;
import com.devpredator.tiendamusicaldata.dao.ArtistaDAO;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Artista;

/**
 * @author DevPredator
 * Clase que implementa el CRUD Generico para realizar las transacciones a la tabla de artista.
 */
public class ArtistaDAOImpl extends CommonDAO<Artista, ArtistaDAO> {

	public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro) {
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}
}
