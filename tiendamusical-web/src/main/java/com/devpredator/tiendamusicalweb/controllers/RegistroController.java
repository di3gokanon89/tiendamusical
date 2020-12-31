/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tiendamusicalentities.entities.Carrito;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalentities.entities.Rol;
import com.devpredator.tiendamusicalservices.service.RegistroService;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author DevPredator
 * Clase que controla el flujo para el formulario de registro de personas.
 */
@ManagedBean
@ViewScoped
public class RegistroController {
	/**
	 * Objeto con la persona a registrarse.
	 */
	private Persona persona;
	/**
	 * Objeto que contiene los metodos de logica de negocio para el registro de usuarios.
	 */
	@ManagedProperty("#{registroServiceImpl}")
	private RegistroService registroServiceImpl;
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(RegistroController.class);
	/**
	 * Metodo que permite inicializar la pantalla de registro.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando pantalla de registro...");
		this.limpiarComponentes();
	}
	/**
	 * Metodo que permite limpiar o inicializar componentes.
	 */
	public void limpiarComponentes() {
		this.persona = new Persona();
		this.persona.setRol(new Rol());
		this.persona.setCarrito(new Carrito());
	}
	/**
	 * Metodo que permite guardar un nuevo usuario en el sistema.
	 */
	public void guardar() {
		Persona personaRegistrada = this.registroServiceImpl.registrarPersona(this.persona);
		
		if (personaRegistrada.getIdPersona() != null) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "OK!", "Te has registrado en el sistema exitósamente");
			this.limpiarComponentes();
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "Hubo un problema al registrarse, favor de intentarlo más tarde.");			
		}
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * @return the registroServiceImpl
	 */
	public RegistroService getRegistroServiceImpl() {
		return registroServiceImpl;
	}
	/**
	 * @param registroServiceImpl the registroServiceImpl to set
	 */
	public void setRegistroServiceImpl(RegistroService registroServiceImpl) {
		this.registroServiceImpl = registroServiceImpl;
	}
}