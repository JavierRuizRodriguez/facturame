package utils;

import java.util.ArrayList;

import pojo.Camion;

public class ConversorArrays {

	public static ArrayList<Camion> convertirCamiones(ArrayList<Object> camionesO) {
		ArrayList<Camion> camiones = new ArrayList<Camion>();

		for (Object o : camionesO)
			camiones.add((Camion) o);

		return camiones;
	}
}
