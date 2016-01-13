package builders;

import java.sql.SQLException;
import java.util.ArrayList;

import factorias.FactoriaCRUD;
import operacionesCRUD.CRUDportes;
import operacionesCRUD.CRUDviajes;
import pojo.Porte;
import pojo.Viaje;

public class CreadorPortes {

	PorteBuilder pb;
	FactoriaCRUD fc;
	CRUDportes cp;
	CRUDviajes cv;
	Porte p;
	ArrayList<Viaje> viajes;

	public void setPb(PorteBuilder pb) {
		this.pb = pb;
		this.fc = new FactoriaCRUD();
		cp = (CRUDportes) fc.crearCRUD(FactoriaCRUD.TIPO_PORTE);
		cv = (CRUDviajes) fc.crearCRUD(FactoriaCRUD.TIPO_VIAJE);
	}

	public void hacerPorte() throws InterruptedException, SQLException {
		pb.getDatosPrincipales();
		pb.getDatosEmpresa();
		pb.getDatosTransportista();
		pb.getDatosCamion();
		pb.getDatosViajes();
		p = pb.getPorte();
		viajes = new ArrayList<Viaje>(pb.cogerViajes());

		cp.insertarActualizar((Object) p, true);
		for (Viaje v : viajes)
			cv.insertarActualizar((Object) v, true);

	}

	public Porte getPorte() {
		return pb.getPorte();
	}

}
