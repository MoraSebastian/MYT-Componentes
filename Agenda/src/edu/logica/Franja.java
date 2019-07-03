package edu.logica;

public class Franja extends FranjaA {

	public Franja(){
		
	}
	public Franja(int id, String nombreFranja, int tiempoInicio, int tiempoFinal, Enum tipoFranja, boolean[] dias) {
		super(id, nombreFranja, tiempoInicio, tiempoFinal, tipoFranja, dias);
	}

}
