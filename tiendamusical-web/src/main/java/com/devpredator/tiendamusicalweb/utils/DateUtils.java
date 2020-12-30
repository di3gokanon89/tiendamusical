/**
 * 
 */
package com.devpredator.tiendamusicalweb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DevPredator
 * Clase de utilerias para las fechas del proyecto.
 */
public class DateUtils {
	/**
	 * Metodo que permite convertir una fecha con formato en un string.
	 * @param formato {@link String} formato de fecha (EX: dd/MM/yyyy)
	 * @param fecha {@link Date} objeto con la fecha.
	 * @return {@link String} cadena de la fecha con formato.
	 */
	public static String convertDateToString(String formato, Date fecha) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);

		String fechaConvert = simpleDateFormat.format(fecha);
		
		return fechaConvert;
	}
}
