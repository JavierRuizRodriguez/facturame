package pojo;

public class Empresa {

	private String nif;
	private String empresa;
	private String direccion;
	private int nTelefono;
	private String email;

	public Empresa(String nif, String empresa, String direccion, int nTelefono, String email) {
		this.nif = nif;
		this.empresa = empresa;
		this.direccion = direccion;
		this.nTelefono = nTelefono;
		this.email = email;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getnTelefono() {
		return nTelefono;
	}

	public void setnTelefono(int nTelefono) {
		this.nTelefono = nTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
