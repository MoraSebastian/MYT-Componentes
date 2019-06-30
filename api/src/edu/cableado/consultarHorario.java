package edu.cableado;

public interface consultarHorario {
	void consultaH();
	void añadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;
	Enum[] obtenerTiposDeFranjas();
}
