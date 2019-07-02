package edu.cableado;

import java.util.ArrayList;
import java.util.Date;

public interface tareaEstudiante {
	void T();
	void anadirTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	void anadirSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	ArrayList<String> consultarMaterias();
	ArrayList<String> consultarTareasP();
}
