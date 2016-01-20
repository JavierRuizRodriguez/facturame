package pojo;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import util.CreadorHashes;

public class UsuarioSistema {
	
	private String dni;
	private String nickname;
	private String hashContrasena;
	private boolean admin;
	private Date fechaAltaUsuario;
	private CreadorHashes ch;
	
	public UsuarioSistema(String dni, String nickname, String pass, boolean admin, Date fechaAltaUsuario) throws NoSuchAlgorithmException {
		super();
		this.ch = CreadorHashes.getCreadorHashes();
		this.dni = dni;
		this.nickname = nickname;
		this.hashContrasena = ch.generarHash(pass);
		this.admin = admin;
		this.fechaAltaUsuario = fechaAltaUsuario;
	}

	public UsuarioSistema(boolean admin) {
		this.admin = admin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHashContraseña() {
		return hashContrasena;
	}

	public void setHashContraseña(String pass) {
		this.hashContrasena = ch.generarHash(pass);
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getFechaAltaUsuario() {
		return fechaAltaUsuario;
	}

	public void setFechaAltaUsuario(Date fechaAltaUsuario) {
		this.fechaAltaUsuario = fechaAltaUsuario;
	}

}
