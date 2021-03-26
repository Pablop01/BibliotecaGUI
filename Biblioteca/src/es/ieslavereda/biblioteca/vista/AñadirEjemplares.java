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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;
import javax.swing.JButton;

public class AñadirEjemplares extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JButton btnInsertarEjemplares;
	private int cantidad;
	/**
	 * Create the frame.
	 */
	public AñadirEjemplares() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 255);
		setTitle("Gestor de biblioteca - Añadir Ejemplares");
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
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(new MigLayout("", "[257.00][63.00]", "[][][][][][][]"));
		
		JLabel lblLibro = new JLabel("Libro");
		panel_1.add(lblLibro, "cell 0 0");
		
		comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 0 1 2 1,growx");
		
		JLabel lblEjemplaresAAadir = new JLabel("Ejemplares a añadir");
		panel_1.add(lblEjemplaresAAadir, "cell 0 3");
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(70, 20));
		spinner.setModel(new SpinnerNumberModel(1,1,100,1));
		panel_1.add(spinner, "cell 0 4");
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cantidad = (int)spinner.getValue();
			}
		});
		
		btnInsertarEjemplares = new JButton("Insertar");
		panel_1.add(btnInsertarEjemplares, "cell 0 6,alignx right");
		
		JLabel lblAadirEjemplares = new JLabel("Añadir Ejemplares");
		lblAadirEjemplares.setForeground(new Color(0, 153, 255));
		lblAadirEjemplares.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblAadirEjemplares);
		contentPane.setLayout(gl_contentPane);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JButton getBtnInsertarEjemplares() {
		return btnInsertarEjemplares;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
}
