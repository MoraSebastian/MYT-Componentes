package edu.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.Controlador.Controlador;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

public class InterfazCrudT extends JFrame {

	private JPanel contentPane;
	Registro panel1;
	JTabbedPane pestañas;
	JScrollPane scroll;
	JScrollPane scroll2;
	RegistroSubT panel2;
	

	/**
	 * Create the frame.
	 */
	public InterfazCrudT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 594);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pestañas = new JTabbedPane();
		pestañas.setBounds(0, 0, 479, 555);
		
						
	}
	public void ControladorEnPanel(Controlador micontrolador) {
		panel1 = new Registro(micontrolador);
		
		//panel2 = new RegistroSubT(micontrolador);
		
		
		scroll = new JScrollPane();
		scroll .setBounds(132, 155, 502, 311);
		scroll .setViewportView(panel1);
		scroll .getViewport().setView(panel1);
		/*
		scroll2 = new JScrollPane();
		scroll2 .setBounds(132, 155, 502, 311);
		scroll2 .setViewportView(panel2);
		scroll2 .getViewport().setView(panel2);
		*/

		panel1.setPreferredSize(new Dimension(445,585));
		//panel2.setPreferredSize(new Dimension(445,585));
		
		pestañas.add("Registro", scroll);
		//pestañas.add("Subtarea", scroll2);
		contentPane.add(pestañas);			
	}
}
