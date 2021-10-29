package ISO2.PrISO2.dominio.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	public void registrarVacunacion(LocalDate fecha, String nombre, String apellidos, String dni, String tipo, boolean segDosis, String region, String grupo) throws Exception {
		Paciente paciente = new Paciente (dni, nombre, apellidos, region, grupo);
		Vacunacion vacunacion = new Vacunacion(tipo, fecha, segDosis,paciente);
		vacunacion.getVacunacionDao().insertarVacunacion(vacunacion);
	}
	public void actualizarVacunacion(String dni) throws Exception {
		Vacunacion vacunacion = new Vacunacion(dni);
		vacunacion.getVacunacionDao().update(vacunacion);
	}
	

}