package es.ieslavereda.biblioteca.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable{

	private String nombre;
	private String apellidos;
	private String dni;
	private ArrayList<Ejemplar> librosActuales;
	
	public Persona(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.librosActuales = new ArrayList<Ejemplar>();

	}

	public int getCantidadLibros() {
		return librosActuales.size();
	}
	
	public void setLibrosActuales(ArrayList<Ejemplar> librosActuales) {
		this.librosActuales = librosActuales;
	}

	public ArrayList<Ejemplar> getLibrosActuales() {
		return librosActuales;
	}
	
	public String imprimirLibros() {
		String salida = "Libros que tiene "+this.nombre+" "+this.apellidos+": ";
		ArrayList<Ejemplar> ejemplares = getLibrosActuales();
		
		for(Ejemplar e : ejemplares) {
			salida += e.getLibro().getTitulo() + " " + e.getCodigo()+" ";
		}
		
		return salida;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
		
	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
	
}
