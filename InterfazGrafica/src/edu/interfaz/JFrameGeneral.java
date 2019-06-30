package edu.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.logica.GestorSolicitudes;

public abstract class JFrameGeneral extends JFrame{
	protected GestorSolicitudes informacion;
	public abstract void iniciarVentana();
}
