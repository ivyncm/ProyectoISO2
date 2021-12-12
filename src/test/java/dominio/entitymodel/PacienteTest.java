package dominio.entitymodel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class PacienteTest {

	@Test
	public void testGetDni() {
		String dni = "04863879Q";
		String region = "Murcia";
		String grupo = "Joven";
		String nombre = "Raul";
		String apellidos = "Garcia Martinez";

		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
        String expected = dni;
        Assert.assertEquals(expected, paciente.getDni());
	}

	@Test
	public void testGetRegion() {
		String dni = "04863879Q";
		String region = "Murcia";
		String grupo = "Joven";
		String nombre = "Raul";
		String apellidos = "Garcia Martinez";

		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
        String expected = region;
        Assert.assertEquals(expected, paciente.getRegion());	}

	@Test
	public void testGetGrupo() {
		String dni = "04863879Q";
		String region = "Murcia";
		String grupo = "Joven";
		String nombre = "Raul";
		String apellidos = "Garcia Martinez";

		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
        String expected = grupo;
        Assert.assertEquals(expected, paciente.getGrupo());	}

	@Test
	public void testGetNombre() {
		String dni = "04863879Q";
		String region = "Murcia";
		String grupo = "Joven";
		String nombre = "Raul";
		String apellidos = "Garcia Martinez";

		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
        String expected = nombre;
        Assert.assertEquals(expected, paciente.getNombre());	}

	@Test
	public void testGetApellidos() {
		String dni = "04863879Q";
		String region = "Murcia";
		String grupo = "Joven";
		String nombre = "Raul";
		String apellidos = "Garcia Martinez";

		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
        String expected = apellidos;
        Assert.assertEquals(expected, paciente.getApellidos());	}

}
