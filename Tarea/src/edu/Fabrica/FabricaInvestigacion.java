package edu.Fabrica;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.logica.Tarea;
import edu.logica.TareaInvestigacion;

public class FabricaInvestigacion implements FabricaAbstracta {

	@Override
	public Tarea crearTarea(String nombreT, String descripcionT, int dificultadT, String tipoT, int horaFinalizacionT,
			Date fechaFinT, String materia, boolean esSubtarea) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fechaFinT);
		
		Tarea tarea = new TareaInvestigacion();
		tarea.setDescripcion(descripcionT);
		System.out.println(tarea.getDescripcion());		
		tarea.setDificultad(Integer.toString(dificultadT));
		System.out.println(tarea.getDificultad());
		tarea.setFecha(fechaComoCadena);
		System.out.println(tarea.getFecha());
		tarea.setHora(Integer.toString(horaFinalizacionT));
		System.out.println(tarea.getHora());
		tarea.setMateria(materia);
		System.out.println(tarea.getMateria());
		tarea.setNombre(nombreT);
		System.out.println(tarea.getNombre());
		tarea.setTareas("null");
		System.out.println(tarea.getTareas());
		tarea.setTipo(tipoT);
		System.out.println(tarea.getTipo());
		return tarea;
								
	}

	@Override
	public Tarea creatSubTarea(String nombreT, String descripcionT, int dificultadT, String tipoT,
			String idTareaPertenencia, int horaFinalizacionT, Date fechaFinT, String materia, boolean esSubtarea) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(fechaFinT);
		
		Tarea tarea = new TareaInvestigacion();
		tarea.setDescripcion(descripcionT);
		tarea.setDificultad(Integer.toString(dificultadT));
		tarea.setFecha(fechaComoCadena);
		tarea.setHora(Integer.toString(horaFinalizacionT));
		tarea.setMateria(materia);
		tarea.setNombre(nombreT);
		tarea.setTareas(idTareaPertenencia);
		tarea.setTipo(tipoT);
		return tarea;
	}
}
