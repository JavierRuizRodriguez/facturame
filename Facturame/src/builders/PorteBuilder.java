package builders;

import java.sql.SQLException;

import pojo.Porte;

public abstract class PorteBuilder {

	private Porte porte;

	abstract void getDatosPrincipales() throws InterruptedException;

	abstract void getDatosEmpresa() throws InterruptedException, SQLException;

	abstract void getDatosTransportista() throws InterruptedException, SQLException;

	abstract void getDatosCamion() throws InterruptedException, SQLException;

	abstract void getDatosViajes() throws InterruptedException;

	public Porte getPorte() {
		return porte;
	}
}
