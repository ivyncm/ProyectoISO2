package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;

import ISO2.PrISO2.persistencia.*;

public class EntregaVacunas {
	private int id;
	String tipo;
	String region;
	String grupoPrioridad;
	String lote;
	EntregaDAO entregaDao;
	private Date fecha;
	private int cantidad;
	
	
	public EntregaVacunas(int id, String tipoVacuna, String region, String grupoPrior, String lote, java.sql.Date fecha, int cantidad) {
		setId(id);
		setTipo(tipo);
		setRegion(region);
		setGrupoPrioridad(grupoPrior);
		setLote(lote);
		setFecha(fecha);
		setCantidad(cantidad);
		
	}
	public EntregaVacunas(int id) {
		setId(id);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGrupoPrioridad() {
		return grupoPrioridad;
	}
	public void setGrupoPrioridad(String grupoPrioridad) {
		this.grupoPrioridad = grupoPrioridad;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}