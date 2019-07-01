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
	protected Franja localizadorFranja = null;

	private void crearPrimerLocalizador() {
		if (localizador == null) {
			localizador = this;
		}
	}

	private void usarHorariosDelLocalizador() {
		if (horarios.isEmpty()) {
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

	/**
	 * Método para obtener un objeto tipo Horario (día) según el número del día, correspondiente a la estructura DiaEnum.
	 * @param numeroDia
	 * @return
	 */
	public Horario obtenerDiaPorNumero(int numeroDia) {
		for (Horario dia : horarios) {
			if (dia.getNumeroDia() == numeroDia) {
				return dia;
			}
		}
		return null;
	}

	/**
	 * Método para mostrar el nombre de los días agrupados.
	 */
	public void mostrarDias() {
		for (Horario dia : horarios) {
			System.out.println(dia.nombreDia);
		}
	}

	protected abstract void mostrarFranjas();

	/**
	 * Método para mostrar las franjas correspondientes a todos los días agrupados del horario.
	 */
	public void mostrarFranjasDeDias() {
		for (Horario dia : horarios) {
			dia.mostrarFranjas();
		}
	}

	/**
	 * Método para mostrar las franjas de un día en específico de la agrupación de Horario.
	 * @param dia
	 */
	public void mostrarFranjaDeDia(Dia dia) {
		for (Horario horarioDia : horarios) {
			if (horarioDia.equals(dia)) {
				horarioDia.mostrarFranjas();
			}
		}
	}

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
		if (localizadorFranja == null) {
			return new Franja();
		}
		return localizadorFranja;
	}

	public void setLocalizadorFranja(Franja localizadorFranja) {
		this.localizadorFranja = localizadorFranja;
	}
}
