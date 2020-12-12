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

import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.InfoPersonalService;
import com.devpredator.tiendamusicalweb.session.SessionBean;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author DevPredator
 * Clase que controla el flujo de informacion de la pantalla de infopersonal del usuario.
 */
@ManagedBean
@ViewScoped
public class InfoPersonalController {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o
	 * en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(InfoPersonalController.class);
	/**
	 * Objeto que contiene la informacion en sesion de la persona.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	/**
	 * Objeto que contiene los metodos de logica de negocio de la informacion personal de la persona.
	 */
	@ManagedProperty("#{infoPersonalServiceImpl}")
	private InfoPersonalService infoPersonalServiceImpl;
	/**
	 * Inicializa la informacion de la pantalla.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Iniciando la pantalla de informacion personal...");
	}
	/**
	 * Metodo que permite actualizar la informacion de la persona en sesion.
	 */
	public void actualizarPersona() {
		Persona personaActualizada = this.infoPersonalServiceImpl.actualizarPersona(this.sessionBean.getPersona());
	
		if (personaActualizada != null) {
			this.sessionBean.setPersona(personaActualizada);
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "OK", "Tu información ha sido actualizada, vuelve a iniciar tu sesión para aplicar los cambios");
		}
	}
	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}
	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	/**
	 * @return the infoPersonalServiceImpl
	 */
	public InfoPersonalService getInfoPersonalServiceImpl() {
		return infoPersonalServiceImpl;
	}
	/**
	 * @param infoPersonalServiceImpl the infoPersonalServiceImpl to set
	 */
	public void setInfoPersonalServiceImpl(InfoPersonalService infoPersonalServiceImpl) {
		this.infoPersonalServiceImpl = infoPersonalServiceImpl;
	}
}
