package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para la creaci�n de hashes para el almacenamiento de contrase�as.
 */
/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class CreadorHashes {

	/**
	 * Objeto de s� mismo para el patr�n singleton
	 */
	private static CreadorHashes ch;
	/**
	 * Objeto para la generaci�n de hashes
	 */
	private MessageDigest md;

	/**
	 * Constructor principal.
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private CreadorHashes() throws NoSuchAlgorithmException {
		this.md = MessageDigest.getInstance("MD5");
	}

	/**
	 * Metodo de generaci�n de hashes a partir de una contrase�a.
	 * 
	 * @param pass
	 * @return
	 */
	public String generarHash(String pass) {
		md.update(pass.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

	/**
	 * M�todo de instanciaci�n del objeto Singleton.
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static CreadorHashes getCreadorHashes() throws NoSuchAlgorithmException {
		if (ch == null)
			ch = new CreadorHashes();
		return ch;
	}

}
