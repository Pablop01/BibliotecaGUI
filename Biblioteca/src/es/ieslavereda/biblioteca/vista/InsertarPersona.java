package es.ieslavereda.biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class InsertarPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldDNI;
	private JTextField txtFieldNombre;
	private JTextField txtFieldApellidos;
	private JButton btnLimpiar;
	private JButton btnInsertar;
	private JPanel panel_1;
	/**
	 * Create the frame.
	 */
	public InsertarPersona() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Gestor de biblioteca - Añadir Socio");
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(new MigLayout("", "[193.00][]", "[][][][][][][][]"));
		
		JLabel lblDNI = new JLabel("DNI");
		panel_1.add(lblDNI, "cell 0 0");
		
		txtFieldDNI = new JTextField();
		panel_1.add(txtFieldDNI, "cell 0 1");
		txtFieldDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_1.add(lblNombre, "cell 0 2");
		
		txtFieldNombre = new JTextField();
		panel_1.add(txtFieldNombre, "cell 0 3 2 1,growx");
		txtFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panel_1.add(lblApellidos, "cell 0 4");
		
		txtFieldApellidos = new JTextField();
		panel_1.add(txtFieldApellidos, "cell 0 5 2 1,growx");
		txtFieldApellidos.setColumns(10);
		
		btnLimpiar = new JButton("Limpiar");
		panel_1.add(btnLimpiar, "cell 0 7,alignx right");
		
		btnInsertar = new JButton("Insertar");
		panel_1.add(btnInsertar, "cell 1 7");
		
		JLabel lblInsertarSocio = new JLabel("Insertar Socio");
		lblInsertarSocio.setForeground(new Color(0, 153, 255));
		lblInsertarSocio.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblInsertarSocio);
		contentPane.setLayout(gl_contentPane);
		setTitle("Gestor de biblioteca - Insertar Socio");
	}

	public JTextField getTxtFieldDNI() {
		return txtFieldDNI;
	}

	public JTextField getTxtFieldNombre() {
		return txtFieldNombre;
	}

	public JTextField getTxtFieldApellidos() {
		return txtFieldApellidos;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}
	
}
