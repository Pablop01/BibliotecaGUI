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
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Prestar extends JFrame {

	private JPanel contentPane;
	private JButton btnPrestar;
	private JComboBox comboBoxUsuario;
	private JComboBox comboBoxLibros;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Create the frame.
	 */
	public Prestar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Gestor de biblioteca - Prestar Libro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
							.addGap(7))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_1.setLayout(new MigLayout("", "[grow]", "[][]"));
		
		JLabel lblLibroAPrestar = new JLabel("Libro a Prestar");
		panel_1.add(lblLibroAPrestar, "cell 0 0");
		
		comboBoxLibros = new JComboBox();
		panel_1.add(comboBoxLibros, "cell 0 1,growx");
		panel_2.setLayout(new MigLayout("", "[grow]", "[21.00][][15.00][][][]"));
		
		JLabel lblUsuarioPrestar = new JLabel("Usuario a Prestar");
		panel_2.add(lblUsuarioPrestar, "cell 0 1");
		
		comboBoxUsuario = new JComboBox();
		panel_2.add(comboBoxUsuario, "cell 0 3,growx");
		
		btnPrestar = new JButton("Prestar");
		panel_2.add(btnPrestar, "cell 0 5,alignx right");
		
		JLabel lblPrestarLibro = new JLabel("Prestar Libro");
		lblPrestarLibro.setForeground(new Color(0, 153, 255));
		lblPrestarLibro.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblPrestarLibro);
		contentPane.setLayout(gl_contentPane);
	}

	public JComboBox getComboBoxLibros() {
		return comboBoxLibros;
	}

	public JButton getBtnPrestar() {
		return btnPrestar;
	}

	public JComboBox getComboBoxUsuario() {
		return comboBoxUsuario;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}
	
}
