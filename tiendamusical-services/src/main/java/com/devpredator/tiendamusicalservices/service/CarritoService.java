/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Carrito;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalentities.entities.Factura;

/**
 * @author DevPredator
 * Interface que define los metodos de logica de negocio para el carrito de compras.
 */
public interface CarritoService {
	/**
	 * Metodo que permite guardar los albums a comprar en el carrito de compras.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con la informacion del album en el carrito.
	 * @param carrito {@link Carrito} objeto con la informacion del carrito del usuario.
	 * @param cantidadAlbumSeleccionada {@link Integer} cantidad seleccionada del album por el usuario.
	 */
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada);
	/**
	 * Metodo que permite calcular el total de la compra.
	 * @param carrito {@link Carrito} objeto con la informacion del carrito a calcular.
	 * @return {@link Float} total calculado.
 	 */
	float calcularTotal(Carrito carrito);
	/**
	 * Metodo que permite eliminar un album del carrito.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album del carrito a eliminar.
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	/**
	 * Metodo que permite actualizar la cantidad del album a comprar en el carrito.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album a actualizar en el carrito.
	 * @param carrito {@link Carrito} objeto con el carrito de compras del usuario.
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
	/**
	 * Metodo que permite actualizar los registros de los productos comprados por el cliente agregandoles la orden de compra
	 * y actualizando su estatus a PAGADO.
	 * @param carritoAlbums {@link List} lista de productos en el carrito a actualizar.
	 * @param factura {@link Factura} objeto con la factura y la orden de compra.
	 * @return {@link Boolean} estatus de la actualizacion del carrito.
	 */
	boolean actualizarCarritoAlbum(List<CarritoAlbum> carritoAlbums, Factura factura);
}
