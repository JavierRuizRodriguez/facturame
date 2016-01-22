package util;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UtilVentanas {

	public static boolean textosIncompletos(ArrayList<JTextField> textos) {
		boolean textosIncompletos = true;
		for (JTextField texto : textos) {
			textosIncompletos = texto.getText().equals("") ? false : textosIncompletos;
		}
		return textosIncompletos;
	}

	public static void borrarTextos(ArrayList<JTextField> textos) {
		for (JTextField texto : textos) {
			texto.setText("");
		}
	}

	public static class Alertas {
		public static String ERROR_CAMPOS_INCOMPLETOS = "Faltan campos por rellenar";
		public static String ERROR_JEFE_EMPLEADO_IGUAL = "No pueden ser la misma persona";
		public static String ERROR_SQL = "Error SQL: ";
		public static String ERROR_IOE = "Error IOE: ";
		public static String ERROR_IOB = "Error IOB: ";
		public static String EXITO_INSERT = "Exito Insert";

		public static void mostrar(String tipo, String error) {
			JOptionPane.showMessageDialog(null, tipo + error);
		}

	}

}
