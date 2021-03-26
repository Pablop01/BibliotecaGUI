package es.ieslavereda.biblioteca.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import es.ieslavereda.biblioteca.common.*;

public class Test implements Serializable{

	public static void main(String[] args)throws IOException{

		Biblioteca b = new Biblioteca();
		cargarListaLibros(b);
		cargarListaSocios(b);
		
		do {
			try {
				showMenu();
				seleccionarOpcion(b);
			} catch (Exception e) {
			}
		} while (true);
	}

	public static void showMenu() {

		System.out.println("	╔═══════════════════════════════════════════════╗");
		System.out.println("	║						║");
		System.out.println("	║	Biblioteca Municipal de La Pobla    	║");
		System.out.println("	║						║");
		System.out.println("	║	1. Dar de alta nuevo socio		║");
		System.out.println("	║	2. Añadir nuevo libro			║");
		System.out.println("	║	3. Añadir ejemplares			║");
		System.out.println("	║	4. Prestar ejemplar			║");
		System.out.println("	║	5. Devolver ejemplar			║");
		System.out.println("	║	6. Ver ejemplares de un libro		║");
		System.out.println("	║	7. Libros que tiene un socio		║");
		System.out.println("	║	8. Lista de socios			║");
		System.out.println("	║	9. Lista de libros			║");
		System.out.println("	║	10. Borrar base de datos		║");
		System.out.println("	║						║");
		System.out.println("	║	Elige una opción		   	║");
		System.out.println("	║						║");
		System.out.println("	╚═══════════════════════════════════════════════╝");
		System.out.println();

	}

	public static void seleccionarOpcion(Biblioteca b) throws IOException{

		Scanner sc = new Scanner(System.in);

		int opcion = sc.nextInt();

		switch (opcion) {

		case 1:
			crearSocio(b);
			break;
		case 2:
			crearLibro(b);
			break;
		case 3:
			addEjemplares(b);
			break;
		case 4:
			prestarEjemplar(b);
			break;
		case 5:
			devolverEjemplar(b);
			break;
		case 6:
			mostrarEjemplares(b);
			break;
		case 7:
			mostrarLibrosSocio(b);
			break;
		case 8:
			System.out.println("Elige como deseas ordenarlos");
			System.out.println("1. Por nombre");
			System.out.println("2. Por cantidad de libros prestados");
			System.out.println();
			mostrarSocios(b);
			break;
		case 9:
			System.out.println("Elige como deseas ordenarlos");
			System.out.println("1. Por titulo");
			System.out.println("2. Por autor");
			System.out.println("2. Por cantidad de ejemplares");
			System.out.println();
			mostrarLibros(b);
			break;
		case 10:
			borrarDatos(b);
			break;
		default:
			System.out.println("Elige una opción valida");
			seleccionarOpcion(b);

		}

	}

	public static void crearSocio(Biblioteca b) throws IOException{

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce los apellidos");
		String apellidos = sc.nextLine();
		System.out.println("Introduce el DNI");
		String dni = sc.nextLine();

		Persona p = new Persona(nombre, apellidos, dni);
		b.addSocio(p);
		guardarListaSocios(b);
	}

	public static void crearLibro(Biblioteca b) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el titulo");
		String titulo = sc.nextLine();
		System.out.println("Introduce el autor");
		String autor = sc.nextLine();
		System.out.println("Introduce el ISBN");
		int isbn = sc.nextInt();

