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
	int idViaje, idPorte;

	public CreadorPortes() {
		this.idViaje = 0;
		this.idPorte = 0;
		this.fc = new FactoriaCRUD();
		this.cp = (CRUDportes) fc.crearCRUD(FactoriaCRUD.TIPO_PORTE);
		this.cv = (CRUDviajes) fc.crearCRUD(FactoriaCRUD.TIPO_VIAJE);
	}

	public void setPb(PorteBuilder pb) {
		this.pb = pb;
	}

	public void hacerPorte() throws InterruptedException, SQLException {
		pb.getDatosPrincipales();
		pb.getDatosEmpresa();
		pb.getDatosTransportista();
		pb.getDatosCamion();
		pb.getDatosViajes();

		idPorte = cp.getUltimoId();
		p = pb.getPorte();
		p.setIdPorte(idPorte + 1);
		cp.insertarActualizar((Object) p, true);

		viajes = new ArrayList<Viaje>(pb.cogerViajes());
		idViaje = cv.ultimoId();
		for (Viaje v : viajes) {
			v.setIdViaje(idViaje + 1);
			v.setIdPorte(idPorte + 1);
			cv.insertarActualizar((Object) v, true);
			idViaje++;
		}

		cp.setUltimoId(idPorte + 1);
		cv.setUltimoId(idViaje);

	}

	public Porte getPorte() {
		return pb.getPorte();
	}

}
