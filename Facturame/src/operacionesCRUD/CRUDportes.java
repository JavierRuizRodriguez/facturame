package operacionesCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Porte;

public class CRUDportes extends CRUDesquema {

	private static String selectAllPorte = "select * from \"Porte\"";
	private static String updatePorte = "UPDATE \"Porte\" SET \"idPorte\"=?, \"nBastidor\"=?, dni=?, \"kgCarga\"=?, \"volumenCarga\"=?, concepto=?, precio=?, \"esGrupaje\"=?, descripcion=?, \"NIF\"=? WHERE \"idPorte\"=?";
	private static String borrarPorte = "delete from \"Porte\" where \"idPorte\"=?";
	private static String insertPorte = "INSERT INTO \"Porte\"(\"idPorte\", \"nBastidor\", dni, \"kgCarga\", \"volumenCarga\", concepto, precio, \"esGrupaje\", descripcion, \"NIF\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String selectPorte = "select * from \"Porte\" where \"idPorte\" = ?";
	private static String getUltimoSerial = "SELECT last_value FROM \"Porte_idPorte_seq\"";
	private static String setUltimoSerial ="ALTER SEQUENCE \"Porte_idPorte_seq\" RESTART WITH ";
	private int idPorteSeq;

	public CRUDportes() {
		idPorteSeq = 0;
	}

	public int setUltimoId(int ultimoId) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDportes.setUltimoSerial.concat(String.valueOf(ultimoId)));
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}
	
	public int getUltimoId() throws SQLException {
		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDportes.getUltimoSerial);

		while (rs.next()) {
			idPorteSeq = rs.getInt(1);
		}

		con.close();
		st.close();
		rs.close();

		return idPorteSeq;
	}

	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		ArrayList<Object> respuesta = new ArrayList<Object>();

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDportes.selectAllPorte);

		String nBastidor, dni, concepto, descripcion, nif;
		int idPorte, kgCarga, volCarga;
		double precio;
		boolean esGrupaje;

		while (rs.next()) {
			idPorte = rs.getInt(1);
			nBastidor = rs.getString(2);
			dni = rs.getString(3);
			kgCarga = rs.getInt(4);
			volCarga = rs.getInt(5);
			concepto = rs.getString(6);
			precio = rs.getDouble(7);
			esGrupaje = rs.getBoolean(8);
			descripcion = rs.getString(9);
			nif = rs.getString(10);

			respuesta.add((Object) new Porte(idPorte, nBastidor, dni, kgCarga, volCarga, concepto, precio, esGrupaje,
					descripcion, nif));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	public Object buscarUno(Object entrada) throws SQLException {
		String idPorteBuscado = String.valueOf(entrada);
		Object respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDportes.selectPorte);
		pst.setString(1, idPorteBuscado);
		rs = pst.executeQuery();

		String nBastidor, dni, concepto, descripcion, nif;
		int idPorte, kgCarga, volCarga;
		double precio;
		boolean esGrupaje;

		while (rs.next()) {
			idPorte = rs.getInt(1);
			nBastidor = rs.getString(2);
			dni = rs.getString(3);
			kgCarga = rs.getInt(4);
			volCarga = rs.getInt(5);
			concepto = rs.getString(6);
			precio = rs.getDouble(7);
			esGrupaje = rs.getBoolean(8);
			descripcion = rs.getString(9);
			nif = rs.getString(10);

			respuesta = new Porte(idPorte, nBastidor, dni, kgCarga, volCarga, concepto, precio, esGrupaje, descripcion,
					nif);
		}

		con.close();
		pst.close();
		rs.close();

		return (Object) respuesta;

	}

	public int insertarActualizar(Object entrada, boolean esInsert) throws SQLException {
		Porte porte = (Porte) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDportes.insertPorte);
		else
			pst = con.prepareStatement(CRUDportes.updatePorte);

		pst.setInt(1, porte.getIdPorte());
		pst.setString(2, porte.getnBastidor());
		pst.setString(3, porte.getDni());
		pst.setInt(4, porte.getKgCarga());
		pst.setInt(5, porte.getVolCarga());
		pst.setString(6, porte.getConcepto());
		pst.setDouble(7, porte.getPrecio());
		pst.setBoolean(8, porte.isEsGrupaje());
		pst.setString(9, porte.getDescripcion());
		pst.setString(10, porte.getNif());

		if (!esInsert)
			pst.setInt(11, porte.getIdPorte());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		int idPorte = (int) entrada;
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDportes.borrarPorte);
		pst.setInt(1, idPorte);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

}
