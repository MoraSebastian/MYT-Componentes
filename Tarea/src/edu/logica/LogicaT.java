package edu.logica;

import javax.swing.JOptionPane;

import edu.cableado.consultarTarea;
import edu.cableado.horarioEstudiante;
import edu.cableado.tareaEstudiante;
import edu.utilidades.Cargador;

public class LogicaT implements tareaEstudiante {

	@Override
	public void T() {
		if(Crud()) {
			JOptionPane.showMessageDialog(null, "Tarea + BD");
		}else {
			JOptionPane.showMessageDialog(null, "Tarea");
		}					
	}
	public boolean Crud() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarTarea.class.getName());
			if(cls != null) {
				consultarTarea ct = (consultarTarea) cls.newInstance();
			    ct.consultaT();			    
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
}
