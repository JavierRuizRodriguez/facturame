package operacionesCRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Porte;
import pojo.Viaje;

public class CRUDviajes extends CRUDesquema {

	private static String selectAllViaje = "select * from \"Viaje\"";
	private static String updateViaje = "UPDATE \"Viaje\" SET \"idViaje\"=?, \"lugarInicio\"=?, \"lugarDestino\"=?, \"horaInico\"=?, \"horaLlegada\"=?, \"fechaInico\"=?, \"fechaLlegada\"=?, \"kmViaje\"=?, \"idPorte\"=? WHERE \"idViaje\" = ?";
	private static String borrarViaje = "delete from \"Vieje\" where \"idViaje\"=?";
	private static String insertViaje = "INSERT INTO \"Viaje\"(\"idViaje\", \"lugarInicio\", \"lugarDestino\", \"horaInico\", \"horaLlegada\", \"fechaInico\", \"fechaLlegada\", \"kmViaje\", \"idPorte\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String selectViaje = "select * from \"Viaje\" where \"idViaje\" = ?";
	private static String getUltimoSerial = "SELECT last_value FROM \"Viaje_idViaje_seq\"";
	private static String setUltimoSerial ="ALTER SEQUENCE \"Viaje_idViaje_seq\" RESTART WITH ";
	private int idViajePeticion;

	public CRUDviajes() {
	}

<<<<<<< HEAD
	public ArrayList<Viaje> buscarTodosViajes() throws SQLException {
		ArrayList<Viaje> respuesta = new ArrayList<Viaje>();
=======
	public int setUltimoId(int ultimoId) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDviajes.setUltimoSerial.concat(String.valueOf(ultimoId)));
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}
	
	public int ultimoId() throws SQLException {
		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDviajes.getUltimoSerial);

		while (rs.next()) {
			idViajePeticion = rs.getInt(1);
		}

		con.close();
		st.close();
		rs.close();

		return idViajePeticion;
	}
	
	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		ArrayList<Object> respuesta = new ArrayList<Object>();
>>>>>>> feature/continuacionBuilder

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDviajes.selectAllViaje);

		String lugarInicio, lugarDestino;
		int idPorte, kmViaje, idViaje;
		Timestamp horaInicio, horaLlegada;
		Date fechaInicio, fechaLlegada;

		while (rs.next()) {
			idViaje = rs.getInt(1);
			lugarInicio = rs.getString(2);
			lugarDestino = rs.getString(3);
			horaInicio = rs.getTimestamp(4);
			horaLlegada = rs.getTimestamp(5);
			fechaInicio = rs.getDate(6);
			fechaLlegada = rs.getDate(7);
			kmViaje = rs.getInt(8);
			idPorte = rs.getInt(9);

			respuesta.add((Object) new Viaje(idViaje, lugarInicio, lugarDestino, horaInicio, horaLlegada, fechaInicio,
					fechaLlegada, kmViaje, idPorte));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	public Object buscarUno(Object entrada) throws SQLException {
		String idViajeBuscado = String.valueOf(entrada);
		Viaje respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDviajes.selectViaje);
		pst.setString(1, idViajeBuscado);
		rs = pst.executeQuery();

		String lugarInicio, lugarDestino;
		int idPorte, kmViaje, idViaje;
		Timestamp horaInicio, horaLlegada;
		Date fechaInicio, fechaLlegada;

		while (rs.next()) {
			idViaje = rs.getInt(1);
			lugarInicio = rs.getString(2);
			lugarDestino = rs.getString(3);
			horaInicio = rs.getTimestamp(4);
			horaLlegada = rs.getTimestamp(5);
			fechaInicio = rs.getDate(6);
			fechaLlegada = rs.getDate(7);
			kmViaje = rs.getInt(8);
			idPorte = rs.getInt(9);

			respuesta = new Viaje(idViaje, lugarInicio, lugarDestino, horaInicio, horaLlegada, fechaInicio,
					fechaLlegada, kmViaje, idPorte);
		}

		con.close();
		pst.close();
		rs.close();

		return (Object) respuesta;

	}

	public int insertarActualizar(Object entrada, boolean esInsert) throws SQLException {
		Viaje viaje = (Viaje) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDviajes.insertViaje);
		else
			pst = con.prepareStatement(CRUDviajes.updateViaje);

		pst.setInt(1, viaje.getIdViaje());
		pst.setString(2, viaje.getLugarInicio());
		pst.setString(3, viaje.getLugarDestino());
		pst.setTimestamp(4, viaje.getHoraInicio());
		pst.setTimestamp(5, viaje.getHoraLlegada());
		pst.setDate(6, viaje.getFechaInicio());
		pst.setDate(7, viaje.getFechaLlegada());
		pst.setInt(8, viaje.getKmViaje());
		pst.setInt(9, viaje.getIdPorte());

		if (!esInsert)
			pst.setInt(10, viaje.getIdViaje());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		int idViaje = (int) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDviajes.borrarViaje);
		pst.setInt(1, idViaje);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}
}
