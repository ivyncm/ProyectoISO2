package dominio.entitymodel;

import java.util.*;

public enum GrupoPrioridad {
	;

	Collection<Paciente> pacientes;
	Collection<EntregaVacunas> entregas;
	private String nombre;
	
	
	private GrupoPrioridad(Collection<Paciente> pacientes, Collection<EntregaVacunas> entregas, String nombre, int prioridad) {
		this.pacientes = pacientes;
		this.entregas = entregas;
		this.nombre = nombre;
		this.prioridad = prioridad;
	}
	public Collection<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}
	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	private int prioridad;

}