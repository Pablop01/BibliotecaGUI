package es.ieslavereda.biblioteca.common;

import java.util.*;
import java.io.Serializable;

public class Libro implements Serializable{

	private String titulo;
	private String autor;
	private int isbn;
	private ArrayList<Ejemplar> ejemplares;
	private int disponibles;

	public Libro(String titulo, String autor, int isbn) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.ejemplares = new ArrayList<Ejemplar>();
		this.disponibles = 0;
	}

	public void addEjemplar() {
		this.ejemplares.add(new Ejemplar(this, ejemplares.size()));
		disponibles++;
	}

	public void addEjemplar(int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			addEjemplar();
		}
	}


	public boolean prestarEjemplar(Persona p) {

		int i = 0;

		if (disponibles > 0) {

			do {

				if (ejemplares.get(i).getaQuien() == null) {
					ejemplares.get(i).prestarEjemplar(this, p);
					break;
				}

				i++;
				
			} while (ejemplares.get(i - 1).getaQuien() != null);
			return true;
		} else {
			System.out.println("No quedan ejemplares disponibles");
			return false;
		}
	}
	
	public boolean devolverEjemplar(Persona p) {

		int i = 0;

		do {

			if (ejemplares.get(i).getaQuien() == p) {
				ejemplares.get(i).devolverEjemplar(this, p);
				return true;
			}

			i++;

		} while (ejemplares.get(i - 1).getaQuien() != p);
		return false;
	}

	public ArrayList<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
	
	public int getCantidadEjemplares() {
		return this.ejemplares.size();
	}

	@Override
	public String toString() {
//		return "Libro [ titulo = " + titulo + "\n" + "	autor = " + autor + "\n" + "	isbn = " + isbn + "\n"
//				+ " ejemplares = " + ejemplares + "]"+"\n";
		return titulo;
	}

}
