package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import vista.RegistroUsuarios;
import vista.RegistroHerramientas;
import java.awt.SystemColor;
public class FramePrincipal {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1168, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnHerramientas = new JButton("Herramientas");
		btnHerramientas.setBounds(440, 47, 342, 153);
		btnHerramientas.setBackground(SystemColor.activeCaption);
		btnHerramientas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHerramientas.setIcon(new ImageIcon("C:\\Users\\PRACTICANTE02\\Downloads\\herra3.png"));
		btnHerramientas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHerramientas h= new FrameHerramientas();
				h.setVisible(true);				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnHerramientas);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(440, 223, 342, 163);
		btnUsuarios.setBackground(SystemColor.activeCaption);
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUsuarios.setIcon(new ImageIcon("C:\\Users\\PRACTICANTE02\\Downloads\\usuario icon.png"));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameUsuarios  u= new FrameUsuarios();
				u.setVisible(true);	
			}
		});
		frame.getContentPane().add(btnUsuarios);
		frame.getContentPane().add(btnHerramientas);	
		
		JButton btnPrestamos = new JButton("Prestamos");
		btnPrestamos.setIcon(new ImageIcon("C:\\Users\\PRACTICANTE02\\Downloads\\usuario icon.png"));
		btnPrestamos.setBackground(SystemColor.activeCaption);
		btnPrestamos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePrestamo p=new FramePrestamo();
				p.setVisible(true);				
			}
		});
		btnPrestamos.setBounds(440, 397, 342, 166);
		frame.getContentPane().add(btnPrestamos);
	}
}
