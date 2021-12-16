package persistencia;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;

public class EntregaDAOTest {
	
	@Test
	public void testGet() throws DAOException {
		EntregaVacunas expected = new EntregaVacunas("Anciano", "23444FD", LocalDate.now(), 100, "Murcia");
		
		expected.getEntregaDao().insert(expected);
		EntregaVacunas actual = expected.getEntregaDao().get(expected.getLote());
		
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testInsert() throws DAOException {
		EntregaVacunas entrega = new EntregaVacunas("Anciano", "124556AA", LocalDate.now(), 250, "Andalucia");
		int actual = entrega.getEntregaDao().insert(entrega);
		int expected = 0;
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testUpdate() throws DAOException {
		EntregaVacunas before = new EntregaVacunas("Joven", "23444FD", LocalDate.now(), 100, "Murcia");
		before.getEntregaDao().insert(before);
		
		EntregaVacunas after = new EntregaVacunas("Anciano", "23444FD", LocalDate.now(), 120, "Murcia");
		
		after.getEntregaDao().update(after);
		
		EntregaVacunas actual = before.getEntregaDao().get(before.getLote());
		
		Assert.assertTrue(after.equals(actual));
		
	}
	
	@Test
	public void testDelete() throws DAOException {
		EntregaVacunas entrega = new EntregaVacunas("Joven", "22444AD", LocalDate.now(), 200, "Cantabria");
		entrega.getEntregaDao().insert(entrega);
		
		int actual = entrega.getEntregaDao().delete(entrega);
		int expected = 0;
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testInsertarEntrega() throws DAOException {
		EntregaVacunas expected = new EntregaVacunas("Anciano", "124556AA", LocalDate.now(), 250, "Andalucia");
		expected.getEntregaDao().insertarEntrega(expected);
		
		EntregaVacunas actual = expected.getEntregaDao().get(expected.getLote());
		
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testSeleccionarcantidadTotal() throws DAOException {
		EntregaVacunas expected = new EntregaVacunas("Anciano", "23444FD", LocalDate.now(), 100, "Murcia");
		
		expected.getEntregaDao().insert(expected);
		
		List<EntregaVacunas> actual = expected.getEntregaDao().seleccionarcantidadTotal();
		
		int cantidad = actual.get(actual.size()-1).getCantidad();
		
		Assert.assertEquals(cantidad, expected.getCantidad());
	}

	@Test
	public void testSeleccionarEntregas() throws DAOException {
		EntregaVacunas expected = new EntregaVacunas("Anciano", "23445XD", LocalDate.now(), 100, "Galicia");
		
		expected.getEntregaDao().insert(expected);
		
		List<EntregaVacunas> actual = expected.getEntregaDao().seleccionarEntregas("Galicia");
		
		String id = actual.get(actual.size()-1).getLote();
		
		Assert.assertEquals(id, expected.getLote());
	}

}
