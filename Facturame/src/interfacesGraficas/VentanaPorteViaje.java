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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
<<<<<<< HEAD
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPorteViaje extends JFrame {

=======

import builders.PorteGrafico;
import pojo.Porte;
import pojo.Viaje;

public class VentanaPorteViaje extends JFrame {

	private Porte p;
	private ArrayList<Viaje> viajes;
	private PorteGrafico pb;
>>>>>>> feature/continuacionBuilder
	private JPanel contentPane;
	private JTextField textoNumeroBastidor;
	private JTextField textDni;
	private JTextField textEmpresa;
	private JTextField textKgCarga;
	private JTextField textVolumenCarga;
	private JTextField textConcepto;
	private JTextField textPrecio;
	private JLabel labelGrupaje;
	private JTextField textDescripcion;
	private JTextPane tViajes;

<<<<<<< HEAD
	public VentanaPorteViaje(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
=======
	public VentanaPorteViaje(PorteGrafico pb) {
		this.p = pb.getPorte();
		this.pb = pb;
		this.viajes = new ArrayList<Viaje>();
>>>>>>> feature/continuacionBuilder
		setTitle("Facturame --- Porte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 862, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNumeroBastidor = new JLabel("N\u00FAmero de bastidor:");
		labelNumeroBastidor.setBounds(10, 20, 131, 15);
		contentPane.add(labelNumeroBastidor);
		
		textoNumeroBastidor = new JTextField();
		textoNumeroBastidor.setEditable(false);
		textoNumeroBastidor.setBounds(130, 15, 90, 20);
		contentPane.add(textoNumeroBastidor);
		textoNumeroBastidor.setColumns(10);
<<<<<<< HEAD
		
		JLabel labelDni = new JLabel("DNI/NIF: ");
		labelDni.setBounds(250, 20, 55, 15);
		contentPane.add(labelDni);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(300, 15, 90, 20);
		contentPane.add(textField);
		
=======

		JLabel labelDni = new JLabel("NIF:");
		labelDni.setBounds(255, 20, 40, 15);
		contentPane.add(labelDni);

		textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setColumns(10);
		textDni.setBounds(300, 15, 90, 20);
		contentPane.add(textDni);

>>>>>>> feature/continuacionBuilder
		JLabel labelEmpresa = new JLabel("Empresa:");
		labelEmpresa.setBounds(10, 50, 120, 15);
		contentPane.add(labelEmpresa);
		
		textEmpresa = new JTextField();
		textEmpresa.setEditable(false);
		textEmpresa.setColumns(10);
		textEmpresa.setBounds(70, 45, 320, 20);
		contentPane.add(textEmpresa);
		
		JLabel labelKgCarga = new JLabel("Kg carga:");
		labelKgCarga.setBounds(10, 80, 120, 15);
		contentPane.add(labelKgCarga);
		
		textKgCarga = new JTextField();
		textKgCarga.setEditable(false);
		textKgCarga.setColumns(10);
		textKgCarga.setBounds(70, 77, 90, 20);
		contentPane.add(textKgCarga);
		
		JLabel labelVolumenCarga = new JLabel("Volumen carga:");
		labelVolumenCarga.setBounds(200, 80, 120, 15);
		contentPane.add(labelVolumenCarga);
		
		textVolumenCarga = new JTextField();
		textVolumenCarga.setEditable(false);
		textVolumenCarga.setColumns(10);
		textVolumenCarga.setBounds(300, 75, 90, 20);
		contentPane.add(textVolumenCarga);
		
		JPanel panelConcepto = new JPanel();
		panelConcepto.setBorder(new TitledBorder(null, "Concepto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelConcepto.setBounds(10, 105, 380, 85);
		contentPane.add(panelConcepto);
		panelConcepto.setLayout(null);
		
		textConcepto = new JTextField();
		textConcepto.setEditable(false);
		textConcepto.setBounds(10, 21, 360, 53);
		panelConcepto.add(textConcepto);
		textConcepto.setColumns(10);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setBounds(10, 200, 50, 15);
		contentPane.add(labelPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(70, 195, 90, 20);
		contentPane.add(textPrecio);
		
		labelGrupaje = new JLabel("Grupaje");
		labelGrupaje.setBounds(190, 200, 55, 15);
		contentPane.add(labelGrupaje);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(240, 195, 25, 25);
		contentPane.add(checkBox);
<<<<<<< HEAD
		
=======
		checkBox.setEnabled(false);

>>>>>>> feature/continuacionBuilder
		JPanel panelDescripcion = new JPanel();
		panelDescripcion.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDescripcion.setBounds(10, 225, 380, 139);
		contentPane.add(panelDescripcion);
		panelDescripcion.setLayout(null);
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(10, 22, 360, 106);
		panelDescripcion.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.setBounds(10, 375, 120, 25);
		contentPane.add(buttonAceptar);
<<<<<<< HEAD
		
=======
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAnadirPorteActionPerformed(e);
			}
		});

>>>>>>> feature/continuacionBuilder
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setBounds(270, 375, 25, 25);
		contentPane.add(buttonBorrar);
		
		JButton buttonAnadirViaje = new JButton("A\u00D1ADIR VIAJE");
		buttonAnadirViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAnadirViajeActionPerformed(e);
			}
		});
<<<<<<< HEAD
=======

>>>>>>> feature/continuacionBuilder
		buttonAnadirViaje.setBounds(140, 375, 120, 25);
		contentPane.add(buttonAnadirViaje);
		
		JPanel panelViajes = new JPanel();
		panelViajes.setBorder(new TitledBorder(null, "Viajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelViajes.setBounds(410, 20, 426, 380);
		contentPane.add(panelViajes);
		panelViajes.setLayout(null);
<<<<<<< HEAD
		
		ArrayList<JLabel> viajes = pruebaCreacion(panelViajes);
		
=======

		this.tViajes = new JTextPane();
		tViajes.setEditable(false);
		tViajes.setBounds(10, 21, 406, 348);
		panelViajes.add(tViajes);

		textConcepto.setText(p.getConcepto());
		textDescripcion.setText(p.getDescripcion());
		textEmpresa.setText(p.getNif());
		textKgCarga.setText(String.valueOf(p.getKgCarga()));
		textoNumeroBastidor.setText(p.getnBastidor());
		textPrecio.setText(String.valueOf(p.getPrecio()));
		textVolumenCarga.setText(String.valueOf(p.getVolCarga()));
		textDni.setText(p.getDni());
		checkBox.setSelected(p.isEsGrupaje());
>>>>>>> feature/continuacionBuilder
	}

	private void buttonAnadirViajeActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaViaje formViaje = new VentanaViaje(this);
		formViaje.setVisible(true);
<<<<<<< HEAD
    }
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
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
=======
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.setVisible(false);
	}

	private void buttonAnadirPorteActionPerformed(java.awt.event.ActionEvent evt) {
		pb.setEspera(false);
		this.setVisible(false);
	}

	public Porte getPorte() {
		return p;
	}

	public void anadirViaje(Viaje v) {
		pb.anadirViaje(v);
		tViajes.setText(tViajes.getText().concat("\n Dirección origen: " + v.getLugarInicio() + "\n Dirección destino: "
				+ v.getLugarDestino() + "\n   ··········"));
	}
>>>>>>> feature/continuacionBuilder
}
