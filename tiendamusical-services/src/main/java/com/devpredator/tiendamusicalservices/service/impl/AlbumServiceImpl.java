/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.AlbumDAO;
import com.devpredator.tiendamusicalentities.dto.AlbumTopTenDTO;
import com.devpredator.tiendamusicalservices.service.AlbumService;

/**
 * @author DevPredator
 * Clase que implementa los metodos del contrato para la logica de negocio de albums.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDAO albumDAO;
	
	@Override
	public List<AlbumTopTenDTO> consultarAlbumsTopTen() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<AlbumTopTenDTO> page = this.albumDAO.consultarAlbumsTopTen(pageable);
		return page.getContent();
	}

}
