package ISO2.PrISO2.dominio.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import ISO2.PrISO2.dominio.entitymodel.*;
import ISO2.PrISO2.persistencia.DAOException;

public class GestorVacunacion {

	/**
	 * 
	 * @param lote
	 * @param fecha
	 * @param cantidad
	 * @param prioridad
	 */
	public void altaEntregaVacunas(String lote, LocalDate fecha, int cantidad, String prioridad, String region) throws Exception {
		EntregaVacunas vacunas = new EntregaVacunas(prioridad, lote, fecha, cantidad, region);
		vacunas.getEntregaDao().insertarEntrega(vacunas);
	}

	/**
	 * 
	 * @param fecha
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param tipo
	 * @throws Exception 
	 */
	public void registrarVacunacion(LocalDate fecha, String nombre, String apellidos, String dni, String tipo, boolean segDosis) throws Exception {
		Paciente paciente = new Paciente (dni, nombre, apellidos);
		Vacunacion vacunacion = new Vacunacion(dni, tipo, fecha, segDosis);
		vacunacion.getVacunacionDao().insertarVacunacion(vacunacion);
	}
	public void actualizarVacunacion(String dni) throws Exception {
		Vacunacion vacunacion = new Vacunacion(dni);
		vacunacion.getVacunacionDao().update(vacunacion);
	}
	
	public boolean comprobarPaciente(String dni) throws Exception {
		Vacunacion vacunacion = new Vacunacion(dni);
		try {
			vacunacion.getVacunacionDao().get(dni);
			return true;
		}catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		} finally {
			return false;
		}
	}
	

}