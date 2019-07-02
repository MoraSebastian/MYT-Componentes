package edu.Controlador;

import java.sql.Date;
import java.util.ArrayList;

import edu.core.LogicaA;

public class Controlador {
	
	private LogicaA logic;
	public Controlador() {
		logic = new LogicaA();
	}
	public void ConsultarRegistro() {
		//gestort.consultaT();
	}
	public void AdicionarTarea(String arg0, String arg1, int arg2, String arg3, int arg4, Date arg5, String arg6, boolean arg7) {
		logic.anadirTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}
	public void AdicionarSubTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6, String arg7,boolean arg8) {
		logic.anadirSubTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);;
	}
	public void BorrarRegistro() {
		
	}
	public ArrayList<String> ConsultaSencilla(String caso, String tabla) {
		return null;//gestort.consultas(caso, tabla);
	}
	public ArrayList<String> ConsultarMaterias(){
		return logic.Resivir();
	}
}
