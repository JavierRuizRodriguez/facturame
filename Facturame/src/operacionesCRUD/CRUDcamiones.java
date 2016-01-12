package operacionesCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.Conexion;
import pojo.Camion;

public class CRUDcamiones {

	private static String selectAllCamion = "select * from \"Camion\"";
	private static String updateCamion = "UPDATE \"Camion\" SET \"nBastidor\"=?, matricula=?, combustible=?, \"nPasajeros\"=?, \"potenciaCV\"=?, \"potenciaKWh\"=?, \"kmTotales\"=?, peso=?, largo=?, ancho=?, \"longCaja\"=?, \"anchoCaja\"=?, \"pesoMaxCaja\"=?, \"volumenCaja\"=?, trampilla=?, descripcion=?, \"altoCaja\"=?, galibo=? where \"nBastidor\" = ?";
	private static String borrarCamion = "delete from \"Camion\" where \"nBastidor\" = ?";
	private static String insertCamion = "INSERT INTO \"Camion\"(\"nBastidor\", matricula, combustible, \"nPasajeros\", \"potenciaCV\",\"potenciaKWh\", \"kmTotales\", peso, largo, ancho, \"longCaja\", \"anchoCaja\", \"pesoMaxCaja\", \"volumenCaja\", trampilla, descripcion, \"altoCaja\", galibo)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String selectCamion = "select * from \"Camion\" where \"nBastidor\" = ?";

	public CRUDcamiones() {
	}

	public ArrayList<Camion> buscarTodosCamiones() throws SQLException {
		ArrayList<Camion> respuesta = new ArrayList<Camion>();

		Connection con;
		Statement st;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		st = con.createStatement();
		rs = st.executeQuery(CRUDcamiones.selectAllCamion);

		String nBastidor, matricula, combustible, descripcion;
		int nPasajeros, potenciaCV, PotenciaKWh, kmTotales, peso;
		Double largo, ancho, longCaja, anchoCaja, pesoMaxCaja, volumenCaja, altoCaja, galibo;
		boolean trampilla;

		while (rs.next()) {
			nBastidor = rs.getString(1);
			matricula = rs.getString(2);
			combustible = rs.getString(3);
			nPasajeros = rs.getInt(4);
			potenciaCV = rs.getInt(5);
			PotenciaKWh = rs.getInt(6);
			kmTotales = rs.getInt(7);
			peso = rs.getInt(8);
			largo = rs.getDouble(9);
			ancho = rs.getDouble(10);
			longCaja = rs.getDouble(11);
			anchoCaja = rs.getDouble(12);
			pesoMaxCaja = rs.getDouble(13);
			volumenCaja = rs.getDouble(14);
			trampilla = rs.getBoolean(15);
			descripcion = rs.getString(16);
			altoCaja = rs.getDouble(17);
			galibo = rs.getDouble(18);
			respuesta.add(new Camion(nBastidor, matricula, combustible, nPasajeros, potenciaCV, PotenciaKWh, kmTotales,
					peso, largo, ancho, longCaja, anchoCaja, pesoMaxCaja, volumenCaja, trampilla, descripcion, altoCaja,
					galibo));
		}

		con.close();
		st.close();
		rs.close();

		return respuesta;

	}

	public Camion buscarUnCamion(String nBastidorBuscado) throws SQLException {
		Camion respuesta = null;

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDcamiones.selectCamion);
		pst.setString(1, nBastidorBuscado);
		rs = pst.executeQuery();

		String nBastidor, matricula, combustible, descripcion;
		int nPasajeros, potenciaCV, PotenciaKWh, kmTotales, peso;
		Double largo, ancho, longCaja, anchoCaja, pesoMaxCaja, volumenCaja, altoCaja, galibo;
		boolean trampilla;

		while (rs.next()) {
			nBastidor = rs.getString(1);
			matricula = rs.getString(2);
			combustible = rs.getString(3);
			nPasajeros = rs.getInt(4);
			potenciaCV = rs.getInt(5);
			PotenciaKWh = rs.getInt(6);
			kmTotales = rs.getInt(7);
			peso = rs.getInt(8);
			largo = rs.getDouble(9);
			ancho = rs.getDouble(10);
			longCaja = rs.getDouble(11);
			anchoCaja = rs.getDouble(12);
			pesoMaxCaja = rs.getDouble(13);
			volumenCaja = rs.getDouble(14);
			trampilla = rs.getBoolean(15);
			descripcion = rs.getString(16);
			altoCaja = rs.getDouble(17);
			galibo = rs.getDouble(18);
			respuesta = new Camion(nBastidor, matricula, combustible, nPasajeros, potenciaCV, PotenciaKWh, kmTotales,
					peso, largo, ancho, longCaja, anchoCaja, pesoMaxCaja, volumenCaja, trampilla, descripcion, altoCaja,
					galibo);
		}

		con.close();
		pst.close();
		rs.close();

		return respuesta;

	}

	// mode 0 --> insert
	// mode 1 --> update
	public int insertarActualizarCamion(Camion camion, boolean esInsert) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		if (esInsert)
			pst = con.prepareStatement(CRUDcamiones.insertCamion);
		else
			pst = con.prepareStatement(CRUDcamiones.updateCamion);

		pst.setString(1, camion.getnBastidor());
		pst.setString(2, camion.getMatricula());
		pst.setString(3, camion.getCombustible());
		pst.setInt(4, camion.getnPasajeros());
		pst.setInt(5, camion.getPotenciaCV());
		pst.setInt(6, camion.getPotenciaKWh());
		pst.setInt(7, camion.getKmTotales());
		pst.setInt(8, camion.getPeso());
		pst.setDouble(9, camion.getLargo());
		pst.setDouble(10, camion.getAncho());
		pst.setDouble(11, camion.getLongCaja());
		pst.setDouble(12, camion.getAnchoCaja());
		pst.setDouble(13, camion.getPesoMaxCaja());
		pst.setDouble(14, camion.getVolumenCaja());
		pst.setBoolean(15, camion.isTrampilla());
		pst.setString(16, camion.getDescripcion());
		pst.setDouble(17, camion.getAlturaCaja());
		pst.setDouble(18, camion.getGalibo());

		if (!esInsert)
			pst.setString(19, camion.getnBastidor());

		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}

	public int borrarCamion(String nBastidor) throws SQLException {
		int respuesta = 0;
		Connection con;
		PreparedStatement pst;

		con = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
		pst = con.prepareStatement(CRUDcamiones.borrarCamion);
		pst.setString(1, nBastidor);
		respuesta = pst.executeUpdate();

		con.close();
		pst.close();

		return respuesta;

	}
}
