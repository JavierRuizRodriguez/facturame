package factorias;

import pojo.Porte;
import pojo.Viaje;

public class FactoriaPortes {

	public static Porte crearPorte() {
		return new Porte();
	}

	public static Viaje crearViaje() {
		return new Viaje();
	}

}
