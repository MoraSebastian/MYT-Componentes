package edu.cableado;

import java.util.ArrayList;

public interface consultarHorario {
	void consultaH();
	void RegistrarH(String[] datos, String tabla, boolean[] dias);
	ArrayList<String> consultas(String caso, String tabla);
	public ArrayList<String[]> CtotalFranjas();
}
