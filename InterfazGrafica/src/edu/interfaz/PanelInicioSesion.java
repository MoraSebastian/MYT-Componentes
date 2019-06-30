package edu.interfaz;
import edu.logica.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInicioSesion extends JPanelAbstracto {
	private JTextField txtUsuario;
	private JPasswordField pwdContrasena;
	private JPanel panel = new JPanel();
	private JPanelAbstracto panelHorario;
	
	public PanelInicioSesion(JFrame frameActual, GestorSolicitudes info) {
		super.frameActual = frameActual;
		informacion = info;

		
		panelHorario = new PanelHorario(super.frameActual, super.informacion);
		setLayout(null);	
		
		panel.setBounds(0, 0, 1160, 700);
		add(panel);
		panel.setLayout(null);
		
		JButton btnOk = new JButton("");
		btnOk.setRolloverIcon(new ImageIcon(PanelInicioSesion.class.getResource("/edu/recursos/Recurso 34@0.75x.png")));
		btnOk.setIcon(new ImageIcon(PanelInicioSesion.class.getResource("/edu/recursos/Recurso 06@0.75x.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comando comando = new QuitarPanel(frameActual);
				comando.ejecutar();
				comando = new AnadirPanel(panelHorario);
				comando.ejecutar();
				
			}
		});
		btnOk.setContentAreaFilled(false);
		btnOk.setOpaque(false);
		btnOk.setBorderPainted(false);
		btnOk.setBounds(518, 407, 89, 81);
		panel.add(btnOk);
		
		JLabel lblFondoTexto = new JLabel("");
		lblFondoTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoTexto.setIcon(new ImageIcon(PanelInicioSesion.class.getResource("/edu/recursos/Recurso 33@0.75x.png")));
		lblFondoTexto.setBounds(383, 106, 475, 519);
		panel.add(lblFondoTexto);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(511, 292, 110, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setText("usuario");
		txtUsuario.setBounds(521, 317, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		pwdContrasena = new JPasswordField();
		pwdContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		pwdContrasena.setText("contrase\u00F1a");
		pwdContrasena.setBounds(521, 376, 86, 20);
		panel.add(pwdContrasena);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(511, 351, 110, 14);
		panel.add(lblContrasena);
		
		JLabel lblFondoinicio = new JLabel("");
		lblFondoinicio.setIcon(new ImageIcon(PanelInicioSesion.class.getResource("/edu/recursos/Recurso 5@0.75x.png")));
		lblFondoinicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoinicio.setBounds(10, 11, 1140, 678);
		panel.add(lblFondoinicio);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelHorario.class.getResource("/edu/recursos/Recurso 4.png")));
		lblFondo.setBounds(-127, -22, 1354, 722);
		panel.add(lblFondo);
	}
	public JFrame getFrame() {
		return super.frameActual;
	}
}
