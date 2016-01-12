package factorias;

import pojo.Empresa;

public class FactoriaCliente {

	public Empresa crearEmpresa(int tipo) {
		return new Empresa();
	}

}
