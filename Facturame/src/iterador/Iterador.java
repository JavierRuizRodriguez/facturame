package iterador;
/**
 * Interfaz donde se definen los m�todos de iteraci�n que tendr�n todos los iteradores concretos.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public interface Iterador {

	/**
	 * M�todo que devuelve el primer objeto del iterador.
	 * 
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
    Object primero() throws IndexOutOfBoundsException;

    /**
     * M�todo que devuelve el siguiente objeto del iterador.
     * 
     * @return
     * @throws IndexOutOfBoundsException
     */
    Object siguiente() throws IndexOutOfBoundsException;

    /**
     * M�todo que devuleve un booleano indicando si hay m�s objetos o no en el iterador.
     * @return
     */
    boolean hayMas();

    /**
     * M�todo que devuelve el objeto actual al que est� apuntando el iterador.
     * @return
     * @throws IndexOutOfBoundsException
     */
    Object elementoActual() throws IndexOutOfBoundsException;
}
