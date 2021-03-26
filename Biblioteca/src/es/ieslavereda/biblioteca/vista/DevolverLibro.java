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
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DevolverLibro extends JFrame {

	private JPanel contentPane;
	private JButton btnDevolver;
	private JComboBox comboBoxSocios;
	private JComboBox comboBoxEjemplares;
	private JButton btnSeleccionar;
	/**
	 * Create the frame.
	 */
	public DevolverLibro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		setTitle("Gestor de biblioteca - Devolver Libro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][][][]"));
		
		JLabel lblSeleccionaElSocio = new JLabel("Selecciona el socio");
		panel_1.add(lblSeleccionaElSocio, "cell 0 0");
		
		comboBoxSocios = new JComboBox();
		panel_1.add(comboBoxSocios, "cell 0 1 7 1,growx");
		
		btnSeleccionar = new JButton("Seleccionar");
		panel_1.add(btnSeleccionar, "cell 7 1");
		
		JLabel lblSeleccionaElEjemplar = new JLabel("Selecciona el ejemplar");
		panel_1.add(lblSeleccionaElEjemplar, "cell 0 3");
		
		comboBoxEjemplares = new JComboBox();
		panel_1.add(comboBoxEjemplares, "cell 0 4 8 1,growx");
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnDevolver, "cell 1 7,alignx center");
		
		JLabel lblDevolverEjemplar = new JLabel("Devolver Ejemplar");
		lblDevolverEjemplar.setForeground(new Color(0, 153, 255));
		lblDevolverEjemplar.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblDevolverEjemplar);
		contentPane.setLayout(gl_contentPane);
	}

	public JButton getBtnDevolver() {
		return btnDevolver;
	}

	public JComboBox getComboBoxSocios() {
		return comboBoxSocios;
	}

	public JComboBox getComboBoxEjemplares() {
		return comboBoxEjemplares;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	
}
