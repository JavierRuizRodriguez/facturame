package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

public class VentanaPorteDatos extends JFrame {

	private JPanel contentPane;
	private JTextField textKgCarga;
	private JTextField textVolumenCarga;
	private JTextField textConcepto;
	private JTextField textPrecio;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPorteDatos frame = new VentanaPorteDatos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPorteDatos() {
		setTitle("Facturame --- Porte --- Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelKgCarga = new JLabel("Kg carga:");
		labelKgCarga.setBounds(10, 16, 120, 15);
		contentPane.add(labelKgCarga);
		
		textKgCarga = new JTextField();
		textKgCarga.setColumns(10);
		textKgCarga.setBounds(70, 13, 90, 20);
		contentPane.add(textKgCarga);
		
		JLabel labelVolumenCarga = new JLabel("Volumen carga:");
		labelVolumenCarga.setBounds(200, 16, 120, 15);
		contentPane.add(labelVolumenCarga);
		
		textVolumenCarga = new JTextField();
		textVolumenCarga.setColumns(10);
		textVolumenCarga.setBounds(300, 11, 90, 20);
		contentPane.add(textVolumenCarga);
		
		JPanel panelConcepto = new JPanel();
		panelConcepto.setLayout(null);
		panelConcepto.setBorder(new TitledBorder(null, "Concepto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelConcepto.setBounds(10, 41, 380, 85);
		contentPane.add(panelConcepto);
		
		textConcepto = new JTextField();
		textConcepto.setColumns(10);
		textConcepto.setBounds(10, 21, 360, 53);
		panelConcepto.add(textConcepto);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setBounds(10, 136, 120, 15);
		contentPane.add(labelPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(70, 131, 90, 20);
		contentPane.add(textPrecio);
		
		JLabel labelGrupaje = new JLabel("Grupaje");
		labelGrupaje.setBounds(190, 136, 55, 15);
		contentPane.add(labelGrupaje);
		
		JCheckBox checkBoxGrupaje = new JCheckBox("");
		checkBoxGrupaje.setBounds(240, 131, 25, 25);
		contentPane.add(checkBoxGrupaje);
		
		JPanel panelDescripcion = new JPanel();
		panelDescripcion.setLayout(null);
		panelDescripcion.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDescripcion.setBounds(10, 162, 380, 139);
		contentPane.add(panelDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(10, 22, 360, 106);
		panelDescripcion.add(textDescripcion);
	}

}
