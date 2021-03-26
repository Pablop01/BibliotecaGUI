package es.ieslavereda.biblioteca.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.ieslavereda.biblioteca.common.Biblioteca;
import es.ieslavereda.biblioteca.common.Ejemplar;
import es.ieslavereda.biblioteca.common.Libro;
import es.ieslavereda.biblioteca.common.Persona;
import es.ieslavereda.biblioteca.vista.AñadirEjemplares;
import es.ieslavereda.biblioteca.vista.BibliotecaVista;
import es.ieslavereda.biblioteca.vista.DevolverLibro;
import es.ieslavereda.biblioteca.vista.InsertarLibro;
import es.ieslavereda.biblioteca.vista.InsertarPersona;
import es.ieslavereda.biblioteca.vista.Prestar;
import es.ieslavereda.biblioteca.vista.TablaLibros;
import es.ieslavereda.biblioteca.vista.TablaSocios;

public class Controlador implements ActionListener {

	private BibliotecaVista vista;
	private InsertarLibro vistaInsertarL;
	private Prestar vistaPrestarL;
	private InsertarPersona vistaInsertarP;
	private AñadirEjemplares vistaAñadirE;
	private TablaSocios vistaTablaS;
	private TablaLibros vistaTablaL;
	private DevolverLibro vistaDevolver;
	private Biblioteca b;
	private Persona p;

	public Controlador(BibliotecaVista vista) {
		super();
		this.vista = vista;

		inicializar();
	}

	private void inicializar() {

		b = new Biblioteca();

		// Add ActionListener
		vista.getBtnInsertarLibro().addActionListener(this);
		vista.getBtnPrestar().addActionListener(this);
		vista.getBtnInsertarUsuario().addActionListener(this);
		vista.getBtnAadirEjemplares().addActionListener(this);
		vista.getBtnMostrar().addActionListener(this);
		vista.getBtnMostrarUsuarios().addActionListener(this);
		vista.getMntmGuardar().addActionListener(this);
		vista.getMntmImportar().addActionListener(this);
		vista.getBtnDevolver().addActionListener(this);

		// Add ActionCommand
		vista.getBtnInsertarLibro().setActionCommand("Insertar Libro Vista");
		vista.getBtnPrestar().setActionCommand("Prestar Libro Vista");
		vista.getBtnInsertarUsuario().setActionCommand("Insertar Usuario Vista");
		vista.getBtnAadirEjemplares().setActionCommand("Añadir ejemplares Vista");
		vista.getBtnMostrar().setActionCommand("Mostrar Libros");
		vista.getBtnMostrarUsuarios().setActionCommand("Mostrar Usuarios");
		vista.getMntmGuardar().setActionCommand("Guardar");
		vista.getMntmImportar().setActionCommand("Importar");
		vista.getBtnDevolver().setActionCommand("Devolver Libro Vista");

	}

