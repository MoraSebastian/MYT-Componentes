package edu.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import edu.cableado.HorarioEstudiante;
import edu.cableado.InformacionEstudiante;
import edu.cableado.Sugerencia;
import edu.cableado.consultarTarea;
import edu.cableado.HorarioEstudiante;
import edu.cableado.tareaEstudiante;
import edu.logica.Asignacion;
import edu.logica.GestorAsignaciones;
import edu.logica.GestorFranjas;
import edu.logica.GestorTareas;
import edu.logica.Tarea;
import edu.utilidades.Cargador;

public class LogicaA implements InformacionEstudiante {
	private static HorarioEstudiante horarioEstudiante = null;
	Cargador cc;
	Class cls;
	tareaEstudiante te;
	HorarioEstudiante he;
	public LogicaA() {
		//I();
		cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			cls = cc.cargarUnaClaseDesdeSuDirectorio(HorarioEstudiante.class.getName());
			if (cls != null) {
				he = (HorarioEstudiante) cls.newInstance();
				horarioEstudiante = he;
//				he.H();
			}
			cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if (cls != null) {
				te = (tareaEstudiante) cls.newInstance();				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void I() {
		if (Inf()) {
			System.out.println("Se cargaron los componentes");
		} else {
			System.out.println("No se cargaron los componentes");
		}

	}
	
	public static void main(String[] args) {
		LogicaA logic = new LogicaA();
		logic.anadirTarea("nombretare1", "esta es la tarea 1", 2, "Trabajo", 18, (new Date("2016/06/25")), "", false);
	}
	
	public boolean Inf() {

		
		try {
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
		if (horarioEstudiante == null) {
			I();
		}
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
	public List<String> obtenerFranjasPorDia(int numeroDia) {
		GestorFranjas gestorFranjas = new GestorFranjas();
		List<Object[]> franjasDia = horarioEstudiante.obtenerFranjasPorDia(numeroDia);
		List<String[]> listadoArregloString = gestorFranjas.gestionarFranjas(franjasDia);
		GestorAsignaciones gestorAsignaciones = new GestorAsignaciones();
		List<String> listadoRetorno = new ArrayList<String>();
		int i = 0;
		for(String[] arrString: listadoArregloString) {
			gestorAsignaciones.put(numeroDia, i, arrString);
			i++;
		}
		for(Asignacion asignacion: gestorAsignaciones.obtenerFranjasDeDia(numeroDia).values()) {
			listadoRetorno.add(asignacion.getNombre());
		}
		
		return listadoRetorno;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enum[] obtenerTiposDeFranjas() {
		if (horarioEstudiante == null) {
			I();
		}
		return horarioEstudiante.obtenerTiposDeFranjas();
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

	// ESTE M�TODO ES PARA ANADIR UNA SUBTAREA
	@Override
	public void anadirSubTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6,
			String arg7, boolean arg8) {
			
		te.anadirSubTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	// ESTE M�TODO ES PARA ANADIR UNA TAREA
	@Override
	public void anadirTarea(String arg0, String arg1, int arg2, String arg3, int arg4, Date arg5, String arg6,
			boolean arg7) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(tareaEstudiante.class.getName());
			if (cls != null) {
				tareaEstudiante te = (tareaEstudiante) cls.newInstance();
				int id = GestorTareas.getListaTareas().size()+1;
				Tarea tarea = new Tarea(arg0, arg2, id);
				
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
	public ArrayList<String[]> solicitarListaTareasFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fecha);
		return consultarTareasPendientes(fechaComoCadena, "tpendientes");
	}

	public ArrayList<String[]> solicitarListaTareasPadreFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fecha);
		return consultarTareasPendientes(fechaComoCadena.toString(), "tpendienteSinpadre");
	}

	public ArrayList<String[]> consultarTareasPendientes(String fecha, String caso) {
		
		try {
			if (cls != null) {				
				switch (caso) {
				case "tpendientes":
					return te.cTareasPendientes(fecha);
				case "tpendienteSinpadre":
					return te.cTareasPadre(fecha);
				default:
					return null;
				}
			} else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String[]> solicitarListaTareasPadre() {		
		try {
			if (cls != null) {
				return te.cTareasPadre();
			} else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<String[]> solicitarListaTareasFechaDificultad(Date fecha, int dificultad) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fecha);
		return consultarTareasSegun(fechaComoCadena, Integer.toString(dificultad), "dificultad");
	}

	@Override
	public ArrayList<String[]> solicitarListaTareasFechaTipo(Date fecha, String tipo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fecha);
		return consultarTareasSegun(fechaComoCadena, tipo, "tipo");
	}

	public ArrayList<String[]> solicitarListaTareasFechaMateria(Date fecha, String materia) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fecha);
		return consultarTareasSegun(fechaComoCadena, materia, "materia");
	}

	public ArrayList<String[]> consultarTareasSegun(String fecha, String nombre, String caso) {		
		try {			
			if (cls != null) {
				switch (caso) {
				case "tipo":
					return te.cTareasPorTipo(fecha, nombre);
				case "dificultad":
					return te.cTareasPorDificultad(fecha, nombre);
				case "materia":
					return te.cTareasPorMateria(fecha, nombre);
				default:
					return null;
				}
			} else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> solicitarListaNombresMateria() {
		return consultarNombre("materia");
	}

	public ArrayList<String> solicitarListaNombresTareaPadre() {
		return consultarNombre("tareap");
	}

	public ArrayList<String> consultarNombre(String caso) {
		try {
			if (cls != null) {
				switch (caso) {
				case "tareap":
					return te.cNombreTareasPadre();
				case "materia":
					return te.cNombreMaterias();
				default:
					return null;
				}
			} else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO TAREA ESTUDIANTE");
				return null;
			}
		} catch (Exception e) {
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
