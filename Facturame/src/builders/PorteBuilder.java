package builders;

import pojo.Porte;

public abstract class PorteBuilder {

	private Porte porte;

	abstract void getDatosPrincipales();

	abstract void getDatosEmpresa();

	abstract void getDatosTransportista();

	abstract void getDatosCamion();

	abstract void getDatosViajes();

	public Porte getPorte() {
		return porte;
	}
}
