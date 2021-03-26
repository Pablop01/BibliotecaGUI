package es.ieslavereda.biblioteca.common;

import java.util.Comparator;

public class PrestadosComparator implements Comparator<Persona>{

	@Override
	public int compare(Persona p1, Persona p2) {
		
		return Integer.compare(p1.getCantidadLibros(),p2.getCantidadLibros());
		
	}

}
