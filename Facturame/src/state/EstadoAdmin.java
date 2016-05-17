package state;

import java.io.IOException;
import java.sql.SQLException;

import interfacesGraficas.VentanaLogin;
import interfacesGraficas.VentanaPrincipal;

public class EstadoAdmin implements Estado{

	@Override
	public void ejecutar(VentanaLogin v) throws SQLException, IOException {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(v.getAuthUser());
		ventanaPrincipal.setVisible(true);		
		
	}

}
