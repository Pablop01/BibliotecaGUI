package es.ieslavereda.biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;

public class BibliotecaVista extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmImportar;
	private JMenuItem mntmGuardar;
	private JButton btnInsertarLibro;
	private JButton btnPrestar;
	private JButton btnDevolver;
	private JButton btnMostrar;
	private JButton btnInsertarUsuario;
	private JButton btnMostrarUsuarios;
	private JButton btnAadirEjemplares;

	/**
	 * Create the frame.
	 */
	public BibliotecaVista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 477);
		setTitle("Gestor de biblioteca");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmImportar = new JMenuItem("Importar");
		mnArchivo.add(mntmImportar);
		
		mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 255, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.anchor = GridBagConstraints.WEST;
		gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 0;
		panel_4.add(lblUsuarios, gbc_lblUsuarios);
		
		btnInsertarUsuario = new JButton("Insertar");
		GridBagConstraints gbc_btnInsertarUsuario = new GridBagConstraints();
		gbc_btnInsertarUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertarUsuario.gridx = 1;
		gbc_btnInsertarUsuario.gridy = 1;
		panel_4.add(btnInsertarUsuario, gbc_btnInsertarUsuario);
		
		btnMostrarUsuarios = new JButton("Mostrar");
		GridBagConstraints gbc_btnMostrarUsuarios = new GridBagConstraints();
		gbc_btnMostrarUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMostrarUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_btnMostrarUsuarios.gridx = 1;
		gbc_btnMostrarUsuarios.gridy = 2;
		panel_4.add(btnMostrarUsuarios, gbc_btnMostrarUsuarios);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 255, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblLibros = new JLabel("Libros");
		GridBagConstraints gbc_lblLibros = new GridBagConstraints();
		gbc_lblLibros.anchor = GridBagConstraints.WEST;
		gbc_lblLibros.insets = new Insets(0, 0, 5, 5);
		gbc_lblLibros.gridx = 1;
		gbc_lblLibros.gridy = 2;
		panel_2.add(lblLibros, gbc_lblLibros);
		
		btnInsertarLibro = new JButton("Insertar");
		GridBagConstraints gbc_btnInsertarLibro = new GridBagConstraints();
		gbc_btnInsertarLibro.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertarLibro.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertarLibro.gridx = 1;
		gbc_btnInsertarLibro.gridy = 3;
		panel_2.add(btnInsertarLibro, gbc_btnInsertarLibro);
		
		btnPrestar = new JButton("Prestar");
		GridBagConstraints gbc_btnPrestar = new GridBagConstraints();
		gbc_btnPrestar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrestar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrestar.gridx = 1;
		gbc_btnPrestar.gridy = 4;
		panel_2.add(btnPrestar, gbc_btnPrestar);
		
		btnDevolver = new JButton("Devolver");
		GridBagConstraints gbc_btnDevolver = new GridBagConstraints();
		gbc_btnDevolver.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDevolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevolver.gridx = 1;
		gbc_btnDevolver.gridy = 5;
		panel_2.add(btnDevolver, gbc_btnDevolver);
		
		btnAadirEjemplares = new JButton("Añadir Ejemplares");
		GridBagConstraints gbc_btnAadirEjemplares = new GridBagConstraints();
		gbc_btnAadirEjemplares.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAadirEjemplares.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadirEjemplares.gridx = 1;
		gbc_btnAadirEjemplares.gridy = 6;
		panel_2.add(btnAadirEjemplares, gbc_btnAadirEjemplares);
		
		btnMostrar = new JButton("Mostrar");
		GridBagConstraints gbc_btnMostrar = new GridBagConstraints();
		gbc_btnMostrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMostrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnMostrar.gridx = 1;
		gbc_btnMostrar.gridy = 7;
		panel_2.add(btnMostrar, gbc_btnMostrar);
		
		JLabel lblTitulo = new JLabel("BIBLIOTECA");
		lblTitulo.setForeground(new Color(0, 153, 255));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblTitulo);
		contentPane.setLayout(gl_contentPane);
	}

	public JButton getBtnInsertarLibro() {
		return btnInsertarLibro;
	}

	public JButton getBtnPrestar() {
		return btnPrestar;
	}

	public JButton getBtnDevolver() {
		return btnDevolver;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public JButton getBtnInsertarUsuario() {
		return btnInsertarUsuario;
	}

	public JButton getBtnEliminarUsuario() {
		return btnMostrarUsuarios;
	}

	public JButton getBtnAadirEjemplares() {
		return btnAadirEjemplares;
	}

	public JMenuItem getMntmImportar() {
		return mntmImportar;
	}
	
	public JMenuItem getMntmGuardar() {
		return mntmGuardar;
	}

	public JButton getBtnMostrarUsuarios() {
		return btnMostrarUsuarios;
	}
	
	
}
