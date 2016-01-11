package pojo;

public class Porte {

	private int idPorte;
	private String nBastidor;
	private String dni;
	private int kgCarga;
	private int volCarga;
	private String concepto;
	private double precio;
	private boolean esGrupaje;
	private String descripcion;
	private String nif;

	public Porte(int idPorte, String nBastidor, String dni, int kgCarga, int volCarga, String concepto, double precio,
			boolean esGrupaje, String descripcion, String nif) {
		this.idPorte = idPorte;
		this.nBastidor = nBastidor;
		this.dni = dni;
		this.kgCarga = kgCarga;
		this.volCarga = volCarga;
		this.concepto = concepto;
		this.precio = precio;
		this.esGrupaje = esGrupaje;
		this.descripcion = descripcion;
		this.nif = nif;
	}

	public int getIdPorte() {
		return idPorte;
	}

	public void setIdPorte(int idPorte) {
		this.idPorte = idPorte;
	}

	public String getnBastidor() {
		return nBastidor;
	}

	public void setnBastidor(String nBastidor) {
		this.nBastidor = nBastidor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getKgCarga() {
		return kgCarga;
	}

	public void setKgCarga(int kgCarga) {
		this.kgCarga = kgCarga;
	}

	public int getVolCarga() {
		return volCarga;
	}

	public void setVolCarga(int volCarga) {
		this.volCarga = volCarga;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEsGrupaje() {
		return esGrupaje;
	}

	public void setEsGrupaje(boolean esGrupaje) {
		this.esGrupaje = esGrupaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

}
