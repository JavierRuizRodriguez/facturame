package operacionesCRUD;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionProxyBBDD.ProxyConexion;
import daos.CrearConexion;
/**
 * Clase abstracta que define las operaciones gen�ricas sobre la BBDD.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public abstract class CRUDesquema {

	protected CrearConexion cc;

	/**
	 * Constructor principal.
	 * 
	 * @throws SecurityException
	 * @throws IOException
	 */
	public CRUDesquema() throws SecurityException, IOException {
		this.cc = new ProxyConexion();
	}

	/**
	 * M�todo para buscar todos los objetos de una tabla.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 */
	public abstract ArrayList<Object> buscarTodo() throws SQLException, NoSuchAlgorithmException;

	/**
	 * M�todo para borrar un objeto de una tabla.
	 * 
	 * @param entrada
	 * @return
	 * @throws SQLException
	 */
	public abstract int borrar(Object entrada) throws SQLException;

	/**
	 * M�todo para insertar o actualizar una entrada en una tabla.
	 * @param entrada
	 * @param esInsert
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertarActualizar(Object entrada, boolean esInsert) throws SQLException;

	/**
	 * M�todo para buscar una entrada en la tabla.
	 * 
	 * @param entrada
	 * @return
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 */
	public abstract Object buscarUno(Object entrada) throws SQLException, NoSuchAlgorithmException;

}
