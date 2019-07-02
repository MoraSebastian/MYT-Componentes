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
	
	public boolean Crud(String datos[]) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarTarea.class.getName());
			if(cls != null) {
				consultarTarea ct = (consultarTarea) cls.newInstance();
			    ct.RegistrarT(datos);			    
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	//PRUEBA DE CONSULTA DE NOMBRES DE TAREAS
	public static void main(String[] args) {
		LogicaT ges = new LogicaT();
		ArrayList<String> array = ges.consultarMaterias();
		if(array != null) {
			for (int i = 0; i < array.size(); i++) {
				System.out.println(array.get(i));
			}
		}else {
			System.out.println("algo paso con la consulta de nombres");
		}		
	}
	public ArrayList<String> consultarMaterias() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarTarea.class.getName());
			if(cls != null) {
				consultarTarea ct = (consultarTarea) cls.newInstance();	
				System.out.println("CARGA EL COMPONENTE DE BASE DE DATOS");
			    return ct.consultarNombreM();			    
			}else {
				JOptionPane.showMessageDialog(null, "ALGO NO SE CARGO CONSULTAR TAREA xD");
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	public ArrayList<String> consultarTareasP() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarTarea.class.getName());
			if(cls != null) {
				consultarTarea ct = (consultarTarea) cls.newInstance();			    
			    return ct.consultarNombreT();			    
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
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
		String [] datos = {"", tarea.getDescripcion(), tarea.getTareas(), tarea.getDificultad(), tarea.getTipo(),
				tarea.getFecha(), tarea.getMateria(), tarea.getNombre(), tarea.getHora()};
		Crud(datos);
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
		case "Investigación":
			fabrica = new FabricaInvestigacion();
		}
		tarea = fabrica.crearTarea(arg0, arg1, arg2, arg3, arg4, arg5, arg6,
				arg7);
		
		tareas.add(tarea);
		String [] datos = {"", tarea.getDescripcion(), tarea.getTareas(), tarea.getDificultad(), tarea.getTipo(),
				tarea.getFecha(), tarea.getMateria(), tarea.getNombre(), tarea.getHora()};
		Crud(datos);
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
