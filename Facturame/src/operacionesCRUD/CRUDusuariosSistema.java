package operacionesCRUD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionProxyBBDD.Conexion;
import pojo.UsuarioSistema;

public class CRUDusuariosSistema extends CRUDesquema{

	private static String selectAllUsuariosSistema = "select * from \"UsuarioSistema\"";
	private static String updateUsuariosSistema = "UPDATE \"UsuarioSistema\" SET dni=?, nickname=?, \"hashContrasena\"=?, admin=?, \"fechaAltaUsuario\"=? WHERE dni=?";
	private static String borrarUsuariosSistema = "delete from \"UsuarioSistema\" where dni = ?";
	private static String insertUsuariosSistema = "INSERT INTO \"UsuarioSistema\"(dni, nickname, \"hashContrasena\", admin, \"fechaAltaUsuario\") VALUES (?, ?, ?, ?, ?)";
	private static String selectUsuariosSistema = "select * from \"UsuarioSistema\" where dni = ?";

	private Conexion c;
	
	public CRUDusuariosSistema() throws SQLException, IOException {
		super();
		this.c = cc.crearConexion();
	}

	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		ArrayList<Object> respuesta = new ArrayList<Object>();

		c.setSt(c.getCon().createStatement());
		c.setRs(c.getSt().executeQuery(CRUDusuariosSistema.selectAllUsuariosSistema));

		String dni, nickname, hashContrasena;
		Date fechaAltaUsuario;
		boolean admin;
		ResultSet rs = c.getRs();

		while (rs.next()) {
			dni = rs.getString(1);
			nickname = rs.getString(2);
			hashContrasena = rs.getString(3);
			admin = rs.getBoolean(4);
			fechaAltaUsuario = rs.getDate(5);

			respuesta.add((Object) new UsuarioSistema(dni, nickname, hashContrasena, admin, fechaAltaUsuario));
		}

		c.cerrarObjCon();
		c.cerrarObjSt();
		c.cerrarObjRs();
		rs.close();


		return respuesta;

	}

	@Override
	public Object buscarUno(Object entrada) throws SQLException {
		String dniUsuario = String.valueOf(entrada);
		UsuarioSistema respuesta = null;

		c.setPst(c.getCon().prepareStatement(CRUDusuariosSistema.selectUsuariosSistema));
		c.prepararPst(1, dniUsuario);
		c.setRs(c.getPst().executeQuery());

		String dni, nickname, hashContrasena;
		Date fechaAltaUsuario;
		boolean admin;
		ResultSet rs = c.getRs();

		while (rs.next()) {
			dni = rs.getString(1);
			nickname = rs.getString(2);
			hashContrasena = rs.getString(3);
			admin = rs.getBoolean(4);
			fechaAltaUsuario = rs.getDate(5);

			respuesta = new UsuarioSistema(dni, nickname, hashContrasena, admin, fechaAltaUsuario);
		}

		c.cerrarObjCon();
		c.cerrarObjPst();
		c.cerrarObjRs();
		rs.close();

		return (Object) respuesta;

	}

	@Override
	public int insertarActualizar(Object entrada, boolean esInsert) throws SQLException {
		UsuarioSistema usuario = (UsuarioSistema) entrada;
		int respuesta = 0;

		if (esInsert)
			c.setPst(c.getCon().prepareStatement(CRUDusuariosSistema.insertUsuariosSistema));
		else
			c.setPst(c.getCon().prepareStatement(CRUDusuariosSistema.updateUsuariosSistema));

		c.prepararPst(1, usuario.getDni());
		c.prepararPst(2, usuario.getNickname());
		c.prepararPst(3, usuario.getHashContraseña());
		c.prepararPst(4, usuario.isAdmin());

		if (!esInsert)
			c.prepararPst(5, usuario.getFechaAltaUsuario());

		respuesta = c.getPst().executeUpdate();

		c.cerrarObjCon();
		c.cerrarObjPst();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		String dniUsuario = String.valueOf(entrada);
		int respuesta = 0;

		c.setPst(c.getCon().prepareStatement(CRUDusuariosSistema.borrarUsuariosSistema));
		c.prepararPst(1, dniUsuario);
		respuesta = c.getPst().executeUpdate();

		c.cerrarObjCon();
		c.cerrarObjPst();

		return respuesta;

	}

}
