package operacionesCRUD;

import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Camion;

public abstract class CRUDesquema {

	public abstract ArrayList<Object> buscarTodo() throws SQLException;

	public abstract int borrar(Object entrada) throws SQLException;

	public abstract int insertarActualizar(Object entrada, boolean esInsert) throws SQLException;

	public abstract Object buscarUno(Object entrada) throws SQLException;

}
