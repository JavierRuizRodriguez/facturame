import pojo.Empleado;
import pojo.Jefe;

public class Main {

	public static void main(String[] args) {
		Jefe t1 = new Jefe("director", 3000.00);
		Jefe j1 = new Jefe("director1", 2000.00); 
		Empleado t2 = new Empleado("chofer1", 1001.00);
		Empleado t3 = new Empleado("chofer2", 1002.00);
		Empleado t4 = new Empleado("chofer3", 1003.00);
		Empleado t5 = new Empleado("chofer4", 1004.00);
		
		t1.anadirSubordinado(t2);
		t1.anadirSubordinado(t3);
		j1.anadirSubordinado(t4);
		j1.anadirSubordinado(t5);
		t1.anadirSubordinado(j1);
		
		System.out.println(t1.getDescripciones());
		
		System.out.println(t1.getSueldos());

	}

}
