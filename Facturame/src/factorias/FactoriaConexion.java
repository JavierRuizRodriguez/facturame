package factorias;

import java.sql.SQLException;

import conexionProxyBBDD.Conexion;
import daos.CrearConexion;

public class FactoriaConexion implements CrearConexion{
	
	@Override
	public Conexion crearConexion() throws SQLException{
		return new Conexion();
	}

}
