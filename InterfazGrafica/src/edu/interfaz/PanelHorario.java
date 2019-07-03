package edu.interfaz;
import edu.logica.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

public class PanelHorario extends JPanelAbstracto{
	Comando comando;
	private JFrameGeneral ventana;
	private JPanelAbstracto panelAgenda;
	public PanelHorario(JFrame frameActual2, GestorSolicitudes info) {
		super.frameActual = frameActual2;
		super.frameActual.setBounds(100, 100, 1160, 700);
		super.frameActual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.frameActual.getContentPane().setLayout(null);
		
		super.informacion = info;
		panelAgenda = new PanelAgenda(super.frameActual, super.informacion);
		setLayout(null);	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1160, 700);
		add(panel);
		panel.setLayout(null);
		
		JButton btnAnadirFranja = new JButton("");
		btnAnadirFranja.setRolloverIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 25@0.75x.png")));
		btnAnadirFranja.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 21@0.75x.png")));
		btnAnadirFranja.setBounds(869, 146, 147, 38);
		btnAnadirFranja.setOpaque(false);
		btnAnadirFranja.setBorderPainted(false);
		btnAnadirFranja.setContentAreaFilled(false);
		btnAnadirFranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana = new VentanaAnadirFranja(info);
				comando = new AnadirVentana(ventana);
				comando.ejecutar();
			}
		});
		
		JButton btnEliminarTarea = new JButton("");
		btnEliminarTarea.setRolloverIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 35@0.75x.png")));
		btnEliminarTarea.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 36@0.75x.png")));
		btnEliminarTarea.setOpaque(false);
		btnEliminarTarea.setContentAreaFilled(false);
		btnEliminarTarea.setBorderPainted(false);
		btnEliminarTarea.setBounds(869, 427, 147, 38);
		panel.add(btnEliminarTarea);
		btnAnadirFranja.setBounds(869, 188, 145, 38);
		panel.add(btnAnadirFranja);
		
		JButton btnVerAgenda = new JButton("");
		btnVerAgenda.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 30@0.75x.png")));
		btnVerAgenda.setRolloverIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 31@0.75x.png")));
		btnVerAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comando = new QuitarPanel(frameActual);
				comando.ejecutar();
				comando = new AnadirPanel(panelAgenda);
				comando.ejecutar();
			}
		});
		
		btnVerAgenda.setOpaque(false);
		btnVerAgenda.setBorderPainted(false);
		btnVerAgenda.setContentAreaFilled(false);
		btnVerAgenda.setBounds(869, 503, 147, 38);
		panel.add(btnVerAgenda);
		
		JButton btnAnadirTarea = new JButton("");
		btnAnadirTarea.setRolloverIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 26@0.75x.png")));
		btnAnadirTarea.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 20@0.75x.png")));
		btnAnadirTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana = new VentanaAnadirTarea(info);
				comando = new AnadirVentana(ventana);
				comando.ejecutar();
			}
		});
		btnAnadirTarea.setOpaque(false);
		btnAnadirTarea.setBorderPainted(false);
		btnAnadirTarea.setContentAreaFilled(false);
		btnAnadirTarea.setBounds(869, 378, 147, 38);
		panel.add(btnAnadirTarea);
		
		JButton btnGuardarHorario = new JButton("");
		btnGuardarHorario.setRolloverIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 29@0.75x.png")));
		btnGuardarHorario.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 28@0.75x.png")));
		btnGuardarHorario.setBounds(869, 127, 147, 38);
		btnGuardarHorario.setOpaque(false);
		btnGuardarHorario.setBorderPainted(false);
		btnGuardarHorario.setContentAreaFilled(false);
		panel.add(btnGuardarHorario);
		
		JButton btnEliminarFranja = new JButton("");
		btnEliminarFranja.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 27@0.75x.png")));
		btnEliminarFranja.setRolloverIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 32@0.75x.png")));
		btnEliminarFranja.setBounds(869, 292, 147, 38);
		btnEliminarFranja.setOpaque(false);
		btnEliminarFranja.setBorderPainted(false);
		btnEliminarFranja.setContentAreaFilled(false);
		panel.add(btnEliminarFranja);
		
		
		JButton btnModificarFranja = new JButton("");
		btnModificarFranja.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 17@0.75x.png")));
		btnModificarFranja.setBounds(869, 239, 147, 38);
		btnModificarFranja.setOpaque(false);
		btnModificarFranja.setBorderPainted(false);
		btnModificarFranja.setContentAreaFilled(false);
		panel.add(btnModificarFranja);
		
		JLabel lblFondohorario = new JLabel("");
		lblFondohorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondohorario.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 14@0.75x.png")));
		lblFondohorario.setBounds(119, 28, 934, 636);
		panel.add(lblFondohorario);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 4.png")));
		lblFondo.setBounds(-127, -22, 1354, 722);
		panel.add(lblFondo);
	}
	public JFrame getFrame() {
		return super.frameActual;
	}
}
