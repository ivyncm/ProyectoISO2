package ISO2.PrISO2.dominio.entitymodel;

public class Paciente {
	String region;
	String grupo;
	private String dni;
	private String nombre;
	private String apellidos;
	
	public Paciente(String dni, String nombre, String apellidos, String grupo, String region) {
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setGrupo(grupo);
		setRegion(region);
	}
	public String getDni() {
		return dni;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
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