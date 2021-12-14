package dominio.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.Paciente;
import persistencia.DAOException;

public class GestorVacunacionTest {

	@Test
	public void testAltaEntregaVacunas() throws DAOException {
		LocalDate fecha = LocalDate.now();
		int cantidad = 100;
		String prioridad = "Ancianos";
		String region = "Cantabria";
		GestorVacunacion vacunacion = new GestorVacunacion();
		vacunacion.altaEntregaVacunas(fecha, cantidad, prioridad, region);
		
		String expected = "";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testRegistrarVacunacion() throws DAOException {
		LocalDate fecha = LocalDate.now();
		String tipo = "Pfizer";
		boolean segDosis = false;
		Paciente paciente = new Paciente("02440456Q", "Federico", "Moreno Martinez", "Anciano", "Extremadura");
		GestorVacunacion vacunacion = new GestorVacunacion();
		vacunacion.registrarVacunacion(fecha, tipo, segDosis, paciente);
		
		String expected = "";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];
		Assert.assertEquals(expected, actual);
	}


}
