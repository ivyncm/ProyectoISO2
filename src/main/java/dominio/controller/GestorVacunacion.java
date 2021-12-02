package dominio.controller;

import java.time.LocalDate;

import dominio.entitymodel.*;
import persistencia.DAOException;

public class GestorVacunacion {

	/**
	 * 
	 * @param lote
	 * @param fecha
	 * @param cantidad
	 * @param prioridad
	 * @throws DAOException 
	 */
	public void altaEntregaVacunas(LocalDate fecha, int cantidad, String prioridad, String region) throws DAOException{
		String lote = GestorRepartoVacunas.cadenaAleatoria();
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
	 * @throws DAOException 
	 * @throws Exception
	 */
	public void registrarVacunacion(LocalDate fecha, String tipo, boolean segDosis, Paciente paciente) throws DAOException{
		Vacunacion vacunacion = new Vacunacion(tipo, fecha, segDosis, paciente);
		vacunacion.getVacunacionDao().insertarVacunacion(vacunacion);
	}

	public void actualizarVacunacion(String dni) throws DAOException{
		Vacunacion vacunacion = new Vacunacion(dni);
		vacunacion.getVacunacionDao().update(vacunacion);
	}

}