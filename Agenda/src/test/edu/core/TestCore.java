package test.edu.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.core.LogicaA;

class TestCore {

	@Test
	void test() {
		LogicaA logicaAgenda = new LogicaA();
		Enum[] tiposFrnaja = logicaAgenda.obtenerTiposDeFranjas();
		System.out.println(tiposFrnaja);
		// --Inicialización
				boolean[] dias = new boolean[7];
				String tipoFranja = tiposFrnaja[0].name();
				int horaInicial = 0, horaFinal = 0;
				String nombreFranja = "";
				// --Creación de franjas
				dias[0] = true;
				dias[1] = true;
				dias[2] = true;
				dias[3] = true;
				dias[4] = true;
				dias[5] = true;
				dias[6] = true;
				tipoFranja = tiposFrnaja[0].name();
				horaInicial = 0;
				horaFinal = 4;
				nombreFranja = "Franja Descanso";
				try {
					logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
