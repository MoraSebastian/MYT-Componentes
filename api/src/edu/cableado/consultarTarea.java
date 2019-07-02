package edu.cableado;

import java.util.ArrayList;

public interface consultarTarea {
	void RegistrarT(String datos[]);
	void consultaT();
	void ModificarT();
	public ArrayList<String[]> CtareasPendientes();
	ArrayList<String> consultarNombreM();
	ArrayList<String> consultarNombreT();
}
