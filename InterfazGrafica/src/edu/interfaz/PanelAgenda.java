package edu.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.logica.*;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PanelAgenda extends JPanelAbstracto {

	private int posicionY, posicionMaxY=555;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public PanelAgenda(JFrame frameActual, GestorSolicitudes info) {
		super.frameActual = frameActual;
		super.informacion = info;
		setLayout(null);	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1160, 700);
		add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(267, 164, 172, 20);
		panel.add(dateChooser);
		
		panel.repaint();
		JComboBox cbxFranja = new JComboBox();
		cbxFranja.setEnabled(false);
		cbxFranja.setBounds(368, 360, 134, 20);
		panel.add(cbxFranja);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setEnabled(false);
		cbxTipo.setBounds(203, 448, 134, 20);
		panel.add(cbxTipo);
		
		JComboBox cbxDificultad = new JComboBox();
		cbxDificultad.setEnabled(false);
		cbxDificultad.setBounds(368, 448, 134, 20);
		panel.add(cbxDificultad);
		
		JRadioButton rdbtnTodas = new JRadioButton("Todas");
		buttonGroup.add(rdbtnTodas);
		rdbtnTodas.setBackground(Color.PINK);
		rdbtnTodas.setSelected(true);
		rdbtnTodas.setBounds(203, 315, 134, 23);
		rdbtnTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxDificultad.setEnabled(false);
				cbxFranja.setEnabled(false);
				cbxDificultad.setEnabled(false);
			}
		});
		panel.add(rdbtnTodas);
		
		JRadioButton rdbtnPorFranja = new JRadioButton("Por franja");
		buttonGroup.add(rdbtnPorFranja);
		rdbtnPorFranja.setBackground(Color.PINK);
		rdbtnPorFranja.setBounds(368, 315, 134, 23);
		rdbtnPorFranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxDificultad.setEnabled(false);
				cbxFranja.setEnabled(true);
				cbxTipo.setEnabled(false);
			}
		});
		panel.add(rdbtnPorFranja);
		
		JRadioButton rdbtnPorDificultad = new JRadioButton("Por dificultad");
		buttonGroup.add(rdbtnPorDificultad);
		rdbtnPorDificultad.setBackground(Color.PINK);
		rdbtnPorDificultad.setBounds(368, 403, 134, 23);
		rdbtnPorDificultad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxTipo.setEnabled(false);
				cbxFranja.setEnabled(false);
				cbxDificultad.setEnabled(true);
			}
		});
		panel.add(rdbtnPorDificultad);
		
		JRadioButton rdbtnPorTipo = new JRadioButton("Por tipo");
		buttonGroup.add(rdbtnPorTipo);
		rdbtnPorTipo.setBackground(Color.PINK);
		rdbtnPorTipo.setBounds(203, 403, 134, 23);
		rdbtnPorTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxDificultad.setEnabled(false);
				cbxFranja.setEnabled(false);
				cbxTipo.setEnabled(true);
			}
		});
		panel.add(rdbtnPorTipo);
		
		JButton btnFiltrar = new JButton("");
		btnFiltrar.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 47@0.75x.png")));
		btnFiltrar.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 46@0.75x.png")));
		btnFiltrar.setBounds(282, 530, 147, 38);
		btnFiltrar.setOpaque(false);
		btnFiltrar.setBorderPainted(false);
		btnFiltrar.setContentAreaFilled(false);
		panel.add(btnFiltrar);
		
		JButton btnVerTareas = new JButton("");
		btnVerTareas.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 44@0.75x.png")));
		btnVerTareas.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 45@0.75x.png")));
		btnVerTareas.setBounds(277, 195, 147, 38);
		btnVerTareas.setOpaque(false);
		btnVerTareas.setBorderPainted(false);
		btnVerTareas.setContentAreaFilled(false);
		panel.add(btnVerTareas);
		
		
		JPanel panelTareas = new JPanel();
		panelTareas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		JLabel lblFondo_1 = new JLabel("");
		lblFondo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_1.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_1.setBounds(-4, 3, 282, 34);
		panelTareas.add(lblFondo_1);
		
		
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
		
		JPanel panelTareas4 = new JPanel();
		panelTareas4.setLayout(null);
		panelTareas4.setBackground(new Color(254, 254, 232));
		panelTareas4.setBounds(642, 253, 356, 38);
		panel.add(panelTareas4);
		
		JButton btnEliminar4 = new JButton("");
		btnEliminar4.setBounds(306, 2, 32, 34);
		btnEliminar4.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar4.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar4.setOpaque(false);
		btnEliminar4.setContentAreaFilled(false);
		btnEliminar4.setBorderPainted(false);
		panelTareas4.add(btnEliminar4);
		
		JButton btnModificar4 = new JButton("");
		btnModificar4.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar4.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar4.setOpaque(false);
		btnModificar4.setContentAreaFilled(false);
		btnModificar4.setBorderPainted(false);
		btnModificar4.setBounds(274, 2, 32, 34);
		panelTareas4.add(btnModificar4);
		
		JLabel llblTextoTarea4 = new JLabel("Texto tarea");
		llblTextoTarea4.setBounds(10, 10, 268, 20);
		panelTareas4.add(llblTextoTarea4);
		llblTextoTarea4.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_4 = new JLabel("");
		lblFondo_4.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_4.setBounds(-4, 3, 282, 34);
		panelTareas4.add(lblFondo_4);
		
		JPanel panelTareas5 = new JPanel();
		panelTareas5.setLayout(null);
		panelTareas5.setBackground(new Color(254, 254, 232));
		panelTareas5.setBounds(642, 292, 356, 38);
		panel.add(panelTareas5);
		
		JButton btnEliminar5 = new JButton("");
		btnEliminar5.setBounds(306, 2, 32, 34);
		btnEliminar5.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar5.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar5.setOpaque(false);
		btnEliminar5.setContentAreaFilled(false);
		btnEliminar5.setBorderPainted(false);
		panelTareas5.add(btnEliminar5);
		
		JButton btnModificar5 = new JButton("");
		btnModificar5.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar5.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar5.setOpaque(false);
		btnModificar5.setContentAreaFilled(false);
		btnModificar5.setBorderPainted(false);
		btnModificar5.setBounds(274, 2, 32, 34);
		panelTareas5.add(btnModificar5);
		
		JLabel llblTextoTarea5 = new JLabel("Texto tarea");
		llblTextoTarea5.setBounds(10, 10, 268, 20);
		panelTareas5.add(llblTextoTarea5);
		llblTextoTarea5.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_5 = new JLabel("");
		lblFondo_5.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_5.setBounds(-4, 3, 282, 34);
		panelTareas5.add(lblFondo_5);
		
		JPanel panelTareas6 = new JPanel();
		panelTareas6.setLayout(null);
		panelTareas6.setBackground(new Color(254, 254, 232));
		panelTareas6.setBounds(642, 331, 356, 38);
		panel.add(panelTareas6);
		
		JButton btnEliminar6 = new JButton("");
		btnEliminar6.setBounds(306, 2, 32, 34);
		btnEliminar6.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar6.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar6.setOpaque(false);
		btnEliminar6.setContentAreaFilled(false);
		btnEliminar6.setBorderPainted(false);
		panelTareas6.add(btnEliminar6);
		
		JButton btnModificar6 = new JButton("");
		btnModificar6.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar6.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar6.setOpaque(false);
		btnModificar6.setContentAreaFilled(false);
		btnModificar6.setBorderPainted(false);
		btnModificar6.setBounds(274, 2, 32, 34);
		panelTareas6.add(btnModificar6);
		
		JLabel llblTextoTarea6 = new JLabel("Texto tarea");
		llblTextoTarea6.setBounds(10, 10, 268, 20);
		panelTareas6.add(llblTextoTarea6);
		llblTextoTarea6.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_6 = new JLabel("");
		lblFondo_6.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_6.setBounds(-4, 3, 282, 34);
		panelTareas6.add(lblFondo_6);
		
		JPanel panelTareas7 = new JPanel();
		panelTareas7.setLayout(null);
		panelTareas7.setBackground(new Color(254, 254, 232));
		panelTareas7.setBounds(642, 370, 356, 38);
		panel.add(panelTareas7);
		
		JButton btnEliminar7 = new JButton("");
		btnEliminar7.setBounds(306, 2, 32, 34);
		btnEliminar7.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar7.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar7.setOpaque(false);
		btnEliminar7.setContentAreaFilled(false);
		btnEliminar7.setBorderPainted(false);
		panelTareas7.add(btnEliminar7);
		
		JButton btnModificar7 = new JButton("");
		btnModificar7.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar7.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar7.setOpaque(false);
		btnModificar7.setContentAreaFilled(false);
		btnModificar7.setBorderPainted(false);
		btnModificar7.setBounds(274, 2, 32, 34);
		panelTareas7.add(btnModificar7);
		
		JLabel llblTextoTarea7 = new JLabel("Texto tarea");
		llblTextoTarea7.setBounds(10, 10, 268, 20);
		panelTareas7.add(llblTextoTarea7);
		llblTextoTarea7.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_7 = new JLabel("");
		lblFondo_7.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_7.setBounds(-4, 3, 282, 34);
		panelTareas7.add(lblFondo_7);
		
		JPanel panelTareas8 = new JPanel();
		panelTareas8.setLayout(null);
		panelTareas8.setBackground(new Color(254, 254, 232));
		panelTareas8.setBounds(642, 409, 356, 38);
		panel.add(panelTareas8);
		
		JButton btnEliminar8 = new JButton("");
		btnEliminar8.setBounds(306, 2, 32, 34);
		btnEliminar8.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar8.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar8.setOpaque(false);
		btnEliminar8.setContentAreaFilled(false);
		btnEliminar8.setBorderPainted(false);
		panelTareas8.add(btnEliminar8);
		
		JButton btnModificar8 = new JButton("");
		btnModificar8.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar8.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar8.setOpaque(false);
		btnModificar8.setContentAreaFilled(false);
		btnModificar8.setBorderPainted(false);
		btnModificar8.setBounds(274, 2, 32, 34);
		panelTareas8.add(btnModificar8);
		
		JLabel llblTextoTarea8 = new JLabel("Texto tarea");
		llblTextoTarea8.setBounds(10, 10, 268, 20);
		panelTareas8.add(llblTextoTarea8);
		llblTextoTarea8.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_8 = new JLabel("");
		lblFondo_8.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_8.setBounds(-4, 3, 282, 34);
		panelTareas8.add(lblFondo_8);
		
		JPanel panelTareas9 = new JPanel();
		panelTareas9.setLayout(null);
		panelTareas9.setBackground(new Color(254, 254, 232));
		panelTareas9.setBounds(642, 448, 356, 38);
		panel.add(panelTareas9);
		
		JButton btnEliminar9 = new JButton("");
		btnEliminar9.setBounds(306, 2, 32, 34);
		btnEliminar9.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar9.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar9.setOpaque(false);
		btnEliminar9.setContentAreaFilled(false);
		btnEliminar9.setBorderPainted(false);
		panelTareas9.add(btnEliminar9);
		
		JButton btnModificar9 = new JButton("");
		btnModificar9.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar9.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar9.setOpaque(false);
		btnModificar9.setContentAreaFilled(false);
		btnModificar9.setBorderPainted(false);
		btnModificar9.setBounds(274, 2, 32, 34);
		panelTareas9.add(btnModificar9);
		
		JLabel llblTextoTarea9 = new JLabel("Texto tarea");
		llblTextoTarea9.setBounds(10, 10, 268, 20);
		panelTareas9.add(llblTextoTarea9);
		llblTextoTarea9.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_9 = new JLabel("");
		lblFondo_9.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_9.setBounds(-4, 3, 282, 34);
		panelTareas9.add(lblFondo_9);
		
		JPanel panelTareas10 = new JPanel();
		panelTareas10.setLayout(null);
		panelTareas10.setBackground(new Color(254, 254, 232));
		panelTareas10.setBounds(642, 487, 356, 38);
		panel.add(panelTareas10);
		
		JButton btnEliminar10 = new JButton("");
		btnEliminar10.setBounds(306, 2, 32, 34);
		btnEliminar10.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 49@0.75x.png")));
		btnEliminar10.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 41@0.75x.png")));
		btnEliminar10.setOpaque(false);
		btnEliminar10.setContentAreaFilled(false);
		btnEliminar10.setBorderPainted(false);
		panelTareas10.add(btnEliminar10);
		
		JButton btnModificar10 = new JButton("");
		btnModificar10.setRolloverIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 48@0.75x.png")));
		btnModificar10.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 40@0.75x.png")));
		btnModificar10.setOpaque(false);
		btnModificar10.setContentAreaFilled(false);
		btnModificar10.setBorderPainted(false);
		btnModificar10.setBounds(274, 2, 32, 34);
		panelTareas10.add(btnModificar10);
		
		JLabel llblTextoTarea10 = new JLabel("Texto tarea");
		llblTextoTarea10.setBounds(10, 10, 268, 20);
		panelTareas10.add(llblTextoTarea10);
		llblTextoTarea10.setFont(new Font("Agency FB", Font.PLAIN, 21));
		
		JLabel lblFondo_10 = new JLabel("");
		lblFondo_10.setIcon(new ImageIcon(PanelAgenda.class.getResource("/edu/recursos/Recurso 42@0.75x.png")));
		lblFondo_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo_10.setBounds(-4, 3, 282, 34);
		panelTareas10.add(lblFondo_10);
		
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
