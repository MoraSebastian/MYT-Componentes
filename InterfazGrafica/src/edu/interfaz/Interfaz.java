package edu.interfaz;

import java.awt.EventQueue;

import edu.cableado.InformacionEstudiante;
import edu.cableado.consultarTarea;
import edu.logica.GestorSolicitudes;
import edu.utilidades.Cargador;

public class Interfaz {

	
	public static void main(String args[]) {
		InformacionEstudiante ct = null;
		GestorSolicitudes informacion;
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(InformacionEstudiante.class.getName());
			if(cls != null) {
				ct = (InformacionEstudiante) cls.newInstance();
				
			}			
		}catch (Exception e) {
			e.printStackTrace();
			
		}		
		
		informacion = new GestorSolicitudes(ct);
		
		//Carga la nueva ventana.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal(informacion);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
