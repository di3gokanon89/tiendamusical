/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author DevPredator
 * Interface que contiene los metodos de logica de negocio para el registro de usuarios en tienda musical.
 */
public interface RegistroService {
	/**
	 * Metodo que permite registrar a una persona en el sistema.
	 * @param persona {@link Persona} objeto con la persona a registrarse.
	 * @return {@link Persona} objeto persona registrada.
	 */
	Persona registrarPersona(Persona persona);
}
