package pojo;

public abstract class Vehiculo {

	private String nBastidor;
	private String matricula;
	private String combustible;
	private int nPasajeros;
	private int potenciaCV;
	private int potenciaKWh;
	private int KmTotales;
	private int peso;
	private double largo;
	private double ancho;
	private String descripcion;
	//FALTA METERLE LOS PATRONES DE ENTRADA A LAS VARIABLES NBASTIDOR, MATRICULA, COMBUSTIBLE, ETC...
	public Vehiculo(String nBastidor, String matricula, String combustible, int nPasajeros, int potenciaCV,
			int potenciaKWh, int kmTotales, int peso, double largo, double ancho, String descripcion) {
		super();
		this.nBastidor = nBastidor;
		this.matricula = matricula;
		this.combustible = combustible;
		this.nPasajeros = nPasajeros;
		this.potenciaCV = potenciaCV;
		this.potenciaKWh = potenciaKWh;
		KmTotales = kmTotales;
		this.peso = peso;
		this.largo = largo;
		this.ancho = ancho;
		this.descripcion = descripcion;
	}
	public String getnBastidor() {
		return nBastidor;
	}
	public void setnBastidor(String nBastidor) {
		this.nBastidor = nBastidor;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	public int getnPasajeros() {
		return nPasajeros;
	}
	public void setnPasajeros(int nPasajeros) {
		this.nPasajeros = nPasajeros;
	}
	public int getPotenciaCV() {
		return potenciaCV;
	}
	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}
	public int getPotenciaKWh() {
		return potenciaKWh;
	}
	public void setPotenciaKWh(int potenciaKWh) {
		this.potenciaKWh = potenciaKWh;
	}
	public int getKmTotales() {
		return KmTotales;
	}
	public void setKmTotales(int kmTotales) {
		KmTotales = kmTotales;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
