package ISO2.PrISO2.dominio.entitymodel;

import java.time.LocalDate;
import java.util.*;
import ISO2.PrISO2.persistencia.*;

public class Vacunacion {
	private String dni;
	String tipoVacuna;
	VacunacionDAO vacunacionDao;
	private LocalDate fecha;
	private boolean isSegundaDosis;
	
	public Vacunacion(String dni, String tipoVacuna, LocalDate fecha, boolean segDosis) throws Exception {
		setdni(dni);
		setVacuna(tipoVacuna);
		setFecha(fecha);
		setSegundaDosis(segDosis);
		vacunacionDao = new VacunacionDAO();
	}
	public Vacunacion(String dni) throws Exception {
		setdni(dni);
		vacunacionDao = new VacunacionDAO();
	}
	public String getdni() {
		return dni;
	}
	public void setdni(String dni) {
		this.dni = dni;
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