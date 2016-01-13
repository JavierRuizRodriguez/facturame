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

public class CRUDempleados extends CRUDesquema {

	private static String selectAllEmpleado = "select * from \"Empleado\"";
	private static String updateEmpleado = "UPDATE \"Empleado\" SET dni=?, nombre=?, apellidos=?, \"fechaNacimiento\"=?, sexo=?, \"fechaAltaEmpleado\"=?, sueldo=?, rango=?	 WHERE dni=?";
	private static String borrarEmpleado = "delete from \"Empleado\" where dni = ?";
	private static String insertEmpleado = "INSERT INTO \"Empleado\"(dni, nombre, apellidos, \"fechaNacimiento\", sexo, \"fechaAltaEmpleado\",sueldo, rango) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static String selectEmpleado = "select * from \"Empleado\" where dni = ?";

	public CRUDempleados() {
	}

	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		ArrayList<Object> respuesta = new ArrayList<Object>();

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDempleados.selectAllEmpleado);

		String dni, nombre, apellidos, sexo, rango;
		Date fechaNacimiento, fechaAltaEmpleado;
		Double sueldo;

		while (rs.next()) {
			dni = rs.getString(1);
			nombre = rs.getString(2);
			apellidos = rs.getString(3);
			fechaNacimiento = rs.getDate(4);
			sexo = rs.getString(5);
			fechaAltaEmpleado = rs.getDate(6);
			sueldo = rs.getDouble(7);
			rango = rs.getString(8);
			respuesta.add((Object) new Trabajador(dni, nombre, apellidos, fechaNacimiento, sexo, fechaAltaEmpleado,
					rango, sueldo));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	@Override
	public Object buscarUno(Object entrada) throws SQLException {
		String dniBuscado = String.valueOf(entrada);
		Trabajador respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDempleados.selectEmpleado);
		pst.setString(1, dniBuscado);
		rs = pst.executeQuery();

		String dni, nombre, apellidos, sexo, rango;
		Date fechaNacimiento, fechaAltaEmpleado;
		Double sueldo;

		while (rs.next()) {
			dni = rs.getString(1);
			nombre = rs.getString(2);
			apellidos = rs.getString(3);
			fechaNacimiento = rs.getDate(4);
			sexo = rs.getString(5);
			fechaAltaEmpleado = rs.getDate(6);
			sueldo = rs.getDouble(7);
			rango = rs.getString(8);
			respuesta = new Trabajador(dni, nombre, apellidos, fechaNacimiento, sexo, fechaAltaEmpleado, rango, sueldo);
		}

		con.close();
		pst.close();
		rs.close();

		return (Object) respuesta;

	}

	@Override
	public int insertarActualizar(Object entrada, boolean esInsert) throws SQLException {
		Trabajador empleado = (Trabajador) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDempleados.insertEmpleado);
		else
			pst = con.prepareStatement(CRUDempleados.updateEmpleado);

		pst.setString(1, empleado.getDni());
		pst.setString(2, empleado.getNombre());
		pst.setString(3, empleado.getApellidos());
		pst.setDate(4, empleado.getFechaNacimiento());
		pst.setString(5, empleado.getSexo());
		pst.setDate(6, empleado.getFechaAltaEmpleado());
		pst.setDouble(7, empleado.getSueldo());
		pst.setString(8, empleado.getRango());

		if (!esInsert)
			pst.setString(9, empleado.getDni());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		String dniEmpleado = String.valueOf(entrada);
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDempleados.borrarEmpleado);
		pst.setString(1, dniEmpleado);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}
}
