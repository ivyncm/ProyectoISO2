package ISO2.PrISO2.dominio.controller;

import java.time.LocalDate;
import java.util.List;

import ISO2.PrISO2.dominio.entitymodel.*;
import ISO2.PrISO2.persistencia.EntregaDAO;
import ISO2.PrISO2.persistencia.LoteVacunasDAO;
import ISO2.PrISO2.persistencia.VacunacionDAO;


//enum region
//{
//   ROJO, VERDE, AZUL;
//}

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
	 * @throws Exception 
	 */
	public void consultarTotalVacunadosPorRegion(String region) throws Exception {
		VacunacionDAO total=new VacunacionDAO();
		List<Vacunacion> vacunaciones=total.seleccionarVacunaciones(region); 
		int contador=0;
		for (int i=0;i<vacunaciones.size() ;i++) {
			if (vacunaciones.get(i).isSegundaDosis()) {
				contador++;
			}
		}
		System.out.println("Una dosis: " +(vacunaciones.size()-contador));
		System.out.println("Pauta completa: " +contador);	
	}

	public void consultarPorcentajeVacunadosSobreRecibidas() {
		
	}

	/**
	 * 
	 * @param region
	 */
	public void consultarPorcentajeVacunadosSobreRecibidasEnRegion(String region) {
		
	}
	
	public void consultarVacunasTotal() throws Exception {
		int total=0;
		EntregaDAO totales=new EntregaDAO();
		List<EntregaVacunas> entrega=totales.seleccionarcantidadTotal();
		for (int i=0; i<entrega.size(); i++) {
			total=total+entrega.get(i).getCantidad();
		}
		System.out.println("Total vacunas entregadas: " +total);
		//return total;
	} 	
}