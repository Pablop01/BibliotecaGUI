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
import java.awt.Container;

import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JButton;

public class InsertarLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldISBN;
	private JTextField txtFieldEditorial;
	private JTextField txtFieldTitulo;
	private JTextField txtFieldAutor;
	private JButton btnInsertar;
	private JButton btnLimpiar;
	private JSpinner spinner;
	private int cantidad;
	private JPanel panel_1;

	/**
	 * Create the frame.
	 */
	public InsertarLibro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 312);
		setTitle("Gestor de biblioteca - Insertar Libro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(9))
		);
		panel_1.setLayout(new MigLayout("", "[131.00][][250]", "[][][][][][][][][]"));
		
		JLabel lblIsbn = new JLabel("ISBN");
		panel_1.add(lblIsbn, "cell 0 0");
		
		JLabel lblEditorial = new JLabel("Editorial");
		panel_1.add(lblEditorial, "cell 2 0");
		
		txtFieldISBN = new JTextField();
		panel_1.add(txtFieldISBN, "cell 0 1,growx");
		txtFieldISBN.setColumns(10);
		
		txtFieldEditorial = new JTextField();
		panel_1.add(txtFieldEditorial, "cell 2 1,growx");
		txtFieldEditorial.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		panel_1.add(lblTitulo, "cell 0 2");
		
		txtFieldTitulo = new JTextField();
		panel_1.add(txtFieldTitulo, "cell 0 3 3 1,growx");
		txtFieldTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		panel_1.add(lblAutor, "cell 0 4");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		panel_1.add(lblCantidad, "cell 2 4,alignx center");
		
		txtFieldAutor = new JTextField();
		panel_1.add(txtFieldAutor, "cell 0 5 2 1,growx");
		txtFieldAutor.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(150, 20));
		spinner.setModel(new SpinnerNumberModel(1,1,100,1));
		spinner.setFocusTraversalPolicyProvider(true);
		panel_1.add(spinner, "cell 2 5,alignx right");
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cantidad = (int)spinner.getValue();
			}
		});
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setPreferredSize(new Dimension(80, 25));
		panel_1.add(btnLimpiar, "cell 1 8,alignx right");
		
		btnInsertar = new JButton("Insertar");
		panel_1.add(btnInsertar, "cell 2 8");
		
		JLabel lblInsertarLibro = new JLabel("Insertar Libro");
		lblInsertarLibro.setForeground(new Color(0, 153, 255));
		lblInsertarLibro.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblInsertarLibro);
		contentPane.setLayout(gl_contentPane);
	}

	public JTextField getTxtFieldISBN() {
		return txtFieldISBN;
	}

	public JTextField getTxtFieldEditorial() {
		return txtFieldEditorial;
	}

	public JTextField getTxtFieldTitulo() {
		return txtFieldTitulo;
	}

	public JTextField getTxtFieldAutor() {
		return txtFieldAutor;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JSpinner getSpinner() {
		return spinner;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}
	
}
