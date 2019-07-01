package edu.interfaz;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.logica.GestorSolicitudes;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.toedter.components.JSpinField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAnadirFranja extends JFrameGeneral {
	private JPanel contentPane;
	JComboBox cBoxTipoFranja;
	JCheckBox chckbxLunes;
	JCheckBox chckbxMartes;
	JCheckBox chckbxMiercoles;
	JCheckBox chckbxJueves;	
	JCheckBox chckbxViernes;
	JCheckBox chckbxSabado;
	JCheckBox chckbxDomingo;
	JTextField txtNombreFranja;
	JSpinField spinFieldFinal;
	JSpinField spinFieldInicio;
	JButton btnAnadirFranja2;
	public void iniciarVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnadirFranja frame = new VentanaAnadirFranja(informacion);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaAnadirFranja(GestorSolicitudes info){
		super.informacion = info;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 580, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cBoxTipoFranja = new JComboBox();
		cBoxTipoFranja.setBounds(294, 281, 159, 20);
		contentPane.add(cBoxTipoFranja);
		
		chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(108, 192, 75, 23);
		contentPane.add(chckbxLunes);
		
		chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(200, 192, 75, 23);
		contentPane.add(chckbxMartes);
		
		chckbxMiercoles = new JCheckBox("Miercoles");
		chckbxMiercoles.setBounds(294, 192, 75, 23);
		contentPane.add(chckbxMiercoles);
		
		chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(389, 192, 75, 23);
		contentPane.add(chckbxJueves);
		
		chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(108, 232, 75, 23);
		contentPane.add(chckbxViernes);
		
		chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setBounds(200, 232, 75, 23);
		contentPane.add(chckbxSabado);
		
		chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(294, 232, 75, 23);
		contentPane.add(chckbxDomingo);
		
		
		txtNombreFranja = new JTextField();
		txtNombreFranja.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		txtNombreFranja.setText("nombreFranja");
		txtNombreFranja.setBounds(294, 121, 159, 20);
		contentPane.add(txtNombreFranja);
		txtNombreFranja.setColumns(10);
		
		spinFieldFinal = new JSpinField();
		spinFieldFinal.setMinimum(0);
		spinFieldFinal.setMaximum(23);
		spinFieldFinal.setBounds(294, 353, 159, 20);
		contentPane.add(spinFieldFinal);
		
		spinFieldInicio = new JSpinField();
		spinFieldInicio.setMinimum(0);
		spinFieldInicio.setMaximum(23);
		spinFieldInicio.setBounds(294, 316, 159, 20);
		contentPane.add(spinFieldInicio);
		
		JLabel lblHorafinal = new JLabel("Hora final:");
		lblHorafinal.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblHorafinal.setBounds(109, 348, 147, 25);
		contentPane.add(lblHorafinal);
		
		JLabel lblHoraInicio = new JLabel("Hora inicio:");
		lblHoraInicio.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblHoraInicio.setBounds(109, 312, 147, 25);
		contentPane.add(lblHoraInicio);
		
		JLabel lblTipoFranja = new JLabel("Tipo franja:");
		lblTipoFranja.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblTipoFranja.setBounds(109, 276, 147, 25);
		contentPane.add(lblTipoFranja);
		
		JLabel lblNombreFranja = new JLabel("Nombre franja:");
		lblNombreFranja.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblNombreFranja.setBounds(109, 115, 147, 25);
		contentPane.add(lblNombreFranja);
		
		JLabel lblDias = new JLabel("Dias:");
		lblDias.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblDias.setBounds(109, 160, 147, 25);
		contentPane.add(lblDias);
		
		btnAnadirFranja2 = new JButton("");
		btnAnadirFranja2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean dias[] = new boolean[7];
				if(chckbxLunes.isSelected()){
					dias[0] = true;
				} else{
					dias[0] = false;
				}
				if(chckbxMartes.isSelected()){
					dias[1] = true;
				} else{
					dias[1] = false;
				}
				if(chckbxMiercoles.isSelected()){
					dias[2] = true;
				} else{
					dias[2] = false;
				}
				if(chckbxJueves.isSelected()){
					dias[3] = true;
				} else{
					dias[3] = false;
				}
				if(chckbxViernes.isSelected()){
					dias[4] = true;
				} else{
					dias[4] = false;
				}
				if(chckbxSabado.isSelected()){
					dias[5] = true;
				} else{
					dias[5] = false;
				}
				if(chckbxDomingo.isSelected()){
					dias[6] = true;
				} else{
					dias[6] = false;
				}
				informacion.anadirFranja(txtNombreFranja.getText(), dias, "Prueba" , spinFieldInicio.getValue(), spinFieldFinal.getValue());
			}
		});
		btnAnadirFranja2.setRolloverIcon(new ImageIcon(VentanaAnadirFranja.class.getResource("/edu/recursos/Recurso 25@0.75x.png")));
		btnAnadirFranja2.setIcon(new ImageIcon(VentanaAnadirFranja.class.getResource("/edu/recursos/Recurso 21@0.75x.png")));
		btnAnadirFranja2.setBounds(220, 612, 147, 38);
		btnAnadirFranja2.setOpaque(false);
		btnAnadirFranja2.setBorderPainted(false);
		btnAnadirFranja2.setContentAreaFilled(false);
		contentPane.add(btnAnadirFranja2);
		
		JLabel lblFonodanadirfranja = new JLabel("");
		lblFonodanadirfranja.setHorizontalAlignment(SwingConstants.CENTER);
		lblFonodanadirfranja.setIcon(new ImageIcon(VentanaAnadirFranja.class.getResource("/edu/recursos/Recurso 8@0.75x.png")));
		lblFonodanadirfranja.setBounds(10, 11, 544, 589);
		contentPane.add(lblFonodanadirfranja);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaAnadirFranja.class.getResource("/edu/recursos/Recurso 4.png")));
		lblFondo.setBounds(-494, 0, 1073, 735);
		contentPane.add(lblFondo);
	}
}
