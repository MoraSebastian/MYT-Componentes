package edu.logica;

public enum DiaEnum {
	LUNES(0), MARTES(1), MIERCOLES(2), JUEVES(3), VIERNES(4), SABADO(5), DOMINGO(6);
	private int numeroDia;
	private DiaEnum(int numeroDia) {
		this.setNumeroDia(numeroDia);
	}
	public DiaEnum getEnumPorNumeroDia(int numeroDia) {
		for(DiaEnum dia: DiaEnum.values()) {
			if(dia.getNumeroDia() == numeroDia) {
				return dia;
			}
		}
		return null;
	}
	public int getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(int numeroDia) {
		this.numeroDia = numeroDia;
	}
}
