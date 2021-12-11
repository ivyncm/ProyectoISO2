package dominio.entitymodel;

import java.time.LocalDate;

public class TipoVacuna{
	private String nombre;
	private String farmaceutica;
	private LocalDate fechaAprobacion;
	
	public TipoVacuna(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFarmaceutica() {
		return farmaceutica;
	}
	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}
	public LocalDate getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(LocalDate fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
