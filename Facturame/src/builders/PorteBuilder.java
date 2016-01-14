package builders;

import java.sql.SQLException;
import java.util.ArrayList;

import factorias.FactoriaPorte;
import pojo.Porte;
import pojo.Viaje;

public abstract class PorteBuilder {

	Porte porte;
	FactoriaPorte fp;
	ArrayList<Viaje> viajes;

	public PorteBuilder() {
		this.fp = new FactoriaPorte();
		this.porte = fp.crearPorte();
		this.viajes = new ArrayList<Viaje>();
	}

	abstract void getDatosPrincipales() throws InterruptedException;

	abstract void getDatosEmpresa() throws InterruptedException, SQLException;

	abstract void getDatosTransportista() throws InterruptedException, SQLException;

	abstract void getDatosCamion() throws InterruptedException, SQLException;

	abstract void getDatosViajes() throws InterruptedException;

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
