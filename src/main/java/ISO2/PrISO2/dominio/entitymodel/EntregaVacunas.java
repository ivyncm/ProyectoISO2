package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;

import ISO2.PrISO2.persistencia.*;

public class EntregaVacunas {
	private int id;
	TipoVacuna tipo;
	RegionEnum region;
	GrupoPrioridad grupoprioridad;
	LoteVacunas lote;
	EntregaDAO entregaDao;
	private Date fecha;
	private int cantidad;
	
	
	public EntregaVacunas(int id, TipoVacuna tipo, RegionEnum region, GrupoPrioridad grupoprioridad, LoteVacunas lote, java.sql.Date fecha, int cantidad) {
		setId(id);
		setTipo(tipo);
		setRegion(region);
		setGrupoPrioridad(grupoprioridad);
		setLote(lote);
		setFecha(fecha);
		setCantidad(cantidad);
		
	}
	public EntregaVacunas(int id) {
		setId(id);
	}
	public TipoVacuna getTipo() {
		return tipo;
	}
	public void setTipo(TipoVacuna tipo) {
		this.tipo = tipo;
	}
	public RegionEnum getRegion() {
		return region;
	}
	public void setRegion(RegionEnum region) {
		this.region = region;
	}
	public GrupoPrioridad getGrupoPrioridad() {
		return grupoPrioridad;
	}
	public void setGrupoPrioridad(GrupoPrioridad grupoPrioridad) {
		this.grupoPrioridad = grupoPrioridad;
	}
	public LoteVacunas getLote() {
		return lote;
	}
	public void setLote(LoteVacunas lote) {
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