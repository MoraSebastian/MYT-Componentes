package edu.interfaz;
import edu.logica.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
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
		ArrayList<String> lunes = informacion.obtenerFranjasPorDia(0);
		ArrayList<String> martes = informacion.obtenerFranjasPorDia(1);
		ArrayList<String> miercoles = informacion.obtenerFranjasPorDia(2);
		ArrayList<String> jueves = informacion.obtenerFranjasPorDia(3);
		ArrayList<String> viernes = informacion.obtenerFranjasPorDia(4);
		ArrayList<String> sabado = informacion.obtenerFranjasPorDia(5);
		ArrayList<String> domingo = informacion.obtenerFranjasPorDia(6);
		
		modelo = new Object[][] {			
			{"0:00 - 1:00", lunes.get(0), martes.get(0), miercoles.get(0), jueves.get(0), viernes.get(0), sabado.get(0), domingo.get(0)},
			{"1:00 - 2:00", lunes.get(1), martes.get(1), miercoles.get(1), jueves.get(1), viernes.get(1), sabado.get(1), domingo.get(1)},
			{"2:00 - 3:00", lunes.get(2), martes.get(2), miercoles.get(2), jueves.get(2), viernes.get(2), sabado.get(2), domingo.get(2)},
			{"3:00 - 4:00", lunes.get(3), martes.get(3), miercoles.get(3), jueves.get(3), viernes.get(3), sabado.get(3), domingo.get(3)},
			{"4:00 - 5:00", lunes.get(4), martes.get(4), miercoles.get(4), jueves.get(4), viernes.get(4), sabado.get(4), domingo.get(4)},
			{"5:00 - 6:00", lunes.get(5), martes.get(5), miercoles.get(5), jueves.get(5), viernes.get(5), sabado.get(5), domingo.get(5)},
			{"6:00 - 7:00", lunes.get(6), martes.get(6), miercoles.get(6), jueves.get(6), viernes.get(6), sabado.get(6), domingo.get(6)},
			{"7:00 - 8:00", lunes.get(7), martes.get(7), miercoles.get(7), jueves.get(7), viernes.get(7), sabado.get(7), domingo.get(7)},
			{"8:00 - 9:00", lunes.get(8), martes.get(8), miercoles.get(8), jueves.get(8), viernes.get(8), sabado.get(8), domingo.get(8)},
			{"9:00 - 10:00", lunes.get(9), martes.get(9), miercoles.get(9), jueves.get(9), viernes.get(9), sabado.get(9), domingo.get(9)},
			{"10:00 - 11:00", lunes.get(10), martes.get(10), miercoles.get(10), jueves.get(10), viernes.get(10), sabado.get(10), domingo.get(10)},
			{"11:00 - 12:00", lunes.get(11), martes.get(11), miercoles.get(11), jueves.get(11), viernes.get(11), sabado.get(11), domingo.get(11)},
			{"12:00 - 13:00", lunes.get(12), martes.get(12), miercoles.get(12), jueves.get(12), viernes.get(12), sabado.get(12), domingo.get(12)},
			{"13:00 - 14:00", lunes.get(13), martes.get(13), miercoles.get(13), jueves.get(13), viernes.get(13), sabado.get(13), domingo.get(13)},
			{"14:00 - 15:00", lunes.get(14), martes.get(14), miercoles.get(14), jueves.get(14), viernes.get(14), sabado.get(14), domingo.get(14)},
			{"15:00 - 16:00", lunes.get(15), martes.get(15), miercoles.get(15), jueves.get(15), viernes.get(15), sabado.get(15), domingo.get(15)},
			{"16:00 - 17:00", lunes.get(16), martes.get(16), miercoles.get(16), jueves.get(16), viernes.get(16), sabado.get(16), domingo.get(16)},
			{"17:00 - 18:00", lunes.get(17), martes.get(17), miercoles.get(17), jueves.get(17), viernes.get(17), sabado.get(17), domingo.get(17)},
			{"18:00 - 19:00", lunes.get(18), martes.get(18), miercoles.get(18), jueves.get(18), viernes.get(18), sabado.get(18), domingo.get(18)},
			{"19:00 - 20:00", lunes.get(19), martes.get(19), miercoles.get(19), jueves.get(19), viernes.get(19), sabado.get(19), domingo.get(19)},
			{"20:00 - 21:00", lunes.get(20), martes.get(20), miercoles.get(20), jueves.get(20), viernes.get(20), sabado.get(20), domingo.get(20)},
			{"21:00 - 22:00", lunes.get(21), martes.get(21), miercoles.get(21), jueves.get(21), viernes.get(21), sabado.get(21), domingo.get(21)},
			{"22:00 - 23:00", lunes.get(22), martes.get(22), miercoles.get(22), jueves.get(22), viernes.get(22), sabado.get(22), domingo.get(22)},
			{"23:00 - 0:00", lunes.get(23), martes.get(23), miercoles.get(23), jueves.get(23), viernes.get(23), sabado.get(23), domingo.get(23)},
		};
	}
}
