/**
 * 
 */
package com.devpredator.tiendamusicalentities.dto;

import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author DevPredator
 * Clase DTO para generar la grafica de Top Ten de Albums mas vendidos para el administrador.
 */
public class AlbumTopTenDTO {
	/**
	 * Objeto con la informacion del album del carrito.
	 */
	private CarritoAlbum carritoAlbum;
	/**
	 * Cantidad total vendida por album.
	 */
	private long cantidadSuma;
	
	/**
	 * Constructor default
	 */
	public AlbumTopTenDTO() {
		super();
	}
	/**
	 * Constructor que permite inicializar la informacion del objeto carritoAlbum y cantidadsumas del album.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con la informacion del album vendido.
	 * @param cantidadSuma {@link Integer} cantidad de suma total de albums vendidos.
	 */
	public AlbumTopTenDTO(CarritoAlbum carritoAlbum, long cantidadSuma) {
		this.carritoAlbum = carritoAlbum;
		this.cantidadSuma = cantidadSuma;
	}
	
	/**
	 * @return the carritoAlbum
	 */
	public CarritoAlbum getCarritoAlbum() {
		return carritoAlbum;
	}
	/**
	 * @param carritoAlbum the carritoAlbum to set
	 */
	public void setCarritoAlbum(CarritoAlbum carritoAlbum) {
		this.carritoAlbum = carritoAlbum;
	}
	/**
	 * @return the cantidadSuma
	 */
	public long getCantidadSuma() {
		return cantidadSuma;
	}
	/**
	 * @param cantidadSuma the cantidadSuma to set
	 */
	public void setCantidadSuma(long cantidadSuma) {
		this.cantidadSuma = cantidadSuma;
	}
}
