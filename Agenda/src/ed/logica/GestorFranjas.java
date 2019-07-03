package ed.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.core.LogicaA;

public class GestorFranjas {
	private static final ConversorFranjas conversorFranjas = new ConversorFranjas();
	private static final int CANTIDAD_HORAS = 24;
	private static final String NO_ASIGNADA = "NO ASIGNADA";

	public List<String[]> gestionarFranjas(List<Object[]> franjas) {
		List<String[]> franjasString = new ArrayList<String[]>();
		List<SubFranja> subFranjasTotales = new ArrayList<SubFranja>();
		for (Object[] datos : franjas) {
			FranjaA franja = conversorFranjas.convertirDatosAFranja(datos);
			List<SubFranja> subfranjas = conversorFranjas.convertirFranjaEnSubFranja(franja);
			subFranjasTotales.addAll(subfranjas);
		}
		ordenarListadoFranjas(subFranjasTotales);
		for(SubFranja sub: subFranjasTotales) {
			franjasString.add(conversorFranjas.convertirSubFranjaEnString(sub));
		}
		return franjasString;
	}

	public void ordenarListadoFranjas(List<SubFranja> franjas) {
		Collections.sort(franjas, new Comparator<SubFranja>() {

			@Override
			public int compare(SubFranja s1, SubFranja s2) {
				return Integer.compare(s1.getHora(), s2.getHora());
			}

		});
	}

	public static ConversorFranjas getConversorfranjas() {
		return conversorFranjas;
	}

}
