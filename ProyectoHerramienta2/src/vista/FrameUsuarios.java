package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import datos.Inventario;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Inventario m=new Inventario();
	private DefaultTableModel model;
	private Object[] fila;
	private JTextField txtBuscarApe;
	private JButton btnListaUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameUsuarios frame = new FrameUsuarios();
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
	public FrameUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 89, 650, 372);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
table.setBackground(SystemColor.menu);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model=new DefaultTableModel();
		table.setModel(model);
		model.addColumn("CODIGO ");
		model.addColumn("NOMBRE ");
		model.addColumn("APELLIDO");


		
		ResultSet dat3=m.consulta("select * from usuario ");
		try {
		while(dat3.next()) {
			fila=new Object[5];
			fila[0]=dat3.getInt(1);
			fila[1]=dat3.getString(2);
			fila[2]=dat3.getString(3);
			
			model.addRow(fila);
		}
		}catch(SQLException e) {
	    }
		
		
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		scrollPane.setViewportView(table);
		
		JButton btnBuscarApe = new JButton("BUSCAR");
		btnBuscarApe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ape=txtBuscarApe.getText();
				model=new DefaultTableModel();
				table.setModel(model);
				model.addColumn("CODIGO ");
				model.addColumn("NOMBRE ");
				model.addColumn("APELLIDO");
				
				ResultSet data=m.consulta("select * from usuario where apellido='"+ ape +"'");
				
				try {
					while(data.next()) {
						fila[0]=data.getInt(1);
						fila[1]=data.getString(2);
						fila[2]=data.getString(3);
						model.addRow(fila);	
					}
					}catch(SQLException e1) {
					}	
			}
		});
		btnBuscarApe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarApe.setBounds(356, 49, 132, 29);
		contentPane.add(btnBuscarApe);
		
		txtBuscarApe = new JTextField();
		txtBuscarApe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBuscarApe.setBounds(498, 49, 271, 29);
		contentPane.add(txtBuscarApe);
		txtBuscarApe.setColumns(10);
		
		JButton btnRegistroUsuario = new JButton("REGISTRAR NUEVO USUARIO");
		btnRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuarios h= new RegistroUsuarios();
				h.setVisible(true);
				
			}
		});
		btnRegistroUsuario.setBounds(304, 474, 261, 37);
		contentPane.add(btnRegistroUsuario);
		
		btnListaUsuario = new JButton("Listar Usuarios ");
		btnListaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel();
				table.setModel(model);
				model.addColumn("CODIGO ");
				model.addColumn("NOMBRE ");
				model.addColumn("APELLIDO");
				model.addColumn("MODIFICAR ");

				
				ResultSet dat3=m.consulta("select * from usuario ");
				try {
				while(dat3.next()) {
					fila=new Object[5];
					fila[0]=dat3.getInt(1);
					fila[1]=dat3.getString(2);
					fila[2]=dat3.getString(3);
					
					model.addRow(fila);
				}
				}catch(SQLException e1) {
			    }
				
			}
		});
		btnListaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListaUsuario.setBounds(143, 49, 148, 29);
		contentPane.add(btnListaUsuario);
		
		
		
	}
}
