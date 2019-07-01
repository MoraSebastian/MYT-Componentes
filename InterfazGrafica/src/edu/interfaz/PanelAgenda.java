package edu.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.logica.*;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToolBar;

import java.awt.Color;
import java.awt.List;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class PanelAgenda extends JPanelAbstracto {

	private int posicionY, posicionMaxY=555;
	
	public PanelAgenda(JFrame frameActual, GestorSolicitudes info) {
		super.frameActual = frameActual;
		super.informacion = info;
		setLayout(null);	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1160, 700);
		add(panel);
		panel.setLayout(null);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(230, 335, 147, 38);
		panel.add(btnFiltrar);
		
		JButton btnVerTareas = new JButton("Ver tareas");
		btnVerTareas.setBounds(230, 256, 147, 38);
		panel.add(btnVerTareas);
		
		
		JPanel panelTareas = new JPanel();
		panelTareas.setBounds(642, 136, 356, 38);
		panel.add(panelTareas);
		panelTareas.setBackground(new Color(254, 254, 232));
		panelTareas.setLayout(null);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar.setBounds(306, 2, 32, 34);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setContentAreaFilled(false);
		panelTareas.add(btnEliminar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar.setBounds(274, 2, 32, 34);
		btnModificar.setOpaque(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setContentAreaFilled(false);
		panelTareas.add(btnModificar);
		
		JLabel lblTextoTarea = new JLabel("Texto tarea");
		lblTextoTarea.setFont(new Font("Agency FB", Font.PLAIN, 21));
		lblTextoTarea.setBounds(10, 10, 268, 20);
		panelTareas.add(lblTextoTarea);
		
		
		JPanel panelTareas2 = new JPanel();
		panelTareas2.setLayout(null);
		panelTareas2.setBackground(new Color(254, 254, 232));
		panelTareas2.setBounds(642, 175, 356, 38);
		panel.add(panelTareas2);
		
		JButton btnEliminar2 = new JButton("");
		btnEliminar2.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar2.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar2.setOpaque(false);
		btnEliminar2.setContentAreaFilled(false);
		btnEliminar2.setBorderPainted(false);
		btnEliminar2.setBounds(306, 2, 32, 34);
		panelTareas2.add(btnEliminar2);
		
		JButton btnModificar2 = new JButton("");
		btnModificar2.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar2.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar2.setOpaque(false);
		btnModificar2.setContentAreaFilled(false);
		btnModificar2.setBorderPainted(false);
		btnModificar2.setBounds(274, 2, 32, 34);
		panelTareas2.add(btnModificar2);
		
		JLabel lblTextoTarea2 = new JLabel("Texto tarea");
		lblTextoTarea2.setFont(new Font("Agency FB", Font.PLAIN, 21));
		lblTextoTarea2.setBounds(10, 10, 268, 20);
		panelTareas2.add(lblTextoTarea2);
		
		JLabel lblFondo_2 = new JLabel("");
		lblFondo_2.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_2.setBounds(-4, 3, 282, 34);
		panelTareas2.add(lblFondo_2);
		
		JPanel panelTareas3 = new JPanel();
		panelTareas3.setLayout(null);
		panelTareas3.setBackground(new Color(254, 254, 232));
		panelTareas3.setBounds(642, 214, 356, 38);
		panel.add(panelTareas3);
		
		JButton btnEliminar3 = new JButton("");
		btnEliminar3.setBounds(306, 2, 32, 34);
		btnEliminar3.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar3.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar3.setOpaque(false);
		btnEliminar3.setContentAreaFilled(false);
		btnEliminar3.setBorderPainted(false);
		btnEliminar2.setBounds(306, 2, 32, 34);
		panelTareas3.add(btnEliminar3);
		
		JButton btnModificar3 = new JButton("");
		btnModificar3.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar3.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar3.setOpaque(false);
		btnModificar3.setContentAreaFilled(false);
		btnModificar3.setBorderPainted(false);
		btnModificar3.setBounds(274, 2, 32, 34);
		panelTareas3.add(btnModificar3);
		
		JLabel llblTextoTarea3 = new JLabel("Texto tarea");
		llblTextoTarea3.setBounds(10, 10, 268, 20);
		panelTareas3.add(llblTextoTarea3);
		llblTextoTarea3.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_3 = new JLabel("");
		lblFondo_3.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_3.setBounds(-4, 3, 282, 34);
		panelTareas3.add(lblFondo_3);
		
		
		
		
		
		JLabel lblFondo_1 = new JLabel("");
		lblFondo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_1.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_1.setBounds(-4, 3, 282, 34);
		panelTareas.add(lblFondo_1);
		
		
		JLabel lblFondoagenda = new JLabel("");
		lblFondoagenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoagenda.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 43@0.75x.png")));
		lblFondoagenda.setBounds(10, 11, 1140, 678);
		panel.add(lblFondoagenda);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 4.png")));
		lblFondo.setBounds(-127, -22, 1354, 722);
		panel.add(lblFondo);
	}

	private void mostrarListaTareas(int numeroTareas){
		
		
	}
	public JFrame getFrame() {
		return super.frameActual;
	}
}
