package es.ieslavereda.biblioteca.common;

import java.util.Comparator;

public class CantidadComparator implements Comparator<Libro>{

	@Override
	public int compare(Libro l1, Libro l2) {

		return Integer.compare(l1.getCantidadEjemplares(), l2.getCantidadEjemplares());
		
	}

}
