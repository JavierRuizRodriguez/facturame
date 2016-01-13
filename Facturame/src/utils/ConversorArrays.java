package utils;

import java.util.ArrayList;

import pojo.Camion;
import pojo.Empresa;

public class ConversorArrays {

	public static ArrayList<Camion> convertirCamiones(ArrayList<Object> camionesO) {
		ArrayList<Camion> camiones = new ArrayList<Camion>();

		for (Object o : camionesO)
			camiones.add((Camion) o);

		return camiones;
	}

	public static ArrayList<Empresa> convertirEmpresas(ArrayList<Object> empresasO) {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();

		for (Object o : empresasO)
			empresas.add((Empresa) o);

		return empresas;
	}
}
