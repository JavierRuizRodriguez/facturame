package pojo;

public abstract class Trabajador{
	
	private String rango;	
	private double sueldo;
	
	public Trabajador(String rango, double sueldo){
		this.rango = rango;
		this.sueldo = sueldo;
	}
	
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "|Trabajador| -> Puesto: " + rango + ", sueldo: " + sueldo + ".";
	}
	
	public abstract void anadirSubordinado(Trabajador trabajador);
	
	public abstract void eliminarSubordinado(Trabajador trabajador);
	
	public abstract double getSueldos();
	
	public abstract String getDescripciones();
	
	
	
	
	
	

}
