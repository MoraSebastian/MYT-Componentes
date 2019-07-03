package test.edu.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.cableado.HorarioEstudiante;
import edu.core.LogicaA;

class TestGestorFranjas {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		LogicaA logicaAgenda = new LogicaA();
		Enum[] tiposFranja = logicaAgenda.obtenerTiposDeFranjas();
		System.out.println(tiposFranja);
		// --Inicialización
		boolean[] dias = new boolean[7];
		String tipoFranja = tiposFranja[0].name();
		int horaInicial = 0, horaFinal = 0;
		String nombreFranja = "";
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = false;
		dias[6] = false;
		tipoFranja = tiposFranja[3].name();
		horaInicial = 18;
		horaFinal = 20;
		nombreFranja = "Franja Libre";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = true;
		dias[6] = true;
		tipoFranja = tiposFranja[1].name();
		horaInicial = 0;
		horaFinal = 4;
		nombreFranja = "Franja Descanso Madrugada";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = true;
		dias[6] = true;
		tipoFranja = tiposFranja[1].name();
		horaInicial = 20;
		horaFinal = 24;
		nombreFranja = "Franja Descanso Noche";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = false;
		dias[6] = false;
		tipoFranja = tiposFranja[2].name();
		horaInicial = 4;
		horaFinal = 6;
		nombreFranja = "Franja Transporte";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = false;
		dias[6] = false;
		tipoFranja = tiposFranja[0].name();
		horaInicial = 6;
		horaFinal = 14;
		nombreFranja = "Franja Materia";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		// --Creación de franjas
		dias[0] = true;
		dias[1] = true;
		dias[2] = true;
		dias[3] = true;
		dias[4] = true;
		dias[5] = false;
		dias[6] = false;
		tipoFranja = tiposFranja[2].name();
		horaInicial = 14;
		horaFinal = 16;
		nombreFranja = "Franja Transporte Tarde";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		// --Creación de franjas
		dias[0] = false;
		dias[1] = false;
		dias[2] = false;
		dias[3] = false;
		dias[4] = false;
		dias[5] = true;
		dias[6] = true;
		tipoFranja = tiposFranja[3].name();
		horaInicial = 4;
		horaFinal = 20;
		nombreFranja = "Franja Fin de semana";
		try {
			logicaAgenda.anadirFranja(nombreFranja, dias, tipoFranja, horaInicial, horaFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// --
		List<String> listadoDia = logicaAgenda.obtenerFranjasPorDia(0);
		List<Object[]> listadoFranjas = logicaAgenda.getHorarioEstudiante().obtenerFranjas();
		System.out.println(listadoDia);
	}

}
