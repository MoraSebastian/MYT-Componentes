package edu.logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import edu.logica.DiaEnum;
import edu.cableado.consultarHorario;
import edu.cableado.consultarTarea;
import edu.cableado.horarioEstudiante;
import edu.utilidades.Cargador;

public class LogicaH implements horarioEstudiante {

	private Horario horarioDia = null;

	@Override
	public void H() {
		Crud();
		JOptionPane.showMessageDialog(null, "Horario");
	}

	private void inicializarDiasSemana() {
		if (horarioDia == null) {
			for (DiaEnum dia : DiaEnum.values()) {
				horarioDia = new Dia();
				horarioDia.setNombreDia(dia.name());
				horarioDia.setNumeroDia(dia.getNumeroDia());
				horarioDia.agruparHorario();
			}
		} else {
			// -- Ya se creó el listado de días.
		}
	}

	public void añadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal)
			throws Exception {
		inicializarDiasSemana();
		for (int i = 0; i < dias.length; i++) {
			if (dias[i]) {
				Franja franja;
				System.out.println(horarioDia.obtenerDiaPorNumero(i).getNombreDia());
				Dia diaSemana = (Dia) horarioDia.obtenerDiaPorNumero(i); 
				franja = diaSemana.getLocalizadorFranja();
				franja.setTiempoInicio(horaInicio);
				franja.setTiempoFinal(horaFinal);
				List<Integer> listaHoras = new ArrayList<>();
				for (int j = franja.getTiempoInicio(); j < franja.getTiempoFinal(); j++) {
					listaHoras.add(j);
				}
				franja.setHoras(listaHoras);
				franja.setNombreFranja(nombreF);
				franja.setTipoFranja(TipoFranjaEnum.valueOf(tipoF));
				franja.agruparFranjaDia();
				diaSemana.setLocalizadorFranja(franja);
				Franja.setLocalizador(null);
				// --
			} else {
				// -- En ese día no va la franja
			}
			System.out.println();
		}
	}

	public void Crud() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
			if (cls != null) {
				consultarHorario ch = (consultarHorario) cls.newInstance();
				ch.consultaH();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Horario getHorarioDia() {
		return horarioDia;
	}

}
