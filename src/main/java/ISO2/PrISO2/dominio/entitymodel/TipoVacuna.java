package ISO2.PrISO2.dominio.entitymodel;


public class TipoVacuna{
	private String nombre;
	private String farmaceutica;
	private String fechaAprobacion;
	
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
	public String getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
