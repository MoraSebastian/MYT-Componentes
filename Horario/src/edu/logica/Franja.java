package edu.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.utilidades.Clonable;

public class Franja {
	protected static Franja localizador;
	protected List<Franja> franjasDia = new ArrayList<>();
	private String nombreFranja;
	private int id;
	private TipoFranjaEnum tipoFranja;
	private int tiempoInicio;
	private int tiempoFinal;
	private List<Integer> horas;
	private static int contId = 0;
	private boolean[] dias;

	/**
	 * Esta l�nea sirve para convertir un String, proveniente de base de datos en el
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

	/**
	 * M�todo para agregar la franja al grupo de franjas, en �l se comprueba si las
	 * horas de la franja a crear no se cruzan con las franjas ya agrupadas.
	 * 
	 * @throws Exception
	 */
	public void agruparFranjaDia() throws Exception {
		crearLocalizadorPrimerVez();
		usarFranjasDelLocalizador();
		if (!comprobarCamposHoras()) {
			throw new Exception("No hay campo para la franja " + this.nombreFranja + " en las horas especificadas.");
		}
		this.setId(contId++);
		franjasDia.add(this);
	}

	/**
	 * M�todo para comprobar que el d�a tenga el espacio suficiente para la franja
	 * que va a ser agregada.
	 * 
	 * @return
	 */
	private boolean comprobarCamposHoras() {
		for (Franja franjaDia : franjasDia) {
			try {
				@SuppressWarnings("unchecked")
				List<Integer> horasAingresarCopia = (List<Integer>) Clonable.clonarConProfundidad(horas);
				@SuppressWarnings("unchecked")
				List<Integer> horasIngresadasCopia = (List<Integer>) Clonable.clonarConProfundidad(franjaDia.horas);
				horasAingresarCopia.removeAll(horasIngresadasCopia);
				if (horasAingresarCopia.size() != horas.size()) {
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
		localizador.setContId(contId--);
		franjasDia = new ArrayList<>();
	}

	/**
	 * M�todo para mostrar en consola los nombres de todas las franjas del d�a.
	 */
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

	public void setId(int id) {
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

	public int getId() {
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

	public List<Integer> getHoras() {
		return horas;
	}

	public boolean[] getDias() {
		return dias;
	}

	public static int getContId() {
		return contId;
	}

	public static void setContId(int contId) {
		Franja.contId = contId;
	}

}
