package edu.test.logica;

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

import edu.logica.Franja;
import edu.logica.Horario;
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
			int diferencia = (int) ((horaFinal.getTime() - horaInicial.getTime())/1000)/3600;
			System.out.println(diferencia);
			int d = horaFinal.compareTo(horaInicial);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testFranjasDeHorario() {
		System.out.println("-----------Test franja y horario-------");
		Horario lunes  = new Franja();
		lunes.setNombreDia("Lunes");
		lunes.setNumeroDia(1);
		Horario martes  = new Franja();
		martes.setNombreDia("Martes");
		martes.setNumeroDia(2);
		Horario miercoles  = new Franja();
		miercoles.setNombreDia("Miércoles");
		miercoles.setNumeroDia(3);
		Horario jueves  = new Franja();
		jueves.setNombreDia("Jueves");
		jueves.setNumeroDia(4);
		Horario viernes  = new Franja();
		viernes.setNombreDia("Viernes");
		viernes.setNumeroDia(5);
		Horario sabado  = new Franja();
		sabado.setNombreDia("Sábado");
		sabado.setNumeroDia(6);
		Horario domingo  = new Franja();
		domingo.setNombreDia("Domingo");
		domingo.setNumeroDia(7);
		lunes.agruparHorario();
		martes.agruparHorario();
		miercoles.agruparHorario();
		jueves.agruparHorario();
		viernes.agruparHorario();
		sabado.agruparHorario();
		domingo.agruparHorario();
		List<Horario> dias =  lunes.getHorarios();
		lunes.mostrarDias();
		for(Horario dia: dias) {
			System.out.println(dia.getNombreDia() + " - " + dia.getNumeroDia());
		}
		System.out.println(dias);
		//--Para las franjas
		Franja franja;
		try {
			
			franja = new Franja();
			franja.setTiempoInicio(12);
			franja.setTiempoFinal(17);
			franja.setNombreFranja("franja 1");
			franja.setTipoFranja(TipoFranjaEnum.MATERIA);
			franja.agruparFranjaDia();
			//--
			franja = new Franja();
			franja.setTiempoInicio(0);
			franja.setTiempoFinal(4);
			franja.setNombreFranja("franja 2");
			franja.setTipoFranja(TipoFranjaEnum.DESCANSO);
			franja.agruparFranjaDia();
			//--
			franja = new Franja();
			franja.setTiempoInicio(6);
			franja.setTiempoFinal(8);
			franja.setNombreFranja("franja 3");
			franja.setTipoFranja(TipoFranjaEnum.TRANSPORTE);
			franja.agruparFranjaDia();
			//--
			franja = new Franja();
			franja.setTiempoInicio(10);
			franja.setTiempoFinal(12);
			franja.setNombreFranja("franja 4");
			franja.setTipoFranja(TipoFranjaEnum.TIEMPO_LIBRE);
			franja.agruparFranjaDia();
//			franja.mostrarNombresFranjas();
			//--Conexión de franjas con los días.
			lunes.setLocalizadorFranja(franja.getLocalizador());
			lunes.getLocalizadorFranja().mostrarNombresFranjas();
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
		if(tamañoLista != lista2.size()) {
			System.out.println("SIRVE");
		}
		//-------
		Map<Integer, Boolean> mapa = new HashMap<>();
		System.out.println(mapa.put(1, true));
		System.out.println(mapa.put(1, false));
		mapa.remove(1);
		System.out.println(mapa.put(1, true));
	}
}
