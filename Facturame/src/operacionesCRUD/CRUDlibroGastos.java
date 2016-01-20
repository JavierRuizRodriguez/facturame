package operacionesCRUD;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionProxyBBDD.Conexion;
import pojo.LibroGastos;

public class CRUDlibroGastos extends CRUDesquema {

	private static String selectAllGasto = "select * from \"LibroGastos\"";
	private static String updateGasto = "UPDATE \"LibroGastos\" SET \"idEntrada\"=?, concepto=?, dinero=?, \"fechaAsiento\"=?, descripcion=? WHERE \"idEntrada\" = ? ";
	private static String borrarGasto = "delete from \"LibroGastos\" where \"idEntrada\" = ?";
	private static String insertGasto = "INSERT INTO \"LibroGastos\"(\"idEntrada\", concepto, dinero, \"fechaAsiento\", descripcion) VALUES (?, ?, ?, ?, ?)";
	private static String selectGasto = "select * from \"LibroGastos\" where \"idEntrada\" = ?";

	private Conexion c;

	public CRUDlibroGastos() throws SQLException, IOException {
		super();
	}

	@Override
	public ArrayList<Object> buscarTodo() throws SQLException {
		c = cc.crearConexion();
		ArrayList<Object> respuesta = new ArrayList<Object>();

		c.setSt(c.getCon().createStatement());
		c.setRs(c.getSt().executeQuery(CRUDlibroGastos.selectAllGasto));

		String concepto, descripcion;
		int idEntrada;
		double dinero;
		Date fechaAsiento;
		ResultSet rs = c.getRs();

		while (rs.next()) {
			idEntrada = rs.getInt(1);
			concepto = rs.getString(2);
			dinero = rs.getDouble(3);
			fechaAsiento = rs.getDate(4);
			descripcion = rs.getString(5);

			respuesta.add((Object) new LibroGastos(idEntrada, concepto, dinero, fechaAsiento, descripcion));
		}

		c.cerrarObjCon();
		c.cerrarObjSt();
		c.cerrarObjRs();
		rs.close();

		return respuesta;

	}

	@Override
	public Object buscarUno(Object entrada) throws SQLException {
		c = cc.crearConexion();
		int idEntradaBuscado = (int) entrada;
		LibroGastos respuesta = null;

		c.setPst(c.getCon().prepareStatement(CRUDlibroGastos.selectGasto));
		c.prepararPst(1, idEntradaBuscado);
		c.setRs(c.getPst().executeQuery());

		String concepto, descripcion;
		int idEntrada;
		double dinero;
		Date fechaAsiento;
		ResultSet rs = c.getRs();

		while (rs.next()) {
			idEntrada = rs.getInt(1);
			concepto = rs.getString(2);
			dinero = rs.getDouble(3);
			fechaAsiento = rs.getDate(4);
			descripcion = rs.getString(5);

			respuesta = new LibroGastos(idEntrada, concepto, dinero, fechaAsiento, descripcion);
		}

		c.cerrarObjCon();
		c.cerrarObjPst();
		c.cerrarObjRs();
		rs.close();
		return (Object) respuesta;

	}

	// mode 0 --> insert
	// mode 1 --> update
	@Override
	public int insertarActualizar(Object entrada, boolean esInsert) throws SQLException {
		c = cc.crearConexion();
		LibroGastos gasto = (LibroGastos) entrada;
		int respuesta = 0;

		if (esInsert)
			c.setPst(c.getCon().prepareStatement(CRUDlibroGastos.insertGasto));
		else
			c.setPst(c.getCon().prepareStatement(CRUDlibroGastos.updateGasto));

		c.prepararPst(1, gasto.getIdEntrada());
		c.prepararPst(2, gasto.getConcepto());
		c.prepararPst(3, gasto.getDinero());
		c.prepararPst(4, gasto.getFechaAsiento());
		c.prepararPst(5, gasto.getDescripcion());

		if (!esInsert)
			c.prepararPst(6, gasto.getIdEntrada());

		respuesta = c.getPst().executeUpdate();

		c.cerrarObjCon();
		c.cerrarObjPst();

		return respuesta;

	}

	@Override
	public int borrar(Object entrada) throws SQLException {
		c = cc.crearConexion();
		int idEntrada = (int) entrada;
		int respuesta = 0;

		c.setPst(c.getCon().prepareStatement(CRUDlibroGastos.borrarGasto));
		c.prepararPst(1, idEntrada);
		respuesta = c.getPst().executeUpdate();

		c.cerrarObjCon();
		c.cerrarObjPst();

		return respuesta;

	}
}
