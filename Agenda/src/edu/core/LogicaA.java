package edu.core;

import javax.swing.JOptionPane;

import edu.cableado.InformacionEstudiante;
import edu.cableado.Sugerencia;
import edu.cableado.consultarTarea;
import edu.cableado.horarioEstudiante;
import edu.cableado.tareaEstudiante;

import edu.utilidades.Cargador;

public class LogicaA implements InformacionEstudiante{
	public static void main(String[] args) {
		
	}

	@Override
	public void I() {
		if(Inf()) {
			JOptionPane.showMessageDialog(null, "Agenda + Tarea(BD) + Horario(BD) + Recomendacion ");
		}else {
			JOptionPane.showMessageDialog(null, "Tarea");
		}		
	}
	public boolean Inf() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(horarioEstudiante.class.getName());
			if(cls != null) {
				horarioEstudiante he = (horarioEstudiante) cls.newInstance();
				he.H();
			}
			cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if(cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				te.T();
			}
			cls = cc.cargarUnaClaseDesdeSuDirectorio(Sugerencia.class.getName());
			if(cls != null) {
				Sugerencia s = (Sugerencia) cls.newInstance();
				s.S();
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
}
