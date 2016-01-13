package operacionesCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Empresa;

public class CRUDempresa extends CRUDesquema{

	private static String selectAllEmpresa = "select * from \"Empresa\"";
	private static String updateEmpresa = "UPDATE \"Empresa\" SET \"NIF\"=?, \"nEmpresa\"=?, \"Dirección\"=?, email=?, telefono=? WHERE \"NIF\" = ?";
	private static String borrarEmpresa = "delete from \"Empresa\" where \"NIF\" = ?";
	private static String insertEmpresa = "INSERT INTO \"Empresa\"(\"NIF\", \"nEmpresa\", \"Dirección\", email, telefono)VALUES (?, ?, ?, ?, ?)";
	private static String selectEmpresa = "select * from \"Empresa\" where \"NIF\" = ?";

	public CRUDempresa() {
	}

	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		ArrayList<Object> respuesta = new ArrayList<Object>();

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDempresa.selectAllEmpresa);

		String nif, empresa, direccion, mail;
		int nTelefono;

		while (rs.next()) {
			nif = rs.getString(1);
			empresa = rs.getString(2);
			direccion = rs.getString(3);
			nTelefono = rs.getInt(4);
			mail = rs.getString(5);

			respuesta.add((Object) new Empresa(nif, empresa, direccion, nTelefono, mail));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	@Override
	public Object buscarUno(Object entrada) throws SQLException {
		String nifBuscado = String.valueOf(entrada);
		Empresa respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDempresa.selectEmpresa);
		pst.setString(1, nifBuscado);
		rs = pst.executeQuery();

		String nif, empresa, direccion, mail;
		int nTelefono;

		while (rs.next()) {
			nif = rs.getString(1);
			empresa = rs.getString(2);
			direccion = rs.getString(3);
			mail = rs.getString(4);
			nTelefono = rs.getInt(5);

			respuesta = new Empresa(nif, empresa, direccion, nTelefono, mail);
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
		Empresa empresa = (Empresa) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDempresa.insertEmpresa);
		else
			pst = con.prepareStatement(CRUDempresa.updateEmpresa);

		pst.setString(1, empresa.getNif());
		pst.setString(2, empresa.getEmpresa());
		pst.setString(3, empresa.getDireccion());
		pst.setString(4, empresa.getEmail());
		pst.setInt(5, empresa.getnTelefono());

		if (!esInsert)
			pst.setString(6, empresa.getNif());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		String nif = String.valueOf(entrada);
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDempresa.borrarEmpresa);
		pst.setString(1, nif);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

}
