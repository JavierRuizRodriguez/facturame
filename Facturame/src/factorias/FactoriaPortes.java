package factorias;

import pojo.Porte;
import pojo.Viaje;

public class FactoriaPortes {

	public Porte crearPorte() {
		return new Porte();
	}

	public Viaje crearViaje() {
		return new Viaje();
	}

}
