/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author DevPredator
 * Interface que contiene los metodos de la logica de negocio para la pantalla de informacion
 * personal.
 */
public interface InfoPersonalService {
	/**
	 * Metodo que permite actualizar la informacion personal del usuario en sesion.
	 * @param persona {@link Persona} objeto que contiene la informacion del usuario en sesion.
	 * @return {@link Persona} persona actualizada
	 */
	Persona actualizarPersona(Persona persona);
}
