package edu.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.core.LogicaA;

public class GestorAsignaciones {
	private static Map<Integer, Asignacion> franjasLunes = new TreeMap<Integer, Asignacion>();
	private static Map<Integer, Asignacion> franjasMartes = new TreeMap<Integer, Asignacion>();
	private static Map<Integer, Asignacion> franjasMiercoles = new TreeMap<Integer, Asignacion>();
	private static Map<Integer, Asignacion> franjasJueves = new TreeMap<Integer, Asignacion>();
	private static Map<Integer, Asignacion> franjasViernes = new TreeMap<Integer, Asignacion>();
	private static Map<Integer, Asignacion> franjasSabado = new TreeMap<Integer, Asignacion>();
	private static Map<Integer, Asignacion> franjasDomingo = new TreeMap<Integer, Asignacion>();

	public Map<Integer, Asignacion> obtenerFranjasDeDia(int dia) {
		switch (dia) {
		case 0:
			return franjasLunes;
		case 1:
			return franjasMartes;
		case 2:
			return franjasMiercoles;
		case 3:
			return franjasJueves;
		case 4:
			return franjasViernes;
		case 5:
			return franjasSabado;
		case 6:
			return franjasDomingo;
		default:
			return null;
		}
	}

	/**
	 * Método para asignar la información de la franja.
	 * 
	 * @param dia
	 * @param hora
	 * @param datosFranja
	 */
	public void put(int dia, Integer hora, String[] datosFranja) {
		if (obtenerFranjasDeDia(dia).get(hora) != null) {
			// Ya fue asignada
		} else {
			Asignacion asignacion = new Asignacion(Integer.valueOf(datosFranja[0]), -1, datosFranja[1], datosFranja[2]);
			obtenerFranjasDeDia(dia).put(hora, asignacion);
		}
	}

	/**
	 * Método para actualizar la información respecto a la tarea asignada en la
	 * franja.
	 * 
	 * @param dia
	 * @param hora
	 * @param idMateria
	 * @param nombre
	 */
	public void put(int dia, Integer hora, int idMateria, String nombre) {
		if (obtenerFranjasDeDia(dia).get(hora) == null) {
			// No ha sido asignada
		} else {
			Asignacion asignacion = obtenerFranjasDeDia(dia).get(hora);
			asignacion.setIdMateria(idMateria);
			asignacion.setNombre(nombre);
			obtenerFranjasDeDia(dia).put(hora, asignacion);
		}
	}

	public void reiniciarFranjas() {

	}

	private boolean comprobarCapacidad(int cont) {
		LogicaA logicaA = new LogicaA();
		Enum[] tiposFranja = logicaA.obtenerTiposDeFranjas();
		for (int dia = 0; dia < 7; dia++) {
			List<Asignacion> asignaciones = new ArrayList<Asignacion>(obtenerFranjasDeDia(dia).values());
			if (asignaciones.size() == 0) {
				// no hay franjas
			} else {
				for (Asignacion asignacion : asignaciones) {
					if (asignacion.getTipofranja().equals(tiposFranja[3]) && asignacion.getIdMateria() <= 0) {
						// Es franja de tiempo libre y está libre
						cont--;
					}
					if (cont == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean asignarTarea(Tarea tarea) {
		List<Tarea> subTareas = Conversor.convertirSubTareasTarea(tarea);
		int cont2 = subTareas.size() - 1;
		int cont = subTareas.size();
		if (comprobarCapacidad(cont)) {
			LogicaA logicaA = new LogicaA();
			Enum[] tiposFranja = logicaA.obtenerTiposDeFranjas();
			for (int dia = 0; dia < 7; dia++) {
				List<Asignacion> asignaciones = new ArrayList<Asignacion>(obtenerFranjasDeDia(dia).values());
				if (asignaciones.size() == 0) {
					// no hay franjas
				} else {
					int hora = 0;
					for (Asignacion asignacion : asignaciones) {
						if (asignacion.getTipofranja().equals(tiposFranja[3]) && asignacion.getIdMateria() <= 0) {
							// Es franja de tiempo libre
							put(dia, hora, tarea.getId(), tarea.getNombreT());
							subTareas.remove(cont2);
							cont--;
						}
						if(subTareas.size()==0) {
							return true;
						}
						hora++;
					}
				}
			}
			return true;
		} else {
			// No hay capacidad
			return false;
		}
	}
}
