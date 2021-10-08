package ISO2.PrISO2.dominio.entitymodel;

public class Paciente {

	RegionEnum region;
	GrupoPrioridad grupo;
	private String dni;
	private String nombre;
	private String apellidos;
	public String getDni() {
		return dni;
	}
	public RegionEnum getRegion() {
		return region;
	}
	public void setRegion(RegionEnum region) {
		this.region = region;
	}
	public GrupoPrioridad getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoPrioridad grupo) {
		this.grupo = grupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}