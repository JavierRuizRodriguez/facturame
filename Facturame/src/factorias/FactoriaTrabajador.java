package factorias;

import pojo.Subordinado;
import pojo.Trabajador;

public class FactoriaTrabajador {

	public static Trabajador crearTrabajador() {
		return new Trabajador();
	}

	public static Subordinado crearSubordinado() {
		return new Subordinado();
	}
}
