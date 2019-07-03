package ed.logica;

import java.util.ArrayList;
import java.util.List;

import edu.core.LogicaA;

public class GestorFranjas {
	private static final ConversorFranjas conversorFranjas = new ConversorFranjas();
	private LogicaA logicaA = new LogicaA();
	
	public List<String[]> gestionarFranjas(List<Object[]> franjas){
		List<String[]> franjasString = new ArrayList<String[]>();
		
		return franjasString;
	}
	
	public static ConversorFranjas getConversorfranjas() {
		return conversorFranjas;
	}
	
}
