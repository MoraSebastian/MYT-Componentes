package edu.interfaz;

import edu.cableado.InformacionEstudiante;
import edu.cableado.consultarTarea;
import edu.utilidades.Cargador;

public class Interfaz {

	
	public static void main(String args[]) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(InformacionEstudiante.class.getName());
			if(cls != null) {
				InformacionEstudiante ct = (InformacionEstudiante) cls.newInstance();
			    ct.I();;			    
			}			
		}catch (Exception e) {
			e.printStackTrace();
			
		}		

	}

}