	public void go() {

		vista.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("Insertar Libro Vista")) {
			insertarLibroVista();
		} else if (comando.equals("Prestar Libro Vista")) {
			prestarLibroVista();
		} else if (comando.equals("Insertar Libro")) {
			insertarLibro();
		} else if (comando.equals("Limpiar Campos Libro")) {
			limpiarCamposLibro();
		} else if (comando.equals("Insertar Usuario Vista")) {
			insertarUsuarioVista();
		} else if (comando.equals("Limpiar Campos Usuario")) {
			limpiarCamposUsuario();
		} else if (comando.equals("Insertar Usuario")) {
			insertarUsuario();
		} else if (comando.equals("Añadir ejemplares Vista")) {
			añadirEjemplaresVista();
		} else if (comando.equals("Insertar Ejemplares")) {
			añadirEjemplares();
		} else if (comando.equals("Prestar Libro")) {
			prestarLibro();
		} else if (comando.equals("Mostrar Usuarios")) {
			mostrarUsuarios();
		} else if (comando.equals("Mostrar Libros")) {
			mostrarLibros();
		} else if (comando.equals("Guardar")) {
			guardar();
		} else if (comando.equals("Importar")) {
			importar();
		} else if (comando.equals("Devolver Libro Vista")) {
			devolverLibroVista();
		} else if (comando.equals("Seleccionar")) {
			seleccionarSocio();
		} else if (comando.equals("Devolver")) {
			devolverLibro();
		}

	}

	private void devolverLibro() {

		try {
			Ejemplar e = (Ejemplar) vistaDevolver.getComboBoxEjemplares().getSelectedItem();
			Libro l = e.getLibro();
			p = (Persona) vistaDevolver.getComboBoxSocios().getSelectedItem();

			if (l.devolverEjemplar(p)) {
				JOptionPane.showMessageDialog(null, "Devolucion procesada correctamente", "Correcto",
						JOptionPane.INFORMATION_MESSAGE);

				vistaDevolver.dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tienes que seleccionar un socio y un libro", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	private void seleccionarSocio() {

		try {

			p = (Persona) vistaDevolver.getComboBoxSocios().getSelectedItem();
			DefaultComboBoxModel dcbLibros = new DefaultComboBoxModel();

			for (Ejemplar e : p.getLibrosActuales()) {

				dcbLibros.addElement(e);

			}
			vistaDevolver.getComboBoxEjemplares().setModel(dcbLibros);
			JOptionPane.showMessageDialog(null, "Socio seleccionado correctamente", "Correcto",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tienes que seleccionar un socio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void devolverLibroVista() {

		if (b.getListaLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vistaInsertarL, "No tenemos libros en la biblioteca", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {

			vistaDevolver = new DevolverLibro();
			vistaDevolver.setVisible(true);

			// Add ActionListener
			vistaDevolver.getBtnDevolver().addActionListener(this);
			vistaDevolver.getBtnSeleccionar().addActionListener(this);

			// Add ActionCommand
			vistaDevolver.getBtnDevolver().setActionCommand("Devolver");
			vistaDevolver.getBtnSeleccionar().setActionCommand("Seleccionar");

			DefaultComboBoxModel dcbSocios = new DefaultComboBoxModel();

			for (Persona p : b.getListaSocios()) {

				dcbSocios.addElement(p);

			}

			vistaDevolver.getComboBoxSocios().setModel(dcbSocios);
		}
	}

	private void importar() {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("Fomulario file", "data", "app"));

		int opcion = jfc.showOpenDialog(vista);
		if (opcion == JFileChooser.APPROVE_OPTION) {

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()))) {

				b = (Biblioteca) ois.readObject();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void guardar() {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("Fomulario file", "app", "data"));

		int opcion = jfc.showSaveDialog(vista);
		if (opcion == JFileChooser.APPROVE_OPTION) {

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(jfc.getSelectedFile()))) {

				oos.writeObject(b);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void mostrarLibros() {

		if (b.getListaLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vistaInsertarL, "No hay libros para mostrar", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			vistaTablaL = new TablaLibros();
			vistaTablaL.setVisible(true);

			for (Libro l : b.getListaLibros()) {
				vistaTablaL.getDtm().addRow(new String[] { Integer.toString(l.getIsbn()), l.getTitulo(), l.getAutor(),
						Integer.toString(l.getCantidadEjemplares()), Integer.toString(l.getDisponibles()) });

			}
		}
	}

	private void mostrarUsuarios() {

		if (b.getListaSocios().isEmpty()) {
			JOptionPane.showMessageDialog(vistaInsertarL, "No socios para mostrar", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			vistaTablaS = new TablaSocios();
			vistaTablaS.setVisible(true);

			for (Persona p : b.getListaSocios()) {
				vistaTablaS.getDtm().addRow(new String[] { p.getDni(), p.getNombre(), p.getApellidos(),
						Integer.toString(p.getCantidadLibros()) });

			}
		}
	}

	private void prestarLibro() {

		try {

			Libro l = (Libro) vistaPrestarL.getComboBoxLibros().getSelectedItem();
			p = (Persona) vistaPrestarL.getComboBoxUsuario().getSelectedItem();

			if (l.prestarEjemplar(p)) {

				JOptionPane.showMessageDialog(null, "Ejemplares prestado correctamente", "Correcto",
						JOptionPane.INFORMATION_MESSAGE);

				vistaPrestarL.dispose();

			} else {

				JOptionPane.showMessageDialog(null, "Esta persona ha superado el numero de libros prestados", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No hay ejemplares de ningun libro para prestar", "Error",
					JOptionPane.ERROR_MESSAGE);
			vistaPrestarL.dispose();

		}

	}

	private void añadirEjemplaresVista() {

		vistaAñadirE = new AñadirEjemplares();
		vistaAñadirE.setVisible(true);

		DefaultComboBoxModel dcbLibros = new DefaultComboBoxModel();

		for (Libro l : b.getListaLibros()) {

			dcbLibros.addElement(l);

		}

		vistaAñadirE.getComboBox().setModel(dcbLibros);

		// Add ActionListener
		vistaAñadirE.getBtnInsertarEjemplares().addActionListener(this);

		// Add ActionCommand
		vistaAñadirE.getBtnInsertarEjemplares().setActionCommand("Insertar Ejemplares");

	}

	private void añadirEjemplares() {

		int cantidad;

		Libro l = (Libro) vistaAñadirE.getComboBox().getSelectedItem();

		cantidad = vistaAñadirE.getCantidad();

		if (cantidad == 0) {
			cantidad = 1;
		}

		l.addEjemplar(cantidad);
		JOptionPane.showMessageDialog(null, "Ejemplares añadidos correctamente", "Correcto",
				JOptionPane.INFORMATION_MESSAGE);
		System.out.println(l.getCantidadEjemplares());

	}

	private void insertarUsuario() {

		boolean vacio = false;

		for (Component c : vistaInsertarP.getPanel_1().getComponents()) {
			if (c instanceof JTextField) {
				if (((JTextField) c).getText().equals("")) {
					vacio = true;
				}
			}
		}

		if (vacio) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los datos", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {

			String dni;
			String nombre;
			String apellidos;
			Persona p;

			dni = vistaInsertarP.getTxtFieldDNI().getText();
			nombre = vistaInsertarP.getTxtFieldNombre().getText();
			apellidos = vistaInsertarP.getTxtFieldApellidos().getText();

			p = new Persona(nombre, apellidos, dni);
			b.addSocio(p);

			JOptionPane.showMessageDialog(vistaInsertarP, "Socio añadido correctamente", "Correcto",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void insertarUsuarioVista() {

		vistaInsertarP = new InsertarPersona();
		vistaInsertarP.setVisible(true);

		// Add ActionListener
		vistaInsertarP.getBtnInsertar().addActionListener(this);
		vistaInsertarP.getBtnLimpiar().addActionListener(this);

		// Add ActionCommand
		vistaInsertarP.getBtnInsertar().setActionCommand("Insertar Usuario");
		vistaInsertarP.getBtnLimpiar().setActionCommand("Limpiar Campos Usuario");

	}

	private void insertarLibro() {

		boolean vacio = false;

		for (Component c : vistaInsertarL.getPanel_1().getComponents()) {
			if (c instanceof JTextField) {
				if (((JTextField) c).getText().equals("")) {
					vacio = true;
				}
			}
		}

		if (vacio) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los datos", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {

			try {

				String titulo;
				String autor;
				int isbn = 0;
				int cantidad;
				Libro l;

				titulo = vistaInsertarL.getTxtFieldTitulo().getText();
				autor = vistaInsertarL.getTxtFieldAutor().getText();
				cantidad = vistaInsertarL.getCantidad();

				isbn = Integer.parseInt(vistaInsertarL.getTxtFieldISBN().getText());

				if (cantidad == 0) {
					cantidad = 1;
				}

				l = new Libro(titulo, autor, isbn);
				l.addEjemplar(cantidad);

				b.addLibro(l);

				JOptionPane.showMessageDialog(vistaInsertarL, "Libro añadido correctamente", "Correcto",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(vistaInsertarL, "Solo debes introducir numeros en el ISBN", "Error",
						JOptionPane.ERROR_MESSAGE);
				vistaInsertarL.getTxtFieldISBN().setText("");
			}

		}

	}

	private void limpiarCamposLibro() {

		vistaInsertarL.getTxtFieldAutor().setText("");
		vistaInsertarL.getTxtFieldTitulo().setText("");
		vistaInsertarL.getTxtFieldEditorial().setText("");
		vistaInsertarL.getTxtFieldISBN().setText("");

	}

	private void limpiarCamposUsuario() {

		vistaInsertarP.getTxtFieldDNI().setText("");
		vistaInsertarP.getTxtFieldNombre().setText("");
		vistaInsertarP.getTxtFieldApellidos().setText("");

	}

	private void prestarLibroVista() {

		if (b.getListaLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vistaInsertarL, "No tenemos libros en la biblioteca", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (b.getListaSocios().isEmpty()) {
			JOptionPane.showMessageDialog(vistaInsertarL, "No hay socios a quien prestar los libros", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {

			vistaPrestarL = new Prestar();
			vistaPrestarL.setVisible(true);

			// Add ActionListener
			vistaPrestarL.getBtnPrestar().addActionListener(this);

			// Add ActionCommand
			vistaPrestarL.getBtnPrestar().setActionCommand("Prestar Libro");

			DefaultComboBoxModel dcbLibros = new DefaultComboBoxModel();
			DefaultComboBoxModel dcbSocios = new DefaultComboBoxModel();

			for (Libro l : b.getListaLibros()) {

				if (l.getDisponibles() != 0) {
					dcbLibros.addElement(l);
				}
			}

			for (Persona p : b.getListaSocios()) {

				dcbSocios.addElement(p);

			}

			vistaPrestarL.getComboBoxLibros().setModel(dcbLibros);
			vistaPrestarL.getComboBoxUsuario().setModel(dcbSocios);
		}
	}

	private void insertarLibroVista() {

		vistaInsertarL = new InsertarLibro();
		vistaInsertarL.setVisible(true);

		// Add ActionListener
		vistaInsertarL.getBtnInsertar().addActionListener(this);
		vistaInsertarL.getBtnLimpiar().addActionListener(this);

		// Add ActionCommand
		vistaInsertarL.getBtnInsertar().setActionCommand("Insertar Libro");
		vistaInsertarL.getBtnLimpiar().setActionCommand("Limpiar Campos Libro");

	}

}
