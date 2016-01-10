package pojo;

public abstract class Vehiculo {

	private String tipo;
	private String nBastidor;
	private String matricula;
	private String tCombustible;
	private int nPasajeros;
	private int potenciaCV;
	private int potenciaKWh;
	private int KmTotales;
	private int peso;
	private double largo;
	private double ancho;
	private String descripcion;
	//FALTA METERLE LOS PATRONES DE ENTRADA A LAS VARIABLES NBASTIDOR, MATRICULA, COMBUSTIBLE, ETC...

	public Vehiculo(String tipo, String nBastidor, String matricula, String tCombustible, int nPasajeros,
			int potenciaCV, int potenciaKWh, int kmTotales, int peso, double largo, double ancho, String descripcion) {
		this.tipo = tipo;
		this.nBastidor = nBastidor;
		this.matricula = matricula;
		this.tCombustible = tCombustible;
		this.nPasajeros = nPasajeros;
		this.potenciaCV = potenciaCV;
		this.potenciaKWh = potenciaKWh;
		this.KmTotales = kmTotales;
		this.peso = peso;
		this.largo = largo;
		this.ancho = ancho;
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String gettCombustible() {
		return tCombustible;
	}

	public void settCombustible(String tCombustible) {
		this.tCombustible = tCombustible;
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
