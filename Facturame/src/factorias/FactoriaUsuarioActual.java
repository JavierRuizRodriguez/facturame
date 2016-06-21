package factorias;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import pojo.UsuarioAutenticacion;
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class FactoriaUsuarioActual {
	
	public UsuarioAutenticacion crearUserAct(String nickname, String pass) throws NoSuchAlgorithmException, SQLException, IOException{
		return new UsuarioAutenticacion(nickname, pass);
	}

}
