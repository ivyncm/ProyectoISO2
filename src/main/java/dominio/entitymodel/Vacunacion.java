package dominio.entitymodel;

import java.time.LocalDate;

import persistencia.*;

public class Vacunacion {
	public Paciente paciente;
	private String dni;
	String tipoVacuna;
	VacunacionDAO vacunacionDao;
	private LocalDate fecha;
	private boolean isSegundaDosis;
	
	public Vacunacion(String tipoVacuna, LocalDate fecha, boolean segDosis, Paciente paciente) {
		setdni(paciente.getDni());
		setVacuna(tipoVacuna);
		setFecha(fecha);
		setSegundaDosis(segDosis);
		setPaciente(paciente);
		vacunacionDao = new VacunacionDAO();
	}
	public Vacunacion(String dni){
		setdni(dni);
		vacunacionDao = new VacunacionDAO();
	}
	public String getdni() {
		return dni;
	}
	public void setdni(String dni) {
		this.dni = dni;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getVacuna() {
		return tipoVacuna;
	}
	public void setVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}
	public VacunacionDAO getVacunacionDao() {
		return vacunacionDao;
	}
	public void setVacunacionDao(VacunacionDAO vacunacionDao) {
		this.vacunacionDao = vacunacionDao;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isSegundaDosis() {
		return isSegundaDosis;
	}
	public void setSegundaDosis(boolean isSegundaDosis) {
		this.isSegundaDosis = isSegundaDosis;
	}
}