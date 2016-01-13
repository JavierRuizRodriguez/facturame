package builders;

import java.sql.SQLException;

import factorias.FactoriaPorte;
import interfacesGraficas.VentanaPorteCamion;
import interfacesGraficas.VentanaPorteDatos;
import interfacesGraficas.VentanaPorteEmpresa;
import interfacesGraficas.VentanaPorteTransportista;
import interfacesGraficas.VentanaPorteViaje;
import pojo.Porte;

public class PorteGrafico extends PorteBuilder {

	private Porte p;
	private FactoriaPorte fp;
	private boolean espera;
	private VentanaPorteDatos v1;
	private VentanaPorteEmpresa v2;
	private VentanaPorteTransportista v3;
	private VentanaPorteCamion v4;
	private VentanaPorteViaje v5;

	public PorteGrafico() {
		this.espera = true;
		this.fp = new FactoriaPorte();
		this.p = fp.crearPorte();
	}

	@Override
	void getDatosPrincipales() throws InterruptedException {
		v1 = new VentanaPorteDatos(this, p);
		v1.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		p = v1.getPorte();
		v1 = null;
	}

	@Override
	void getDatosEmpresa() throws InterruptedException {
		v2 = new VentanaPorteEmpresa(this, p);
		v2.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		p = v2.getPorte();
		v2 = null;
	}

	@Override
	void getDatosTransportista() throws InterruptedException {
		v3 = new VentanaPorteTransportista(this, p);
		v3.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		p = v3.getPorte();
		v3 = null;
	}

	@Override
	void getDatosCamion() throws InterruptedException, SQLException {
		v4 = new VentanaPorteCamion(this, p);
		v4.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		p = v4.getPorte();
		v4 = null;
	}

	@Override
	void getDatosViajes() throws InterruptedException {
		v5 = new VentanaPorteViaje(this, p);
		v5.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		p = v5.getPorte();
		v5 = null;
	}

	public void setEspera(boolean espera) {
		this.espera = espera;
	}

}
