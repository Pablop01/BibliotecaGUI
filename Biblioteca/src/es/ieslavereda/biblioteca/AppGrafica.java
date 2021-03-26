package es.ieslavereda.biblioteca;

import java.awt.EventQueue;

import es.ieslavereda.biblioteca.controlador.Controlador;
import es.ieslavereda.biblioteca.vista.BibliotecaVista;

public class AppGrafica {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliotecaVista frame = new BibliotecaVista();
					Controlador controlador = new Controlador(frame);
					controlador.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
