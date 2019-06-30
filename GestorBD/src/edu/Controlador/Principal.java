package edu.Controlador;

import edu.Interfaz.InterfazCrudT;

public class Principal {
	Controlador micontrolador;
	InterfazCrudT miInterfaz;
	
	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.Iniciar();
	}
	private void Iniciar() {
		miInterfaz = new InterfazCrudT();
		micontrolador = new Controlador();
		
		miInterfaz.ControladorEnPanel(micontrolador);
		miInterfaz.setVisible(true);
	}
}
