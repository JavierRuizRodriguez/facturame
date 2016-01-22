package builders;

import java.io.IOException;
import java.sql.SQLException;

import interfacesGraficas.VentanaPorteCamion;
import interfacesGraficas.VentanaPorteDatos;
import interfacesGraficas.VentanaPorteEmpresa;
import interfacesGraficas.VentanaPorteTransportista;
import interfacesGraficas.VentanaPorteViaje;
import interfacesGraficas.VentanaPrincipal;

public class PorteGrafico extends PorteBuilder {

	private boolean espera;
	private VentanaPorteDatos v1;
	private VentanaPorteEmpresa v2;
	private VentanaPorteTransportista v3;
	private VentanaPorteCamion v4;
	private VentanaPorteViaje v5;

	public PorteGrafico() throws SQLException, IOException {
		super();
		this.espera = true;
	}

	@Override
	void getDatosPrincipales(VentanaPrincipal ventanaPrincipal) throws InterruptedException {
		v1 = new VentanaPorteDatos(this, ventanaPrincipal);
		while (espera) {
			Thread.sleep(1500);
		}
		espera = true;
		porte = v1.getPorte();
		v1 = null;
	}

	@Override
	void getDatosEmpresa(VentanaPrincipal ventanaPrincipal) throws InterruptedException, SQLException, IOException {
		v2 = new VentanaPorteEmpresa(this, ventanaPrincipal);
		v2.setVisible(true);
		while (espera) {
			Thread.sleep(1500);
		}
		espera = true;
		porte = v2.getPorte();
		v2 = null;
	}

	@Override
	void getDatosTransportista(VentanaPrincipal ventanaPrincipal)
			throws InterruptedException, SQLException, IOException {

		this.v3 = new VentanaPorteTransportista(this, ventanaPrincipal);
		v3.setVisible(true);
		while (espera) {
			Thread.sleep(1500);
		}
		espera = true;
		porte = v3.getPorte();
		v3 = null;
	}

	@Override
	void getDatosCamion(VentanaPrincipal ventanaPrincipal) throws InterruptedException, SQLException, IOException {
		v4 = new VentanaPorteCamion(this, ventanaPrincipal);
		v4.setVisible(true);
		while (espera) {
			Thread.sleep(1500);
		}
		espera = true;
		porte = v4.getPorte();
		v4 = null;
	}

	@Override
	void getDatosViajes(VentanaPrincipal ventanaPrincipal) throws InterruptedException {
		v5 = new VentanaPorteViaje(this, ventanaPrincipal);
		v5.setVisible(true);
		while (espera) {
			Thread.sleep(1500);
		}
		espera = true;
		porte = v5.getPorte();
		porte.setIdPorte(1);
		v5 = null;
	}

	public void setEspera(boolean espera) {
		this.espera = espera;
	}

}
