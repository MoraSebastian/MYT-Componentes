package edu.Controlador;

import java.util.ArrayList;

import edu.conexionT.GestorT;

public class Controlador {
	private GestorT gestort;
	
	public Controlador() {
		gestort = new GestorT();
	}
	public void ConsultarRegistro() {
		gestort.consultaT();
	}
	public void AdicionarRegistro(String[] datos, String tabla) {
		gestort.RegistrarT(datos);
	}
	public void BorrarRegistro() {
		
	}
	public ArrayList<String> ConsultaSencilla(String caso, String tabla) {
		return gestort.consultas(caso, tabla);
	}
}
