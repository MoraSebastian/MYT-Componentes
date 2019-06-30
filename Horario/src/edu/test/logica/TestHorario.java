package edu.test.logica;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import edu.logica.Franja;
import edu.logica.Horario;

public class TestHorario {

	@Test
	@Ignore
	public void testHoras() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd H");
		try {
			Date horaInicial = formato.parse("2019-06-29 12");
			Date horaFinal = formato.parse("2019-06-29 17");
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
		System.out.println("acá vamos");
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
	}
}
