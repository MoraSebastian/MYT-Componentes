package edu.cableado;

public interface horarioEstudiante {
	void H();
	void a�adirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception;
	Enum[] obtenerTiposDeFranjas();
	void eliminarFranja(String nombreF);
}
