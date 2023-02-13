package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.Inventario;
import modelos.Render;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePrestamo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[] fila;
	Inventario m=new Inventario();
	private DefaultTableModel model;
	private JTextField textField;
	private JButton btnBuscar;
	private JButton btnListarPrestamo;
	private JButton btnRegistrarPrestamo;
	private JButton btnHistorial;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrestamo frame = new FramePrestamo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrestamo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 110, 585, 381);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.menu);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model=new DefaultTableModel();
		table.setModel(model);
		model.addColumn("COD PRESTAMO");
		model.addColumn("USUARIO ");
		model.addColumn("HERRAMIENTA");
		model.addColumn("FECHA");
		model.addColumn("HORA INICIO");
		model.addColumn("FINALIZAR");
		
//		inner join
		ResultSet dat3=m.consulta("select * from prestamo ");
		try {
		while(dat3.next()) {
			 fila=new Object[5];
			fila[0]=dat3.getInt(1);
			fila[1]=dat3.getInt(2);
			fila[2]=dat3.getInt(3);			
			fila[3]=dat3.getString(4);
			fila[4]=dat3.getString(5);
			
			model.addRow(fila);
		}
		}catch(SQLException e) {
	    }
		
		
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(533, 67, 191, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(408, 67, 103, 32);
		contentPane.add(btnBuscar);
		
		btnListarPrestamo = new JButton("Lista de Prestamos");
		btnListarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				model=new DefaultTableModel();
				table.setModel(model);
				
				model.addColumn("COD PRESTAMO");
				model.addColumn("USUARIO ");
				model.addColumn("HERRAMIENTA");
				model.addColumn("FECHA");
				model.addColumn("HORA INICIO");
				model.addColumn("");
				
				ResultSet dat3=m.consulta("select * from prestamo ");
				try {
				while(dat3.next()) {
					 fila=new Object[5];
					fila[0]=dat3.getInt(1);
					fila[1]=dat3.getInt(2);
					fila[2]=dat3.getInt(3);			
					fila[3]=dat3.getString(4);
					fila[4]=dat3.getString(5);
					
					
					model.addRow(fila);
				}
				}catch(SQLException e1) {
			    }
				
				
			}
		});
		btnListarPrestamo.setBounds(176, 72, 138, 23);
		contentPane.add(btnListarPrestamo);
		
		btnRegistrarPrestamo = new JButton("REGISTRAR NUEVO PRESTAMO");
		btnRegistrarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroPrestamo r=new RegistroPrestamo();
				r.setVisible(true);
				
			}
		});
		btnRegistrarPrestamo.setBounds(274, 502, 222, 38);
		contentPane.add(btnRegistrarPrestamo);
		
		btnHistorial = new JButton("HISTORIAL");
		btnHistorial.setBounds(612, 502, 127, 32);
		contentPane.add(btnHistorial);
		
	}

}
