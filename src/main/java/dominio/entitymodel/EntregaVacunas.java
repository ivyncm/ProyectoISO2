package dominio.entitymodel;

import java.time.LocalDate;

import persistencia.*;

public class EntregaVacunas {
	String region;
	String grupoprioridad;
	String lote;
	EntregaDAO entregaDao;
	private LocalDate fecha;
	private int cantidad;
	
	public EntregaVacunas(String grupoprioridad, String lote, LocalDate fecha, int cantidad,String region) throws Exception {
		setGrupoPrioridad(grupoprioridad);
		setLote(lote);
		setFecha(fecha);
		setCantidad(cantidad);
		setRegion(region);
		entregaDao = new EntregaDAO();
	}
	
	@Override
	public String toString() {
		return ": region=" + region + " -- grupoprioridad=" + grupoprioridad + " -- cantidad=" + cantidad;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGrupoPrioridad() {
		return grupoprioridad;
	}
	public void setGrupoPrioridad(String grupoPrioridad) {
		this.grupoprioridad = grupoPrioridad;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public EntregaDAO getEntregaDao() {
		return entregaDao;
	}
	public void setEntregaDao(EntregaDAO entregaDao) {
		this.entregaDao = entregaDao;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}