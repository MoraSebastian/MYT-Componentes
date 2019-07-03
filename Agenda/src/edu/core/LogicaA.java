package edu.core;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.cableado.HorarioEstudiante;
import edu.cableado.InformacionEstudiante;
import edu.cableado.Sugerencia;
import edu.cableado.consultarTarea;
import edu.cableado.HorarioEstudiante;
import edu.cableado.tareaEstudiante;
import edu.utilidades.Cargador;

public class LogicaA implements InformacionEstudiante {
	private static HorarioEstudiante horarioEstudiante = null;


	@Override
	public void I() {
		if (Inf()) {
			JOptionPane.showMessageDialog(null, "Agenda + Tarea(BD) + Horario(BD) + Recomendacion ");
		} else {
			JOptionPane.showMessageDialog(null, "Tarea");
		}

	}

	public boolean Inf() {

		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(HorarioEstudiante.class.getName());
			if (cls != null) {
				HorarioEstudiante he = (HorarioEstudiante) cls.newInstance();
				horarioEstudiante = he;
//				he.H();
			}
			cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if (cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				// te.anadirTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
			}
			cls = cc.cargarUnaClaseDesdeSuDirectorio(Sugerencia.class.getName());
			if (cls != null) {
				Sugerencia s = (Sugerencia) cls.newInstance();
				// s.S();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void anadirFranja(String nombreFranja, boolean[] dias, String tipoFranja, int horaInicial, int horaFinal)
			throws Exception {
		I();
		if (horarioEstudiante != null) {
			try {
				horarioEstudiante.agregarFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
			} catch (Exception e) {
				throw e;
			}
		} else {
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
	//ESTE MÉTODO ES PARA ANADIR UNA SUBTAREA
	@Override
	public void anadirSubTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6,
			String arg7, boolean arg8) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if (cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				te.anadirSubTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);					
			}													
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	//ESTE MÉTODO ES PARA ANADIR UNA TAREA
	@Override
	public void anadirTarea(String arg0, String arg1, int arg2, String arg3, int arg4, Date arg5, String arg6,
			boolean arg7) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if (cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				te.anadirTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);						
			}															
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	public static HorarioEstudiante getHorarioEstudiante() {
		return horarioEstudiante;
	}

	public static void setHorarioEstudiante(HorarioEstudiante horarioEstudiante) {
		LogicaA.horarioEstudiante = horarioEstudiante;
	}

	@Override
	public Enum[] obtenerTiposDeFranjas() {
		return horarioEstudiante.obtenerTiposDeFranjas();
	}

	@Override
	public ArrayList<String[]> solicitarListaTareasFecha(Date fecha) {
		return consultarTareasPendientes(fecha.toString(), "tpendientes");
	}
	public ArrayList<String[]> solicitarListaTareasPadreFecha(Date fecha) {
		return consultarTareasPendientes(fecha.toString(), "tpendienteSinpadre");
	}
	public ArrayList<String[]> consultarTareasPendientes(String fecha, String caso) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if(cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				switch(caso) {
				case "tpendientes":
					return te.cTareasPendientes(fecha);
				case "tpendienteSinpadre":
					return te.cTareasPadre(fecha);
				default:
					return null;
				}
			}else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<String[]> solicitarListaTareasPadre() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if(cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();								
				return te.cTareasPadre();											
			}else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<String[]> solicitarListaTareasFechaDificultad(Date fecha, int dificultad) {
		return consultarTareasSegun(fecha.toString(), Integer.toString(dificultad), "dificultad");
	}

	@Override
	public ArrayList<String[]> solicitarListaTareasFechaTipo(Date fecha, String tipo) {
		return consultarTareasSegun(fecha.toString(), tipo, "tipo");
	}
	public ArrayList<String[]> solicitarListaTareasFechaMateria(Date fecha, String materia) {
		return consultarTareasSegun(fecha.toString(), materia, "materia");
	}
	public ArrayList<String[]> consultarTareasSegun(String fecha, String nombre, String caso){
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if(cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				switch(caso) {
				case "tipo":
					return te.cTareasPorTipo(fecha, nombre);
				case "dificultad":
					return te.cTareasPorDificultad(fecha, nombre);
				case "materia":
					return te.cTareasPorMateria(fecha, nombre);
				default:
					return null;
				}
			}else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> solicitarListaNombresMateria(){
		return consultarNombre("materia");
	}
	public ArrayList<String> solicitarListaNombresTareaPadre(){
		return consultarNombre("tareap");
	}

	public ArrayList<String> consultarNombre(String caso){
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if(cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				switch(caso) {
				case "tareap":
					return te.cNombreTareasPadre();
				case "materia":
					return te.cNombreMaterias();
				default:
					return null;
				}
			}else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	



	@Override
	public ArrayList<String> solicitarMaterias() {
		// TODO Auto-generated method stub
		return null;
	}


}
