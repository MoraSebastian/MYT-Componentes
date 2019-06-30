package edu.logica;

import javax.swing.JOptionPane;

import edu.cableado.consultarHorario;
import edu.cableado.consultarTarea;
import edu.cableado.horarioEstudiante;
import edu.utilidades.Cargador;

public class LogicaH implements horarioEstudiante {

	@Override
	public void H() {
		Crud();	
		JOptionPane.showMessageDialog(null, "Horario");				
	}
	
	
	public void añadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception{
		for(int i = 0; i < dias.length;i++) {
			if(dias[i]) {
				
			}else {
				//-- En ese día no va la franja
			}
		}
	}
	public void Crud() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
			if(cls != null) {
				consultarHorario ch = (consultarHorario) cls.newInstance();
				ch.consultaH();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
