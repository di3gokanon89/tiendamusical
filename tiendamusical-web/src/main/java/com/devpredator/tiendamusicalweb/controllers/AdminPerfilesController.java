/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;

import com.devpredator.tiendamusicalentities.entities.Rol;
import com.devpredator.tiendamusicalservices.service.AdminPerfilesService;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author DevPredator
 * Clase que controla el flujo de informacion de la pantalla de administracion de perfiles.
 */
@ManagedBean
@ViewScoped
public class AdminPerfilesController {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o
	 * en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(AdminPerfilesController.class);
	/**
	 * Perfiles a mostrar en el datatable.
	 */
	private List<Rol> perfiles;
	/**
	 * Perfiles filtrados del datatable.
	 */
	private List<Rol> perfilesFiltrados;
	/**
	 * Objeto con el perfil o rol a actualizar o guardar.
	 */
	private Rol perfil;
	/**
	 * Objeto que contiene los metodos de logica de negocio para la administracion de perfiles.
	 */
	@ManagedProperty("#{adminPerfilesServiceImpl}")
	private AdminPerfilesService adminPerfilesServiceImpl;
	
	/**
	 * Inicializando pantalla de administracion de perfiles.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando la pantalla de perfiles...");
		this.consultar();
		this.limpiarComponentes();
	}
	/**
	 * Metodo que permite consultar el listado de perfiles para el datatable
	 */
	public void consultar() {
		LOGGER.info("Consultando perfiles de la base de datos...");
		this.perfiles = this.adminPerfilesServiceImpl.consultarPerfiles();
	}
	/**
	 * Metodo que permite limpiar los componentes de la pantalla.
	 */
	public void limpiarComponentes() {
		this.perfil = new Rol();
	}
	/**
	 * Metodo que permite guardar un perfil.
	 */
	public void guardar() {
		Rol rolGuardado = this.adminPerfilesServiceImpl.guardarPerfil(this.perfil);
		
		if (rolGuardado.getIdRol() != null) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "OK!", "Perfil guardado/actualizado exitósamente");
			
			this.consultar();
			PrimeFaces.current().executeScript("PF('dlgPerfil').hide()");
			
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "Hubo un error al tratar de guardar o actualizar el perfil, favor de intentarlo más tarde.");
		}
	}
	/**
	 * Metodo que permite cargar el perfil seleccionado del datatable para actualizar.
	 * @param perfil {@link Rol} perfil seleccionado.
	 */
	public void cargarPerfil(Rol perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the perfiles
	 */
	public List<Rol> getPerfiles() {
		return perfiles;
	}

	/**
	 * @param perfiles the perfiles to set
	 */
	public void setPerfiles(List<Rol> perfiles) {
		this.perfiles = perfiles;
	}

	/**
	 * @return the perfilesFiltrados
	 */
	public List<Rol> getPerfilesFiltrados() {
		return perfilesFiltrados;
	}

	/**
	 * @param perfilesFiltrados the perfilesFiltrados to set
	 */
	public void setPerfilesFiltrados(List<Rol> perfilesFiltrados) {
		this.perfilesFiltrados = perfilesFiltrados;
	}

	/**
	 * @return the adminPerfilesServiceImpl
	 */
	public AdminPerfilesService getAdminPerfilesServiceImpl() {
		return adminPerfilesServiceImpl;
	}

	/**
	 * @param adminPerfilesServiceImpl the adminPerfilesServiceImpl to set
	 */
	public void setAdminPerfilesServiceImpl(AdminPerfilesService adminPerfilesServiceImpl) {
		this.adminPerfilesServiceImpl = adminPerfilesServiceImpl;
	}
	/**
	 * @return the perfil
	 */
	public Rol getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Rol perfil) {
		this.perfil = perfil;
	}
}
