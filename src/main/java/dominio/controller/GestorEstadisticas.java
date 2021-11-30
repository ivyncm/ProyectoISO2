package dominio.controller;

import java.util.ArrayList;
import java.util.List;

import dominio.entitymodel.*;
import persistencia.EntregaDAO;
import persistencia.VacunacionDAO;

public class GestorEstadisticas {
	public List<Integer> consultarTotalVacunados() throws Exception {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones();
		int contador = calcularvacunadostotal();
		List<Integer> totalVacunados = new ArrayList<>();
		totalVacunados.add(vacunaciones.size());
		totalVacunados.add(contador);
		return totalVacunados;
	}

	/**
	 * 
	 * @param region
	 * @return 
	 * @throws Exception
	 */
	public List<Integer> consultarTotalVacunadosPorRegion(String region) throws Exception {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones(region);
		int contador = calcularvacunadostotalregion(region);
		List<Integer> totalVacunados = new ArrayList<>();
		totalVacunados.add(vacunaciones.size());
		totalVacunados.add(contador);
		return totalVacunados;
	}

	public double consultarPorcentajeVacunadosSobreRecibidas() throws Exception {
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
	public List<Double> consultarPorcentajeVacunadosSobreRecibidasEnRegion(String region) throws Exception {
		double vacunados = calcularvacunadostotalregion(region);
		double recibidas = consultartotalrecibidasregion(region);
		
		List<Double> porcentajeRegion = new ArrayList<>();
		porcentajeRegion.add(vacunados);
		porcentajeRegion.add(recibidas);
		return porcentajeRegion;
	}

	// Metodos auxiliares total
	public int calcularvacunadostotal() throws Exception {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones();
		int contador = 0;
		for (int i = 0; i < vacunaciones.size(); i++) {
			if (vacunaciones.get(i).isSegundaDosis()) {
				contador++;
			}
		}
		return contador;
	}

	public int consultartotalrecibidas() throws Exception {
		int total = 0;
		EntregaDAO totales = new EntregaDAO();
		List<EntregaVacunas> entrega = totales.seleccionarcantidadTotal();
		for (int i = 0; i < entrega.size(); i++) {
			total = total + entrega.get(i).getCantidad();
		}
		return total;
	}

	// Metodos auxiliares region
	public int calcularvacunadostotalregion(String region) throws Exception {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones(region);
		int contador = 0;
		for (int i = 0; i < vacunaciones.size(); i++) {
			if (vacunaciones.get(i).isSegundaDosis()) {
				contador++;
			}
		}
		return contador;
	}

	public int consultartotalrecibidasregion(String region) throws Exception {
		int total = 0;
		EntregaDAO totales = new EntregaDAO();
		List<EntregaVacunas> entrega = totales.seleccionarEntregas(region);
		for (int i = 0; i < entrega.size(); i++) {
			total = total + entrega.get(i).getCantidad();
		}
		return total;
	}
}