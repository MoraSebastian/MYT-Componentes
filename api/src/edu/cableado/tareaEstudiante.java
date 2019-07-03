package edu.cableado;

import java.util.ArrayList;
import java.util.Date;

public interface tareaEstudiante {
	void T();
	
	//REGISTROS
	void anadirTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	void anadirSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea);
	
	void modificarTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6,
			String arg7, boolean arg8);
	//CONSULTAS
	
	//ESTAS CONSULTAS SON PARA UNA FECHA 
	ArrayList<String[]> cTareasPendientes(String fecha); //1 TODAS LAS TAREAS 
	ArrayList<String[]> cTareasPadre(String fecha); //2 TODAS LAS TAREAS QUE SON PADRE 
	ArrayList<String[]> cTareasPorMateria(String fecha, String nombre); //3 TODAS LAS TAREAS POR MATERIA 
	ArrayList<String[]> cTareasPorTipo(String fecha, String nombre); //4 TODAS LAS TAREAS POR TIPO 
	ArrayList<String[]> cTareasPorDificultad(String fecha, String nombre); //5 TODAS LAS TAREAS POR DIFICULTAD
	ArrayList<String[]> cTareasPadre();
	//ESTAS CONSULTAS SON MÁS SENCILLAS SOLO DE NOMBRES SEGUN EL CASO
	ArrayList<String> cNombreMaterias(); //6 CONSULTAR NOMBRES DE MATERIAS 
	ArrayList<String> cNombreTareasPadre(); // 7 CONSULTAR NOMBRES DE TAREAS PADRE
	
}
