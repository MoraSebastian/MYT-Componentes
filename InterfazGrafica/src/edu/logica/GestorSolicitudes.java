package edu.logica;

import edu.cableado.InformacionEstudiante;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class GestorSolicitudes {
	private InformacionEstudiante interfaceSolicitudes;

	public GestorSolicitudes(InformacionEstudiante info) {
		interfaceSolicitudes = info;
	}

	/** Anadir tarea le envia la solicitud a la interfaz de añadir una tarea */
	public void anadirTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, 
			int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea) {
		try {
			interfaceSolicitudes.anadirTarea(nombreT,descripcionT, dificultadT, tipoT, horaFinalizacionT,  fechaFinT,  materia, esSubtarea);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo añadir una tarea nueva ya que el componente de tarea no está disponible");
		}
	}

	public void anadirSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT,
			String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea) {
		try {
			interfaceSolicitudes.anadirSubTarea(nombreT, descripcionT, dificultadT, tipoT, idTareaPertenencia,  horaFinalizacionT,  fechaFinT,  materia,  esSubtarea);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo añadir una subtarea nueva ya que el componente de tarea no está disponible");
		}
	}

	public void eliminarTarea() {

	}

	public void modificarTarea() {

	}

	public void anadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) {
		if (interfaceSolicitudes != null) {
			try {
				interfaceSolicitudes.anadirFranja(nombreF, dias, tipoF, horaInicio, horaFinal);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				JOptionPane.showMessageDialog(null, e.getMessage(), "¡Ups! Ocurrió un error", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,"No se pudo añadir una franja nueva ya que el componente de Horario no está disponible");
		}
	}

	public ArrayList<String[]> solicitarListaTareasFecha(Date fecha){
		try {
			 return interfaceSolicitudes.solicitarListaTareasFecha(fecha);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de tareas porque el componente no está disponible");
			return null;
		}
	}
	
	public ArrayList<String[]> solicitarListaTareasFechaDificultad(Date fecha, int dificultad){
		try {
			return interfaceSolicitudes.solicitarListaTareasFechaDificultad(fecha, dificultad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de tareas porque el componente no está disponible");
			return null;
		}
	}
	
	public ArrayList<String[]> solicitarListaTareasFechaTipo(Date fecha, String tipo){
		try {
			return interfaceSolicitudes.solicitarListaTareasFechaTipo(fecha, tipo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de tareas porque el componente no está disponible");
			return null;
		}
	}
	
	public ArrayList<String[]> solicitarListaTareas(){
		try {
			return interfaceSolicitudes.solicitarListaTareasPadre();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de tareas porque el componente no está disponible");
			return null;
		}
	}
	
	public ArrayList<String> solicitarMaterias(){
		try {
			return interfaceSolicitudes.solicitarListaNombresMateria();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo obtener la lista de materias porque el componente no está disponible");
			return null;
		}
	}
	
	public String[] obtenerTiposDeFranjas(){
		String[] franjas= {""};
		Enum[] franjaEnum;
		try{			
			franjaEnum = interfaceSolicitudes.obtenerTiposDeFranjas();
			franjas =  new String[franjaEnum.length];
			for(int i=0; i<franjaEnum.length; i++){
				franjas[i] = franjaEnum[i].name();
			
			}
		} catch(Exception e){
			
		}
		return franjas;
	}
}
