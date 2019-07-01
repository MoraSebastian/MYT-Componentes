package edu.core;

import java.util.Date;

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

	@Override
	public void anadirFranja(String arg0, boolean[] arg1, String arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anadirSubTarea(String arg0, String arg1, int arg2, int arg3, int arg4, int arg5, Date arg6,
			boolean arg7) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anadirTarea(String arg0, String arg1, int arg2, int arg3, int arg4, Date arg5, boolean arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarFranja() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTarea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarFranja() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarTarea() {
		// TODO Auto-generated method stub
		
	}
}
