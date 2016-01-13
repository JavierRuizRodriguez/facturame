package builders;

import pojo.Porte;

public class CreadorPortes {

	PorteBuilder pb;

	public void setPb(PorteBuilder pb) {
		this.pb = pb;
	}
	
	public void hacerPorte() throws InterruptedException{
		pb.getDatosPrincipales();
		pb.getDatosEmpresa();
		pb.getDatosTransportista();
		pb.getDatosCamion();
		pb.getDatosViajes();
	}

	public Porte getPorte(){
		return pb.getPorte();
	}

}
