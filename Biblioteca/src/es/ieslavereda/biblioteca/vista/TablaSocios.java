package es.ieslavereda.biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaSocios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	/**
	 * Create the frame.
	 */
	public TablaSocios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 231);
		setTitle("Gestor de biblioteca - Listado Socios");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		dtm = new DefaultTableModel();
		dtm.addColumn("DNI");
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellidos");
		dtm.addColumn("Prestados");
		
		table.setModel(dtm);
		scrollPane.setViewportView(table);
	}
	
	public DefaultTableModel getDtm() {
		return dtm;
	}
	

}
