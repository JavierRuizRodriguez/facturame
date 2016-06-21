package builders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import factorias.FactoriaCRUD;
import interfacesGraficas.VentanaPrincipal;
import operacionesCRUD.CRUDportes;
import operacionesCRUD.CRUDviajes;
import pojo.Porte;
import pojo.Viaje;

/**
 * Esta clase es el director del patron builder. Es el encargado de instanciar un objeto a trav�s de la intervaz de construcci�n PorteBuilder.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class CreadorPortes {

	/**
	 * Interfaz de construcci�n del objeto Porte.
	 */
	private PorteBuilder pb;
	/**
	 * Factor�a para la creaci�n de objetos CRUD.
	 */
	private FactoriaCRUD fc;
	/**
	 * Objeto CRUD de portes.
	 */
	private CRUDportes cp;
	/**
	 * Objeto CRUD de viajes.
	 */
	private CRUDviajes cv;
	/**
	 * Referencia a la ventana anterior para poder volver a ella.
	 */
	private VentanaPrincipal ventanaPrincipal;
	/**
	 * Oobjeto Porte.
	 */
	private Porte p;
	/**
	 * Array de objetos Viaje
	 */
	private ArrayList<Viaje> viajes;
	/**
	 * Id secuenciales para la identificaci�n de los portes y los viajes.
	 */
	private int idViaje, idPorte;

	/**
	 * Constructor principal
	 * 
	 * @param principal
	 * @throws SQLException
	 * @throws IOException
	 */
	public CreadorPortes(VentanaPrincipal principal) throws SQLException, IOException {
		this.idViaje = 0;
		this.idPorte = 0;
		this.fc = new FactoriaCRUD();
		this.cp = (CRUDportes) fc.crearCRUD(FactoriaCRUD.TIPO_PORTE);
		this.cv = (CRUDviajes) fc.crearCRUD(FactoriaCRUD.TIPO_VIAJE);
		this.ventanaPrincipal = principal;
		this.pb = null;
	}

	/**
	 * M�todo para selecci�n del constructor de Portes que se va a escoger.
	 * 
	 * @param pb
	 */
	public void setPb(PorteBuilder pb) {
		this.pb = pb;
	}

	/**
	 * M�todo principal del builder. Es el encargado de ir mostrando los
	 * formularios en su orden correspondiente.
	 * 
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void hacerPorte() throws InterruptedException, SQLException, IOException {
		pb.getDatosPrincipales(ventanaPrincipal);
		pb.getDatosEmpresa(ventanaPrincipal);
		pb.getDatosTransportista(ventanaPrincipal);
		pb.getDatosCamion(ventanaPrincipal);
		pb.getDatosViajes(ventanaPrincipal);

		idPorte = cp.getUltimoId();
		p = pb.getPorte();
		p.setIdPorte(idPorte + 1);
		cp.insertarActualizar((Object) p, true);

		viajes = new ArrayList<Viaje>(pb.cogerViajes());
		idViaje = cv.getUltimoId();
		for (Viaje v : viajes) {
			v.setIdViaje(idViaje + 1);
			v.setIdPorte(idPorte + 1);
			cv.insertarActualizar((Object) v, true);
			idViaje++;
		}

		cp.setUltimoId(idPorte + 1);
		cv.setUltimoId(idViaje);

	}

	/**
	 * M�todo para acceder al porte creado.
	 * 
	 * @return
	 */
	public Porte getPorte() {
		return pb.getPorte();
	}

}
