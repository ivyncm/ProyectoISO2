package dominio.controller;

import java.util.ArrayList;
import java.util.List;

import dominio.entitymodel.*;
import persistencia.EntregaDAO;
import persistencia.VacunacionDAO;

public class GestorEstadisticas {
	public List<Integer> consultarTotalVacunados() throws controllerException {
		VacunacionDAO total;
		try {
			total = new VacunacionDAO();
			List<Vacunacion> vacunaciones = total.seleccionarVacunaciones();
			int contador = calcularvacunadostotal();
			List<Integer> totalVacunados = new ArrayList<>();
			totalVacunados.add(vacunaciones.size());
			totalVacunados.add(contador);
			return totalVacunados;
		} catch (Exception e) {
			throw new controllerException("Error al consultar vacunados", e);
		}
	}

	/**
	 * 
	 * @param region
	 * @return 
	 * @throws Exception
	 */
	public List<Integer> consultarTotalVacunadosPorRegion(String region) throws controllerException {
		try {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones(region);
		int contador = calcularvacunadostotalregion(region);
		List<Integer> totalVacunados = new ArrayList<>();
		totalVacunados.add(vacunaciones.size());
		totalVacunados.add(contador);
		return totalVacunados;
		} catch (Exception e) {
			throw new controllerException("Error al consultar vacunados por región", e);
		}
	}

	public double consultarPorcentajeVacunadosSobreRecibidas() throws controllerException {
		double vacunados = calcularvacunadostotal();
		double recibidas = consultartotalrecibidas();
		return (vacunados / recibidas);
		
	}

	/**
	 * 
	 * @param region
	 * @return 
	 * @throws Exception
	 */
	public List<Double> consultarPorcentajeVacunadosSobreRecibidasEnRegion(String region) throws controllerException {
		double vacunados = calcularvacunadostotalregion(region);
		double recibidas = consultartotalrecibidasregion(region);
		
		List<Double> porcentajeRegion = new ArrayList<>();
		porcentajeRegion.add(vacunados);
		porcentajeRegion.add(recibidas);
		return porcentajeRegion;
	}

	// Metodos auxiliares total
	public int calcularvacunadostotal() throws controllerException {
		VacunacionDAO total;
		try {
			total = new VacunacionDAO();
			List<Vacunacion> vacunaciones = total.seleccionarVacunaciones();
			int contador = 0;
			for (int i = 0; i < vacunaciones.size(); i++) {
				if (vacunaciones.get(i).isSegundaDosis()) {
					contador++;
				}
			}
			return contador;
		} catch (Exception e) {
			throw new controllerException("Error al calcular total de vacunados", e);
		}
		
	}

	public int consultartotalrecibidas() throws controllerException {
		int total = 0;
		EntregaDAO totales;
		try {
			totales = new EntregaDAO();
			List<EntregaVacunas> entrega = totales.seleccionarcantidadTotal();
			for (int i = 0; i < entrega.size(); i++) {
				total = total + entrega.get(i).getCantidad();
			}
			return total;
		} catch (Exception e) {
			throw new controllerException("Error al consultar total de vacunas recibidas", e);
		}
	}

	// Metodos auxiliares region
	public int calcularvacunadostotalregion(String region) throws controllerException {
		VacunacionDAO total;
		try {
			total = new VacunacionDAO();
			List<Vacunacion> vacunaciones = total.seleccionarVacunaciones(region);
			int contador = 0;
			for (int i = 0; i < vacunaciones.size(); i++) {
				if (vacunaciones.get(i).isSegundaDosis()) {
					contador++;
				}
			}
			return contador;
		} catch (Exception e) {
			throw new controllerException("Error al consultar total de vacunados por región", e);
		}
	}

	public int consultartotalrecibidasregion(String region) throws controllerException {
		int total = 0;
		EntregaDAO totales;
		try {
			totales = new EntregaDAO();
			List<EntregaVacunas> entrega = totales.seleccionarEntregas(region);
			for (int i = 0; i < entrega.size(); i++) {
				total = total + entrega.get(i).getCantidad();
			}
			return total;
		} catch (Exception e) {
			throw new controllerException("Error al consultar total de vacunas por región", e);
		}
	}
}