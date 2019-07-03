package ed.logica;

import java.util.ArrayList;
import java.util.List;

public abstract class FranjaA {

	protected String nombreFranja;
	protected int id;
	protected Enum tipoFranja;
	protected int tiempoInicio;
	protected int tiempoFinal;
	protected List<Integer> horas;
	protected boolean[] dias;

	public FranjaA() {

	}

	public FranjaA(int id, String nombreFranja, int tiempoInicio, int tiempoFinal, Enum tipoFranja, boolean[] dias) {
		this.nombreFranja = nombreFranja;
		this.id = id;
		this.tipoFranja = tipoFranja;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFinal = tiempoFinal;
		this.dias = dias;
		List<Integer> listaHoras = new ArrayList<>();
		for (int j = this.getTiempoInicio(); j < this.getTiempoFinal(); j++) {
			listaHoras.add(j);
		}
		this.setHoras(listaHoras);
	}

	public String getNombreFranja() {
		return nombreFranja;
	}

	public void setNombreFranja(String nombreFranja) {
		this.nombreFranja = nombreFranja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enum getTipoFranja() {
		return tipoFranja;
	}

	public void setTipoFranja(Enum tipoFranja) {
		this.tipoFranja = tipoFranja;
	}

	public int getTiempoInicio() {
		return tiempoInicio;
	}

	public void setTiempoInicio(int tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}

	public void setTiempoFinal(int tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}

	public List<Integer> getHoras() {
		return horas;
	}

	public void setHoras(List<Integer> horas) {
		this.horas = horas;
	}

	public boolean[] getDias() {
		return dias;
	}

	public void setDias(boolean[] dias) {
		this.dias = dias;
	}

}
