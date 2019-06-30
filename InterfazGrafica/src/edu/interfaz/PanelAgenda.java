package edu.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.logica.*;

public class PanelAgenda extends JPanelAbstracto {


	public PanelAgenda(JFrame frameActual, GestorSolicitudes info) {
		super.frameActual = frameActual;
		super.informacion = info;
		setLayout(null);	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1160, 700);
		add(panel);
		panel.setLayout(null);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 4.png")));
		lblFondo.setBounds(-127, -22, 1354, 722);
		panel.add(lblFondo);
		
		JLabel lblFondoagenda = new JLabel("");
		lblFondoagenda.setBounds(10, 22, 46, 14);
		panel.add(lblFondoagenda);
	}

	
	public JFrame getFrame() {
		return super.frameActual;
	}

}
