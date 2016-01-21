import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;

import interfacesGraficas.VentanaEmpleado;
import interfacesGraficas.VentanaLogin;
import interfacesGraficas.VentanaUsuarioSistema;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException, IOException, NoSuchAlgorithmException {
		VentanaLogin login = VentanaLogin.getLogin();
		login.setVisible(true);
		
	}

}
