package ordenacionObjetos;

import java.util.ArrayList;

import pojo.Porte;
/**
 * Clase que usa las distintas ordenaciones dependiendo de su necesidad.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */

public class ContextoOrdenacion{

	/**
	 * Lista de objetos gen�ricos.
	 */
	private ArrayList<Object> lista;
	/**
	 * Objeto que representa la estrategia seleccionada.
	 */
	private Estrategia estrategia;

	/**
	 * Constructor principal.
	 * 
	 * @param lista
	 * @param estrategia
	 */
	public ContextoOrdenacion(ArrayList<Object> lista, Estrategia estrategia) {
		this.lista = new ArrayList<Object>(lista);
		this.estrategia = estrategia;
	}

	/**
	 * M�todo que ejecuta la estrategia de ordenaci�n seleccionada.
	 * 
	 * @param campo
	 * @return
	 */
	public ArrayList<Object> ejecutarEstrategia(String campo) {
		estrategia.ordena(lista, campo);
		return lista;
	}

}
