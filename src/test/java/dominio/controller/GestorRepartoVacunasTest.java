package dominio.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import persistencia.DAOException;

public class GestorRepartoVacunasTest {

	@Test
	public void testAltaNuevoLoteVacunas() throws ControllerException {
		LocalDate fecha = LocalDate.now();
		String tipo = "Pfizer";
		int cantidad = 100;
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		reparto.altaNuevoLoteVacunas(fecha, tipo, cantidad);
		
		String expected = "";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCalcularEntregasRegionMayor200() throws DAOException, ControllerException {
		String id = "asds51";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 200; 
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id, fecha, cantidad, farmaceutica);
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		List<EntregaVacunas> entregas = reparto.calcularEntregasRegion(lote, "Joven");
		Assert.assertNotEquals(entregas, null);
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
		Assert.assertNotEquals(entregas, null);
	}

	@Test
	public void testImprimirLotes() throws DAOException{
		GestorRepartoVacunas reparto = new GestorRepartoVacunas();
		List<LoteVacunas> LoteVacunas = reparto.imprimirLotes();
		Assert.assertNotEquals(LoteVacunas, null);
	}

}
