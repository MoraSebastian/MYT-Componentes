package edu.cableado;

import java.util.Date;

public interface InformacionEstudiante {
	void I();
	void anadirTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	void anadirSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	void eliminarTarea();
	void modificarTarea();
	void anadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;
	void modificarFranja();
	void eliminarFranja();
}
