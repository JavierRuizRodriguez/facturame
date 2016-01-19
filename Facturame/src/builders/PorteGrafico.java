package builders;

import java.io.IOException;
import java.sql.SQLException;

import factorias.FactoriaPorte;
import interfacesGraficas.VentanaPorteCamion;
import interfacesGraficas.VentanaPorteDatos;
import interfacesGraficas.VentanaPorteEmpresa;
import interfacesGraficas.VentanaPorteTransportista;
import interfacesGraficas.VentanaPorteViaje;
import pojo.Porte;

public class PorteGrafico extends PorteBuilder {

	private boolean espera;
	private VentanaPorteDatos v1;
	private VentanaPorteEmpresa v2;
	private VentanaPorteTransportista v3;
	private VentanaPorteCamion v4;
	private VentanaPorteViaje v5;

	public PorteGrafico() {
		super();
		this.espera = true;
		this.fp = new FactoriaPorte();
	}

	@Override
	void getDatosPrincipales() throws InterruptedException {
		v1 = new VentanaPorteDatos(this);
		v1.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		this.porte = v1.getPorte();
		v1 = null;
	}

	@Override
	void getDatosEmpresa() throws InterruptedException, SQLException, IOException {
		v2 = new VentanaPorteEmpresa(this);
		v2.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		this.porte = v2.getPorte();
		v2 = null;
	}

	@Override
	void getDatosTransportista() throws InterruptedException, SQLException, IOException {
		v3 = new VentanaPorteTransportista(this);
		v3.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		this.porte = v3.getPorte();
		v3 = null;
	}

	@Override
	void getDatosCamion() throws InterruptedException, SQLException, IOException {
		v4 = new VentanaPorteCamion(this);
		v4.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		this.porte = v4.getPorte();
		v4 = null;
	}

	@Override
	void getDatosViajes() throws InterruptedException {
		v5 = new VentanaPorteViaje(this);
		v5.setVisible(true);
		while (espera) {
			Thread.sleep(500);
		}
		espera = true;
		this.porte = v5.getPorte();
		this.porte.setIdPorte(1);
		v5 = null;
	}

	public void setEspera(boolean espera) {
		this.espera = espera;
	}

}
