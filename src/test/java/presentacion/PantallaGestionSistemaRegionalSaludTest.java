package presentacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PantallaGestionSistemaRegionalSaludTest {

	@Test
	public void testMain() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSalir() throws Exception {
		
		String userInput = String.format("4");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);

	    String expected = "Sesión cerrada\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String exit = "Sesión cerrada\n";
	    Assert.assertEquals(exit, exit);	}
	
	@Test
	public void testNuevaEntrega() throws Exception {
		
		String userInput = String.format("1");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);

	    String expected = "Sesión cerrada\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String exit = "Sesión cerrada\n";
	    Assert.assertEquals(exit, );	}
	
	@Test
	public void testRegVacunacion() throws Exception {
		
		String userInput = String.format("4");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);

	    String expected = "Sesión cerrada\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String exit = "Sesión cerrada\n";
	    Assert.assertEquals(exit, );	}
	
	@Test
	public void testEstadisticas() throws Exception {
		
		String userInput = String.format("4");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);

	    String expected = "Sesión cerrada\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String exit = "Sesión cerrada\n";
	    Assert.assertEquals(exit, );	}

	@Test
	public void testDatosPaciente() {
		throw new RuntimeException("not yet implemented");
	}

}
