package conexionProxyBBDD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import daos.CrearConexion;
import factorias.FactoriaConexion;

public class ProxyConexion implements CrearConexion {

	private FactoriaConexion fc;
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	public ProxyConexion() throws SecurityException, IOException {
		this.fh = new FileHandler("logs\\LogAccesoBD.log");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
	}

	@Override
	public Conexion crearConexion() throws SQLException {
		try {
			logger.info("El usuario " + " ha cogido un objeto conexión a las " + ".");
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		if (fc == null)
			fc = new FactoriaConexion();

		return fc.crearConexion();
	}

}
