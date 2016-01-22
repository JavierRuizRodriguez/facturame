package builders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import factorias.FactoriaCRUD;
import interfacesGraficas.VentanaPrincipal;
import operacionesCRUD.CRUDportes;
import operacionesCRUD.CRUDviajes;
import pojo.Porte;
import pojo.Viaje;

public class CreadorPortes {

	private PorteBuilder pb;
	private FactoriaCRUD fc;
	private CRUDportes cp;
	private CRUDviajes cv;
	private VentanaPrincipal ventanaPrincipal;
	private Porte p;
	private ArrayList<Viaje> viajes;
	private int idViaje, idPorte;

	public CreadorPortes(VentanaPrincipal principal) throws SQLException, IOException {
		this.idViaje = 0;
		this.idPorte = 0;
		this.fc = new FactoriaCRUD();
		this.cp = (CRUDportes) fc.crearCRUD(FactoriaCRUD.TIPO_PORTE);
		this.cv = (CRUDviajes) fc.crearCRUD(FactoriaCRUD.TIPO_VIAJE);
		this.ventanaPrincipal = principal;
		this.pb = null;
	}

	public void setPb(PorteBuilder pb) {
		this.pb = pb;
	}

	public void hacerPorte() throws InterruptedException, SQLException, IOException {
		pb.getDatosPrincipales(ventanaPrincipal);
		pb.getDatosEmpresa(ventanaPrincipal);
		pb.getDatosTransportista(ventanaPrincipal);
		pb.getDatosCamion(ventanaPrincipal);
		pb.getDatosViajes(ventanaPrincipal);
		
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
