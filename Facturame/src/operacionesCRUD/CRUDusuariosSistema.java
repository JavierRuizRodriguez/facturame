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
import pojo.Trabajador;
import pojo.UsuarioSistema;

public class CRUDusuariosSistema {

	private static String selectAllUsuariosSistema = "select * from \"UsuarioSistema\"";
	private static String updateUsuariosSistema = "UPDATE \"UsuarioSistema\" SET dni=?, nickname=?, \"hashContrasena\"=?, admin=?, \"fechaAltaUsuario\"=? WHERE dni=?";
	private static String borrarUsuariosSistema = "delete from \"UsuarioSistema\" where dni = ?";
	private static String insertUsuariosSistema = "INSERT INTO \"UsuarioSistema\"(dni, nickname, \"hashContrasena\", admin, \"fechaAltaUsuario\") VALUES (?, ?, ?, ?, ?)";
	private static String selectUsuariosSistema = "select * from \"UsuarioSistema\" where dni = ?";

	public CRUDusuariosSistema() {
	}

	public ArrayList<UsuarioSistema> buscarTodo() throws SQLException {
		ArrayList<UsuarioSistema> respuesta = new ArrayList<UsuarioSistema>();

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDusuariosSistema.selectAllUsuariosSistema);

		String dni, nickname, hashContrasena;
		Date fechaAltaUsuario;
		boolean admin;

		while (rs.next()) {
			dni = rs.getString(1);
			nickname = rs.getString(2);
			hashContrasena = rs.getString(3);
			admin = rs.getBoolean(4);
			fechaAltaUsuario = rs.getDate(5);

			respuesta.add(new UsuarioSistema(dni, nickname, hashContrasena, admin, fechaAltaUsuario));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	public UsuarioSistema buscarUno(String dniUsuario) throws SQLException {
		UsuarioSistema respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDusuariosSistema.selectUsuariosSistema);
		pst.setString(1, dniUsuario);
		rs = pst.executeQuery();

		String dni, nickname, hashContrasena;
		Date fechaAltaUsuario;
		boolean admin;

		while (rs.next()) {
			dni = rs.getString(1);
			nickname = rs.getString(2);
			hashContrasena = rs.getString(3);
			admin = rs.getBoolean(4);
			fechaAltaUsuario = rs.getDate(5);

			respuesta = new UsuarioSistema(dni, nickname, hashContrasena, admin, fechaAltaUsuario);
		}

		con.close();
		pst.close();
		rs.close();

		return respuesta;

	}

	public int insertarActualizar(UsuarioSistema usuario, boolean esInsert) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDusuariosSistema.insertUsuariosSistema);
		else
			pst = con.prepareStatement(CRUDusuariosSistema.updateUsuariosSistema);

		pst.setString(1, usuario.getDni());
		pst.setString(2, usuario.getNickname());
		pst.setString(3, usuario.getHashContraseña());
		pst.setBoolean(4, usuario.isAdmin());

		if (!esInsert)
			pst.setDate(5, usuario.getFechaAltaUsuario());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	public int borrar(String dniUsuario) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDusuariosSistema.borrarUsuariosSistema);
		pst.setString(1, dniUsuario);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

}
