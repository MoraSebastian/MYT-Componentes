package edu.Fabrica;

import java.util.Date;

import edu.logica.Tarea;

public interface FabricaAbstracta {
	public Tarea crearTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	public Tarea creatSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
}
