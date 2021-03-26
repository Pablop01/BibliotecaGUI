package es.ieslavereda.biblioteca.common;

import java.util.Comparator;

public class TituloComparator implements Comparator<Libro>{

	@Override
	public int compare(Libro l1, Libro l2) {
		
		return l1.getTitulo().compareTo(l2.getTitulo());
		
	}


	
}
