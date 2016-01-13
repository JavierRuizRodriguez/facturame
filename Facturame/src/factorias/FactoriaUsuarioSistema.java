package factorias;

import pojo.UsuarioSistema;

public class FactoriaUsuarioSistema {

	public static UsuarioSistema crearUsuarioSistema(boolean admin) {
		if (admin)
			return new UsuarioSistema(true);
		else
			return new UsuarioSistema(false);
	}

}
