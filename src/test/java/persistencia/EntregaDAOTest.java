package persistencia;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;

public class EntregaDAOTest {
	EntregaDAO edao=new EntregaDAO();
	
	@Test
	public void testGet() throws DAOException {
		EntregaVacunas expected1 = null;
		expected1.setGrupoPrioridad("Anciano");
		expected1.setLote("23444FD");
		expected1.setFecha(LocalDate.now());
		expected1.setCantidad(100);
		EntregaVacunas expected2;
		
		expected2=edao.get("23444FD");
		
		Assert.assertEquals(expected1, expected2);
	}

	@Test
	public void testInsert() throws DAOException {
		EntregaVacunas entrega = new EntregaVacunas("Anciano", "124556AA", LocalDate.now(), 250, "Andalucia");
		int expected;
		try {
			expected =edao.insert(entrega);
		} catch (DAOException e) {
			throw new DAOException("Error SQL");
		}
		Assert.assertNotEquals(0, expected);
	}

	@Test
	public void testUpdate() {
		int i;
		
	}
	
	/*Person person = new Person();
	 
	person.setUsername("zhangsan");
	person.setPassword("123456");
	person.setAge(40);

	personDB.insert(person);

	int maxId = this.getMaxId();

	Person person2 = personDB.getById(maxId);

	this.comparePersons(person, person2);
	
	personDB.removeById(maxId);
*/

	@Test
	public void testDelete() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testInsertarEntrega() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSeleccionarcantidadTotal() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSeleccionarEntregas() {
		throw new RuntimeException("not yet implemented");
	}

}
