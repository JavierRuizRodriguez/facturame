package interfacesGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("Facturame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonRegistrarCamion = new JButton("Registrar CAMI\u00D3N");
		buttonRegistrarCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotonVentaActionPerformed(e);
			}
		});
		buttonRegistrarCamion.setBounds(120, 21, 150, 25);
		contentPane.add(buttonRegistrarCamion);
		
		JButton btnRegistrarEmpleado = new JButton("Registrar EMPLEADO");
		btnRegistrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrarEmpleado.setBounds(120, 70, 150, 25);
		contentPane.add(btnRegistrarEmpleado);
		
		JButton btnRegistrarPorte = new JButton("Registrar PORTE");
		btnRegistrarPorte.setBounds(120, 121, 150, 25);
		contentPane.add(btnRegistrarPorte);
	}
	
	private void BotonVentaActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaCamion venta = new VentanaCamion();
        this.setVisible(false);
    }

}
