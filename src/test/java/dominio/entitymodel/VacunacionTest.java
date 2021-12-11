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
        Assert.assertEquals(expected, vacuna.getPaciente());	}

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

}
