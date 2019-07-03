package edu.cableado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface InformacionEstudiante {
	void I();

	void anadirTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, int horaFinalizacionT,
			Date fechaFinT, String materia, boolean esSubtarea);

	void anadirSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, String idTareaPertenencia,
			int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);

	void eliminarTarea();

	void modificarTarea();

	void anadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;

	void modificarFranja();

	void eliminarFranja();

	/**
	 * M�todo para obtener las franjas en formato String por d�a. La estructura ser�
	 * la siguiente: String[0]: idFranja - String[1]: nombreFranja -String[2]:
	 * tipoFranja. Es un arreglo de 24 posiciones, una por cada hora del d�a. Las
	 * horas en las que no haya franja asignada se les pondr� el id = 0 y el
	 * nombreFranja = NO_ASIGNADA.
	 * 
	 * @param dia: n�mero del d�a del que se requieren las franjas.
	 * @return
	 */
	List<String> obtenerFranjasPorDia(int dia);

	@SuppressWarnings("rawtypes")
	Enum[] obtenerTiposDeFranjas();

	ArrayList<String[]> solicitarListaTareasFecha(Date fecha);

	ArrayList<String[]> solicitarListaTareasPadreFecha(Date fecha);

	ArrayList<String[]> solicitarListaTareasFechaDificultad(Date fecha, int dificultad);

	ArrayList<String[]> solicitarListaTareasFechaMateria(Date fecha, String materia);

	ArrayList<String[]> solicitarListaTareasFechaTipo(Date fecha, String tipo);

	ArrayList<String> solicitarListaNombresMateria();

	ArrayList<String> solicitarListaNombresTareaPadre();

	ArrayList<String[]> solicitarListaTareasPadre();

	ArrayList<String> solicitarMaterias();

}
