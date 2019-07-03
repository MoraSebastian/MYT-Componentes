package edu.logica;

public class Asignacion {
	private int idFranja;
	private int idMateria;
	private String nombre;
	private String tipofranja;
	
	
	
	public Asignacion(int idFranja, int idMateria, String nombre, String tipofranja) {
		super();
		this.idFranja = idFranja;
		this.idMateria = idMateria;
		this.nombre = nombre;
		this.tipofranja = tipofranja;
	}
	public int getIdFranja() {
		return idFranja;
	}
	public void setIdFranja(int idFranja) {
		this.idFranja = idFranja;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipofranja() {
		return tipofranja;
	}
	public void setTipofranja(String tipofranja) {
		this.tipofranja = tipofranja;
	}
	
}
