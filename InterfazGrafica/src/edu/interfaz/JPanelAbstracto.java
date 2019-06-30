package edu.interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.logica.GestorSolicitudes;

public abstract class JPanelAbstracto extends JPanel {
	protected JFrame frameActual;
	protected GestorSolicitudes informacion;
	public abstract JFrame getFrame();
}
