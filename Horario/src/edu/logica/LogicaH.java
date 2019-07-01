package edu.logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.cableado.consultarHorario;
import edu.cableado.consultarTarea;
import edu.cableado.horarioEstudiante;
import edu.utilidades.Cargador;

public class LogicaH implements horarioEstudiante {

	@Override
	public void H() {
		//Crud();	
		JOptionPane.showMessageDialog(null, "Horario");				
	}
	
	
	public void añadirFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception{
		String datos[] = {"", ""+horaInicio, ""+horaFinal, tipoF, nombreF};	
		Crud(datos, "bloque", dias);		
	}
	//REGISTRO DE FRANJA UNICAMENTE, SU RELACION CON LOS DIAS VA EN OTRO LADO
	public void Crud(String[] datos, String tabla, boolean[] dias) {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		ArrayList<String> array;
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
			if(cls != null) {
				consultarHorario ch = (consultarHorario) cls.newInstance();
				//ENCONTRAR EL ID, YA QUE NO LO HACE POR DEFECTO
				array = ch.consultas("maxid", tabla);
				if(array.get(0)==null) {
					datos[0] = "1";
				}else {
					datos[0] = array.get(0);
				}
				ch.RegistrarH(datos, tabla, dias);											
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void eliminarFranja(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Enum[] obtenerTiposDeFranjas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
