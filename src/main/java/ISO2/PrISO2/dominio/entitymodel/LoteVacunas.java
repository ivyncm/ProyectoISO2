package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;
import ISO2.PrISO2.persistencia.*;

public class LoteVacunas {

	Collection<EntregaVacunas> entregas;
	TipoVacuna tipo;
	LoteVacunasDAO loteVacunasDao;
	private int id;
	private Date fecha;
	private int cantidad;
	private String farmaceutica;
	
	public LoteVacunas(int id, String tipoVacuna, java.sql.Date fecha, int cantidad, String farmaceutica) {
		
	}
	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}
	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}
	public TipoVacuna getTipo() {
		return tipo;
	}
	public void setTipo(TipoVacuna tipo) {
		this.tipo = tipo;
	}
	public LoteVacunasDAO getLoteVacunasDao() {
		return loteVacunasDao;
	}
	public void setLoteVacunasDao(LoteVacunasDAO loteVacunasDao) {
		this.loteVacunasDao = loteVacunasDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFarmaceutica() {
		return farmaceutica;
	}
	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	
}