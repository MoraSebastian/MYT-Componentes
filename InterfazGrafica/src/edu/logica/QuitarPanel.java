package edu.logica;

import javax.swing.JFrame;

public class QuitarPanel implements Comando{
	JFrame frame;
	public QuitarPanel(JFrame frame){
		this.frame = frame;
	}
	public void ejecutar() {
		frame.getContentPane().removeAll();	
	}

}
