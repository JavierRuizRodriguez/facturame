package factorias;

import pojo.Subordinado;
import pojo.Trabajador;
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class FactoriaTrabajador {

	public Trabajador crearTrabajador() {
		return new Trabajador();
	}

	public Subordinado crearSubordinado() {
		return new Subordinado();
	}
}
