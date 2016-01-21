package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import composite.AccesoEmpleados;

public class VentanaVisualizacionComposite extends JFrame {

	private JPanel contentPane;
	private AccesoEmpleados ae;
	private String jefe;
	private JTextPane tResultado;

	public VentanaVisualizacionComposite(VentanaPrincipal principal) throws SQLException, IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		        formWindowClosing(principal);
			}
		});
		this.jefe = "1";
		this.ae = new AccesoEmpleados(jefe);
		setTitle("ESTAD\u00CDSTICAS GENERALES EMPLEADOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 486, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Visualizaci\u00F3n datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 107, 449, 301);
		contentPane.add(panel);
		panel.setLayout(null);

		this.tResultado = new JTextPane();
		this.tResultado.setEditable(false);
		this.tResultado.setBounds(10, 21, 429, 269);
		panel.add(tResultado);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Seleccionar operaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_1.setBounds(10, 11, 450, 85);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton bSueldos = new JButton("Cuant\u00EDa total sueldos empresa");
		bSueldos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bSueldosActionPerformed(evt);
			}
		});
		bSueldos.setBounds(10, 21, 205, 53);
		panel_1.add(bSueldos);

		JButton tJerarquia = new JButton("Jerarqu\u00EDa personal empresa");
		tJerarquia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bJerarquiaActionPerformed(evt);
			}
		});
		tJerarquia.setBounds(235, 21, 205, 53);
		panel_1.add(tJerarquia);
	}

	private void bSueldosActionPerformed(ActionEvent evt) {
		tResultado.setText("La cuantía total de los sueldo de todos los empleados registrados en el sistema es de  ·······  "
				+ String.valueOf(ae.getSueldos()) + " €.");

	}
	
	private void bJerarquiaActionPerformed(ActionEvent evt) {
		tResultado.setText(ae.getDescripciones());

	}
	
	private void formWindowClosing(VentanaPrincipal principal) {
	    this.setVisible(false);
	    principal.setVisible(true);
	}

}
