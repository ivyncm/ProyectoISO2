package persistencia;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.Paciente;
import dominio.entitymodel.Vacunacion;

public class VacunacionDAOTest {

	@Test
	public void testGet() throws DAOException {
		Paciente paciente = new Paciente("05441147A", "Rodolfo", "Dominguez Talavante", "Adulto", "Andalucia");
		Vacunacion expected = new Vacunacion("Astrazeneca", LocalDate.now(), false, paciente);
		expected.getVacunacionDao().insert(expected);
		Vacunacion actual = expected.getVacunacionDao().get(expected.getdni());
		
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testInsert() throws DAOException {
		Paciente paciente = new Paciente("05444447A", "Agustin", "Martinez Alvarez", "Adulto", "Galicia");
		Vacunacion vacunacion = new Vacunacion("Pfizer", LocalDate.now(), false, paciente);
		int actual = vacunacion.getVacunacionDao().insert(vacunacion);
		int expected = 0;
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testUpdate() throws DAOException {
		Paciente paciente = new Paciente("05441852T", "Joaquin", "Dominguez Martinez", "Anciano", "Murcia");
		Vacunacion before = new Vacunacion("Astrazeneca", LocalDate.now(), false, paciente);
		before.getVacunacionDao().insert(before);
		
		Vacunacion after = new Vacunacion("Astrazeneca", LocalDate.now(), true, paciente);
		after.getVacunacionDao().update(after);
		
		Vacunacion actual = before.getVacunacionDao().get(before.getdni());
		
		Assert.assertTrue(after.equals(actual));
	}

	@Test
	public void testDelete() throws DAOException {
		Paciente paciente = new Paciente("02454447V", "Paco", "Fernandez Alvarez", "Joven", "Galicia");
		Vacunacion vacunacion = new Vacunacion("Pfizer", LocalDate.now(), false, paciente);
		vacunacion.getVacunacionDao().insert(vacunacion);
		
		int actual = vacunacion.getVacunacionDao().delete(vacunacion);
		int expected = 0;
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testInsertarVacunacion() throws DAOException {
		Paciente paciente = new Paciente("03441147P", "Esteban", "Dominguez Talavante", "Adulto", "Andalucia");
		Vacunacion expected = new Vacunacion("Astrazeneca", LocalDate.now(), false, paciente);
		expected.getVacunacionDao().insertarVacunacion(expected);
		Vacunacion actual = expected.getVacunacionDao().get(expected.getdni());
		
		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testSeleccionarVacunaciones() throws DAOException {
		Paciente paciente = new Paciente("02454447V", "Paco", "Fernandez Alvarez", "Joven", "Galicia");
		Vacunacion vacunacion = new Vacunacion("Pfizer", LocalDate.now(), false, paciente);
		vacunacion.getVacunacionDao().insert(vacunacion);
		
		List<Vacunacion> actual = vacunacion.getVacunacionDao().seleccionarVacunaciones();
		
		String dni = actual.get(actual.size()-1).getdni();
		
		Assert.assertEquals(dni, vacunacion.getdni());
	}

	@Test
	public void testSeleccionarVacunacionesString() throws DAOException {
		Paciente paciente = new Paciente("02459047V", "Alfredo", "Gomez Alvarez", "Joven", "Asturias");
		Vacunacion vacunacion = new Vacunacion("Janssen", LocalDate.now(), false, paciente);
		vacunacion.getVacunacionDao().insert(vacunacion);
		
		List<Vacunacion> actual = vacunacion.getVacunacionDao().seleccionarVacunaciones("Asturias");
		String dni = actual.get(actual.size()-1).getdni();
		
		Assert.assertEquals(dni, vacunacion.getdni());
	}

}
