package factorias;

import operacionesCRUD.CRUDcamiones;
import operacionesCRUD.CRUDempleados;
import operacionesCRUD.CRUDempresa;
import operacionesCRUD.CRUDesquema;
import operacionesCRUD.CRUDusuariosSistema;
import operacionesCRUD.CRUDviajes;

public class FactiriaCRUD {
	
	private static int TIPO_CAMION= 1;
	private static int TIPO_EMPLEADO= 2;
	private static int TIPO_EMPRESA= 3;
	private static int TIPO_GASTO= 4;
	private static int TIPO_PORTE= 5;
	private static int TIPO_SUBORDINADO= 6;
	private static int TIPO_US_SISTEMA= 7;
	private static int TIPO_VIAJE= 8;
	
	//hay que controlar el null devuelto
	public CRUDesquema crearCRUD(int tipo){
		switch(tipo){
		case 1: return new CRUDcamiones();
		case 2: return new CRUDempleados();
		case 3: return new CRUDempresa();
		//case 4: return new CRUDgasto();
		//case 5: return new CRUDporte();
		//case 6: return new CRUDsubordinado();
		//case 7: return new CRUDusuariosSistema();
		//case 8: return new CRUDviajes();
		default: return null;		
															
		}
	}
	
	

}
