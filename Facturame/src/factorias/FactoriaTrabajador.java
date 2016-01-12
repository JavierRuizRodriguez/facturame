package factorias;

import pojo.Subordinado;
import pojo.Trabajador;

public class FactoriaTrabajador {

	public Trabajador crearTrabajador() {
		return new Trabajador();
	}

	public Subordinado crearSubordinado() {
		return new Subordinado();
	}
}
