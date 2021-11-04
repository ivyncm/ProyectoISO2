package ISO2.PrISO2.dominio.controller;

import java.util.List;

import ISO2.PrISO2.dominio.entitymodel.*;
import ISO2.PrISO2.persistencia.EntregaDAO;
import ISO2.PrISO2.persistencia.VacunacionDAO;

public class GestorEstadisticas {
	public void consultarTotalVacunados() throws Exception {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones();
		int contador = calcularvacunadostotal();
		System.out.println("Una dosis: " + (vacunaciones.size() - contador));
		System.out.println("Pauta completa: " + contador);
	}

	/**
	 * 
	 * @param region
	 * @throws Exception
	 */
	public void consultarTotalVacunadosPorRegion(String region) throws Exception {
		VacunacionDAO total = new VacunacionDAO();
		List<Vacunacion> vacunaciones = total.seleccionarVacunaciones(region);
		int contador = calcularvacunadostotalregion(region);
		System.out.println("Una dosis: " + (vacunaciones.size() - contador));
		System.out.println("Pauta completa: " + contador);
	}

	public void consultarPorcentajeVacunadosSobreRecibidas() throws Exception {
		double vacunados = calcularvacunadostotal();
		double recibidas = consultartotalrecibidas();
		System.out.println(vacunados);
		System.out.println(recibidas);
		System.out.printf("Porcentaje vacunados: %.3f%%", (vacunados / recibidas) * 100);
	}

	/**
	 * 
	 * @param region
	 * @throws Exception
	 */
	public void consultarPorcentajeVacunadosSobreRecibidasEnRegion(String region) throws Exception {
		double vacunados = calcularvacunadostotalregion(region);
		double recibidas = consultartotalrecibidasregion(region);
		if (recibidas == 0) {
			System.out.println("Porcentaje vacunados: 0,000%");
		} else {
			System.out.printf("Porcentaje vacunados: %.3f%%\n", (vacunados / recibidas) * 100);
		}
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