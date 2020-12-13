/**
 * 
 */
package com.devpredator.tiendamusicalweb.enums;

/**
 * @author DevPredator
 * Enumeracion con los colores de la grafica del administrador.
 */
public enum ColorEnum {

	COLOR_ROJO(1, "rgba(255, 99, 132, 0.2)"),
	
	COLOR_AMARILLO(2, "rgba(255, 255, 0, 0.2)"),
	
	COLOR_VERDE(3, "rgba(52, 255, 51, 0.2)"),

	COLOR_MORADO(4, "rgba(87, 35, 100, 1.0)"),
	
	COLOR_AZUL(5, "rgba(51, 59, 255, 0.2)");
	
	private int valor;
	
	private String descripcion;

	ColorEnum(int valor, String descripcion) {
		this.valor = valor;
		this.descripcion = descripcion;
	}

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
