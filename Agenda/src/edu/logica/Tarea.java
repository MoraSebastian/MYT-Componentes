package edu.logica;

import java.util.Date;

public class Tarea {

	private String nombreT;
	private String descripcionT;
	private int dificultadT;
	private String tipoT;
	private int horaFinalizacionT;
	private Date fechaFinT;
	private String materia;
	private boolean esSubtarea;
	private int id;

	public Tarea(String nombreT, int dificultadT, int id) {
		super();
		this.nombreT = nombreT;
		this.dificultadT = dificultadT;
		this.setId(id);
	}

	public String getNombreT() {
		return nombreT;
	}

	public void setNombreT(String nombreT) {
		this.nombreT = nombreT;
	}

	public String getDescripcionT() {
		return descripcionT;
	}

	public void setDescripcionT(String descripcionT) {
		this.descripcionT = descripcionT;
	}

	public int getDificultadT() {
		return dificultadT;
	}

	public void setDificultadT(int dificultadT) {
		this.dificultadT = dificultadT;
	}

	public String getTipoT() {
		return tipoT;
	}

	public void setTipoT(String tipoT) {
		this.tipoT = tipoT;
	}

	public int getHoraFinalizacionT() {
		return horaFinalizacionT;
	}

	public void setHoraFinalizacionT(int horaFinalizacionT) {
		this.horaFinalizacionT = horaFinalizacionT;
	}

	public Date getFechaFinT() {
		return fechaFinT;
	}

	public void setFechaFinT(Date fechaFinT) {
		this.fechaFinT = fechaFinT;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public boolean isEsSubtarea() {
		return esSubtarea;
	}

	public void setEsSubtarea(boolean esSubtarea) {
		this.esSubtarea = esSubtarea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
