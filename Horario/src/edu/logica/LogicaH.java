package edu.logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.cableado.consultarHorario;
import edu.cableado.HorarioEstudiante;
import edu.utilidades.Cargador;

public class LogicaH implements HorarioEstudiante {

	private Horario horarioDia = null;

	@Override
	public void H() {
		Crud();
		JOptionPane.showMessageDialog(null, "Horario");
	}

	public void agregarFranjaCrud(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal)
			throws Exception {
		String datos[] = { "", "" + horaInicio, "" + horaFinal, tipoF, nombreF };
		Crud(datos, "bloque", dias);
	}

	// REGISTRO DE FRANJA UNICAMENTE, SU RELACION CON LOS DIAS VA EN OTRO LADO
	public void Crud(String[] datos, String tabla, boolean[] dias) {
		Crud();
		JOptionPane.showMessageDialog(null, "Horario");
	}

	/**
	 * Método para crear la agrupación de días según la estructura de DiaEnum.
	 */
	private void inicializarDiasSemana() {
		if (horarioDia == null) {
			for (DiaEnum dia : DiaEnum.values()) {
				horarioDia = new Dia();
				horarioDia.setNombreDia(dia.name());
				horarioDia.setNumeroDia(dia.getNumeroDia());
				horarioDia.agruparHorario();
			}
		} else {
			// -- Ya se creo el listado de dias.
		}
	}

	/**
	 * Método para realizar la validación y agregación de franjas según los días en
	 * los que se vaya a crear. Teniendo en cuenta que no se puede permitir el cruce
	 * de horas.
	 * @param nombreF: nombre de la franja
	 * @param dias: arreglo de booleanos, en donde se expresa en que días estará habilitada la franja.
	 * @param tipoF: tipo de franja.
	 * @param horarioInicio
	 * @param horarioFinal
	 * @throws Exception
	 */
	/*
	 * @see edu.cableado.HorarioEstudiante#agregarFranja(java.lang.String,
	 * boolean[], java.lang.String, int, int)
	 */
	@Override
	public void agregarFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal)
			throws Exception {
		inicializarDiasSemana();
		for (int i = 0; i < dias.length; i++) {
			if (dias[i]) {
				Franja franja;
				System.out.println(horarioDia.obtenerDiaPorNumero(i).getNombreDia());
				Dia diaSemana = (Dia) horarioDia.obtenerDiaPorNumero(i);
				franja = new Franja();
				Franja.setLocalizador(diaSemana.getLocalizadorFranja());
				franja.setTiempoInicio(horaInicio);
				franja.setTiempoFinal(horaFinal);
				List<Integer> listaHoras = new ArrayList<>();
				for (int j = franja.getTiempoInicio(); j < franja.getTiempoFinal(); j++) {
					listaHoras.add(j);
				}
				franja.setHoras(listaHoras);
				franja.setNombreFranja(nombreF);
				franja.setDias(dias);
				franja.setTipoFranja(TipoFranjaEnum.valueOf(tipoF));
				try {
					franja.agruparFranjaDia();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "No se pudo agregar la franja",
							JOptionPane.INFORMATION_MESSAGE);
					throw e;
				}
				diaSemana.setLocalizadorFranja(franja);
				Franja.setLocalizador(null);
				// --
			} else {
				// -- En ese dia no va la franja
			}
		}
	}

	// public void Crud(String[] datos, String tabla, boolean[] dias) {
	// Cargador cc = new Cargador("componentes",
	// ClassLoader.getSystemClassLoader());
	// ArrayList<String> array;
	// try {
	// Class cls =
	// cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
	// if (cls != null) {
	// consultarHorario ch = (consultarHorario) cls.newInstance();
	// //ENCONTRAR EL ID, YA QUE NO LO HACE POR DEFECTO
	// array = ch.consultas("maxid", tabla);
	// if(array.get(0)==null) {
	// datos[0] = "1";
	// }else {
	// datos[0] = array.get(0);
	// }
	// ch.RegistrarH(datos, tabla, dias);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	public void Crud() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			@SuppressWarnings("rawtypes")
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
			if (cls != null) {
				consultarHorario ch = (consultarHorario) cls.newInstance();
				ch.consultaH();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarFranja(String arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enum[] obtenerTiposDeFranjas() {
		return TipoFranjaEnum.values();
	}

	public Horario getHorarioDia() {
		return horarioDia;
	}

}
