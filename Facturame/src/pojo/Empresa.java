package pojo;

public class Empresa {

	private String NIF;
	private String empresa;
	private String direccion;
	private int nTelefono;
	private String email;
	
	public Empresa(String nIF, String empresa, String direccion, int nTelefono, String email) {
		super();
		NIF = nIF;
		this.empresa = empresa;
		this.direccion = direccion;
		this.nTelefono = nTelefono;
		this.email = email;
	}
	
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
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
