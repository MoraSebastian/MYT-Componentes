package edu.logica;

public enum TipoFranjaEnum {
	MATERIA("Materia"), DESCANSO("Descanso"), TRANSPORTE("Transporte"), TIEMPO_LIBRE("Tiempo libre");
	private String nombre;
	
	private TipoFranjaEnum(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
