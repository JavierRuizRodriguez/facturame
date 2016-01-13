package factorias;

import pojo.Empresa;

public class FactoriaEmpresa {

	public Empresa crearEmpresa(int tipo) {
		return new Empresa();
	}

}
