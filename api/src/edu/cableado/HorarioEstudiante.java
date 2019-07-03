package edu.cableado;

import java.util.List;
/**
 * Clase conectora entre Agenda y Horario. Agenda consume recursos de Horario.
 *
 */
public interface HorarioEstudiante {
	void H();
	void agregarFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;
	@SuppressWarnings("rawtypes")
	Enum[] obtenerTiposDeFranjas();
	void eliminarFranja(String nombreF);
	/**
	 * La estructura del arreglo de objetos es:
	 * [0] = int id
	 * [1] = String nombreFranja
	 * [2] = int tiempoInicial
	 * [3] = int tiempoFinal
	 * [4] = Enum tipoFranja
	 * [5] = boolean[] dias
	 * [6] = boolean ocupada
	 */
	List<Object[]> obtenerFranjas();
	List<Object[]> obtenerFranjasPorDia(int dia);
}
