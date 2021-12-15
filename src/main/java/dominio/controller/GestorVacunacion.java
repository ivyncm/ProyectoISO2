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
	public void altaEntregaVacunas(EntregaVacunas entrega) throws DAOException{
		entrega.getEntregaDao().insertarEntrega(entrega);
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
	public void registrarVacunacion(Vacunacion vacunacion) throws DAOException{
		vacunacion.getVacunacionDao().insertarVacunacion(vacunacion);
	}


}