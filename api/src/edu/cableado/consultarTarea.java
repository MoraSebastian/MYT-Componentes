package edu.cableado;

import java.util.ArrayList;

public interface consultarTarea {
	void RegistrarT(String datos[]);
	void consultaT();
	void ModificarT();
	
	//ESTAS CONSULTAS SON PARA UNA FECHA 
	ArrayList<String[]> cTareasPendientes(String fecha); //1 TODAS LAS TAREAS 
	ArrayList<String[]> cTareasPadre(String fecha); //2 TODAS LAS TAREAS QUE SON PADRE 
	ArrayList<String[]> cTareasPorMateria(String fecha, String nombre); //3 TODAS LAS TAREAS POR MATERIA 
	ArrayList<String[]> cTareasPorTipo(String fecha, String nombre); //4 TODAS LAS TAREAS POR TIPO 
	ArrayList<String[]> cTareasPorDificultad(String fecha, String nombre); //5 TODAS LAS TAREAS POR DIFICULTAD
	ArrayList<String[]> cTareasPadre(); //8 CONSULTA A LAS TAREAS PADRES
	
	//ESTAS CONSULTAS SON MÁS SENCILLAS SOLO DE NOMBRES SEGUN EL CASO
	ArrayList<String> cNombreMaterias(); //6 CONSULTAR NOMBRES DE MATERIAS 
	ArrayList<String> cNombreTareasPadre(); // 7 CONSULTAR NOMBRES DE TAREAS PADRE
	
	void Conectar();
}
