package state;

import java.io.IOException;
import java.sql.SQLException;

import interfacesGraficas.VentanaLogin;

/**
 * Interfaz gen�rica del estado. Todos los distintos estados implementar�n dicho m�todo.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public interface Estado {

	/**
	 * M�todo de visualizaci�n de la ventana principal de la aplicaci�n.
	 * 
	 * @param v
	 * @throws SQLException
	 * @throws IOException
	 */
	public void ejecutar(VentanaLogin v) throws SQLException, IOException;
}