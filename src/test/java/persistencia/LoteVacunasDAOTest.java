package persistencia;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAOTest {


	@Test
	public void testGet() throws DAOException {
		LoteVacunas expected = new LoteVacunas(LocalDate.now(), 100, "Pfizer");
		
		expected.getLoteVacunasDao().insert(expected);
		LoteVacunas actual = expected.getLoteVacunasDao().get(expected.getId());
		
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testSeleccionarLote() throws DAOException {
		LoteVacunas expected = new LoteVacunas(LocalDate.now(), 300, "Astrazeneca");
		
		expected.getLoteVacunasDao().insert(expected);
		
		List<LoteVacunas> lote = expected.getLoteVacunasDao().seleccionarLote();
		
		String id = lote.get(lote.size()-1).getId();
		
		
		Assert.assertEquals(id, expected.getId());
	}

	@Test
	public void testInsert() throws DAOException {
		LoteVacunas lote = new LoteVacunas(LocalDate.now(), 500, "Pfizer");
		
		int actual = lote.getLoteVacunasDao().insert(lote);
		int expected = 0;
		
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testUpdate() throws DAOException {
		LoteVacunas before = new LoteVacunas(LocalDate.now(), 800, "Moderna");
		before.getLoteVacunasDao().insert(before);
		
		LoteVacunas after = new LoteVacunas(before.getId(), LocalDate.now(), 500, "Moderna");
		after.getLoteVacunasDao().update(after);
		
		LoteVacunas actual = before.getLoteVacunasDao().get(before.getId());
		
		Assert.assertTrue(after.equals(actual));
	}

	@Test
	public void testDelete() throws DAOException {
		LoteVacunas lote = new LoteVacunas(LocalDate.now(), 100, "Janssen");
		lote.getLoteVacunasDao().insert(lote);
		
		int actual = lote.getLoteVacunasDao().delete(lote);
		int expected = 0;
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testInsertarLoteVacunas() throws DAOException {
		LoteVacunas expected = new LoteVacunas(LocalDate.now(), 800, "Moderna");
		expected.getLoteVacunasDao().insertarLoteVacunas(expected);
		
		LoteVacunas actual = expected.getLoteVacunasDao().get(expected.getId());
		
		Assert.assertTrue(expected.equals(actual));
	}

}
