package edu.logica;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.interfaz.JPanelAbstracto;

public class AnadirPanel implements Comando {
	private JPanelAbstracto panel;
	private JFrame framePanel;
	public AnadirPanel(JPanelAbstracto panelEntrada){
		this.panel = panelEntrada;
		this.framePanel = panelEntrada.getFrame();
	}
	
	public void ejecutar() {
		this.panel.setBounds(0, 0, 1160, 700);
		framePanel.getContentPane().add(this.panel);
		framePanel.getContentPane().repaint();
	}

}