		Libro l = new Libro(titulo, autor, isbn);
		b.addLibro(l);
		guardarListaLibros(b);
	}

	public static void addEjemplares(Biblioteca b) throws IOException{

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el ISBN del libro");

			int isbn = sc.nextInt();
			Libro l = b.buscarIsbn(isbn);
			System.out.println("Introduce la cantidad");

			int cantidad = sc.nextInt();
			l.addEjemplar(cantidad);
			guardarListaLibros(b);
		} catch (Exception e) {
			System.out.println("No hay nigun libro con ese ISBN");
		}
	}

	public static void prestarEjemplar(Biblioteca b) throws IOException{

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI de la persona");
		String dni = sc.nextLine();
		System.out.println("Introduce el ISBN del libro");
		int isbn = sc.nextInt();

		Persona p = b.buscarDNI(dni);
		Libro l = b.buscarIsbn(isbn);

		l.prestarEjemplar(p);
		guardarListaLibros(b);
		guardarListaSocios(b);

	}

	public static void devolverEjemplar(Biblioteca b) throws IOException{

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI de la persona");
		String dni = sc.nextLine();
		System.out.println("Introduce el ISBN del libro");
		int isbn = sc.nextInt();

		Persona p = b.buscarDNI(dni);
		Libro l = b.buscarIsbn(isbn);

		l.devolverEjemplar(p);
		guardarListaLibros(b);
		guardarListaSocios(b);

	}

	public static void mostrarEjemplares(Biblioteca b) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el ISBN del libro");

			int isbn = sc.nextInt();
			Libro l = b.buscarIsbn(isbn);
			System.out.println(l.getEjemplares());
		} catch (Exception e) {
			System.out.println("No hay nigun libro con ese ISBN");
		}
	}

	public static void mostrarLibrosSocio(Biblioteca b) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el DNI del socio");

			String dni = sc.nextLine();
			Persona p = b.buscarDNI(dni);
			System.out.println(p.imprimirLibros());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void mostrarSocios(Biblioteca b) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Persona> listaSocios = b.getListaSocios();

		int opcion = sc.nextInt();

		switch (opcion) {

		case 1:
			Collections.sort(listaSocios, new NombreComparator());
			System.out.println(listaSocios);
			break;
		case 2:
			Collections.sort(listaSocios, new PrestadosComparator());
			System.out.println(listaSocios);
			break;
		default:
			System.out.println("Introduce una opcion valida");
			mostrarSocios(b);

		}

	}

	public static void mostrarLibros(Biblioteca b) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Libro> listaLibros = b.getListaLibros();

		int opcion = sc.nextInt();

		switch (opcion) {

		case 1:
			Collections.sort(listaLibros, new TituloComparator());
			System.out.println(listaLibros);
			break;
		case 2:
			Collections.sort(listaLibros, new AutorComparator());
			System.out.println(listaLibros);
			break;
		case 3:
			Collections.sort(listaLibros, new CantidadComparator());
			System.out.println(listaLibros);
			break;
		default:
			System.out.println("Introduce una opcion valida");
			mostrarLibros(b);

		}
		
	}
	
	public static void guardarListaLibros(Biblioteca b) throws IOException{
		
		ObjectOutputStream escribiendoFichero = new ObjectOutputStream( 
	            new FileOutputStream("ListaLibros.dat") );
	            escribiendoFichero.writeObject(b.getListaLibros());
	            escribiendoFichero.close();
		
	}
	
	public static void guardarListaSocios(Biblioteca b) throws IOException{
		
		ObjectOutputStream escribiendoFichero = new ObjectOutputStream( 
	            new FileOutputStream("ListaSocios.dat") );
	            escribiendoFichero.writeObject(b.getListaSocios());
	            escribiendoFichero.close();
		
	}
	
	public static void cargarListaLibros(Biblioteca b) throws IOException{
		
		ArrayList<Libro> listaLibros2 = new ArrayList();

		try {
        ObjectInputStream leyendoFichero = new ObjectInputStream( 
        new FileInputStream("ListaLibros.dat") );
        listaLibros2 = ( ArrayList <Libro> )leyendoFichero.readObject();
        leyendoFichero.close();
        b.setListaLibros(listaLibros2);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void cargarListaSocios(Biblioteca b) throws IOException{
		
		ArrayList<Persona> listaSocios2 = new ArrayList();

		try {
        ObjectInputStream leyendoFichero = new ObjectInputStream( 
        new FileInputStream("ListaSocios.dat") );
        listaSocios2 = ( ArrayList <Persona> )leyendoFichero.readObject();
        leyendoFichero.close();
        b.setListaSocios(listaSocios2);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void borrarDatos(Biblioteca b) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Estas seguro de que quieres borrar todos los datos?");
		System.out.println("Los cambios serán irreversibles");
		System.out.println("");
		System.out.println("0. Si");
		System.out.println("1. No");
		
		int opcion = sc.nextInt();
		
		switch(opcion) {
			case 0:
		        File archivo1 = new File("ListaLibros.dat");
		        File archivo2 = new File("ListaSocios.dat");
		        
		       if( archivo1.delete() && archivo2.delete()) {
		    	   System.out.println("Datos borrados correctamente");
		       }
		        
		        b.vaciarListaLibros();
		        b.vaciarListaSocios();
		        
		        break;
			case 1:
				showMenu();
				seleccionarOpcion(b);
				break;
			default:
				System.out.println("Introduce una opcion valida");
				borrarDatos(b);
		
		}		
		
	}

}
