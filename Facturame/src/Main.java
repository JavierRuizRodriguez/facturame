import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import interfacesGraficas.VentanaPrincipal;
import pojo.UsuarioAutenticacion;

public class Main {

	public static void main(String[] args) throws SQLException, IOException, NoSuchAlgorithmException {
		// VentanaLogin login = VentanaLogin.getLogin();
		// login.setVisible(true);

//		PorteGrafico pg = new PorteGrafico();
//		CreadorPortes cp;
//		try {
//		cp = new CreadorPortes(null);
//		
//		cp.setPb(pg);
//		cp.hacerPorte();
//		 } catch (IOException | InterruptedException e1) {
//		 e1.printStackTrace();
//		 }

		 VentanaPrincipal v = new VentanaPrincipal(new
		 UsuarioAutenticacion("javier", "javato"));
		 v.setVisible(true);

	}
}
