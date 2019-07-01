package edu.cableado;

public interface HorarioEstudiante {
	void H();
	void agregarFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;
	Enum[] obtenerTiposDeFranjas();
	void eliminarFranja(String nombreF);
}
