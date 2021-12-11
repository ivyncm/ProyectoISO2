package dominio.entitymodel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import persistencia.DAOException;

public class LoteVacunasTest {

	@Test
	public void testToString() throws DAOException {
		String id = "asdcass";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 20;
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id,fecha,cantidad,farmaceutica);
		String expected = ": cantidad = " + cantidad + " -- Tipo de vacuna = " + farmaceutica;
        Assert.assertEquals(expected, lote.toString());
	}

	@Test
	public void testGetTipo() throws DAOException {
		String id = "asdcass";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 20;
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id,fecha,cantidad,farmaceutica);
		String expected = farmaceutica;
        Assert.assertEquals(expected, lote.getTipo().getFarmaceutica());
	}


	/*@Test
	public void testGetLoteVacunasDao() {
		throw new RuntimeException("not yet implemented");
	}*/


	@Test
	public void testGetId() throws DAOException {
		String id = "asdcass";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 20;
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id,fecha,cantidad,farmaceutica);
		String expected = id;
        Assert.assertEquals(expected, lote.getId());
	}


	@Test
	public void testGetFecha() throws DAOException {
		String id = "asdcass";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 20;
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id,fecha,cantidad,farmaceutica);
		LocalDate expected = fecha;
        Assert.assertEquals(expected, lote.getFecha());
	}


	@Test
	public void testGetCantidad() throws DAOException {
		String id = "asdcass";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 20;
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id,fecha,cantidad,farmaceutica);
		int expected = cantidad;
        Assert.assertEquals(expected, lote.getCantidad());
	}


	@Test
	public void testGetFarmaceutica() throws DAOException {
		String id = "asdcass";
		LocalDate fecha = LocalDate.now(); 
		int cantidad = 20;
		String farmaceutica = "Pfizer";
		LoteVacunas lote = new LoteVacunas(id,fecha,cantidad,farmaceutica);
		String expected = farmaceutica;
        Assert.assertEquals(expected, lote.getFarmaceutica());
	}
}
