package daos;

import java.sql.SQLException;

import conexionProxyBBDD.Conexion;

public interface CrearConexion {
	
	Conexion crearConexion() throws SQLException;

}
