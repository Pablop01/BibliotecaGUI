package es.ieslavereda.biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaLibros extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	/**
	 * Create the frame.
	 */
	public TablaLibros() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 230);
		setTitle("Gestor de biblioteca - Listado Libros");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		dtm = new DefaultTableModel();
		dtm.addColumn("ISBN");
		dtm.addColumn("Titulo");
		dtm.addColumn("Autor");
		dtm.addColumn("Nº Ejemplares");
		dtm.addColumn("Ejemplares Disp.");
		
		table.setModel(dtm);
		scrollPane.setViewportView(table);
	}
	
	public DefaultTableModel getDtm() {
		return dtm;
	}
	

}
