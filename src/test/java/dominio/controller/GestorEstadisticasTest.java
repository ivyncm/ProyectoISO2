package dominio.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GestorEstadisticasTest {

	@Test
	public void testConsultarTotalVacunados() throws ControllerException {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		for(int vacunados:totalVacunados) {
			Assert.assertTrue(vacunados >= 0);
		}
	}

	@Test
	public void testConsultarTotalVacunadosPorRegion() throws ControllerException {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunadosPorRegion("Andalucia");
		
		for(int vacunados:totalVacunados) {
			Assert.assertTrue(vacunados >= 0);
		}
	}

	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidas() throws ControllerException {
		GestorEstadisticas gestor = new GestorEstadisticas();
		double porcentaje = gestor.consultarPorcentajeVacunadosSobreRecibidas();
		Assert.assertTrue(porcentaje >= 0);
	}

	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion() throws ControllerException {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Double> porcentajes = gestor.consultarPorcentajeVacunadosSobreRecibidasEnRegion("Murcia");
		for(double porcentaje:porcentajes) {
			Assert.assertTrue(porcentaje >= 0);
		}
	}
}
