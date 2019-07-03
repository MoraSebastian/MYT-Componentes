package ed.logica;

import java.util.ArrayList;

public class SubFranja extends Franja {
	int hora;

	public SubFranja(int id, String nombreFranja, int tiempoInicio, int tiempoFinal, Enum tipoFranja, boolean[] dias) {
		super(id, nombreFranja, tiempoInicio, tiempoFinal, tipoFranja, dias);
	}

	SubFranja(FranjaA franja) {
		this.id = franja.id;
		this.dias = franja.dias;
		this.horas = new ArrayList<Integer>();
		horas.add(franja.tiempoInicio);
		this.nombreFranja = franja.nombreFranja;
		this.tipoFranja = franja.tipoFranja;
	}

	public SubFranja() {

	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

}
