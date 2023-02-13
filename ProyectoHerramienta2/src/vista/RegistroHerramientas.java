package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

import vista.FramePrincipal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;

import datos.Inventario;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.SystemColor;

public class RegistroHerramientas extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreHerra;
	private JTextField textMarca;
	private JTextField textSerie;
	private JTextField textCodBarra;
	private String aleatorio2 ;
	private Image img128;
	JFrame myFrame=new JFrame("mi Frame");
	Inventario m=new Inventario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHerramientas frame = new RegistroHerramientas();
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
	public RegistroHerramientas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1195, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(301, 26, 544, 585);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(123, 115, 72, 14);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		
		textNombreHerra = new JTextField();
		textNombreHerra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombreHerra.setBounds(231, 105, 148, 36);
		panel.add(textNombreHerra);
		textNombreHerra.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(134, 183, 72, 14);
		panel.add(lblMarca);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textMarca = new JTextField();
		textMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMarca.setBounds(231, 173, 148, 36);
		panel.add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblSerie = new JLabel("Serie");
		lblSerie.setBounds(142, 241, 53, 17);
		panel.add(lblSerie);
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textSerie = new JTextField();
		textSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSerie.setBounds(231, 232, 148, 36);
		panel.add(textSerie);
		textSerie.setColumns(10);
		
		JButton btnCodBarra = new JButton("Generar Cod Barra");
		btnCodBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCodBarra.setBounds(97, 284, 158, 30);
		panel.add(btnCodBarra);
		
		
		
		textCodBarra = new JTextField();
		textCodBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCodBarra.setBounds(149, 325, 230, 66);
		panel.add(textCodBarra);
		textCodBarra.setColumns(10);
		
		
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImprimir.setBounds(112, 402, 115, 30);
		panel.add(btnImprimir);
		
		JButton btnRegistroHerra = new JButton("Registrar");
		btnRegistroHerra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistroHerra.setBounds(177, 483, 217, 58);
		panel.add(btnRegistroHerra);
		
		JLabel lblNewLabel = new JLabel("REGISTRO  DE HERRAMIENTAS ");
		lblNewLabel.setBounds(123, 33, 278, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(SystemColor.desktop);
		btnRegistroHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=textNombreHerra.getText();
				String marca=textMarca.getText();
				String serie=textSerie.getText();
				int cod_barra=Integer.parseInt(textCodBarra.getText());
				boolean w=m.registrar_herra(cod_barra,nom,marca,serie);
				if(w==true) {
					
					JOptionPane.showMessageDialog(null,"Herramienta Registrada Correctamente");
					textNombreHerra.setText("");
					textMarca.setText("");
					textSerie.setText("");
					textCodBarra.setText("");
					FrameHerramientas  u= new FrameHerramientas ();
					u.setVisible(true);					
					myFrame.setVisible(false);
					myFrame.dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "Error en el registro");
				}	
			
			}
		});
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario x=new Inventario();
				x.reporte1("codigo_barra", "SELECT * FROM p_herramienta.herramienta ");
				
				try {
					
					String master="src/reportes/codigo_barra.jrxml";
					JasperDesign jd=JRXmlLoader.load(master);
					HashMap  parametros=new HashMap();
					parametros.put("cod_herramienta", textCodBarra.getText());
				
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,parametros,new JREmptyDataSource());
					JasperViewer.viewReport(jp,false);
		        }catch(Exception e3) {
		        	JOptionPane.showMessageDialog(null,"Error al generar reporte");
		        }
				
			
				
			}
		});
		btnCodBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document doc= new Document();
				try {
					PdfWriter pdf= PdfWriter.getInstance(doc, new FileOutputStream("src/reportes/codigo_barra.jrxml"));
					doc.open();
					
					int aleatorio = 0;
					aleatorio2 = Integer.toString((int) (Math.random() * 1000000000 +1));
					
					
					Barcode128 code128= new Barcode128();
					code128.setCode(aleatorio2);
					textCodBarra.setText(aleatorio2);
					 img128= code128.createImageWithBarcode(pdf.getDirectContent(),BaseColor.BLACK,BaseColor.BLACK);
					img128.scalePercent(200);
					doc.add(img128);
					doc.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		

		
	}
}
