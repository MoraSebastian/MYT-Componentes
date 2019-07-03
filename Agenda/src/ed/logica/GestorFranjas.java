package ed.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.core.LogicaA;

public class GestorFranjas {
	private static final ConversorFranjas conversorFranjas = new ConversorFranjas();
	private static final int CANTIDAD_HORAS = 24;
	public static final String NO_ASIGNADA = "NO ASIGNADA";
	private static Map<Integer, SubFranja> mapaFranjas = new TreeMap<Integer, SubFranja>();

	public List<String[]> gestionarFranjas(List<Object[]> franjas) {
		mapaFranjas = new TreeMap<Integer, SubFranja>();
		List<String[]> franjasString = new ArrayList<String[]>();
		List<SubFranja> subFranjasTotales = new ArrayList<SubFranja>();
		for (Object[] datos : franjas) {
			FranjaA franja = conversorFranjas.convertirDatosAFranja(datos);
			List<SubFranja> subfranjas = conversorFranjas.convertirFranjaEnSubFranja(franja);
			subFranjasTotales.addAll(subfranjas);
		}
		for (SubFranja sf : subFranjasTotales) {
			mapaFranjas.put(sf.getHora(), sf);
		}
		llenarEspaciosVacios();
		List<SubFranja> sft = new ArrayList<>(mapaFranjas.values());
		for (SubFranja sub : sft) {
			franjasString.add(conversorFranjas.convertirSubFranjaEnString(sub));
		}
		return franjasString;
	}

	public void llenarEspaciosVacios() {
		for (int i = 0; i < CANTIDAD_HORAS; i++) {
			if (!mapaFranjas.containsKey(i)) {
				SubFranja subFranja = new SubFranja();
				subFranja.setHora(i);
				subFranja.setId(0);
				subFranja.setNombreFranja(NO_ASIGNADA);
				subFranja.setTipoFranja(null);
				mapaFranjas.put(i, subFranja);
			}
		}
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
