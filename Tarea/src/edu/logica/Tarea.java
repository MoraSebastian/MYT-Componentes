package edu.logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Tarea {
	protected String descripcion;
	protected String tareas;
	protected String dificultad;
	protected String tipo;
	protected String fecha;
	protected String materia;
	protected String nombre;
	protected String hora;
	protected ArrayList<Tarea> hijos = new ArrayList<Tarea>();
	
	public  void anadirHijo(Tarea hijo) {
		hijos.add(hijo);
	}
	public ArrayList<Tarea> getHijos(){
		return hijos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTareas() {
		return tareas;
	}
	public void setTareas(String tareas) {
		this.tareas = tareas;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void ModificarT(String nombreT, String descripcionT, int dificultadT, String tipoT, 
			String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fechaFinT);
		
		Tarea tarea = new TareaInvestigacion();
		tarea.setDescripcion(descripcionT);
		tarea.setDificultad(Integer.toString(dificultadT));
		tarea.setFecha(fechaComoCadena);
		tarea.setHora(Integer.toString(horaFinalizacionT));
		tarea.setMateria(materia);
		tarea.setNombre(nombreT);
		tarea.setTareas(idTareaPertenencia);
		tarea.setTipo(tipoT);
	}	
}
