package iterador;

import java.util.ArrayList;
/**
 * Implementaci�n de la interfaz Agregado y crea los iteradores concretos seg�n necesite.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class AgregadoConcreto implements Agregado {

    public ArrayList elementos;

    /**
     * Constructor principal.
     * 
     * @param vec
     */
    public AgregadoConcreto(ArrayList vec) {
        elementos = vec;
    }

    @Override
    public Iterador crearIterador() {
        return new IteradorConcreto(this);
    }
}
