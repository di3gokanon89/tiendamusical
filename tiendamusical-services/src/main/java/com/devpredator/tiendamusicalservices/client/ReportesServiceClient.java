/**
 * 
 */
package com.devpredator.tiendamusicalservices.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author DevPredator
 * Clase cliente que consume el webservice de reportes.
 */
@Service
public class ReportesServiceClient {
	
	@Value("${spring.base.url.ws.reportes}")
	String urlReportesWS;
	/**
	 * Metodo que permite consumir el webservice para generar el reporte jasper.
	 * @param orderID {@link String} orden de compra del cliente.
	 * @param destinatario {@link String} correo o email del cliente.
	 * @param cliente {@link String} nombre completo del cliente.
	 * @return {@link Response} respuesta generada por el webservice.
	 */
	public Response generarReporte(String orderID, String destinatario, String cliente) {
		ClientConfig clientConfig = new ClientConfig();
		
		Client client = ClientBuilder.newClient(clientConfig);
		
		WebTarget webTarget = client.target(this.urlReportesWS).path("generarReporte");
		
		Form form = new Form();
		form.param("orderID", orderID);
		form.param("cliente", cliente);
		form.param("destinatario", destinatario);
		
		Response response = webTarget.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), Response.class);
		
		return response;
	}
}
