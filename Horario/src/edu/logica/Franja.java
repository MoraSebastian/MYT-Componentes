package edu.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Franja extends Horario{
	protected static Franja localizador;
	private static final int HORAS_POR_DIA = 24;
	protected List<Franja> franjasDia;
	private String nombreFranja;
	private String id;
	private TipoFranjaEnum tipoFranja;
	private Date tiempoInicio;
	private Date tiempoFinal;
	private boolean idOcupado;
	private List<Integer> horas;
	private boolean[] dias;
	
	/**
	 * Esta línea sirve para convertir un String, proveniente de base de datos en el
	 * tipo de franja (enum): --> Enum.valueOf(TipoFranjaEnum.class, "nombre del
	 * enum guardado en base de datos");
	 */

	
	@Override
	protected void ubicarFranja() {
		int horas = HORAS_POR_DIA;
//		int diferencia = (int) ((horaFinal.getTime() - horaInicial.getTime())/1000)/3600;
	}
//	protected abstract void ocuparFranja(String id, Date horaInicial, Date horaFinal);
	
	private void crearLocalizadorPrimerVez() {
		if(localizador==null) {
			localizador = this;
		}
	}
	
	private void usarDiasDelLocalizador() {
		if(franjasDia.isEmpty()) {
			franjasDia = localizador.franjasDia;
		}
	}
	
	public void agruparFranjaDia() {
		crearLocalizadorPrimerVez();
		usarDiasDelLocalizador();
		franjasDia.add(this);
	}
	public void desagruparFranjaDia() {
		franjasDia.remove(this);
		franjasDia = new ArrayList<>();
	}

	public List<Franja> getFranjasDia() {
		return franjasDia;
	}

	public void setFranjasDia(List<Franja> franjasDia) {
		this.franjasDia = franjasDia;
	}
	
	
}
