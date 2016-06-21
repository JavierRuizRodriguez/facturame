package ordenacionObjetos;

import java.util.ArrayList;
/**
 * Interfaz que representa el m�todo que todas la estrategias deben implementar.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public interface Estrategia{

	/**
	 * M�todo que ordena una lista de objetos por un campo concreto.
	 * 
	 * @param lista
	 * @param campo
	 */
	void ordena(ArrayList<?> lista, String campo);
}
