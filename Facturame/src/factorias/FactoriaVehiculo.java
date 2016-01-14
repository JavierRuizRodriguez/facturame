package factorias;

import pojo.Camion;
import pojo.Vehiculo;

public class FactoriaVehiculo {

	static int tipoCamion = 1;

	/**
	 * + Explicacion. El método por defecto es devolver un camion.
	 * 
	 * @param tipo
	 * @return
	 */
	public Vehiculo crearCamion(int tipo) {
		switch (tipo) {
		case 1:
			return new Camion();
		default:
			return new Camion();
		}
	}

}
