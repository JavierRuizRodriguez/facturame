package interfacesGraficas;

import java.awt.EventQueue;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class VentanaPorte extends JFrame {

	private JPanel contentPane;
	private JTextField textoNumeroBastidor;
	private JTextField textField;
	private JTextField textEmpresa;
	private JTextField textKgCarga;
	private JTextField textVolumenCarga;
	private JTextField textConcepto;
	private JTextField textPrecio;
	private JLabel labelGrupaje;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPorte frame = new VentanaPorte();
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
	public VentanaPorte() {
		setTitle("Facturame --- Porte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNumeroBastidor = new JLabel("N\u00FAmero de bastidor:");
		labelNumeroBastidor.setBounds(10, 20, 131, 15);
		contentPane.add(labelNumeroBastidor);
		
		textoNumeroBastidor = new JTextField();
		textoNumeroBastidor.setBounds(130, 15, 90, 20);
		contentPane.add(textoNumeroBastidor);
		textoNumeroBastidor.setColumns(10);
		
		JLabel labelDni = new JLabel("DNI/NIF: ");
		labelDni.setBounds(250, 20, 120, 15);
		contentPane.add(labelDni);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(300, 15, 90, 20);
		contentPane.add(textField);
		
		JLabel labelEmpresa = new JLabel("Empresa:");
		labelEmpresa.setBounds(10, 50, 120, 15);
		contentPane.add(labelEmpresa);
		
		textEmpresa = new JTextField();
		textEmpresa.setColumns(10);
		textEmpresa.setBounds(70, 45, 320, 20);
		contentPane.add(textEmpresa);
		
		JLabel labelKgCarga = new JLabel("Kg carga:");
		labelKgCarga.setBounds(10, 80, 120, 15);
		contentPane.add(labelKgCarga);
		
		textKgCarga = new JTextField();
		textKgCarga.setColumns(10);
		textKgCarga.setBounds(70, 77, 90, 20);
		contentPane.add(textKgCarga);
		
		JLabel labelVolumenCarga = new JLabel("Volumen carga:");
		labelVolumenCarga.setBounds(200, 80, 120, 15);
		contentPane.add(labelVolumenCarga);
		
		textVolumenCarga = new JTextField();
		textVolumenCarga.setColumns(10);
		textVolumenCarga.setBounds(300, 75, 90, 20);
		contentPane.add(textVolumenCarga);
		
		JPanel panelConcepto = new JPanel();
		panelConcepto.setBorder(new TitledBorder(null, "Concepto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelConcepto.setBounds(10, 105, 380, 85);
		contentPane.add(panelConcepto);
		panelConcepto.setLayout(null);
		
		textConcepto = new JTextField();
		textConcepto.setBounds(10, 21, 360, 53);
		panelConcepto.add(textConcepto);
		textConcepto.setColumns(10);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setBounds(10, 200, 120, 15);
		contentPane.add(labelPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(70, 195, 90, 20);
		contentPane.add(textPrecio);
		
		labelGrupaje = new JLabel("Grupaje");
		labelGrupaje.setBounds(190, 200, 55, 15);
		contentPane.add(labelGrupaje);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(240, 195, 25, 25);
		contentPane.add(checkBox);
		
		JPanel panelDescripcion = new JPanel();
		panelDescripcion.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDescripcion.setBounds(10, 225, 380, 139);
		contentPane.add(panelDescripcion);
		panelDescripcion.setLayout(null);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(10, 22, 360, 106);
		panelDescripcion.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.setBounds(10, 375, 120, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setBounds(270, 375, 25, 25);
		contentPane.add(buttonBorrar);
		
		JButton buttonAnadirViaje = new JButton("A\u00D1ADIR VIAJE");
		buttonAnadirViaje.setBounds(140, 375, 120, 25);
		contentPane.add(buttonAnadirViaje);
		
		JPanel panelViajes = new JPanel();
		panelViajes.setBorder(new TitledBorder(null, "Viajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelViajes.setBounds(410, 20, 214, 344);
		contentPane.add(panelViajes);
		panelViajes.setLayout(null);
		
		ArrayList<JLabel> viajes = pruebaCreacion(panelViajes);
		
		JScrollBar scrollBar = new JScrollBar();
	
		scrollBar.setMaximum(600);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			int scrollBarPosAnt = scrollBar.getValue();
			int scrollBarPosSig = scrollBar.getValue();
			int diferencia = 0;
		      public void adjustmentValueChanged(AdjustmentEvent ae) {
		        scrollBarPosSig = ae.getValue();
		        diferencia = scrollBarPosSig - scrollBarPosAnt;
		        for(JLabel viaje : viajes){		        	
		        	if (viaje.getY()-diferencia < 18) viaje.setVisible(false); else viaje.setVisible(true);
		        	viaje.setBounds(viaje.getX(), viaje.getY()-diferencia, viaje.getWidth(), viaje.getHeight());		        	
		        }
		        scrollBarPosAnt = scrollBarPosSig;
		      }
		    });

		scrollBar.setUnitIncrement(18);
		scrollBar.setBounds(184, 11, 20, 338);
		panelViajes.add(scrollBar);		
		
	}

	public ArrayList<JLabel> pruebaCreacion(JPanel panel){
		
		JLabel labelAux;
		ArrayList<JLabel> viajes = new ArrayList<JLabel>();
		int x = 0;
		for(int i = 0; i<=10; i++){
			labelAux = new JLabel(i+": Barcelona - Bilbao");
			x = (i==0) ? 18 : 18*(i+1);
			labelAux.setBounds(10, x, 180, 20);
			panel.add(labelAux);
			viajes.add(labelAux);
		}
		
		return viajes;
	}
}
