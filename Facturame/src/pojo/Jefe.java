package pojo;

import java.util.ArrayList;

public class Jefe extends Trabajador {
	
	private ArrayList<Trabajador> subordinados;
	
	public Jefe(String rango, double salario){
		super(rango, salario);
		subordinados = new ArrayList<Trabajador>();
	}

	@Override
	public double getSueldos() {
		double saldoTotal = this.getSueldo();		
		for(Trabajador t : subordinados){
			saldoTotal += t.getSueldos();
		}
		return saldoTotal;
	}

	@Override
	public String getDescripciones() {
		String descripcion = this.toString();
		for(Trabajador t : subordinados){
			descripcion += "\n\t···" + t.getDescripciones();
		}
		return descripcion;
	}
	
	@Override
	public void anadirSubordinado(Trabajador trabajador) {
		subordinados.add(trabajador);		
	}

	@Override
	public void eliminarSubordinado(Trabajador trabajador) {
		subordinados.remove(trabajador);
	}

}
