package builders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import factorias.FactoriaPorte;
import interfacesGraficas.VentanaPrincipal;
import pojo.Porte;
import pojo.Viaje;

/**
 * Interfaz de construcci�n de los objetos Porte. Define de forma abstracta los m�todos que tendr�n todos los constructores de portes.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public abstract class PorteBuilder {

	/*
	 * Objeto Porte.
	 */
	protected Porte porte;
	/*
	 * Factor�a para la creaci�n de objetos Porte.
	 */
	private FactoriaPorte fp;
	/**
	 * Array de objetos Viaje
	 */
	private ArrayList<Viaje> viajes;

	/**
	 * Constructor Principal
	 */
	public PorteBuilder() {
		this.fp = new FactoriaPorte();
		this.porte = fp.crearPorte();
		this.viajes = new ArrayList<Viaje>();
	}

	/**
	 * Formulario para los datos b�sicos del porte.
	 * 
	 * @param ventanaPrincipal
	 * @throws InterruptedException
	 */
	abstract void getDatosPrincipales(VentanaPrincipal ventanaPrincipal) throws InterruptedException;

	/**
	 * Formulario para los datos de la empresa a la que se le va a realizar el porte.
	 * 
	 * @param ventanaPrincipal
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws IOException
	 */
	abstract void getDatosEmpresa(VentanaPrincipal ventanaPrincipal)
			throws InterruptedException, SQLException, IOException;

	/**
	 * Formulario para los datos del transportista que va a realizar el porte.
	 * 
	 * @param ventanaPrincipal
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws IOException
	 */
	abstract void getDatosTransportista(VentanaPrincipal ventanaPrincipal)
			throws InterruptedException, SQLException, IOException;

	/**
	 * Formulario para los datos del cami�n asociado al porte.
	 * 
	 * @param ventanaPrincipal
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws IOException
	 */
	abstract void getDatosCamion(VentanaPrincipal ventanaPrincipal)
			throws InterruptedException, SQLException, IOException;

	/**
	 * Formulario para los datos de los viajes que se compone el porte.
	 * 
	 * @param ventanaPrincipal
	 * @throws InterruptedException
	 */
	abstract void getDatosViajes(VentanaPrincipal ventanaPrincipal) throws InterruptedException;

	/**
	 * M�todo para la adici�n de Viajes a la estructura contenedora de todos los viajes.
	 * 
	 * @param viaje
	 */
	public void anadirViaje(Viaje viaje) {
		viajes.add(viaje);
	}

	/**
	 * M�todo para coger todos los viajes del Porte.
	 * 
	 * @return
	 */
	public ArrayList<Viaje> cogerViajes() {
		return viajes;
	}

	/**
	 * M�todo para coger el Porte generado.
	 * 
	 * @return
	 */
	public Porte getPorte() {
		return porte;
	}

}
