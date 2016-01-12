package ordenacionObjetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pojo.Porte;

public class EstrategiaEnterosDesc implements Estrategia {

	@Override
	public void ordena(ArrayList<?> lista) {

		Comparator comparadorEnteros = (Comparator) (Object o1, Object o2) -> {
			Porte p1 = (Porte) o1;
			Porte p2 = (Porte) o2;

			return Integer.compare(p1.getIdPorte(), p2.getIdPorte());
		};
		
		Collections.sort(lista, comparadorEnteros);
	}

}
