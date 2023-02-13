package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import datos.Inventario;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class RegistroUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textNomUsuario;
	private JTextField textApeUsuario;
	private JTable table;
	Inventario m=new Inventario();
	private JTable table_1;
	private JTable table_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuarios frame = new RegistroUsuarios();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroUsuarios() {
		
		setForeground(SystemColor.textHighlight);
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1281, 777);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(180, 180, 180), new Color(180, 180, 180), SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder));
		panel.setBounds(383, 55, 439, 499);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE USUARIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(104, 119, 215, 30);
		panel.add(lblNewLabel);
		
		JLabel lblnombre = new JLabel("NOMBRES");
		lblnombre.setBounds(92, 202, 87, 17);
		panel.add(lblnombre);
		lblnombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblapellido = new JLabel("APELLIDOS");
		lblapellido.setBounds(90, 277, 106, 14);
		panel.add(lblapellido);
		lblapellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textApeUsuario = new JTextField();
		textApeUsuario.setBackground(SystemColor.control);
		textApeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textApeUsuario.setBounds(221, 266, 146, 37);
		panel.add(textApeUsuario);
		textApeUsuario.setColumns(10);
		
		textNomUsuario = new JTextField();
		textNomUsuario.setBackground(SystemColor.control);
		textNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNomUsuario.setBounds(221, 192, 146, 37);
		panel.add(textNomUsuario);
		textNomUsuario.setColumns(10);
		
		JButton btnRegistroUsuario = new JButton("Registrar");
		btnRegistroUsuario.setForeground(new Color(255, 255, 255));
		btnRegistroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nom=textNomUsuario.getText();
				String ape=textApeUsuario.getText();
				boolean w=m.registrar_usuario(nom,ape);
				if(w==true) {
					
					JOptionPane.showMessageDialog(null," Usuario Registrado Correctamente");
	
					textNomUsuario.setText("");
					textApeUsuario.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "Error al registrar Usuario");
				}	
				
				
			}
		});
		
		
		btnRegistroUsuario.setBackground(new Color(135, 206, 235));
		btnRegistroUsuario.setBounds(159, 416, 160, 42);
		panel.add(btnRegistroUsuario);
		btnRegistroUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnImportarUsuarios = new JButton("Importar Usuarios");
		btnImportarUsuarios.setForeground(Color.WHITE);
		btnImportarUsuarios.setBackground(new Color(135, 206, 235));
		btnImportarUsuarios.setBounds(23, 11, 173, 37);
		panel.add(btnImportarUsuarios);
		btnImportarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
	}
}
