/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.ArtistaDAO;
import com.devpredator.tiendamusicaldata.dao.GeneroDAO;
import com.devpredator.tiendamusicaldata.dao.NacionalidadDAO;
import com.devpredator.tiendamusicaldata.dao.SubGeneroDAO;
import com.devpredator.tiendamusicalentities.entities.Artista;
import com.devpredator.tiendamusicalentities.entities.Genero;
import com.devpredator.tiendamusicalentities.entities.Nacionalidad;
import com.devpredator.tiendamusicalentities.entities.SubGenero;
import com.devpredator.tiendamusicalservices.service.AdminArtistasService;

/**
 * @author DevPredator
 * Clase que implementa los metodos de la logica de negocio para la administracion de artistas.
 */
@Service
public class AdminArtistasServiceImpl implements AdminArtistasService {

	@Autowired
	private ArtistaDAO artistaDAO;
	
	@Autowired
	private NacionalidadDAO nacionalidadDAO;
	
	@Autowired
	private GeneroDAO generoDAO;
	
	@Autowired
	private SubGeneroDAO subGeneroDAO;
	
	@Override
	public List<Artista> consultarArtistas() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("nombre"));
		Page<Artista> page = this.artistaDAO.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<Nacionalidad> consultarNacionalidades() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("descripcion"));
		Page<Nacionalidad> page = this.nacionalidadDAO.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<Genero> consultarGeneros() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("descripcion"));
		Page<Genero> page = this.generoDAO.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<SubGenero> consultarSubGeneroPorGenero(Long idGenero) {
		return this.subGeneroDAO.findAllByGenero(idGenero);
	}

	@Override
	public Artista guardarArtista(Artista artista) {

		if (artista.getIdArtista() != null) {
			artista.setFechaActualizacion(LocalDateTime.now());
		} else {
			artista.setFechaCreacion(LocalDateTime.now());
			artista.setEstatus(true);
		}
	
		return this.artistaDAO.save(artista);
	}
	

}
