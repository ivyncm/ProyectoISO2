package dominio.entitymodel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class TipoVacunaTest {

	@Test
	public void testGetNombre() {
		String nombre = "Jesus";
		String farmaceutica = "Pfizer";
		LocalDate fechaAprobacion = LocalDate.now();

		TipoVacuna vacuna = new TipoVacuna(farmaceutica);
		vacuna.setNombre(nombre);
        String expected = nombre;
        Assert.assertEquals(expected, vacuna.getNombre());
	}

	@Test
	public void testGetFarmaceutica() {
		String nombre = "Jesus";
		String farmaceutica = "Pfizer";
		LocalDate fechaAprobacion = LocalDate.now();

		TipoVacuna vacuna = new TipoVacuna(farmaceutica);
        String expected = farmaceutica;
        Assert.assertEquals(expected, vacuna.getFarmaceutica());
	}

	@Test
	public void testGetFechaAprobacion() {
		String nombre = "Jesus";
		String farmaceutica = "Pfizer";
		LocalDate fechaAprobacion = LocalDate.now();

		TipoVacuna vacuna = new TipoVacuna(farmaceutica);
		vacuna.setFechaAprobacion(fechaAprobacion);
        LocalDate expected = fechaAprobacion;
        Assert.assertEquals(expected, vacuna.getFechaAprobacion());
	}

}
