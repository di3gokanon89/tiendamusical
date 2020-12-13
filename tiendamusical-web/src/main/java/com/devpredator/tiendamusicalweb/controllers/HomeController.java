/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

import com.devpredator.tiendamusicalentities.dto.AlbumTopTenDTO;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.AlbumService;
import com.devpredator.tiendamusicalservices.service.CarritoService;
import com.devpredator.tiendamusicalservices.service.HomeService;
import com.devpredator.tiendamusicalweb.enums.ColorEnum;
import com.devpredator.tiendamusicalweb.session.SessionBean;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author DevPredator
 * Clase que contrala el flujo de informacion para la pantalla de home de cualquier tipo de usuario.
 */
@ManagedBean
@ViewScoped
public class HomeController {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	
	/**
	 * Texto ingresado por el cliente en el buscador.
	 */
	private String filtro;
	/**
	 * Lista obtenida a partir del filtro ingresado en el buscador.
	 */
	private List<ArtistaAlbumDTO> artistasAlbumDTO;
	/**
	 * Se inyecta el objeto de spring con jsf para obtener los metodos de logica de negocio del home.
	 */
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	/**
	 * Se inyecta el objeto de spring con jsf para obtener los metodos de logica de negocio del carrito.
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	/**
	 * Objeto que almacena informacion en sesion.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	/**
	 * Objeto que permitira generar el modelo para mostrar la grafica del albums top ten vendidos.
	 */
	private BarChartModel barChartModel;
	/**
	 * Objeto que contiene la logica de negocio para los albums.
	 */
	@ManagedProperty("#{albumServiceImpl}")
	private AlbumService albumServiceImpl;
	
	/**
	 * Inicializando pantalla.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		LOGGER.fatal("FATAL");
		
		if (this.sessionBean.getPersona().getRol().getIdRol() == 3) {
			this.crearGraficaTopTenAlbumsVendidos();
		}
	}
	/**
	 * Metodo que permite obtener los albums de los artistas encontrados en la base de datos
	 * con respecto al filtro ingresado por el cliente.
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistasAlbumDTO != null) {
			this.artistasAlbumDTO.forEach( artistaAlbumDTO -> {
				LOGGER.info("Artista: " + artistaAlbumDTO.getArtista().getNombre());
			});
		}
	}
	
	/**
	 * Metodo que permite ver el detalle del album seleccionado por el cliente.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album seleccionado.
	 */
	public void verDetalleAlbum(ArtistaAlbumDTO artistaAlbumDTO) {
		this.sessionBean.setArtistaAlbumDTO(artistaAlbumDTO);
		try {
			CommonUtils.redireccionar("/pages/cliente/detalle.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡UPS!", "Hubo un error de formato en la página a ingresar. "
					+ "Favor de contactar con soporte.");
			e.printStackTrace();
		}
	}
	/**
	 * Metodo que permite agregar un album en el carrito de compras.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} album a agregar al carrito.
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		LOGGER.info("Agregando album: " + artistaAlbumDTO.getAlbum().getNombre());
		
		CarritoAlbum carritoAlbum = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(), 1);
		
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritoAlbum);
	}
	/**
	 * Metodo que permite generar y mostrar la grafica de top ten de albums vendidos para el administrador.
	 */
	public void crearGraficaTopTenAlbumsVendidos() {
		
		this.barChartModel = new BarChartModel();
		ChartData chartData = new ChartData();
		
		//Se consulta la informacion de los albums mas vendidos.
		List<AlbumTopTenDTO> albumsTopTen = this.albumServiceImpl.consultarAlbumsTopTen();
		
		String[] meses = new DateFormatSymbols().getMonths();
		
		//Se itera la lista de albums topten y se integran los valores a la grafica.
		for (int i = 0; i < albumsTopTen.size(); i++) {
			
			BarChartDataSet barChartDataSet = new BarChartDataSet();
			barChartDataSet.setLabel(albumsTopTen.get(i).getCarritoAlbum().getAlbum().getNombre());
			barChartDataSet.setBackgroundColor(ColorEnum.values()[i].getDescripcion());
			barChartDataSet.setBorderWidth(1);
			
			List<Number> numeros = new ArrayList<Number>();
			
			//Se obtiene el mes en el que se realizo la compra del album.
			String mesCompra = albumsTopTen.get(i).getCarritoAlbum().getFechaCompra()
					.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "MX"));
			
			for (int j = 0; j < meses.length; j++) {
				String mes = meses[j];
				
				if (mes.equals(mesCompra)) {
					numeros.add(albumsTopTen.get(i).getCantidadSuma());
				} else {
					numeros.add(0);
				}
			}
			
			barChartDataSet.setData(numeros);
			chartData.addChartDataSet(barChartDataSet);
		}
		
		List<String> etiquetasMeses = new ArrayList<String>();
		etiquetasMeses.add("Enero");
		etiquetasMeses.add("Febrero");
		etiquetasMeses.add("Marzo");
		etiquetasMeses.add("Abril");
		etiquetasMeses.add("Mayo");
		etiquetasMeses.add("Junio");
		etiquetasMeses.add("Julio");
		etiquetasMeses.add("Agosto");
		etiquetasMeses.add("Septiembre");
		etiquetasMeses.add("Octubre");
		etiquetasMeses.add("Noviembre");
		etiquetasMeses.add("Diciembre");
		
		chartData.setLabels(etiquetasMeses);
		this.barChartModel.setData(chartData);

		BarChartOptions barChartOptions = new BarChartOptions();
		CartesianScales cartesianScales = new CartesianScales();
		CartesianLinearAxes cartesianLinearAxes = new CartesianLinearAxes();
		CartesianLinearTicks cartesianLinearTicks = new CartesianLinearTicks();
		
		cartesianLinearTicks.setBeginAtZero(true);
		cartesianLinearAxes.setTicks(cartesianLinearTicks);
		cartesianScales.addYAxesData(cartesianLinearAxes);
		barChartOptions.setScales(cartesianScales);
		
		Title title = new Title();
		title.setDisplay(true);
		title.setText("Top 10 Albums más vendidos por mes");
		barChartOptions.setTitle(title);
		
		this.barChartModel.setOptions(barChartOptions);
	}
	
	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}
	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	/**
	 * @return the artistasAlbumDTO
	 */
	public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
		return artistasAlbumDTO;
	}
	/**
	 * @param artistasAlbumDTO the artistasAlbumDTO to set
	 */
	public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
		this.artistasAlbumDTO = artistasAlbumDTO;
	}
	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}
	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
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
	 * @return the carritoServiceImpl
	 */
	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}
	/**
	 * @param carritoServiceImpl the carritoServiceImpl to set
	 */
	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}
	/**
	 * @return the barChartModel
	 */
	public BarChartModel getBarChartModel() {
		return barChartModel;
	}
	/**
	 * @param barChartModel the barChartModel to set
	 */
	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}
	/**
	 * @return the albumServiceImpl
	 */
	public AlbumService getAlbumServiceImpl() {
		return albumServiceImpl;
	}
	/**
	 * @param albumServiceImpl the albumServiceImpl to set
	 */
	public void setAlbumServiceImpl(AlbumService albumServiceImpl) {
		this.albumServiceImpl = albumServiceImpl;
	}
}
