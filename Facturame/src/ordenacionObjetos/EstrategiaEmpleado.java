package ordenacionObjetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pojo.Trabajador;
/**
 * Estrategia espec�fica para la ordenaci�n de los empleados.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class EstrategiaEmpleado implements Estrategia{

	@Override
	public void ordena(ArrayList<?> lista, String campo) {
		Comparator comparadorEmpleado = (Comparator) (Object o1, Object o2) -> {
			Trabajador t1 = (Trabajador) o1;
			Trabajador t2 = (Trabajador) o2;

			switch (campo) {
			case "nombre":
				return t1.getNombre().compareTo(t2.getNombre());
			case "apellidos":
				return t1.getApellidos().compareTo(t2.getApellidos());
			case "DNI":
				return t1.getDni().compareTo(t2.getDni());
			default:
				return t1.getNombre().compareTo(t2.getNombre());
			}
		};

		Collections.sort(lista, comparadorEmpleado);
		
	}

}
