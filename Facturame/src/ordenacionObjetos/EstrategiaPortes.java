package ordenacionObjetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pojo.Porte;

public class EstrategiaPortes implements Estrategia {

	@Override
	public void ordena(ArrayList<?> lista, int nCampo) {

		Comparator comparadorPortes = (Comparator) (Object o1, Object o2) -> {
			Porte p1 = (Porte) o1;
			Porte p2 = (Porte) o2;

			switch (nCampo) {
			case 1:
				return Integer.compare(p1.getIdPorte(), p2.getIdPorte());
			case 2:
				return p1.getnBastidor().compareTo(p2.getnBastidor());
			case 3:
				return p1.getDni().compareTo(p2.getDni());
			case 4:
				return Integer.compare(p1.getKgCarga(), p2.getKgCarga());
			case 5:
				return Integer.compare(p1.getVolCarga(), p2.getVolCarga());
			case 6:
				return p1.getConcepto().compareTo(p2.getConcepto());
			case 7:
				return Double.compare(p1.getPrecio(), p2.getPrecio());
			case 8:
				return Boolean.compare(p1.isEsGrupaje(), p2.isEsGrupaje());
			case 9:
				return p1.getDescripcion().compareTo(p2.getDescripcion());
			case 10:
				return p1.getNif().compareTo(p2.getNif());
			default:
				return Integer.compare(p1.getIdPorte(), p2.getIdPorte());
			}
		};

		Collections.sort(lista, comparadorPortes);
	}

}
