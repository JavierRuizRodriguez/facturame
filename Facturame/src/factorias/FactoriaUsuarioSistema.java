package factorias;

import java.security.NoSuchAlgorithmException;

import pojo.UsuarioSistema;

public class FactoriaUsuarioSistema {

	public UsuarioSistema crearUsuarioSistema(boolean admin) throws NoSuchAlgorithmException {
		if (admin)
			return new UsuarioSistema(true);
		else
			return new UsuarioSistema(false);
	}

}
