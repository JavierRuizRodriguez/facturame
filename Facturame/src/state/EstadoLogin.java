package state;

import interfacesGraficas.VentanaLogin;

public class EstadoLogin implements Estado{

	@Override
	public void ejecutar(VentanaLogin v) {
		if (v.getAuthUser().isAdmin())
			v.setEstadoActual(new EstadoAdmin());
		else
			v.setEstadoActual(new EstadoNoAdmin());
	}

}
