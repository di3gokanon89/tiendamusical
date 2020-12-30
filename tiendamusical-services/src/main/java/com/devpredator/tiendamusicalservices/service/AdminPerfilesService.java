/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.entities.Rol;

/**
 * @author DevPredator
 * Interface que contiene los metodos de logica de negocio para la pantalla de administracion de perfiles.
 */
public interface AdminPerfilesService {
	/**
	 * Metodo que permite consultar la lista de perfiles.
	 * @return {@link List} perfiles consultados.
	 */
	List<Rol> consultarPerfiles();
	/**
	 * Metodo que permite guardar un perfil.
	 * @param rol {@link Rol} objeto con el rol o perfil a guardar.
	 * @return {@link Rol} perfil o rol obtenido despues del guardado.
	 */
	Rol guardarPerfil(Rol rol);
}
