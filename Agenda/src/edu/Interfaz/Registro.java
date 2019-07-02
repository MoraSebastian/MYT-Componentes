package edu.Interfaz;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import edu.Controlador.Controlador;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

public class Registro extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	public JPanel panel;
	protected Controlador micontrolador;
	protected JButton btnRegistrarTarea;
	protected JButton btnAnadirTipo;
	protected JTextArea taDescripcion;
	protected JDateChooser dcFechaentrega;
	protected JSpinner sHoraentrega;
	protected JComboBox<Integer> cbDificultad;
	protected JComboBox cbTipo;
	protected JComboBox cbMateria;
	protected ArrayList<String> nombres;
	protected JTextField tfNombre;
	protected String subtarea = "";
	protected JSpinField sFHora;
	
	public Registro(Controlador micontrolador) {
		this.micontrolador = micontrolador;
		setBackground(Color.WHITE);
		setLayout(null);
		
		subtarea = "null";
		
		
		
		JLabel lblAadirDescripcin = new JLabel("<html>A\u00F1adir descripci\u00F3n:<html>");
		lblAadirDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAadirDescripcin.setBounds(32, 29, 114, 14);
		add(lblAadirDescripcin);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		taDescripcion = new JTextArea();
		taDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		taDescripcion.setBounds(168, 24, 230, 85);
		taDescripcion.setBorder(border);
		add(taDescripcion);
		
		
		
		JLabel lblAadirDificultad = new JLabel("<html>A\u00F1adir Dificultad:<html>");
		lblAadirDificultad.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAadirDificultad.setBounds(32, 213, 114, 14);
		add(lblAadirDificultad);
		
		JLabel lblDeterminarTipoDe = new JLabel("<html>Determinar tipo de tarea:<html>");
		lblDeterminarTipoDe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblDeterminarTipoDe.setBounds(32, 274, 114, 30);
		add(lblDeterminarTipoDe);
		
		btnAnadirTipo = new JButton("A\u00F1adir Tipo");
		btnAnadirTipo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAnadirTipo.addActionListener(this);
		btnAnadirTipo.setBackground(Color.WHITE);
		btnAnadirTipo.setBounds(293, 271, 105, 23);
		add(btnAnadirTipo);
		
		JLabel lblAadirFechaDe = new JLabel("<html>A\u00F1adir fecha de entrega:<html>");
		lblAadirFechaDe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAadirFechaDe.setBounds(32, 341, 114, 30);
		add(lblAadirFechaDe);
		
		dcFechaentrega = new JDateChooser();
		dcFechaentrega.setBackground(Color.WHITE);
		dcFechaentrega.setBounds(168, 341, 105, 30);
		add(dcFechaentrega);
		
		sFHora = new JSpinField();
		sFHora.setMinimum(0);
		sFHora.setMaximum(23);
		sFHora.setBounds(168, 394, 159, 20);
		add(sFHora);
		
		
		JLabel lblAadirHoraDe = new JLabel("<html>A\u00F1adir hora de entrega:<html>");
		lblAadirHoraDe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAadirHoraDe.setBounds(32, 398, 114, 30);
		add(lblAadirHoraDe);
		
		JLabel lblLaTareaPertenece = new JLabel("<html>La tarea pertenece a alguna materia, si es el caso, definela aca:<html>");
		lblLaTareaPertenece.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblLaTareaPertenece.setBounds(32, 439, 114, 74);
		add(lblLaTareaPertenece);
		
		cbDificultad = new JComboBox<Integer>();
		cbDificultad.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbDificultad.setBackground(Color.WHITE);
		cbDificultad.setBounds(168, 210, 105, 23);
		cbDificultad.addItem(1);
		cbDificultad.addItem(2);
		cbDificultad.addItem(3);
		cbDificultad.addItem(4);
		cbDificultad.addItem(5);
		add(cbDificultad);
		
		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbTipo.setBackground(Color.WHITE);
		cbTipo.setBounds(168, 272, 105, 23);		
		nombres = micontrolador.ConsultaSencilla("nombre", "tipotarea");
		if(nombres == null ) {
			cbTipo.addItem("");
		}else {
			cbTipo.addItem("");
			//System.out.println("nombres.get(0): "+nombres.get(0));
			for (int i = 0; i < nombres.size(); i++) {
				cbTipo.addItem(nombres.get(i));
			}
		}		
		add(cbTipo);
		
		cbMateria = new JComboBox();
		cbMateria.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbMateria.setBackground(Color.WHITE);
		cbMateria.setBounds(168, 463, 230, 23);
		nombres = micontrolador.ConsultarMaterias();
		if(nombres == null) {
			cbMateria.addItem("");
		}else {
			for(int i=0; i<nombres.size(); i++) {			
				cbMateria.addItem(nombres.get(i));
			}	
		}					
		add(cbMateria);
		
		btnRegistrarTarea = new JButton("Registrar Tarea");
		btnRegistrarTarea.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnRegistrarTarea.setBackground(Color.WHITE);
		btnRegistrarTarea.addActionListener(this);
		btnRegistrarTarea.setBounds(32, 535, 114, 23);
		add(btnRegistrarTarea);
		
		JLabel lblAsignarNombre = new JLabel("Asignar nombre:");
		lblAsignarNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAsignarNombre.setBounds(32, 169, 114, 14);
		add(lblAsignarNombre);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tfNombre.setBounds(168, 167, 230, 23);
		add(tfNombre);
		tfNombre.setColumns(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRegistrarTarea) {
			//Validacion de campos vacios
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); //17/06/2014 18:19:25
			boolean validar = true;
			if(taDescripcion.getText().equals("")){
				validar = false;
				JOptionPane.showMessageDialog(null, "NO SE HA LLENADO EL CAMPO DE DESCRIPCIÓN");
			}	
			if(tfNombre.getText().equals("")) {
				validar = false;
				JOptionPane.showMessageDialog(null, "NO SE HA LLENADO EL CAMPO DE NOMBRE");
			}
			if(cbDificultad.getSelectedItem().toString().equals("")) {
				validar = false;
				JOptionPane.showMessageDialog(null, "FALTA LLENAR EL CAMPO DIFICULTAD");
			}
			if(cbTipo.getSelectedItem().toString().equals("")) {
				validar = false;
				JOptionPane.showMessageDialog(null, "FALTA DEFINIR EL TIPO DE TAREA");
			}
				
			if(dcFechaentrega.getDate() == null) {
				validar = false;
				JOptionPane.showMessageDialog(null, "FALTA DEFINIR LA FECHA DE ENTREGA");
			}
			
			
			if(validar == true) {
				String[] datos = new String[9];
				if(micontrolador.ConsultaSencilla("maxid", "tarea").get(0) == null) {
					datos[0] = "1";
				}else {
					datos[0] = Integer.toString(Integer.parseInt(micontrolador.ConsultaSencilla("maxid", "tarea").get(0))+1);
				}				
				datos[1] = "'" + taDescripcion.getText() + "'";
				datos[2] = subtarea;
				datos[3] = cbDificultad.getSelectedItem().toString();
				datos[4] = micontrolador.ConsultaSencilla(cbTipo.getSelectedItem().toString(), "tipotarea").get(0);
				datos[5] = "'" + Integer.toString(dcFechaentrega.getCalendar().get(Calendar.DAY_OF_MONTH)) + "/" + 
						 Integer.toString(dcFechaentrega.getCalendar().get(Calendar.MONTH)+1) + "/" +
						 Integer.toString(dcFechaentrega.getCalendar().get(Calendar.YEAR))+"'";
				
				
				datos[6] = "'" + sdf.format(sHoraentrega.getValue()) + "'";		
				if(cbMateria.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Si no se define una materia para la tarea, "
							+ "quiere decir que esta tarea es personal, y puedes definirla mejor con el tipo.");
					datos[7] = "null";
					
				}else {
					datos[7] = micontrolador.ConsultaSencilla(cbMateria.getSelectedItem().toString(), "materia").get(0);
				}
				
				datos[8] = "'" + tfNombre.getText() + "'";
				for (int i = 0; i < datos.length; i++) {
					System.out.println(datos[i]);
				}
				//System.out.println("MAXIMO ID TIPOTAREA: "+micontrolador.ConsultaSencilla("maxid", "tipotarea").get(0));
				micontrolador.AdicionarTarea(tfNombre.getText(), taDescripcion.getText(), cbDificultad.getSelectedIndex(), 
						cbTipo.getSelectedItem().toString(), sFHora.getValue(), (java.sql.Date) dcFechaentrega.getDate(), 
						cbMateria.getSelectedItem().toString(), false);
			}							
		}		
		if(e.getSource()==btnAnadirTipo) {
			AgregarTipo agregart = new AgregarTipo();
			agregart.setControlador(micontrolador);
			agregart.setVisible(true);
		}
	}
}
