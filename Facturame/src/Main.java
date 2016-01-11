import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import operacionesCRUD.CRUDempleados;
import pojo.Trabajador;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {
		/*
		 * Jefe t1 = new Jefe("director", 3000.00); Jefe j1 = new
		 * Jefe("director1", 2000.00); Empleado t2 = new Empleado("chofer1",
		 * 1001.00); Empleado t3 = new Empleado("chofer2", 1002.00); Empleado t4
		 * = new Empleado("chofer3", 1003.00); Empleado t5 = new
		 * Empleado("chofer4", 1004.00);
		 * 
		 * t1.anadirSubordinado(t2); t1.anadirSubordinado(t3);
		 * j1.anadirSubordinado(t4); j1.anadirSubordinado(t5);
		 * t1.anadirSubordinado(j1);
		 */
		// System.out.println(t1.getDescripciones());

		// System.out.println(t1.getSueldos());

		@SuppressWarnings("deprecation")
		Date d = new Date(01, 01, 01);

		CRUDempleados c = new CRUDempleados();
		// System.out.println(c.insertar(new Trabajador("09062732A", "Javier",
		// "manuel", Date.valueOf("2016-01-01"), "hombre",
		// Date.valueOf("2016-01-01"), "director", 1500.00)));
		System.out.println(c.buscarUnEmpleado("09062732L"));
		System.out.println(c.insertarActualizaEmpleado(new Trabajador("09062732A", "Emilio", "Emilio",
				Date.valueOf("2016-01-01"), "Emilio", Date.valueOf("2016-01-01"), "Emilio", 1500000.00), true));
	}

}
