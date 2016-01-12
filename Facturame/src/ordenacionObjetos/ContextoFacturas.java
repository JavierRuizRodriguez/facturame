package ordenacionObjetos;

import java.util.ArrayList;

import pojo.Porte;

/**
 * Parte de la implementación del patro strategy.
 * 
 * @author Javier
 *
 */

public class ContextoFacturas {

	private ArrayList<Porte> portes;
	private Estrategia estrategia;

	public ContextoFacturas(ArrayList<Porte> portes, Estrategia estrategia) {
		this.portes = new ArrayList<Porte>(portes);
		this.estrategia = estrategia;
	}

	public ArrayList<Porte> ejecutarEstrategia(int nCampo) {
		estrategia.ordena(portes, nCampo);
		return portes;
	}

}
