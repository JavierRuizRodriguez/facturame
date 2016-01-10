package pojo;

public class Camion extends Vehiculo {

	private double longCaja;
	private double anchoCaja;
	private double pesoMaxCaja;
	private double volumenCaja;
	private boolean trampilla;
	
	public Camion(String tipo, String nBastidor, String matricula, String tCombustible, int nPasajeros, int potenciaCV,
			int potenciaKWh, int kmTotales, int peso, double largo, double ancho, String descripcion, double longCaja,
			double anchoCaja, double pesoMaxCaja, double volumenCaja, boolean trampilla) {
		super(tipo, nBastidor, matricula, tCombustible, nPasajeros, potenciaCV, potenciaKWh, kmTotales, peso, largo,
				ancho, descripcion);
		this.longCaja = longCaja;
		this.anchoCaja = anchoCaja;
		this.pesoMaxCaja = pesoMaxCaja;
		this.volumenCaja = volumenCaja;
		this.trampilla = trampilla;
	}
	
	public double getLongCaja() {
		return longCaja;
	}
	public void setLongCaja(double longCaja) {
		this.longCaja = longCaja;
	}
	public double getAnchoCaja() {
		return anchoCaja;
	}
	public void setAnchoCaja(double anchoCaja) {
		this.anchoCaja = anchoCaja;
	}
	public double getPesoMaxCaja() {
		return pesoMaxCaja;
	}
	public void setPesoMaxCaja(double pesoMaxCaja) {
		this.pesoMaxCaja = pesoMaxCaja;
	}
	public double getVolumenCaja() {
		return volumenCaja;
	}
	public void setVolumenCaja(double volumenCaja) {
		this.volumenCaja = volumenCaja;
	}
	public boolean isTrampilla() {
		return trampilla;
	}
	public void setTrampilla(boolean trampilla) {
		this.trampilla = trampilla;
	}

	
}
