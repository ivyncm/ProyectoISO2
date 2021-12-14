package presentacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import dominio.controller.ControllerException;
import dominio.controller.GestorRepartoVacunas;
import persistencia.DAOException;

public class PantallaGestionSistemaSaludNacionalTest {



	@Test
	public void testMenuSalir() throws Exception {
		String userInput = String.format("4\n");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);

	    String expected = "Sesión cerrada\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);

	    PantallaGestionSistemaSaludNacional.menu();//Llamada a método

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];

	    Assert.assertEquals(expected,actual);
	}

	@Test
	public void testAltaNuevoLote() throws Exception {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("2\n50\n".getBytes());
		System.setIn(in);
	    PantallaGestionSistemaSaludNacional.altaNuevoLote(new GestorRepartoVacunas());//Llamada a método
	    System.setIn(sysInBackup);
	    Assert.assertTrue(true);
	}

	@Test
	public void testCalcularReparto() throws DAOException, ControllerException {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("2\n1\n".getBytes());
		System.setIn(in);
	    PantallaGestionSistemaSaludNacional.calcularReparto(new GestorRepartoVacunas());//Llamada a método
	    System.setIn(sysInBackup);
	    Assert.assertTrue(true); 
	    
	}

}
