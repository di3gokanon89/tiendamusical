/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.entities.Factura;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.paypal.orders.Order;

/**
 * @author DevPredator
 * Interface que define los metodos de logica de negocio para la generacion de la factura.
 */
public interface FacturaService {
	/**
	 * Metodo que permite generar la factura de compra del pedido del cliente.
	 * @param factura {@link Factura} objeto con la informacion de la factura generada.
	 * @param order {@link Order} objeto con la orden generada por PayPal.
	 * @param persona {@link Persona} objeto con la informacion de la persona a la que se le asigna la factura.
	 */
	Factura guardarFactura(Factura factura, Order order, Persona persona);
	/**
	 * Metodo que permite consultar las facturas de la persona
	 * @param persona {@link Persona} objeto que contiene la persona en sesion.
	 * @return {@link Factura} lista de facturas de la persona.
	 */
	List<Factura> consultarFacturasPersona(Persona persona);
}
