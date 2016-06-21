package daos;

import java.sql.SQLException;

import conexionProxyBBDD.Conexion;
/**
 * Interfaz de creaci�n de conexiones.
 */
/**
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public interface CrearConexion {
	
	/**
	 * Devuelve un objeto de tipo conexi�n.
	 * 
	 * @return
	 * @throws SQLException
	 */
	Conexion crearConexion() throws SQLException;

}
