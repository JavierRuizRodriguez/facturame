package factorias;

import java.sql.SQLException;

import conexionProxyBBDD.Conexion;
import daos.CrearConexion;
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class FactoriaConexion implements CrearConexion{
	
	@Override
	public Conexion crearConexion() throws SQLException{
		return new Conexion();
	}

}
