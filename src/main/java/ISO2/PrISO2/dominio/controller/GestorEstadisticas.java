package ISO2.PrISO2.dominio.controller;

import java.time.LocalDate;
import java.util.List;

import ISO2.PrISO2.dominio.entitymodel.*;
import ISO2.PrISO2.persistencia.VacunacionDAO;

public class GestorEstadisticas {

	public void consultarTotalVacunados() throws Exception {
		VacunacionDAO total=new VacunacionDAO();
		List<Vacunacion> vacunaciones=total.seleccionarVacunaciones(); 
		int contador=0;
		for (int i=0;i<vacunaciones.size() ;i++) {
			if (vacunaciones.get(i).isSegundaDosis()) {
				contador++;
			}
		}
		System.out.println("Una dosis: " +(vacunaciones.size()-contador));
		System.out.println("Pauta completa: " +contador);
		
	}

	/**
	 * 
	 * @param region
	 */
	public void consultarTotalVacunadosPorRegion(RegionEnum region) {
		// TODO - implement GestorEstadisticas.consultarTotalVacunadosPorRegion
		throw new UnsupportedOperationException();
	}

	public void consultarPorcentajeVacunadosSobreRecibidas() {
		// TODO - implement GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param region
	 */
	public void consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) {
		// TODO - implement GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidasEnRegion
		throw new UnsupportedOperationException();
	}

}