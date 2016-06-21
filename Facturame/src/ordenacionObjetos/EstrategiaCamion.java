package ordenacionObjetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pojo.Camion;
/**
 * Estrategia espec�fica para la ordenaci�n de los camiones.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class EstrategiaCamion implements Estrategia {

	@Override
	public void ordena(ArrayList<?> lista, String campo) {
		Comparator comparadorCamiones = (Comparator) (Object o1, Object o2) -> {
			Camion c1 = (Camion) o1;
			Camion c2 = (Camion) o2;

			switch (campo) {
			case "bastidor":
				return c1.getnBastidor().compareTo(c2.getnBastidor());
			case "matricula":
				return c1.getMatricula().compareTo(c2.getMatricula());
			case "km":
				return Integer.compare(c1.getKmTotales(), c2.getKmTotales());
			default:
				return c1.getnBastidor().compareTo(c2.getnBastidor());
			}
		};

		Collections.sort(lista, comparadorCamiones);
	}

}
