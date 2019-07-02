package edu.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.Controlador.Controlador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarTipo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfTipot;
	private JButton btnAgregarTipoDe;
	private Controlador micontrolador;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AgregarTipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 247);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDefinaElNuevo = new JLabel("<html>Defina el nuevo tipo de tarea que te hace falta:<html>");
		lblDefinaElNuevo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblDefinaElNuevo.setBounds(28, 33, 114, 70);
		contentPane.add(lblDefinaElNuevo);
		
		tfTipot = new JTextField();
		tfTipot.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tfTipot.setBounds(177, 58, 131, 28);
		contentPane.add(tfTipot);
		tfTipot.setColumns(10);
		
		btnAgregarTipoDe = new JButton("<html>Agregar Tipo de tarea<html>");
		btnAgregarTipoDe.setBackground(Color.WHITE);
		btnAgregarTipoDe.addActionListener(this);
		btnAgregarTipoDe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAgregarTipoDe.setBounds(28, 134, 131, 39);
		contentPane.add(btnAgregarTipoDe);
	}
	public void setControlador(Controlador micontrolador) {
		this.micontrolador = micontrolador;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnAgregarTipoDe) {
			if(tfTipot.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "NO SE HA ESPECIFICADO EL TIPO");
			}else {
				String[] datos = new String[2];
				if(micontrolador.ConsultaSencilla("maxid", "tipotarea").get(0) == null) { 
					datos[0] = "1";
				}else {
					datos[0] = Integer.toString(Integer.parseInt(micontrolador.ConsultaSencilla("maxid", "tipotarea").get(0))+1);
				}
				
				datos[1] = "'" + tfTipot.getText() + "'";
				
				for(int i=0; i<2; i++) {
					System.out.println(datos[i]);
				}
				
			//	micontrolador.AdicionarRegistro(datos, "tipotarea");
				JOptionPane.showMessageDialog(null, "ALGO TUVO QUE PASAR");
			}
			
		}
	}
}
