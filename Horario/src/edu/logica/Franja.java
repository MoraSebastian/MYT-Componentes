package edu.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.utilidades.Clonable;

public class Franja{
	protected static Franja localizador;
	private static final int HORAS_POR_DIA = 24;
	protected List<Franja> franjasDia = new ArrayList<>();
	private String nombreFranja;
	private String id;
	private TipoFranjaEnum tipoFranja;
	private int tiempoInicio;
	private int tiempoFinal;
	private boolean ocupada;
	private List<Integer> horas;
	private boolean[] dias;

	/**
	 * Esta línea sirve para convertir un String, proveniente de base de datos en el
	 * tipo de franja (enum): --> Enum.valueOf(TipoFranjaEnum.class, "nombre del
	 * enum guardado en base de datos");
	 */

	public Franja() {
		dias = new boolean[7];
	}

	private void crearLocalizadorPrimerVez() {
		if (localizador == null) {
			localizador = this;
		}
	}

	private void usarFranjasDelLocalizador() {
		if (franjasDia.isEmpty()) {
			franjasDia = localizador.franjasDia;
		}
	}

	public void agruparFranjaDia() throws Exception {
		crearLocalizadorPrimerVez();
		usarFranjasDelLocalizador();
		if (!comprobarCamposHoras()) {
			throw new Exception("Mensaje de excepción: no hay campo en esa franja horaria (Nombre:" + this.nombreFranja + ")");
		}
		franjasDia.add(this);
	}

	public boolean comprobarCamposHoras() {
		for (Franja franjaDia : franjasDia) {
			try {
				List<Integer> horasAingresarCopia = (List<Integer>) Clonable.clonarConProfundidad(horas);
				List<Integer> horasIngresadasCopia = (List<Integer>) Clonable.clonarConProfundidad(franjaDia.horas);
				horasAingresarCopia.removeAll(horasIngresadasCopia);
				if(horasAingresarCopia.size() != horas.size()) {
					return false;
				}
			} catch (ClassNotFoundException | IOException e) {
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public void desagruparFranjaDia() {
		franjasDia.remove(this);
		franjasDia = new ArrayList<>();
	}

	public void mostrarNombresFranjas() {
		for (Franja franjaDia : franjasDia) {
			System.out.println(franjaDia.getNombreFranja());
		}
	}

	public List<Franja> getFranjasDia() {
		return franjasDia;
	}

	public void setFranjasDia(List<Franja> franjasDia) {
		this.franjasDia = franjasDia;
	}

	public void setNombreFranja(String nombreFranja) {
		this.nombreFranja = nombreFranja;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTipoFranja(TipoFranjaEnum tipoFranja) {
		this.tipoFranja = tipoFranja;
	}

	public void setTiempoInicio(int tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public void setTiempoFinal(int tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public void setHoras(List<Integer> horas) {
		this.horas = horas;
	}

	public void setDias(boolean[] dias) {
		this.dias = dias;
	}

	public Franja getLocalizador() {
		return localizador;
	}

	public static void setLocalizador(Franja localizador) {
		Franja.localizador = localizador;
	}

	public String getNombreFranja() {
		return nombreFranja;
	}

	public String getId() {
		return id;
	}

	public TipoFranjaEnum getTipoFranja() {
		return tipoFranja;
	}

	public int getTiempoInicio() {
		return tiempoInicio;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public List<Integer> getHoras() {
		return horas;
	}

	public boolean[] getDias() {
		return dias;
	}

}
