package state;

import interfacesGraficas.VentanaLogin;

/**
 * Clase que representa el estado NO logeado.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class EstadoLogin implements Estado{

	@Override
	public void ejecutar(VentanaLogin v) {
		if (v.getAuthUser().isAdmin())
			v.setEstadoActual(new EstadoAdmin());
		else
			v.setEstadoActual(new EstadoNoAdmin());
	}

}
