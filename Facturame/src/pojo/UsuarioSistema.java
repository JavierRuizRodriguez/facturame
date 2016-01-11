package pojo;

import java.sql.Date;

public class UsuarioSistema {
	
	private String dni;
	private String nickname;
	private String hashContrasena;
	private boolean admin;
	private Date fechaAltaUsuario;
	
	public UsuarioSistema(String dni, String nickname, String hashContrasena, boolean admin, Date fechaAltaUsuario) {
		super();
		this.dni = dni;
		this.nickname = nickname;
		this.hashContrasena = hashContrasena;
		this.admin = admin;
		this.fechaAltaUsuario = fechaAltaUsuario;
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

	public void setHashContraseña(String hashContrasena) {
		this.hashContrasena = hashContrasena;
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
