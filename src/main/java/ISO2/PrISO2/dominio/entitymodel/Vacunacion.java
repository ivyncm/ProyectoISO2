package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;
import ISO2.PrISO2.persistencia.*;

public class Vacunacion {
	private int id;
	String vacuna;
	String paciente;
	VacunacionDAO vacunacionDao;
	private Date fecha;
	private boolean isSegundaDosis;
	
	public Vacunacion(int id, String tipoVacuna, String paciente, java.sql.Date fecha, boolean segDosis) {
		setId(id);
		setVacuna(tipoVacuna);
		setPaciente(paciente);
		setFecha(fecha);
		setSegundaDosis(segDosis);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVacuna() {
		return vacuna;
	}
	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public VacunacionDAO getVacunacionDao() {
		return vacunacionDao;
	}
	public void setVacunacionDao(VacunacionDAO vacunacionDao) {
		this.vacunacionDao = vacunacionDao;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isSegundaDosis() {
		return isSegundaDosis;
	}
	public void setSegundaDosis(boolean isSegundaDosis) {
		this.isSegundaDosis = isSegundaDosis;
	}
}