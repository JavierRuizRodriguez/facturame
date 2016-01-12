package factorias;

import pojo.UsuarioSistema;

public class FactoriaUsuarioSistema {

	public UsuarioSistema crearUsuarioSistema(boolean admin) {
		if (admin)
			return new UsuarioSistema(true);
		else
			return new UsuarioSistema(false);
	}

}
