package cargaDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Subordinado;
import pojo.Trabajador;

public class CRUDempleados {

	private static String selectAllEmpleado = "select * from \"Empleado\"";
	private static String updateEmpleado = "UPDATE \"Empleado\" SET dni=?, nombre=?, apellidos=?, \"fechaNacimiento\"=?, sexo=?, \"fechaAltaEmpleado\"=?, sueldo=?, rango=?	 WHERE dni=?";
	private static String selectAllSubordinado = "select * from \"Subordinado\"";
	private static String borrarEmpleado = "delete from \"Empleado\" where dni = ?";
	private static String insertEmpleado = "INSERT INTO \"Empleado\"(dni, nombre, apellidos, \"fechaNacimiento\", sexo, \"fechaAltaEmpleado\",sueldo, rango) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static String selectEmpleado = "select * from \"Empleado\" where dni = ?";

	public CRUDempleados() {
	}

	public ArrayList<Trabajador> buscarTodosEmpleados() throws SQLException {
		ArrayList<Trabajador> respuesta = new ArrayList<Trabajador>();

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
			respuesta.add(
					new Trabajador(dni, nombre, apellidos, fechaNacimiento, sexo, fechaAltaEmpleado, rango, sueldo));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	public ArrayList<Trabajador> buscarUnEmpleados(String dniBuscado) throws SQLException {
		ArrayList<Trabajador> respuesta = new ArrayList<Trabajador>();

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
			respuesta.add(
					new Trabajador(dni, nombre, apellidos, fechaNacimiento, sexo, fechaAltaEmpleado, rango, sueldo));
		}

		con.close();
		pst.close();
		rs.close();

		return respuesta;

	}

	public Integer actualizarEmpleados(Trabajador empleado) throws SQLException {
		Integer respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDempleados.updateEmpleado);
		pst.setString(1, empleado.getDni());
		pst.setString(2, empleado.getNombre());
		pst.setString(3, empleado.getApellidos());
		pst.setDate(4, empleado.getFechaNacimiento());
		pst.setString(5, empleado.getSexo());
		pst.setDate(6, empleado.getFechaAltaEmpleado());
		pst.setDouble(7, empleado.getSueldo());
		pst.setString(8, empleado.getRango());
		pst.setString(9, empleado.getDni());
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	public Integer insertarTrabajador(Trabajador empleado) throws SQLException {
		Integer respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDempleados.insertEmpleado);
		pst.setString(1, empleado.getDni());
		pst.setString(2, empleado.getNombre());
		pst.setString(3, empleado.getApellidos());
		pst.setDate(4, empleado.getFechaNacimiento());
		pst.setString(5, empleado.getSexo());
		pst.setDate(6, empleado.getFechaAltaEmpleado());
		pst.setDouble(7, empleado.getSueldo());
		pst.setString(8, empleado.getRango());
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	public Integer borrarTrabajador(String dniEmpleado) throws SQLException {
		Integer respuesta = 0;
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

	private ArrayList<Subordinado> buscarEnSubordinados() throws SQLException {
		ArrayList<Subordinado> respuesta = new ArrayList<Subordinado>();
		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDempleados.selectAllSubordinado);
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

}
