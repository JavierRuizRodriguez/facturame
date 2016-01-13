package builders;

import pojo.Porte;

public abstract class PorteBuilder {

	private Porte porte;

	abstract void getDatosPrincipales() throws InterruptedException;

	abstract void getDatosEmpresa() throws InterruptedException;

	abstract void getDatosTransportista() throws InterruptedException;

	abstract void getDatosCamion() throws InterruptedException;

	abstract void getDatosViajes() throws InterruptedException;

	public Porte getPorte() {
		return porte;
	}
}
