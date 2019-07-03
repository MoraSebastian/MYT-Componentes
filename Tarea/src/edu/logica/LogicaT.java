package edu.logica;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.Fabrica.FabricaAbstracta;
import edu.Fabrica.FabricaInvestigacion;
import edu.Fabrica.FabricaLectura;
import edu.Fabrica.FabricaTrabajo;
import edu.cableado.consultarTarea;
import edu.cableado.tareaEstudiante;
import edu.utilidades.Cargador;

public class LogicaT implements tareaEstudiante {
	ArrayList<Tarea> tareas = new ArrayList<Tarea>();
	
	@Override
	public void T() {
		if(true) {
			JOptionPane.showMessageDialog(null, "Tarea + BD");
		}else {
			JOptionPane.showMessageDialog(null, "Tarea");
		}					
	}
	
	
	@Override
	/**
	 * Metodo que obtiene las tareas padre sin importar fecha
	 */
	public ArrayList<String[]> cTareasPadre() {
		ArrayList<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getTareas().equals("null")) {
				String[] t = new String[8];
				t[0] = tareas.get(i).getDescripcion();
				t[1] = tareas.get(i).getNombre();
				t[2] = tareas.get(i).getDificultad();
				t[3] = tareas.get(i).getTareas();
				t[4] = tareas.get(i).getTipo();
				t[5] = tareas.get(i).getMateria();
				t[6] = tareas.get(i).getFecha();
				t[7] = tareas.get(i).getHora();
				array.add(t);
			}
		}
		return array;
	}
	/**
	 * Metodo que retorna tareas pendientes para una fecha 
	 */
	public ArrayList<String[]> cTareasPendientes(String fecha){
		ArrayList<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getFecha() == fecha) {
				String[] t = new String[8];
				t[0] = tareas.get(i).getDescripcion();
				t[1] = tareas.get(i).getNombre();
				t[2] = tareas.get(i).getDificultad();
				t[3] = tareas.get(i).getTareas();
				t[4] = tareas.get(i).getTipo();
				t[5] = tareas.get(i).getMateria();
				t[6] = tareas.get(i).getFecha();
				t[7] = tareas.get(i).getHora();
				array.add(t);
			}
		}
		return array;
	}	
	/**
	 * metodo que obtiene las tareas padre para una fecha 
	 */
	@Override
	public ArrayList<String[]> cTareasPadre(String fecha) {
		ArrayList<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getFecha() == fecha && tareas.get(i).getTareas().equals("null")) {
				String[] t = new String[8];
				t[0] = tareas.get(i).getDescripcion();
				t[1] = tareas.get(i).getNombre();
				t[2] = tareas.get(i).getDificultad();
				t[3] = tareas.get(i).getTareas();
				t[4] = tareas.get(i).getTipo();
				t[5] = tareas.get(i).getMateria();
				t[6] = tareas.get(i).getFecha();
				t[7] = tareas.get(i).getHora();
				array.add(t);
			}
		}
		return array;
	}
	/**
	 * metodo que obtiene las tareas por materia
	 */
	public ArrayList<String[]> cTareasPorMateria(String fecha, String materia){
		ArrayList<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getMateria() == materia && tareas.get(i).getFecha() == fecha) {
				String[] t = new String[8];
				t[0] = tareas.get(i).getDescripcion();
				t[1] = tareas.get(i).getNombre();
				t[2] = tareas.get(i).getDificultad();
				t[3] = tareas.get(i).getTareas();
				t[4] = tareas.get(i).getTipo();
				t[5] = tareas.get(i).getMateria();
				t[6] = tareas.get(i).getFecha();
				t[7] = tareas.get(i).getHora();
				array.add(t);
			}
		}
		return array;
	}
	/**
	 * metodo que obtiene las tareas por tipo para una fecha
	 */
	public ArrayList<String[]> cTareasPorTipo(String fecha, String tipo){
		ArrayList<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getTipo() == tipo && tareas.get(i).getTipo() == tipo) {
				String[] t = new String[8];
				t[0] = tareas.get(i).getDescripcion();
				t[1] = tareas.get(i).getNombre();
				t[2] = tareas.get(i).getDificultad();
				t[3] = tareas.get(i).getTareas();
				t[4] = tareas.get(i).getTipo();
				t[5] = tareas.get(i).getMateria();
				t[6] = tareas.get(i).getFecha();
				t[7] = tareas.get(i).getHora();
				array.add(t);
			}
		}
		return array;
	}
	/**
	 * metodo que obtiene las tareas por dificultad para una fecha
	 */
	public ArrayList<String[]> cTareasPorDificultad(String fecha, String dificultad){
		ArrayList<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getDificultad() == dificultad && tareas.get(i).getFecha() == fecha) {
				String[] t = new String[8];
				t[0] = tareas.get(i).getDescripcion();
				t[1] = tareas.get(i).getNombre();
				t[2] = tareas.get(i).getDificultad();
				t[3] = tareas.get(i).getTareas();
				t[4] = tareas.get(i).getTipo();
				t[5] = tareas.get(i).getMateria();
				t[6] = tareas.get(i).getFecha();
				t[7] = tareas.get(i).getHora();
				array.add(t);
			}
		}
		return array;
	}
	
	
	public ArrayList<String> cNombreMaterias(){
		return consultarNombre("materia");
	}
	public ArrayList<String> cNombreTareasPadre(){
		return consultarNombre("tareap");
	}
	public ArrayList<String> consultarNombre(String caso){
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarTarea.class.getName());
			if(cls != null) {
				consultarTarea ct = (consultarTarea) cls.newInstance();	
				switch (caso) {
				case "tareap":
					return ct.cNombreTareasPadre();					
				
				case "materia":
					return ct.cNombreMaterias();
				default:
					return null;
				}			    		   
			}else {
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static void main(String[] args) {
		LogicaT ges = new LogicaT();
		ges.anadirTarea("nombretare1", "esta es la tarea 1", 2, "Trabajo", 18, (new Date("2016/06/25")), "", false);
	}			
	@Override
	public void anadirSubTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6,
			String arg7, boolean arg8) {
		FabricaAbstracta fabrica = null;
		Tarea tarea;
		switch (arg3) {
		case "Trabajo":
			fabrica = new FabricaTrabajo();
			break;
		case "Lectura":
			fabrica = new FabricaLectura();
			break;
		case "Investigación":
			fabrica = new FabricaInvestigacion();
		}
		tarea = fabrica.creatSubTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6,
				arg7, arg8);
		int i = 0;
		while(arg4 != tareas.get(i).getTareas()) {
			i++;
		}
		tareas.get(i).anadirHijo(tarea);				
	}
	@Override
	public void anadirTarea(String arg0, String arg1, int arg2, String arg3, int arg4, Date arg5, String arg6,
			boolean arg7) {
		FabricaAbstracta fabrica = null;
		Tarea tarea;
		switch (arg3) {
		case "Trabajo":
			fabrica = new FabricaTrabajo();
			break;
		case "Lectura":
			fabrica = new FabricaLectura();
			break;
		case "Investigacion":
			fabrica = new FabricaInvestigacion();
		}
		tarea = fabrica.crearTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6,
				arg7);		
		tareas.add(tarea);
		System.out.println("LLEGA AL COMPONENTE TAREA DESDE AGENDA");
		System.out.println(tarea.getFecha());
	}
	public void modificarTarea(String arg0, String arg1, int arg2, String arg3, String arg4, int arg5, Date arg6,
			String arg7, boolean arg8) {
		int i = 0;
		while (arg0 != tareas.get(i).getNombre()) {
			i++;
		}
		tareas.get(i).ModificarT(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	
							
	
}
