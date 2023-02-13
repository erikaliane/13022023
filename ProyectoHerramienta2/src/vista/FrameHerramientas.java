package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.Inventario;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameHerramientas extends JFrame {

	private JPanel contentPane;

	private JTable table_3;
	Inventario m=new Inventario();
	private DefaultTableModel model;
	private JTextField textBuscarHerra;
	private Object[] fila;
	private JButton btnRegistrarHerra;
	private JButton btnListarHerra;



	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 FrameHerramientas frame = new FrameHerramientas();
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
	public FrameHerramientas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		

JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 76, 861, 429);
		contentPane.add(scrollPane);
		
		table_3 = new JTable();
		scrollPane.setViewportView(table_3);
		
		table_3.setBackground(SystemColor.menu);
		
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		model=new DefaultTableModel();
		table_3.setModel(model);
		model.addColumn("COD HERRAMIENTA");
		model.addColumn("NOMBRE ");
		model.addColumn("MARCA");
		model.addColumn("SERIE ");

		
		ResultSet dat3=m.consulta("select * from herramienta ");
		try {
		while(dat3.next()) {
			 fila=new Object[5];
			fila[0]=dat3.getInt(1);
			fila[1]=dat3.getString(2);
			fila[2]=dat3.getString(3);
			fila[3]=dat3.getString(4);			
			model.addRow(fila);
		}
		}catch(SQLException e) {
			
	    }
		
		
		table_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		scrollPane.setViewportView(table_3);
		
		textBuscarHerra = new JTextField();
		textBuscarHerra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textBuscarHerra.setBounds(619, 36, 263, 30);
		contentPane.add(textBuscarHerra);
		textBuscarHerra.setColumns(10);
		
		JButton btnBuscarHerra = new JButton("Buscar");
		btnBuscarHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom =textBuscarHerra.getText();
				model=new DefaultTableModel();
				table_3.setModel(model);
				model.addColumn("COD HERRAMIENTA");
				model.addColumn("NOMBRE ");
				model.addColumn("MARCA");
				model.addColumn("SERIE ");

				ResultSet data=m.consulta("select * from herramienta where nombre='"+ nom +"'");
				try {
				while(data.next()) {
					fila[0]=data.getInt(1);
					fila[1]=data.getString(2);
					fila[2]=data.getString(3);
					fila[3]=data.getString(4);
					model.addRow(fila);	
				}
				}catch(SQLException e1) {
				}		
				
			}
		});
		btnBuscarHerra.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBuscarHerra.setBounds(478, 35, 131, 30);
		contentPane.add(btnBuscarHerra);
		
		btnRegistrarHerra = new JButton("Registrar Nueva Herramienta");
		btnRegistrarHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroHerramientas h= new RegistroHerramientas();
				h.setVisible(true);
			
				
				
			}
		});
		btnRegistrarHerra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrarHerra.setBounds(361, 518, 263, 43);
		contentPane.add(btnRegistrarHerra);
		
		btnListarHerra = new JButton("Listar Herramientas");
		btnListarHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model=new DefaultTableModel();
				table_3.setModel(model);
				model.addColumn("COD HERRAMIENTA");
				model.addColumn("NOMBRE ");
				model.addColumn("MARCA");
				model.addColumn("SERIE ");

				
				ResultSet dat3=m.consulta("select * from herramienta ");
				try {
				while(dat3.next()) {
					 fila=new Object[5];
					fila[0]=dat3.getInt(1);
					fila[1]=dat3.getString(2);
					fila[2]=dat3.getString(3);
					fila[3]=dat3.getString(4);			
					model.addRow(fila);
				}
				}catch(SQLException e1) {
			    }
				
			}
		});
		btnListarHerra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListarHerra.setBounds(129, 36, 191, 29);
		contentPane.add(btnListarHerra);
		
		
	}
}
