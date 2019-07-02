package test.edu.logica;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import edu.logica.Dia;
import edu.logica.Franja;
import edu.logica.Horario;
import edu.logica.LogicaH;
import edu.logica.TipoFranjaEnum;

public class TestHorario {

	@Test
	@Ignore
	public void testHoras() {
		System.out.println("-----------Test horas------------");
		SimpleDateFormat formato = new SimpleDateFormat("HH");
		try {
			Date horaInicial = formato.parse("12");
			System.out.println(horaInicial);
			Date horaFinal = formato.parse("17");
			int diferencia = (int) ((horaFinal.getTime() - horaInicial.getTime()) / 1000) / 3600;
			System.out.println(diferencia);
			int d = horaFinal.compareTo(horaInicial);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Ignore
	public void testFranjasDeHorario() {
		System.out.println("-----------Test franja y horario-------");
		Horario lunes = new Dia();
		lunes.setNombreDia("Lunes");
		lunes.setNumeroDia(1);
		Horario martes = new Dia();
		martes.setNombreDia("Martes");
		martes.setNumeroDia(2);
		Horario miercoles = new Dia();
		miercoles.setNombreDia("Miércoles");
		miercoles.setNumeroDia(3);
		Horario jueves = new Dia();
		jueves.setNombreDia("Jueves");
		jueves.setNumeroDia(4);
		Horario viernes = new Dia();
		viernes.setNombreDia("Viernes");
		viernes.setNumeroDia(5);
		Horario sabado = new Dia();
		sabado.setNombreDia("Sábado");
		sabado.setNumeroDia(6);
		Horario domingo = new Dia();
		domingo.setNombreDia("Domingo");
		domingo.setNumeroDia(7);
		lunes.agruparHorario();
		martes.agruparHorario();
		miercoles.agruparHorario();
		jueves.agruparHorario();
		viernes.agruparHorario();
		sabado.agruparHorario();
		domingo.agruparHorario();
		List<Horario> dias = lunes.getHorarios();
		lunes.mostrarDias();
		for (Horario dia : dias) {
			System.out.println(dia.getNombreDia() + " - " + dia.getNumeroDia());
		}
		// --Para las franjas
		Franja franja;
		try {

			franja = new Franja();
			franja.setTiempoInicio(12);
			franja.setTiempoFinal(17);
			List<Integer> listaHoras = new ArrayList<>();
			for (int i = franja.getTiempoInicio(); i < franja.getTiempoFinal(); i++) {
				listaHoras.add(i);
			}
			franja.setHoras(listaHoras);
			franja.setNombreFranja("franja 1");
			franja.setTipoFranja(TipoFranjaEnum.MATERIA);
			franja.agruparFranjaDia();
			// --
			franja = new Franja();
			franja.setTiempoInicio(0);
			franja.setTiempoFinal(4);
			listaHoras = new ArrayList<>();
			for (int i = franja.getTiempoInicio(); i < franja.getTiempoFinal(); i++) {
				listaHoras.add(i);
			}
			franja.setHoras(listaHoras);
			franja.setNombreFranja("franja 2");
			franja.setTipoFranja(TipoFranjaEnum.DESCANSO);
			franja.agruparFranjaDia();
			// --
			franja = new Franja();
			franja.setTiempoInicio(6);
			franja.setTiempoFinal(8);
			listaHoras = new ArrayList<>();
			for (int i = franja.getTiempoInicio(); i < franja.getTiempoFinal(); i++) {
				listaHoras.add(i);
			}
			franja.setHoras(listaHoras);
			franja.setNombreFranja("franja 3");
			franja.setTipoFranja(TipoFranjaEnum.TRANSPORTE);
			franja.agruparFranjaDia();
			// --
			franja = new Franja();
			franja.setTiempoInicio(8);
			franja.setTiempoFinal(12);
			listaHoras = new ArrayList<>();
			for (int i = franja.getTiempoInicio(); i < franja.getTiempoFinal(); i++) {
				listaHoras.add(i);
			}
			franja.setHoras(listaHoras);
			franja.setNombreFranja("franja 4");
			franja.setTipoFranja(TipoFranjaEnum.TIEMPO_LIBRE);
			franja.agruparFranjaDia();
			// franja.mostrarNombresFranjas();
			// --Conexión de franjas con los días.
			lunes.setLocalizadorFranja(franja.getLocalizador());
			lunes.getLocalizadorFranja().mostrarNombresFranjas();
			franja.desagruparFranjaDia();
			franja = new Franja();
			System.out.println("limpio");
			franja.mostrarNombresFranjas();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testListas() {
		System.out.println("----------------Test de listas-------------");
		List<Integer> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista1.add(4);
		lista1.add(5);
		lista2.add(4);
		lista2.add(5);
		lista2.add(6);
		int tamañoLista = lista2.size();
		lista2.removeAll(lista1);
		System.out.println(lista2);
		if (tamañoLista != lista2.size()) {
			System.out.println("SIRVE");
		}
		// -------
		Map<Integer, Boolean> mapa = new HashMap<>();
		System.out.println(mapa.put(1, true));
		System.out.println(mapa.put(1, false));
		mapa.remove(1);
		System.out.println(mapa.put(1, true));
	}

	@Test
	@Ignore
	public void testEnum() {
		System.out.println("-------------------Test Enumn----------------------");
		Enum[] tipos = TipoFranjaEnum.values();
		for (Enum e : tipos) {
			System.out.println(e.name());
		}
	}

	@Test
	public void testLogicaH() {
		// --Inicialización
		LogicaH logicaH = new LogicaH();
		boolean[] dias = new boolean[7];
		String tipoF = TipoFranjaEnum.MATERIA.name();
		int horaInicio = 0, horaFinal = 0;
		String nombreF = "";
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = true;
		dias[6] = true;
		tipoF = TipoFranjaEnum.DESCANSO.name();
		horaInicio = 0;
		horaFinal = 4;
		nombreF = "Franja Descanso";
		try {
			logicaH.agregarFranja(nombreF, dias, tipoF, horaInicio, horaFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//--
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = false;
		dias[6] = false;
		tipoF = TipoFranjaEnum.MATERIA.name();
		horaInicio = 6;
		horaFinal = 16;
		nombreF = "Franja materias";
		try {
			logicaH.agregarFranja(nombreF, dias, tipoF, horaInicio, horaFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//--
		dias[0] = true;
		dias[1] = false;
		dias[2] = true;
		dias[3] = false;
		dias[4] = true;
		dias[5] = false;
		dias[6] = true;
		tipoF = TipoFranjaEnum.TRANSPORTE.name();
		horaInicio = 16;
		horaFinal = 20;
		nombreF = "Franja Transporte";
		try {
			logicaH.agregarFranja(nombreF, dias, tipoF, horaInicio, horaFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//--
		dias[0] = false;
		dias[1] = false;
		dias[2] = false;
		dias[3] = false;
		dias[4] = false;
		dias[5] = true;
		dias[6] = true;
		tipoF = TipoFranjaEnum.TIEMPO_LIBRE.name();
		horaInicio = 20;
		horaFinal = 24;
		nombreF = "Franja Tiempo Libre";
		try {
			logicaH.agregarFranja(nombreF, dias, tipoF, horaInicio, horaFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dias[0] = true;
		dias[1] = false;
		dias[2] = true;
		dias[3] = false;
		dias[4] = true;
		dias[5] = false;
		dias[6] = true;
		tipoF = TipoFranjaEnum.TRANSPORTE.name();
		horaInicio = 16;
		horaFinal = 20;
		nombreF = "Franja cruzada";
		try {
			logicaH.agregarFranja(nombreF, dias, tipoF, horaInicio, horaFinal);
		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println();
	}
}
