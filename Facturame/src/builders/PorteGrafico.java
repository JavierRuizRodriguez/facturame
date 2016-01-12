package builders;

import interfacesGraficas.VentanaPorteCamion;
import interfacesGraficas.VentanaPorteDatos;
import interfacesGraficas.VentanaPorteEmpresa;
import interfacesGraficas.VentanaPorteTransportista;
import interfacesGraficas.VentanaPorteViaje;

public class PorteGrafico extends PorteBuilder {

	private VentanaPorteDatos v1;
	private VentanaPorteEmpresa v2;
	private VentanaPorteTransportista v3;
	private VentanaPorteCamion v4;
	private VentanaPorteViaje v5;

	@Override
	void getDatosPrincipales() {
		v1 = new VentanaPorteDatos();
		v1.setVisible(true);
		while (v1.isVisible()) {
		}
	}

	@Override
	void getDatosEmpresa() {
		v2 = new VentanaPorteEmpresa();
		v2.setVisible(true);
		while (v2.isVisible()) {
		}

	}

	@Override
	void getDatosTransportista() {
		v3 = new VentanaPorteTransportista();
		v3.setVisible(true);
		while (v3.isVisible()) {
		}

	}

	@Override
	void getDatosCamion() {
		v4 = new VentanaPorteCamion();
		v4.setVisible(true);
		while (v4.isVisible()) {
		}

	}

	@Override
	void getDatosViajes() {
		v5 = new VentanaPorteViaje();
		v5.setVisible(true);
		while (v5.isVisible()) {
		}

	}

}
