package ordenacionObjetos;

import java.util.ArrayList;

import pojo.Porte;

/**
 * Parte de la implementación del patro strategy.
 * 
 * @author Javier
 *
 */

public class ContextoOrdenacion{

	private ArrayList<Object> lista;
	private Estrategia estrategia;

	public ContextoOrdenacion(ArrayList<Object> lista, Estrategia estrategia) {
		this.lista = new ArrayList<Object>(lista);
		this.estrategia = estrategia;
	}

	public ArrayList<Object> ejecutarEstrategia(String campo) {
		estrategia.ordena(lista, campo);
		return lista;
	}

}
