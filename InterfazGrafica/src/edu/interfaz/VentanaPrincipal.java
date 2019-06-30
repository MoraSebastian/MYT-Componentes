package edu.interfaz;
import edu.logica.*;

import javax.swing.JFrame;

public class VentanaPrincipal {
	private Comando comando;
	JFrame frame;
	private JPanelAbstracto panelInicio;
	private GestorSolicitudes informacion;

	public VentanaPrincipal(GestorSolicitudes informacion) {
		this.informacion = informacion;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1160, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelInicio = new PanelInicioSesion(frame, this.informacion);
		comando = new AnadirPanel(panelInicio);
		comando.ejecutar();

	}
	

}
