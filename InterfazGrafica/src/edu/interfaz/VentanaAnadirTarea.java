package edu.interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.logica.AnadirPanel;
import edu.logica.GestorSolicitudes;
import edu.logica.QuitarPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.DefaultComboBoxModel;

public class VentanaAnadirTarea extends JFrameGeneral {
	private String[] modeloTareas = {""}, modeloMaterias = {""};
	private ArrayList<String[]> todasLasTareas;
	private ArrayList<String> materias;
	private JPanel contentPane;
	private JTextField txtNombretarea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public void iniciarVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnadirTarea frame = new VentanaAnadirTarea(informacion);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	public VentanaAnadirTarea(GestorSolicitudes info) {
		super.informacion = info;
		cargarMaterias();
		cargarTareas();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 580, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBounds(281, 345, 159, 20);
		contentPane.add(dateChooser);
		
		JSpinField spinField = new JSpinField();
		spinField.setMinimum(0);
		spinField.setMaximum(23);
		spinField.setBounds(281, 385, 159, 20);
		contentPane.add(spinField);
		
		txtNombretarea = new JTextField();
		txtNombretarea.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		txtNombretarea.setText("nombreTarea");
		txtNombretarea.setBounds(281, 130, 159, 20);
		contentPane.add(txtNombretarea);
		txtNombretarea.setColumns(10);
		
		JTextArea txtrDescripciontarea = new JTextArea();
		txtrDescripciontarea.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		txtrDescripciontarea.setText("descripcionTarea");
		txtrDescripciontarea.setBounds(280, 168, 160, 89);
		contentPane.add(txtrDescripciontarea);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Trabajo", "Lectura", "Investigacion"}));
		cbxTipo.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		cbxTipo.setBounds(281, 307, 159, 20);
		contentPane.add(cbxTipo);
		
		JComboBox cbxQueTarea = new JComboBox();
		cbxQueTarea.setModel(new DefaultComboBoxModel(modeloTareas));
		cbxQueTarea.setEnabled(false);
		cbxQueTarea.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		cbxQueTarea.setBounds(281, 511, 159, 20);
		contentPane.add(cbxQueTarea);
		
		JComboBox cbxDificultad = new JComboBox();
		cbxDificultad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cbxDificultad.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		cbxDificultad.setBounds(281, 268, 159, 20);
		contentPane.add(cbxDificultad);
		
		JRadioButton rdbtnSiSubtarea = new JRadioButton("Si");
		rdbtnSiSubtarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxQueTarea.setEnabled(true);
			}
		});
		
		JComboBox cbxPerteneceAmateria = new JComboBox();
		cbxPerteneceAmateria.setModel(new DefaultComboBoxModel(modeloTareas));
		cbxPerteneceAmateria.setBounds(281, 428, 159, 20);
		contentPane.add(cbxPerteneceAmateria);
		buttonGroup.add(rdbtnSiSubtarea);
		rdbtnSiSubtarea.setBounds(281, 459, 47, 23);
		contentPane.add(rdbtnSiSubtarea);
			
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setSelected(true);
		rdbtnNo.setBounds(393, 461, 47, 23);
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxQueTarea.setEnabled(false);
			}
		});
		contentPane.add(rdbtnNo);
		
		JLabel lblSubtarea = new JLabel("Subtarea:");
		lblSubtarea.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblSubtarea.setBounds(114, 459, 110, 25);
		contentPane.add(lblSubtarea);
		
		JLabel lblHoraDeEntrega = new JLabel("Hora de entrega:");
		lblHoraDeEntrega.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblHoraDeEntrega.setBounds(114, 376, 159, 30);
		contentPane.add(lblHoraDeEntrega);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega:");
		lblFechaDeEntrega.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblFechaDeEntrega.setBounds(114, 338, 159, 27);
		contentPane.add(lblFechaDeEntrega);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblNombre.setBounds(114, 123, 125, 29);
		contentPane.add(lblNombre);
		
		JLabel lblHorasDeDuracion = new JLabel("Tipo de tarea:");
		lblHorasDeDuracion.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblHorasDeDuracion.setBounds(114, 302, 147, 25);
		contentPane.add(lblHorasDeDuracion);
		
		JLabel lblDecripcion = new JLabel("Descripci\u00F3n:");
		lblDecripcion.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblDecripcion.setBounds(114, 163, 110, 29);
		contentPane.add(lblDecripcion);
		
		JLabel lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblDificultad.setBounds(114, 267, 110, 24);
		contentPane.add(lblDificultad);
		
		JButton btnAnadirTarea = new JButton("");
		btnAnadirTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean subTarea;
				try{
					if(rdbtnSiSubtarea.isSelected()){
						String pertenencia=""; //Revisar lo del id
						for (int i=0; i<todasLasTareas.size(); i++){
							if(cbxQueTarea.getSelectedItem().toString().equals(todasLasTareas.get(i))){
								pertenencia = todasLasTareas.get(i)[0];
							}
						}
						
						subTarea = true;
						informacion.anadirSubTarea(txtNombretarea.getText(), txtrDescripciontarea.getText(), Integer.parseInt(cbxDificultad.getSelectedItem().toString()),
								cbxTipo.getSelectedItem().toString(), pertenencia,spinField.getValue(), dateChooser.getDate(),
								cbxPerteneceAmateria.getSelectedItem().toString(), subTarea);
					} else{
						subTarea = false;
						informacion.anadirTarea(txtNombretarea.getText(), txtrDescripciontarea.getText(), Integer.parseInt(cbxDificultad.getSelectedItem().toString()), 
								cbxTipo.getToolTipText(), spinField.getValue(), dateChooser.getDate(), cbxPerteneceAmateria.getSelectedItem().toString(),
								subTarea);
					}
					dispose();
				} catch(Exception e){
					JOptionPane.showMessageDialog(null,
							"No se pudo agregar la tarea porque el componente no está cargado ");
				}
				
			}
		});
		
		JLabel lblPerteneceAMateria = new JLabel("Pertenece a materia:");
		lblPerteneceAMateria.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblPerteneceAMateria.setBounds(114, 421, 183, 30);
		contentPane.add(lblPerteneceAMateria);
		btnAnadirTarea.setRolloverIcon(new ImageIcon(VentanaAnadirTarea.class.getResource("/edu/recursos/Recurso 26@0.75x.png")));
		btnAnadirTarea.setIcon(new ImageIcon(VentanaAnadirTarea.class.getResource("/edu/recursos/Recurso 20@0.75x.png")));
		btnAnadirTarea.setBounds(232, 612, 147, 38);
		btnAnadirTarea.setOpaque(false);
		btnAnadirTarea.setBorderPainted(false);
		btnAnadirTarea.setContentAreaFilled(false);
		contentPane.add(btnAnadirTarea);
		
		JLabel lblFonodanadirtarea = new JLabel("");
		lblFonodanadirtarea.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblFonodanadirtarea.setHorizontalAlignment(SwingConstants.CENTER);
		lblFonodanadirtarea.setIcon(new ImageIcon(VentanaAnadirTarea.class.getResource("/edu/recursos/Recurso 18@0.75x.png")));
		lblFonodanadirtarea.setBounds(10, 11, 544, 589);
		contentPane.add(lblFonodanadirtarea);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaAnadirTarea.class.getResource("/edu/recursos/Recurso 4.png")));
		lblFondo.setBounds(-494, 0, 1073, 735);
		contentPane.add(lblFondo);
	}
	
	private void cargarTareas(){
		try{
			//todasLasTareas = informacion.solicitarListaTareas();
			//modeloMaterias = new String[todasLasTareas.size()];
			ArrayList<String> array = informacion.solicitarListaTareas();
			for(int i=0; i<array.size(); i++){
				//modeloTareas[i]= todasLasTareas.get(i)[7];
				modeloTareas[i]= array.get(i);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de tareas porque el componente no está disponible ");
		}				
	}
	
	private void cargarMaterias(){
		try{
			materias = informacion.solicitarMaterias();
			for(int i=0; i<materias.size(); i++){
				modeloMaterias[i]= materias.get(i);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de materias porque el componente no está disponible ");
		}
		
	}
}
