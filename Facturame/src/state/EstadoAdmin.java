package state;

import java.io.IOException;
import java.sql.SQLException;

import interfacesGraficas.VentanaLogin;
import interfacesGraficas.VentanaPrincipal;
/**
 * Clase que representa el estado logeado y con permisos de administrador.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class EstadoAdmin implements Estado{

	@Override
	public void ejecutar(VentanaLogin v) throws SQLException, IOException {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(v.getAuthUser());
		ventanaPrincipal.setVisible(true);		
		
	}

}
