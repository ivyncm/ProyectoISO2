package dominio.entitymodel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class VacunacionTest {

	@Test
	public void testGetdni() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
        String expected = dni;
        Assert.assertEquals(expected, vacuna.getdni());
	}

	@Test
	public void testGetPaciente() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
        Paciente expected = paciente;
        Assert.assertEquals(expected, vacuna.getPaciente());	
	}
	@Test
	public void testGetVacunacionDao() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
        Assert.assertNotNull(vacuna.getVacunacionDao());	
	}

	@Test
	public void testGetVacuna() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
        String expected = tipoVacuna;
        Assert.assertEquals(expected, vacuna.getVacuna());	}


	@Test
	public void testGetFecha() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
        LocalDate expected = fecha;
        Assert.assertEquals(expected, vacuna.getFecha());	}

	@Test
	public void testIsSegundaDosis() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
        boolean expected = isSegundaDosis;
        Assert.assertEquals(expected, vacuna.isSegundaDosis());	}

	
	@Test
	public void testEquals() {
		String dni = "04863879Q";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente = new Paciente(dni, "Jesus", "Gacia", "Joven", "Murcia");
		
		Vacunacion vacuna1 = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
		Vacunacion vacuna2 = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente);
		
        Assert.assertTrue(vacuna1.equals(vacuna2));	}
	
	@Test
	public void testNotEquals() {
		String dni1 = "04863879Q";
		String dni2 = "02853974F";
		String tipoVacuna = "Pfizer";
		LocalDate fecha = LocalDate.now();
		boolean isSegundaDosis = true;
		Paciente paciente1 = new Paciente(dni1, "Jesus", "Gacia", "Joven", "Murcia");
		Paciente paciente2 = new Paciente(dni2, "David", "Moreno", "Joven", "Murcia");
		
		Vacunacion vacuna1 = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente1);
		Vacunacion vacuna2 = new Vacunacion(tipoVacuna,fecha,isSegundaDosis,paciente2);
		
        Assert.assertFalse(vacuna1.equals(vacuna2));	}
}
