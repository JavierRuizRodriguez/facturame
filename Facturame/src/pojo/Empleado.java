package pojo;

public class Empleado extends Trabajador{

	public Empleado(String rango, double salario){
		super(rango, salario);		
	}

	@Override
	public void anadirSubordinado(Trabajador trabajador) {}

	@Override
	public void eliminarSubordinado(Trabajador trabajador) {}

	@Override
	public double getSueldos() {
		return this.getSueldo();
	}

	@Override
	public String getDescripciones() {
		return "···" + this.toString();
	}
}
