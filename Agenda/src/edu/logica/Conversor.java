package edu.logica;

import java.util.ArrayList;
import java.util.List;

public class Conversor {

	public static Franja convertirDatosAFranja(Object[] datos) {
		int id = Integer.valueOf(datos[0].toString());
		String nombreFranja = String.valueOf(datos[1]);
		int tiempoInicio = Integer.valueOf(datos[2].toString());
		int tiempoFinal = Integer.valueOf(datos[3].toString());
		Enum tipo = (Enum) datos[4];
		boolean[] dias = (boolean[]) datos[5];
		Franja franja = new Franja(id, nombreFranja, tiempoInicio, tiempoFinal, tipo, dias);
		return franja;
	}

	public static List<SubFranja> convertirFranjaEnSubFranja(FranjaA franja) {
		List<SubFranja> subFranjas = new ArrayList<SubFranja>();
		for (int hora : franja.getHoras()) {
			SubFranja subFranja = new SubFranja(franja);
			subFranja.setHora(hora);
			subFranja.setTiempoInicio(hora);
			subFranja.setTiempoFinal(hora + 1);
			subFranjas.add(subFranja);
		}
		return subFranjas;
	}

	public static String[] convertirSubFranjaEnString(SubFranja subFranja) {
		String[] datosStr = new String[3];
		datosStr[0] = String.valueOf(subFranja.getId());
		datosStr[1] = subFranja.getNombreFranja();
		if (subFranja.getTipoFranja() != null) {
			datosStr[2] = subFranja.getTipoFranja().name();
		} else {
			datosStr[2] = GestorFranjas.NO_ASIGNADA;
		}
		return datosStr;
	}

	public static List<Tarea> convertirSubTareasTarea(Tarea tarea) {
		List<Tarea> subTareas = new ArrayList<Tarea>();
		for (int hora = 0; hora < tarea.getDificultadT(); hora++) {
			Tarea tarea2 = new Tarea(tarea.getNombreT(), 1, tarea.getId());
			subTareas.add(tarea2);
		}
		return subTareas;
	}
}
