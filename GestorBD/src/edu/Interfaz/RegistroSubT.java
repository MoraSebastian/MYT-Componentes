package edu.Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import edu.Controlador.Controlador;

public class RegistroSubT extends JPanel implements ActionListener{

	private JComboBox cbtareaPadre;
	private JButton btnRegistrarT;
	private ArrayList<String> nombres;
		
	protected Controlador micontrolador;
	protected JButton btnRegistrarTarea;
	protected JButton btnAnadirTipo;
	protected JTextArea taDescripcion;
	protected JDateChooser dcFechaentrega;
	protected JSpinner sHoraentrega;
	protected JComboBox<Integer> cbDificultad;
	protected JComboBox cbTipo;
	protected JComboBox<String> cbMateria;
	
	protected JTextField tfNombre;
	
	public RegistroSubT(Controlador micontrolador) {
		nombres = new ArrayList<String>();
		
		JLabel lblAadirDificultad = new JLabel("<html>Definir tarea padre:<html>");
		lblAadirDificultad.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAadirDificultad.setBounds(32, 130, 114, 14);
		add(lblAadirDificultad);				
		
		cbtareaPadre = new JComboBox<Integer>();
		cbtareaPadre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbtareaPadre.setBackground(Color.WHITE);
		cbtareaPadre.setBounds(168, 130, 105, 23);
		cbtareaPadre.addItem("");
		nombres = micontrolador.ConsultaSencilla("nombrepadre", "tarea");
		for (int i = 0; i < nombres.size(); i++) {
			cbtareaPadre.addItem(nombres.get(i));
		}
		add(cbtareaPadre);		
		
		this.micontrolador = micontrolador;
		setBackground(Color.WHITE);
		setLayout(null);
										
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
		
		
		
		JLabel lblAadirDificultad1 = new JLabel("<html>A\u00F1adir Dificultad:<html>");
		lblAadirDificultad1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAadirDificultad1.setBounds(32, 213, 114, 14);
		add(lblAadirDificultad1);
		
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
		
		Date date = new Date(); 
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY); 
		sHoraentrega = new javax.swing.JSpinner(sm); 
		sHoraentrega.setBackground(Color.WHITE);
		JSpinner.DateEditor de_sHoraentrega = new JSpinner.DateEditor(sHoraentrega, "HH:mm:ss"); 
		sHoraentrega.setEditor(de_sHoraentrega);
		sHoraentrega.setBounds(168, 394, 105, 23);
		add(sHoraentrega);
		
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
		cbTipo.addItem("");
		nombres = micontrolador.ConsultaSencilla("nombre", "tipotarea");
		for (int i = 0; i < nombres.size(); i++) {
			cbTipo.addItem(nombres.get(i));
		}
		add(cbTipo);
		
		cbMateria = new JComboBox<String>();
		cbMateria.setEnabled(false);
		cbMateria.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbMateria.setBackground(Color.WHITE);
		cbMateria.setBounds(168, 463, 230, 23);		
		nombres = micontrolador.ConsultaSencilla("nombre", "materia");
		for (int i = 0; i < nombres.size(); i++) {
			cbMateria.addItem(nombres.get(i));
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
			nombres = micontrolador.ConsultaSencilla("idmateria", "'"+cbtareaPadre.getSelectedItem().toString()+"'");
			System.out.println("nombres.get(0): "+nombres.get(0));
			cbMateria.setSelectedItem(nombres.get(0));
			System.out.println(cbMateria.getSelectedItem().toString());
			
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
			if(cbtareaPadre.getSelectedItem().toString().equals("")) {
				validar = false;
				JOptionPane.showMessageDialog(null, "NO SE HA DEFINIDO A QUE TAREA PERTENECE ESTA SUBTAREA");
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
			if(sdf.format(sHoraentrega.getValue()).equals("")) {
				validar = false;
				JOptionPane.showMessageDialog(null, "FALTA DEFINIR LA HORA DE ENTREGA");
			}			
			if(validar == true) {
				String[] datos = new String[9];
				datos[0] = Integer.toString(Integer.parseInt(micontrolador.ConsultaSencilla("maxid", "tarea").get(0))+1);
				datos[1] = "'" + taDescripcion.getText() + "'";
				datos[2] = micontrolador.ConsultaSencilla(cbtareaPadre.getSelectedItem().toString(), "tarea").get(0);
				datos[3] = cbDificultad.getSelectedItem().toString();
				datos[4] = micontrolador.ConsultaSencilla(cbTipo.getSelectedItem().toString(), "tipotarea").get(0);
				datos[5] = "'" + Integer.toString(dcFechaentrega.getCalendar().get(Calendar.DAY_OF_MONTH)) + "/" + 
						 Integer.toString(dcFechaentrega.getCalendar().get(Calendar.MONTH)+1) + "/" +
						 Integer.toString(dcFechaentrega.getCalendar().get(Calendar.YEAR))+"'";
				
				
				datos[6] = "'" + sdf.format(sHoraentrega.getValue()) + "'";						 
				datos[7] = micontrolador.ConsultaSencilla(cbMateria.getSelectedItem().toString(), "materia").get(0);
				datos[8] = "'" + tfNombre.getText() + "'";
				for (int i = 0; i < datos.length; i++) {
					System.out.println(datos[i]);
				}
				//System.out.println("MAXIMO ID TIPOTAREA: "+micontrolador.ConsultaSencilla("maxid", "tipotarea").get(0));
				micontrolador.AdicionarRegistro(datos, "tarea");
			}							
		}		
		if(e.getSource()==btnAnadirTipo) {
			AgregarTipo agregart = new AgregarTipo();
			agregart.setControlador(micontrolador);
			agregart.setVisible(true);
		}
	}

}
