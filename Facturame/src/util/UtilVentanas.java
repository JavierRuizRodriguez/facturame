package util;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase sirve para la comprobaci�n de campos.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class UtilVentanas {

	/**
	 * M�todo de comprobaci�n de campos incompletos.
	 * 
	 * @param textos
	 * @return
	 */
	public static boolean textosIncompletos(ArrayList<JTextField> textos) {
		boolean textosIncompletos = true;
		for (JTextField texto : textos) {
			textosIncompletos = texto.getText().equals("") ? false : textosIncompletos;
		}
		return textosIncompletos;
	}

	/**
	 * M�todo para eliminar todos los datos de los campos de una ventana.
	 * 
	 * @param textos
	 */
	public static void borrarTextos(ArrayList<JTextField> textos) {
		for (JTextField texto : textos) {
			texto.setText("");
		}
	}

	/**
	 * 
	 * Esta clase sirve para mostrar mensajes de error o de acierto.
	 * 
	 * 
	 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
	 *
	 */
	public static class Alertas {
		public static String ERROR_CAMPOS_INCOMPLETOS = "Faltan campos por rellenar";
		public static String ERROR_JEFE_EMPLEADO_IGUAL = "No pueden ser la misma persona";
		public static String ERROR_SQL = "Error SQL: ";
		public static String ERROR_IOE = "Error IOE: ";
		public static String ERROR_IOB = "Error IOB: ";
		public static String EXITO_INSERT = "Exito al insertar ";
		public static String EXITO_FACTURA = "Exito al generar factura";

		/**
		 * M�todo que muestra los mensajes por pantalla.
		 * 
		 * @param tipo
		 * @param error
		 */
		public static void mostrar(String tipo, String error) {
			JOptionPane.showMessageDialog(null, tipo + error);
		}

	}

}
