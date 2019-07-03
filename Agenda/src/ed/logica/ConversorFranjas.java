package ed.logica;

import java.util.ArrayList;
import java.util.List;

public class ConversorFranjas {

	public Franja convertirDatosAFranja(Object[] datos) {
		int id = Integer.valueOf(datos[0].toString());
		String nombreFranja = String.valueOf(datos[1]);
		int tiempoInicio = Integer.valueOf(datos[2].toString());
		int tiempoFinal = Integer.valueOf(datos[3].toString());
		Enum tipo = (Enum) datos[4];
		boolean[] dias = (boolean[]) datos[5];
		Franja franja = new Franja(id, nombreFranja, tiempoInicio, tiempoFinal, tipo, dias);
		return franja;
	}

	public List<SubFranja> convertirFranjaEnSubFranja(FranjaA franja) {
		List<SubFranja> subFranjas = new ArrayList<SubFranja>();
		for (int hora : franja.getHoras()) {
			SubFranja subFranja = new SubFranja(franja);
			subFranja.setHora(hora);
			subFranja.setTiempoInicio(hora);
			subFranja.setTiempoFinal(hora++);
			subFranjas.add(subFranja);
		}
		return subFranjas;
	}
}
