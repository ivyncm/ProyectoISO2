package ISO2.PrISO2.dominio.entitymodel;

import java.time.LocalDate;
import java.util.*;
import ISO2.PrISO2.persistencia.*;

public class Vacunacion {
	private String id;
	String tipoVacuna;
	Paciente paciente;
	VacunacionDAO vacunacionDao;
	private LocalDate fecha;
	private boolean isSegundaDosis;
	
	public Vacunacion(String id, String tipoVacuna, Paciente paciente, LocalDate fecha, boolean segDosis) throws Exception {
		setId(id);
		setVacuna(tipoVacuna);
		setPaciente(paciente);
		setFecha(fecha);
		setSegundaDosis(segDosis);
		vacunacionDao = new VacunacionDAO();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVacuna() {
		return tipoVacuna;
	}
	public void setVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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