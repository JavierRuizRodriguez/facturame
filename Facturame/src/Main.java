import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import interfacesGraficas.VentanaLogin;

/**
 * @author Javier
 *
 */
public class Main {

	public static void main(String[] args)
			throws SQLException, IOException, InterruptedException, NoSuchAlgorithmException {
		 VentanaLogin login = VentanaLogin.getLogin();
		 login.setVisible(true);

	}
}
