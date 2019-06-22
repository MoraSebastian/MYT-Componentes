package edu.conexionH;

import javax.swing.JOptionPane;

import edu.cableado.consultarHorario;

public class GestorH implements consultarHorario {

	@Override
	public void consultaH() {
		JOptionPane.showMessageDialog(null, "DBHorario");

	}

}
