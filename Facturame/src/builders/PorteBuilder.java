package builders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import factorias.FactoriaPorte;
import interfacesGraficas.VentanaPrincipal;
import pojo.Porte;
import pojo.Viaje;

public abstract class PorteBuilder {

	protected Porte porte;
	private FactoriaPorte fp;
	private ArrayList<Viaje> viajes;

	public PorteBuilder() {
		this.fp = new FactoriaPorte();
		this.porte = fp.crearPorte();
		this.viajes = new ArrayList<Viaje>();
	}

	abstract void getDatosPrincipales(VentanaPrincipal ventanaPrincipal) throws InterruptedException;

	abstract void getDatosEmpresa(VentanaPrincipal ventanaPrincipal) throws InterruptedException, SQLException, IOException;

	abstract void getDatosTransportista(VentanaPrincipal ventanaPrincipal) throws InterruptedException, SQLException, IOException;

	abstract void getDatosCamion(VentanaPrincipal ventanaPrincipal) throws InterruptedException, SQLException, IOException;

	abstract void getDatosViajes(VentanaPrincipal ventanaPrincipal) throws InterruptedException;

	public void anadirViaje(Viaje viaje) {
		viajes.add(viaje);
	}

	public ArrayList<Viaje> cogerViajes() {
		return viajes;
	}

	public Porte getPorte() {
		return porte;
	}

}
