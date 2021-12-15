package dominio.controller;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.Vacunacion;
import persistencia.DAOException;

public class GestorVacunacionTest {

	@Test
	public void testAltaEntregaVacunas() throws DAOException {
		LocalDate fecha = LocalDate.now();
		int cantidad = 100;
		String prioridad = "Ancianos";
		String region = "Cantabria";
		EntregaVacunas expected = new EntregaVacunas(prioridad, fecha, cantidad, region);
		GestorVacunacion vacunacion = new GestorVacunacion();
		vacunacion.altaEntregaVacunas(expected);
		
		EntregaVacunas actual = expected.getEntregaDao().get(expected.getLote());

		Assert.assertTrue(expected.equals(actual));
	}

	@Test
	public void testRegistrarVacunacion() throws DAOException {
		LocalDate fecha = LocalDate.now();
		String tipo = "Pfizer";
		boolean segDosis = false;
		Paciente paciente = new Paciente("02440456Q", "Federico", "Moreno Martinez", "Anciano", "Extremadura");
		GestorVacunacion GestorVacunacion = new GestorVacunacion();
		Vacunacion expected = new Vacunacion(tipo, fecha, segDosis, paciente);
		GestorVacunacion.registrarVacunacion(expected);

		Vacunacion actual = expected.getVacunacionDao().get(expected.getPaciente().getDni());

		Assert.assertTrue(expected.equals(actual));
	}
}
