package edu.logica;



import javax.swing.JOptionPane;

import edu.cableado.consultarHorario;
import edu.cableado.consultarTarea;
import edu.cableado.HorarioEstudiante;
import edu.utilidades.Cargador;

public class LogicaH implements HorarioEstudiante {

	@Override
	public void H() {
		Crud();	
		JOptionPane.showMessageDialog(null, "Horario");				
	}
	
	
	public void agregarFranjaCrud(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal) throws Exception{
		String datos[] = {"", ""+horaInicio, ""+horaFinal, tipoF, nombreF};	
		Crud(datos, "bloque", dias);		
	}
	//REGISTRO DE FRANJA UNICAMENTE, SU RELACION CON LOS DIAS VA EN OTRO LADO
	public void Crud(String[] datos, String tabla, boolean[] dias) {
		Crud();
		JOptionPane.showMessageDialog(null, "Horario");
	}

	private void inicializarDiasSemana() {
		if (horarioDia == null) {
			for (DiaEnum dia : DiaEnum.values()) {
				horarioDia = new Dia();
				horarioDia.setNombreDia(dia.name());
				horarioDia.setNumeroDia(dia.getNumeroDia());
				horarioDia.agruparHorario();
			}
		} else {
			// -- Ya se creo el listado de dias.
		}
	}

	@Override
	public void agregarFranja(String nombreF, boolean dias[], String tipoF, int horaInicio, int horaFinal)
			throws Exception {
		inicializarDiasSemana();
		for (int i = 0; i < dias.length; i++) {
			if (dias[i]) {
				Franja franja;
				System.out.println(horarioDia.obtenerDiaPorNumero(i).getNombreDia());
				Dia diaSemana = (Dia) horarioDia.obtenerDiaPorNumero(i); 
				franja = new Franja();
				Franja.setLocalizador(diaSemana.getLocalizadorFranja());
				franja.setTiempoInicio(horaInicio);
				franja.setTiempoFinal(horaFinal);
				List<Integer> listaHoras = new ArrayList<>();
				for (int j = franja.getTiempoInicio(); j < franja.getTiempoFinal(); j++) {
					listaHoras.add(j);
				}
				franja.setHoras(listaHoras);
				franja.setNombreFranja(nombreF);
				franja.setDias(dias);
				franja.setTipoFranja(TipoFranjaEnum.valueOf(tipoF));
				franja.agruparFranjaDia();
				diaSemana.setLocalizadorFranja(franja);
				Franja.setLocalizador(null);
				// --
			} else {
				// -- En ese dia no va la franja
			}
		}	
	}

//	public void Crud(String[] datos, String tabla, boolean[] dias) {
//		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
//		ArrayList<String> array;
//		try {
//			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
//			if (cls != null) {
//				consultarHorario ch = (consultarHorario) cls.newInstance();
//				//ENCONTRAR EL ID, YA QUE NO LO HACE POR DEFECTO
//				array = ch.consultas("maxid", tabla);
//				if(array.get(0)==null) {
//					datos[0] = "1";
//				}else {
//					datos[0] = array.get(0);
//				}
//				ch.RegistrarH(datos, tabla, dias);											
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public void Crud() {
		Cargador cc = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		try {
			Class cls = cc.cargarUnaClaseDesdeSuDirectorio(consultarHorario.class.getName());
			if (cls != null) {
				consultarHorario ch = (consultarHorario) cls.newInstance();
				ch.consultaH();
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
	

	public Horario getHorarioDia() {
		return horarioDia;
	}


}
