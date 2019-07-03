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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelHorario extends JPanelAbstracto{
	Comando comando;
	private JFrameGeneral ventana;
	private JPanelAbstracto panelAgenda;
	private JTable table;
	private Object[][] modelo;
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
				panelAgenda.updateUI();
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
		btnGuardarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarModelo();
			}
		});
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 134, 650, 465);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(modelo,
			new String[] {
				"HORA", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
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
	
	private void llenarModelo(){
		
		modelo = new Object[][] {
			{"0:00 - 1:00", informacion.obtenerFranjasPorDia(0).get(0), informacion.obtenerFranjasPorDia(1).get(0), informacion.obtenerFranjasPorDia(2).get(0), informacion.obtenerFranjasPorDia(3).get(0), informacion.obtenerFranjasPorDia(4).get(0), informacion.obtenerFranjasPorDia(5).get(0), informacion.obtenerFranjasPorDia(6).get(0)},
			{"1:00 - 2:00", informacion.obtenerFranjasPorDia(0).get(1), informacion.obtenerFranjasPorDia(1).get(1), informacion.obtenerFranjasPorDia(2).get(1), informacion.obtenerFranjasPorDia(3).get(1), informacion.obtenerFranjasPorDia(4).get(1), informacion.obtenerFranjasPorDia(5).get(1), informacion.obtenerFranjasPorDia(6).get(1)},
			{"2:00 - 3:00", informacion.obtenerFranjasPorDia(0).get(2), informacion.obtenerFranjasPorDia(1).get(2), informacion.obtenerFranjasPorDia(2).get(2), informacion.obtenerFranjasPorDia(3).get(2), informacion.obtenerFranjasPorDia(4).get(2), informacion.obtenerFranjasPorDia(5).get(2), informacion.obtenerFranjasPorDia(6).get(2)},
			{"3:00 - 4:00", informacion.obtenerFranjasPorDia(0).get(3), informacion.obtenerFranjasPorDia(1).get(3), informacion.obtenerFranjasPorDia(2).get(3), informacion.obtenerFranjasPorDia(3).get(3), informacion.obtenerFranjasPorDia(4).get(3), informacion.obtenerFranjasPorDia(5).get(3), informacion.obtenerFranjasPorDia(6).get(3)},
			{"4:00 - 5:00", informacion.obtenerFranjasPorDia(0).get(4), informacion.obtenerFranjasPorDia(1).get(4), informacion.obtenerFranjasPorDia(2).get(4), informacion.obtenerFranjasPorDia(3).get(4), informacion.obtenerFranjasPorDia(4).get(4), informacion.obtenerFranjasPorDia(5).get(4), informacion.obtenerFranjasPorDia(6).get(4)},
			{"5:00 - 6:00", informacion.obtenerFranjasPorDia(0).get(5), informacion.obtenerFranjasPorDia(1).get(5), informacion.obtenerFranjasPorDia(2).get(5), informacion.obtenerFranjasPorDia(3).get(5), informacion.obtenerFranjasPorDia(4).get(5), informacion.obtenerFranjasPorDia(5).get(5), informacion.obtenerFranjasPorDia(6).get(5)},
			{"6:00 - 7:00", informacion.obtenerFranjasPorDia(0).get(6), informacion.obtenerFranjasPorDia(1).get(6), informacion.obtenerFranjasPorDia(2).get(6), informacion.obtenerFranjasPorDia(3).get(6), informacion.obtenerFranjasPorDia(4).get(6), informacion.obtenerFranjasPorDia(5).get(6), informacion.obtenerFranjasPorDia(6).get(6)},
			{"7:00 - 8:00", informacion.obtenerFranjasPorDia(0).get(7), informacion.obtenerFranjasPorDia(1).get(7), informacion.obtenerFranjasPorDia(2).get(7), informacion.obtenerFranjasPorDia(3).get(7), informacion.obtenerFranjasPorDia(4).get(7), informacion.obtenerFranjasPorDia(5).get(7), informacion.obtenerFranjasPorDia(6).get(7)},
			{"8:00 - 9:00", informacion.obtenerFranjasPorDia(0).get(8), informacion.obtenerFranjasPorDia(1).get(8), informacion.obtenerFranjasPorDia(2).get(8), informacion.obtenerFranjasPorDia(3).get(8), informacion.obtenerFranjasPorDia(4).get(8), informacion.obtenerFranjasPorDia(5).get(8), informacion.obtenerFranjasPorDia(6).get(8)},
			{"9:00 - 10:00", informacion.obtenerFranjasPorDia(0).get(9), informacion.obtenerFranjasPorDia(1).get(9), informacion.obtenerFranjasPorDia(2).get(9), informacion.obtenerFranjasPorDia(3).get(9), informacion.obtenerFranjasPorDia(4).get(9), informacion.obtenerFranjasPorDia(5).get(9), informacion.obtenerFranjasPorDia(6).get(9)},
			{"10:00 - 11:00", informacion.obtenerFranjasPorDia(0).get(10), informacion.obtenerFranjasPorDia(1).get(10), informacion.obtenerFranjasPorDia(2).get(10), informacion.obtenerFranjasPorDia(3).get(10), informacion.obtenerFranjasPorDia(4).get(10), informacion.obtenerFranjasPorDia(5).get(10), informacion.obtenerFranjasPorDia(10).get(10)},
			{"11:00 - 12:00", informacion.obtenerFranjasPorDia(0).get(11), informacion.obtenerFranjasPorDia(1).get(11), informacion.obtenerFranjasPorDia(2).get(11), informacion.obtenerFranjasPorDia(3).get(11), informacion.obtenerFranjasPorDia(4).get(11), informacion.obtenerFranjasPorDia(5).get(11), informacion.obtenerFranjasPorDia(6).get(11)},
			{"12:00 - 13:00", informacion.obtenerFranjasPorDia(0).get(12), informacion.obtenerFranjasPorDia(1).get(12), informacion.obtenerFranjasPorDia(2).get(12), informacion.obtenerFranjasPorDia(3).get(12), informacion.obtenerFranjasPorDia(4).get(12), informacion.obtenerFranjasPorDia(5).get(12), informacion.obtenerFranjasPorDia(6).get(12)},
			{"13:00 - 14:00", informacion.obtenerFranjasPorDia(0).get(13), informacion.obtenerFranjasPorDia(1).get(13), informacion.obtenerFranjasPorDia(2).get(13), informacion.obtenerFranjasPorDia(3).get(13), informacion.obtenerFranjasPorDia(4).get(13), informacion.obtenerFranjasPorDia(5).get(13), informacion.obtenerFranjasPorDia(6).get(13)},
			{"14:00 - 15:00", informacion.obtenerFranjasPorDia(0).get(14), informacion.obtenerFranjasPorDia(1).get(14), informacion.obtenerFranjasPorDia(2).get(14), informacion.obtenerFranjasPorDia(3).get(14), informacion.obtenerFranjasPorDia(4).get(14), informacion.obtenerFranjasPorDia(5).get(14), informacion.obtenerFranjasPorDia(6).get(14)},
			{"15:00 - 16:00", informacion.obtenerFranjasPorDia(0).get(15), informacion.obtenerFranjasPorDia(1).get(15), informacion.obtenerFranjasPorDia(2).get(15), informacion.obtenerFranjasPorDia(3).get(15), informacion.obtenerFranjasPorDia(4).get(15), informacion.obtenerFranjasPorDia(5).get(15), informacion.obtenerFranjasPorDia(6).get(15)},
			{"16:00 - 17:00", informacion.obtenerFranjasPorDia(0).get(16), informacion.obtenerFranjasPorDia(1).get(16), informacion.obtenerFranjasPorDia(2).get(16), informacion.obtenerFranjasPorDia(3).get(16), informacion.obtenerFranjasPorDia(4).get(16), informacion.obtenerFranjasPorDia(5).get(16), informacion.obtenerFranjasPorDia(6).get(16)},
			{"17:00 - 18:00", informacion.obtenerFranjasPorDia(0).get(17), informacion.obtenerFranjasPorDia(1).get(17), informacion.obtenerFranjasPorDia(2).get(17), informacion.obtenerFranjasPorDia(3).get(17), informacion.obtenerFranjasPorDia(4).get(17), informacion.obtenerFranjasPorDia(5).get(17), informacion.obtenerFranjasPorDia(6).get(17)},
			{"18:00 - 19:00", informacion.obtenerFranjasPorDia(0).get(18), informacion.obtenerFranjasPorDia(1).get(18), informacion.obtenerFranjasPorDia(2).get(18), informacion.obtenerFranjasPorDia(3).get(18), informacion.obtenerFranjasPorDia(4).get(18), informacion.obtenerFranjasPorDia(5).get(18), informacion.obtenerFranjasPorDia(6).get(18)},
			{"19:00 - 20:00", informacion.obtenerFranjasPorDia(0).get(19), informacion.obtenerFranjasPorDia(1).get(19), informacion.obtenerFranjasPorDia(2).get(19), informacion.obtenerFranjasPorDia(3).get(19), informacion.obtenerFranjasPorDia(4).get(19), informacion.obtenerFranjasPorDia(5).get(19), informacion.obtenerFranjasPorDia(6).get(19)},
			{"20:00 - 21:00", informacion.obtenerFranjasPorDia(0).get(20), informacion.obtenerFranjasPorDia(1).get(20), informacion.obtenerFranjasPorDia(2).get(20), informacion.obtenerFranjasPorDia(3).get(20), informacion.obtenerFranjasPorDia(4).get(20), informacion.obtenerFranjasPorDia(5).get(20), informacion.obtenerFranjasPorDia(6).get(20)},
			{"21:00 - 22:00", informacion.obtenerFranjasPorDia(0).get(21), informacion.obtenerFranjasPorDia(1).get(21), informacion.obtenerFranjasPorDia(2).get(21), informacion.obtenerFranjasPorDia(3).get(21), informacion.obtenerFranjasPorDia(4).get(21), informacion.obtenerFranjasPorDia(5).get(21), informacion.obtenerFranjasPorDia(6).get(21)},
			{"22:00 - 23:00", informacion.obtenerFranjasPorDia(0).get(22), informacion.obtenerFranjasPorDia(1).get(22), informacion.obtenerFranjasPorDia(2).get(22), informacion.obtenerFranjasPorDia(3).get(22), informacion.obtenerFranjasPorDia(4).get(22), informacion.obtenerFranjasPorDia(5).get(22), informacion.obtenerFranjasPorDia(6).get(22)},
			{"23:00 - 0:00", informacion.obtenerFranjasPorDia(0).get(23), informacion.obtenerFranjasPorDia(1).get(23), informacion.obtenerFranjasPorDia(2).get(23), informacion.obtenerFranjasPorDia(3).get(23), informacion.obtenerFranjasPorDia(4).get(23), informacion.obtenerFranjasPorDia(5).get(23), informacion.obtenerFranjasPorDia(6).get(23)},
		};
	}
}
