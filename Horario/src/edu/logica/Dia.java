package edu.logica;

/**
 * Clase concreta para el uso de agrupaciones de tipo horario.
 *
 */
public class Dia extends Horario{

	@Override
	protected void mostrarFranjas() {
		localizadorFranja.mostrarNombresFranjas();
	}

}
