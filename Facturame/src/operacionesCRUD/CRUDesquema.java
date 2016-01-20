package operacionesCRUD;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionProxyBBDD.ProxyConexion;
import daos.CrearConexion;

public abstract class CRUDesquema {

	protected CrearConexion cc;

	public CRUDesquema() throws SecurityException, IOException {
		this.cc = new ProxyConexion();
	}

	public abstract ArrayList<Object> buscarTodo() throws SQLException, NoSuchAlgorithmException;

	public abstract int borrar(Object entrada) throws SQLException;

	public abstract int insertarActualizar(Object entrada, boolean esInsert) throws SQLException;

	public abstract Object buscarUno(Object entrada) throws SQLException, NoSuchAlgorithmException;

}
