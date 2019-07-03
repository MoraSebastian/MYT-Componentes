package edu.logica;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
	private static List<Tarea> listaTareas = new ArrayList<Tarea>();

	
	public static List<Tarea> getListaTareas() {
		return listaTareas;
	}

	public static void setListaTareas(List<Tarea> listaTareas) {
		GestorTareas.listaTareas = listaTareas;
	}
	
}
