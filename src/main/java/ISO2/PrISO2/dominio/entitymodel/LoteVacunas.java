package ISO2.PrISO2.dominio.entitymodel;

import java.time.LocalDate;
import java.util.*;

import ISO2.PrISO2.persistencia.*;

public class LoteVacunas {
	Collection<EntregaVacunas> entregas;
	TipoVacuna tipo;
	public LoteVacunasDAO loteVacunasDao;
	private String id;
	private LocalDate fecha;
	private int cantidad;
	private String farmaceutica;
	
	public LoteVacunas(String id, LocalDate fecha, int cantidad, String farmaceutica) throws Exception {
		setId(id);
		setFecha(fecha);
		setCantidad(cantidad);
		setFarmaceutica(farmaceutica);
		tipo = new TipoVacuna(farmaceutica);
		loteVacunasDao = new LoteVacunasDAO();
	}
	
	@Override
	public String toString() {
		return "LoteVacunas [id=" + id + ", fecha=" + fecha + 
				", cantidad=" + cantidad + ", tipoVacuna=" + farmaceutica + "]";
	}

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}
	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}
	public LoteVacunasDAO getLoteVacunasDao() {
		return loteVacunasDao;
	}
	public void setLoteVacunasDao(LoteVacunasDAO loteVacunasDao) {
		this.loteVacunasDao = loteVacunasDao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getFarmaceutica() {
		return farmaceutica;
	}
	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}
}