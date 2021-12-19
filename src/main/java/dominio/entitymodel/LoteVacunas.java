package dominio.entitymodel;

import java.time.LocalDate;
import java.util.Objects;

import persistencia.*;

public class LoteVacunas {
	TipoVacuna tipo;
	private LoteVacunasDAO loteVacunasDao;
	private String id;
	private LocalDate fecha;
	private int cantidad;
	private String farmaceutica;
	
	public LoteVacunas(String id, LocalDate fecha, int cantidad, String farmaceutica){
		setId(id);
		setFecha(fecha);
		setCantidad(cantidad);
		setFarmaceutica(farmaceutica);
		setTipo(new TipoVacuna(farmaceutica));
		setLoteVacunasDao(new LoteVacunasDAO());
	}
	public LoteVacunas(LocalDate fecha, int cantidad, String farmaceutica){
		setId(EntregaVacunas.cadenaAleatoria());
		setFecha(fecha);
		setCantidad(cantidad);
		setFarmaceutica(farmaceutica);
		setTipo(new TipoVacuna(farmaceutica));
		setLoteVacunasDao(new LoteVacunasDAO());
	}
	
	@Override
	public String toString() {
		return ": cantidad = " + cantidad + " -- Tipo de vacuna = " + farmaceutica;
	}
	public TipoVacuna getTipo() {
		return this.tipo;	
	}
	public void setTipo(TipoVacuna tipoVacuna) {
		this.tipo = tipoVacuna;	
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, farmaceutica, fecha, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteVacunas other = (LoteVacunas) obj;
		return cantidad == other.cantidad && Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id);
	}
	
}