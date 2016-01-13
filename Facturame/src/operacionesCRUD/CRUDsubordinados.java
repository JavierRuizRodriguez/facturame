package operacionesCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Subordinado;

public class CRUDsubordinados {

	private static String selectAllSubordinado = "select * from \"Subordinado\"";
	private static String updateSubordinado = "UPDATE \"Subordinado\" SET \"dniSubordinado\"=?, \"dniJefe\"=? WHERE \"dniJefe\" =?";
	private static String borrarSubordinado = "delete from \"Subordinado\" where \"dniJefe\" = ?";
	private static String insertSubordinado = "INSERT INTO \"Subordinado\"(\"dniJefe\",\"dniSubordinado\") VALUES (?, ?)";
	private static String selectSubordinado = "select * from \"Subordinado\" where \"dniJefe\" = ?";

	private ArrayList<Subordinado> buscarTodosSubordinados() throws SQLException {
		ArrayList<Subordinado> respuesta = new ArrayList<Subordinado>();
		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDsubordinados.selectAllSubordinado);

		String dniJefe, dniSubordinado;

		while (rs.next()) {
			dniJefe = rs.getString(1);
			dniSubordinado = rs.getString(2);
			respuesta.add(new Subordinado(dniJefe, dniSubordinado));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	public Subordinado buscarUnSubodinado(String dniJefeBuscado) throws SQLException {
		Subordinado respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDsubordinados.selectSubordinado);
		pst.setString(1, dniJefeBuscado);
		rs = pst.executeQuery();

		String dniJefe, dniSubordinado;

		while (rs.next()) {
			dniJefe = rs.getString(1);
			dniSubordinado = rs.getString(2);
			respuesta = new Subordinado(dniJefe, dniSubordinado);
		}

		con.close();
		pst.close();
		rs.close();

		return respuesta;

	}

	public int insertarActualizaSubordinado(Subordinado subordinado, boolean esInsert) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDsubordinados.insertSubordinado);
		else
			pst = con.prepareStatement(CRUDsubordinados.updateSubordinado);

		pst.setString(1, subordinado.getDniJefe());
		pst.setString(2, subordinado.getDniSubordinado());

		if (!esInsert)
			pst.setString(9, subordinado.getDniJefe());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	public int borrarSubordinado(String dniJefe) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDsubordinados.borrarSubordinado);
		pst.setString(1, dniJefe);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

}
