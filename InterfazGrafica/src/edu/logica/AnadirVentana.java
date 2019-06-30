package edu.logica;

import javax.swing.JFrame;

import edu.interfaz.JFrameGeneral;

public class AnadirVentana implements Comando {
	private JFrameGeneral frame;
	public AnadirVentana(JFrameGeneral frame){
		this.frame = frame;
	}
	public void ejecutar() {
		frame.iniciarVentana();
	}

}
