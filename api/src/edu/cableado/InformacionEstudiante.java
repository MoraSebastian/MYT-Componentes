package edu.cableado;

import java.util.Date;

public interface InformacionEstudiante {
	void I();
	void anadirTarea(String nombreT, String descripcionT, int dificultadT, int tipoT, int horaFinalizacionT, Date fechaFinT, boolean esSubtarea);
	void anadirSubTarea(String nombreT, String descripcionT, int dificultadT, int tipoT, int idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, boolean esSubtarea);
	void eliminarTarea();
	void modificarTarea();
	void anadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal);
	void modificarFranja();
	void eliminarFranja();
}
