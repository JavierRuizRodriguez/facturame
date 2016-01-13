package operacionesCRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Empresa;
import pojo.LibroGastos;

public class CRUDlibroGastos extends CRUDesquema {

	private static String selectAllGasto = "select * from \"LibroGastos\"";
	private static String updateGasto = "UPDATE \"LibroGastos\" SET \"idEntrada\"=?, concepto=?, dinero=?, \"fechaAsiento\"=?, descripcion=? WHERE \"idEntrada\" = ? ";
	private static String borrarGasto = "delete from \"LibroGastos\" where \"idEntrada\" = ?";
	private static String insertGasto = "INSERT INTO \"LibroGastos\"(\"idEntrada\", concepto, dinero, \"fechaAsiento\", descripcion) VALUES (?, ?, ?, ?, ?)";
	private static String selectGasto = "select * from \"LibroGastos\" where \"idEntrada\" = ?";

	public CRUDlibroGastos() {
	}

	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		ArrayList<Object> respuesta = new ArrayList<Object>();

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDlibroGastos.selectAllGasto);

		String concepto, descripcion;
		int idEntrada;
		double dinero;
		Date fechaAsiento;

		while (rs.next()) {
			idEntrada = rs.getInt(1);
			concepto = rs.getString(2);
			dinero = rs.getDouble(3);
			fechaAsiento = rs.getDate(4);
			descripcion = rs.getString(5);

			respuesta.add((Object) new LibroGastos(idEntrada, concepto, dinero, fechaAsiento, descripcion));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	@Override
	public Object buscarUno(Object entrada) throws SQLException {
		int idEntradaBuscado = (int) entrada;
		LibroGastos respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDlibroGastos.selectGasto);
		pst.setInt(1, idEntradaBuscado);
		rs = pst.executeQuery();

		String concepto, descripcion;
		int idEntrada;
		double dinero;
		Date fechaAsiento;

		while (rs.next()) {
			idEntrada = rs.getInt(1);
			concepto = rs.getString(2);
			dinero = rs.getDouble(3);
			fechaAsiento = rs.getDate(4);
			descripcion = rs.getString(5);

			respuesta = new LibroGastos(idEntrada, concepto, dinero, fechaAsiento, descripcion);
		}

		con.close();
		pst.close();
		rs.close();

		return (Object) respuesta;

	}

	// mode 0 --> insert
	// mode 1 --> update
	@Override
	public int insertarActualizar(Object entrada, boolean esInsert) throws SQLException {
		LibroGastos gasto = (LibroGastos) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDlibroGastos.insertGasto);
		else
			pst = con.prepareStatement(CRUDlibroGastos.updateGasto);

		pst.setInt(1, gasto.getIdEntrada());
		pst.setString(2, gasto.getConcepto());
		pst.setDouble(3, gasto.getDinero());
		pst.setDate(4, gasto.getFechaAsiento());
		pst.setString(5, gasto.getDescripcion());

		if (!esInsert)
			pst.setInt(6, gasto.getIdEntrada());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		int idEntrada = (int) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDlibroGastos.borrarGasto);
		pst.setInt(1, idEntrada);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}
}
