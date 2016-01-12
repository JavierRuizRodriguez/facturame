import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import ordenacionObjetos.ContextoFacturas;
import ordenacionObjetos.EstrategiaPortes;
import pojo.Porte;

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

		// @SuppressWarnings("deprecation")
		// Date d = new Date(01, 01, 01);

		// CRUDempleados c = new CRUDempleados();
		// System.out.println(c.insertar(new Trabajador("09062732A", "Javier",
		// "manuel", Date.valueOf("2016-01-01"), "hombre",
		// Date.valueOf("2016-01-01"), "director", 1500.00)));
		/*
		 * System.out.println(c.buscarUnEmpleado("09062732L"));
		 * System.out.println(c.insertarActualizarEmpleado(new
		 * Trabajador("09062732A", "Emilio", "Emilio",
		 * Date.valueOf("2016-01-01"), "Emilio", Date.valueOf("2016-01-01"),
		 * "Emilio", 1500000.00), true));
		 */

		ArrayList<Porte> portes = new ArrayList<Porte>();

		portes.add(new Porte(2, "bb", "bb", 1, 1, "bb", 2, false, "bb", "bb"));
		portes.add(new Porte(4, "dd", "aa", 1, 1, "aa", 4, false, "aa", "aa"));
		portes.add(new Porte(5, "ee", "aa", 1, 1, "aa", 5, false, "aa", "aa"));
		portes.add(new Porte(3, "cc", "aa", 1, 1, "aa", 3, false, "aa", "aa"));
		portes.add(new Porte(1, "aa", "aa", 1, 1, "aa", 1, false, "aa", "aa"));

		EstrategiaPortes est = new EstrategiaPortes();
		ContextoFacturas con = new ContextoFacturas(portes, est);
		
		ArrayList<Porte> portesOrdenados = new ArrayList<Porte>(con.ejecutarEstrategia(4));
		
		for (Porte p:portesOrdenados)
			System.out.println(p.toString());
	}

}
