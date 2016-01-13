package builders;

import interfacesGraficas.VentanaPorteCamion;
import interfacesGraficas.VentanaPorteDatos;
import interfacesGraficas.VentanaPorteEmpresa;
import interfacesGraficas.VentanaPorteTransportista;
import interfacesGraficas.VentanaPorteViaje;

public class PorteGrafico extends PorteBuilder {

	private boolean espera;
	private VentanaPorteDatos v1;
	private VentanaPorteEmpresa v2;
	private VentanaPorteTransportista v3;
	private VentanaPorteCamion v4;
	private VentanaPorteViaje v5;

	public PorteGrafico() {
		this.espera = true;
	}

	@Override
	void getDatosPrincipales() throws InterruptedException {
		v1 = new VentanaPorteDatos(this);
		v1.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		this.espera = true;
		v1 = null;
	}

	@Override
	void getDatosEmpresa() throws InterruptedException {
		v2 = new VentanaPorteEmpresa(this);
		v2.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		this.espera = true;
		v2 = null;
	}

	@Override
	void getDatosTransportista() throws InterruptedException {
		v3 = new VentanaPorteTransportista(this);
		v3.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		this.espera = true;
		v3 = null;
	}

	@Override
	void getDatosCamion() throws InterruptedException {
		v4 = new VentanaPorteCamion(this);
		v4.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		this.espera = true;
		v4 = null;
	}

	@Override
	void getDatosViajes() throws InterruptedException {
		v5 = new VentanaPorteViaje(this);
		v5.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		this.espera = true;
		v5 = null;
	}

	public void setEspera(boolean espera) {
		this.espera = espera;
	}

}
