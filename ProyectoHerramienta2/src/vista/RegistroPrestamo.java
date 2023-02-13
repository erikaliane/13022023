package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Inventario;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;

public class RegistroPrestamo extends JFrame {

	private JPanel contentPane;
	private JTextField textCodBarra;
	private JTable table;
	Inventario m=new Inventario();
	private JTextField textfecha;
	private JButton button;
	private DefaultTableModel model;
	private JTextField textAPE;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPrestamo frame = new RegistroPrestamo();
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
	public RegistroPrestamo() {
		setTitle("REGISTRO DE PRESTAMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 624);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel.setBounds(296, 42, 510, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(97, 85, 77, 20);
		panel.add(lblNewLabel);
		
		textCodBarra = new JTextField();
		textCodBarra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCodBarra.setBounds(261, 155, 166, 62);
		panel.add(textCodBarra);
		textCodBarra.setColumns(10);
		
		
		
		
		
		JButton btnLeerCodBarra = new JButton("Cod Barra");
		btnLeerCodBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeerCodBarra.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLeerCodBarra.setBounds(69, 174, 118, 27);
		panel.add(btnLeerCodBarra);
		
		textfecha = new JTextField();
		textfecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textfecha.setBounds(261, 248, 166, 42);
		panel.add(textfecha);
		textfecha.setColumns(10);
		
		String txtDate= new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
		textfecha.setText(txtDate);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(110, 261, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(110, 342, 46, 14);
		panel.add(lblNewLabel_2);
		
		JFormattedTextField hora_inicio = new JFormattedTextField();
		hora_inicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hora_inicio.setBounds(261, 332, 169, 36);
		panel.add(hora_inicio);
		
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("HH:mm:ss");
		hora_inicio.setText(dtf3.format(LocalDateTime.now()));
		
		textAPE = new JTextField();
		textAPE.setBounds(260, 80, 166, 37);
		panel.add(textAPE);
		textAPE.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar Prestamo");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod_barra=Integer.parseInt(textCodBarra.getText());
				String fecha=textfecha.getText();  
				String  hora_i=hora_inicio.getText();
	
				String ape=textAPE.getText();
				
				ResultSet data=m.consulta("select * from usuario where apellido='"+ ape +"'");
				ResultSet busqueda_cod=m.consulta("select * from herramienta where cod_herramienta='"+ cod_barra +"'");
				ResultSet busqueda_cod_barra=m.consulta("select * from prestamo where cod_herramienta='"+ cod_barra +"'");
				
				int cod_usuario = 0;
				int cod2=0;
				
			
				try {
					
					
					while(busqueda_cod.next()) {
						 cod2= busqueda_cod.getInt(1);
					}
					if(cod2 == cod_barra) {
						JOptionPane.showMessageDialog(null," Codigo Barra Valido");
					}else {
						JOptionPane.showMessageDialog(null, "Codigo no pertenece a ninguna herramienta");
					}	
				}catch(SQLException e1) {
				
				}
				
				try {
					while(data.next()) {
						 cod_usuario=data.getInt(1);
					}
					boolean w=m.registrar_prestamo(cod_usuario,cod_barra,fecha,hora_i,"");
					if(w==true) {
						JOptionPane.showMessageDialog(null," Prestamo  Correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "Error al reealizar prestamo");
					}	
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, "Usuario No Registrado");
					}	
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrar.setBounds(157, 451, 187, 42);
		panel.add(btnRegistrar);
		
		
		
		JButton boton = new JButton("Finalizar");
		boton.setSize(100,45);
		boton.setVisible(true);
		ActionListener listener = new ActionListener(){ 
		   public void actionPerformed(ActionEvent e) { 
		    
		   }         
		};
		boton.addActionListener(listener);
		
		model=new DefaultTableModel();
		model.addColumn("COD PRESTAMO");
		model.addColumn("USUARIO");
		model.addColumn("HERRAMIENTA");
		model.addColumn("FECHA");
		model.addColumn("HORA INICIO");
		model.addColumn("FINALIZAR");
		
		ResultSet dat3=m.consulta("select * from prestamo");
		try {
		while(dat3.next()) {
			Object[] fila=new Object[5];
			fila[0]=dat3.getInt(1);
			
			fila[1]=dat3.getInt(2);
			fila[2]=dat3.getInt(3);
			fila[3]=dat3.getString(4);
			fila[4]=dat3.getString(5);
			
			model.addRow(fila);
		}
		}catch(SQLException e) {
	    }
	}
}
