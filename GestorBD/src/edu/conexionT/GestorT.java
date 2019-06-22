package edu.conexionT;

import javax.swing.JOptionPane;

import edu.cableado.consultarTarea;

public class GestorT implements consultarTarea {

	@Override
	public void consultaT() {
		JOptionPane.showMessageDialog(null, "DBTarea");

	}

}
