package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreadorHashes {

	private static CreadorHashes ch;
	private MessageDigest md;

	private CreadorHashes() throws NoSuchAlgorithmException {
		this.md = MessageDigest.getInstance("MD5");
	}

	public String generarHash(String pass) {
		md.update(pass.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

	public static CreadorHashes getCreadorHashes() throws NoSuchAlgorithmException {
		if (ch == null)
			ch = new CreadorHashes();
		return ch;
	}

}
