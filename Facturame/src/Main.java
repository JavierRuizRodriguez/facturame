import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import interfacesGraficas.VentanaLogin;
/**
 * Punto de partida de la aplicaci�n. Inicializa la ventana de login y posteriormente la muestra.
 */

/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class Main {

	/**
	 * M�todo principal del programa.
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws NoSuchAlgorithmException
	 */
	public static void main(String[] args)
			throws SQLException, IOException, InterruptedException, NoSuchAlgorithmException {
		 VentanaLogin login = VentanaLogin.getLogin();
		 login.setVisible(true);

	}
}
