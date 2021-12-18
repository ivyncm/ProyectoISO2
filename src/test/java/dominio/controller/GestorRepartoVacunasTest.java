package dominio.controller;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import persistencia.DAOException;

public class GestorRepartoVacunasTest {

	@Test
	public void testAltaNuevoLoteVacunas() throws ControllerException, DAOException {
		LocalDate fecha = LocalDate.now();
		String tipo = "Pfizer";
		int cantidad = 100;
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		LoteVacunas expected = new LoteVacunas(fecha, cantidad, tipo);
		reparto.altaNuevoLoteVacunas(expected);
		
		
		LoteVacunas actual = expected.getLoteVacunasDao().get(expected.getId());
		
		
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testCalcularEntregasRegionMayor200() throws DAOException, ControllerException {
		String id = "asds51";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 300; 
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id, fecha, cantidad, farmaceutica);
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		List<EntregaVacunas> entregas = reparto.calcularEntregasRegion(lote, "Joven");
		
		
		Assert.assertEquals(entregas.size(), 19);
	}
	@Test
	public void testCalcularEntregasRegionMenor200() throws DAOException, ControllerException {
		String id = "asds51";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 50; 
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id, fecha, cantidad, farmaceutica);
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		List<EntregaVacunas> entregas = reparto.calcularEntregasRegion(lote, "Joven");
		
		Assert.assertEquals(entregas.size(), 1);
	}

	@Test
	public void testImprimirLotes() throws DAOException{
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		List<LoteVacunas> LoteVacunas = reparto.imprimirLotes();
		Assert.assertNotEquals(LoteVacunas, null);
	}

}
