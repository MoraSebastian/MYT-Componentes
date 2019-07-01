package edu.core;

import java.util.Date;

import javax.swing.JOptionPane;

import edu.cableado.HorarioEstudiante;
import edu.cableado.InformacionEstudiante;
import edu.cableado.Sugerencia;
import edu.cableado.consultarTarea;
<<<<<<< HEAD
import edu.cableado.HorarioEstudiante;
=======
>>>>>>> cf06ea46a0d9c7ce481f9ccfba63e460a08f5e74
import edu.cableado.tareaEstudiante;

import edu.utilidades.Cargador;

public class LogicaA implements InformacionEstudiante{
	private static HorarioEstudiante horarioEstudiante = null;
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
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(HorarioEstudiante.class.getName());
			if(cls != null) {
				HorarioEstudiante he = (HorarioEstudiante) cls.newInstance();
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
	public void anadirFranja(String nombreFranja, boolean[] dias, String tipoFranja, int horaInicial, int horaFinal) throws Exception{
		if(horarioEstudiante!=null) {
			try {
				horarioEstudiante.agregarFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
			} catch (Exception e) {
				throw e;
			}
		}else {
			throw new Exception("El componente horario no ha sido cargado");
		}
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

	@Override
	public void anadirSubTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6,
			String arg7, boolean arg8) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anadirTarea(String arg0, String arg1, int arg2, String arg3, int arg4, Date arg5, String arg6,
			boolean arg7) {
		// TODO Auto-generated method stub
		
	}

	public static HorarioEstudiante getHorarioEstudiante() {
		return horarioEstudiante;
	}

	public static void setHorarioEstudiante(HorarioEstudiante horarioEstudiante) {
		LogicaA.horarioEstudiante = horarioEstudiante;
	}
}
