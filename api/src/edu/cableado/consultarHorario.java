package edu.cableado;

public interface consultarHorario {
	void consultaH();
	void a�adirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;
	Enum[] obtenerTiposDeFranjas();
}
