package composite;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import factorias.FactoriaCRUD;
import iterador.Agregado;
import iterador.AgregadoConcreto;
import iterador.Iterador;
import operacionesCRUD.CRUDempleados;
import operacionesCRUD.CRUDsubordinados;
import pojo.Subordinado;
import pojo.Trabajador;

public class AccesoEmpleados {

	private ArrayList<Object> empleados;
	private ArrayList<Object> jefes;
	private FactoriaCRUD fc;
	private CRUDempleados ce;
	private CRUDsubordinados cs;
	private ListMultimap<String, String> subordinados;
	private HashMap<String, TrabajadorC> trabajadoresComp;
	private Jefe jefe;

	public AccesoEmpleados(String dniJefe) throws SQLException, IOException {
		this.fc = new FactoriaCRUD();
		this.ce = (CRUDempleados) fc.crearCRUD(FactoriaCRUD.TIPO_EMPLEADO);
		this.cs = (CRUDsubordinados) fc.crearCRUD(FactoriaCRUD.TIPO_SUBORDINADO);
		this.empleados = new ArrayList<>(ce.buscarTodo());
		this.jefes = new ArrayList<>(cs.buscarTodo());
		this.subordinados = ArrayListMultimap.create();
		this.trabajadoresComp = new HashMap<String, TrabajadorC>();
		this.cargarTrabajadores();
		if (!subordinados.isEmpty())
			this.jefe = (Jefe) trabajadoresComp.get(dniJefe);
		else
			this.jefe = null;
	}

	private void cargarTrabajadores() {

		// primero se crea un mapa para ver quien es jefe de quien, y luego asi
		// instanciar.
		Agregado agregado = new AgregadoConcreto(jefes);
		Iterador iterador = agregado.crearIterador();

		try {
			while (iterador.hayMas()) {
				Subordinado s = (Subordinado) iterador.elementoActual();
				subordinados.put(s.getDniJefe(), s.getDniSubordinado());
				iterador.siguiente();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error: " + e.toString());
		}

		// lo siguiente es instanciar a los empleados dependiendo de si son
		// Jefes o empleados.
		agregado = new AgregadoConcreto(empleados);
		iterador = agregado.crearIterador();

		try {
			while (iterador.hayMas()) {

				Trabajador t = (Trabajador) iterador.elementoActual();
				if (subordinados.containsKey(t.getDni()))
					trabajadoresComp.put(t.getDni(), new Jefe(t.getRango(), t.getSueldo()));
				else
					trabajadoresComp.put(t.getDni(), new Empleado(t.getRango(), t.getSueldo()));
				iterador.siguiente();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error: " + e.toString());
		}

		for (Map.Entry entrada : subordinados.entries()) {

			Jefe t = (Jefe) trabajadoresComp.get((String) entrada.getKey());

			t.anadirSubordinado(trabajadoresComp.get((String) (entrada.getValue())));
			trabajadoresComp.put(String.valueOf(entrada.getKey()), t);
		}

	}

	public Double getSueldos() {
		if (jefe != null)
			return jefe.getSalarios();
		else
			return 0.0;
	}

	public String getDescripciones() {
		if (jefe != null)
			return jefe.getDescripcion();
		else
			return "No existen subordinados en la BD.";
	}
}
