/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author DevPredator
 * Clase que controla el flujo para cambiar de pantalla.
 */
@ManagedBean
@ViewScoped
public class PaginaController {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(PaginaController.class);
	
	/**
	 * Inicializa la carga del controlador de paginas.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando controlador de Pagina Controller...");
	}
	/**
	 * Metodo que permite redireccionar entre pantallas del aplicativo
	 * @param pagina {@link String} pagina a ingresar.
	 */
	public void redireccionarPagina(String pagina) {
		try {
			CommonUtils.redireccionar(pagina);
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Hubo un error al cambiar a la pantalla de " + pagina);
			e.printStackTrace();
		}
	}
}
