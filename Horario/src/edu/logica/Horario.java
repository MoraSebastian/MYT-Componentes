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
	

//	public Boolean comprobarCapacidad(Franja[] franjas, Franja franjaNueva) {
//		if (franjas.length > 0) {
//			int horasFranjas = 0;
//			for (int i = 0; i < franjas.length; i++) {
//				horasFranjas += franjas[i].getHoras();
//			}
//			if (horasFranjas == HORAS_POR_DIA) {
//				// Ese día no tiene capacidad.
//				return null;
//			}
//			if (horasFranjas + franjaNueva.getHoras() > HORAS_POR_DIA) {
//				// No se puede agregar la franja entera en un día, se mira capacidad del próximo
//				// día.
//				int horasProximoDia = (horasFranjas + franjaNueva.getHoras()) - HORAS_POR_DIA;
//				Franja franjaPrimerDia;
//				try {
//					franjaPrimerDia = (Franja) Clonable.clonarConProfundidad(franjaNueva);
//					franjaPrimerDia.setHoras(franjaNueva.getHoras()-horasProximoDia);
//					Franja franjaSegundoDia = (Franja) Clonable.clonarConProfundidad(franjaNueva);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return null;
//	}

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
