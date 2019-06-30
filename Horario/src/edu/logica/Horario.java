package edu.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.utilidades.Clonable;

public abstract class Horario {

	protected static Horario localizador;
	protected List<Horario> horarios = new ArrayList<>();
	protected String nombreDia;
	protected int numeroDia;
	private Franja localizadorFranja;
	
	private void crearPrimerLocalizador() {
		if(localizador == null) {
			localizador = this;
		}
	}
	
	private void usarHorariosDelLocalizador() {
		if(horarios.isEmpty()) {
			horarios = localizador.horarios;
		}
	}

	public void agruparHorario() {
		crearPrimerLocalizador();
		usarHorariosDelLocalizador();
		horarios.add(this);
	}

	public void desagruparHorario() {
		horarios.remove(this);
		horarios = new ArrayList<>();
	}

	public void obtenerHorarioDeDia() {
		
	}
	
	public void mostrarDias() {
		for(Horario dia: horarios) {
			System.out.println(dia.nombreDia);
		}
	}

	protected abstract void ubicarFranja();

	public Horario getLocalizador() {
		return localizador;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public String getNombreDia() {
		return nombreDia;
	}
	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}
	public int getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(int numeroDia) {
		this.numeroDia = numeroDia;
	}

	public Franja getLocalizadorFranja() {
		return localizadorFranja;
	}

	public void setLocalizadorFranja(Franja localizadorFranja) {
		this.localizadorFranja = localizadorFranja;
	}
}
