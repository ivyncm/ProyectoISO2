package presentacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.Vacunacion;

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

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método

	    String[] actual = baos.toString().split(System.lineSeparator());
	    String expected = "Sesión cerrada\n";
	    Assert.assertEquals(expected, actual);	
    }
	
	@Test
	public void testMenuNuevaEntrega() throws Exception {
		
		String userInput = String.format("1\n50\n2\n");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);
	    
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método
	    
	    EntregaVacunas expected = new EntregaVacunas("Adulto", LocalDate.now(), 50, region);

	    List<EntregaVacunas> entregas = expected.getEntregaDao().seleccionarEntregas(region);
	    EntregaVacunas actual = entregas.get(entregas.size()-1);
	    
	    expected.setLote(actual.getLote());
		
		Assert.assertTrue(expected.equals(actual));
    }
	
	@Test
	public void testMenuRegVacunacion() throws Exception {
		
		String menu = "2";
		String tipo = "1";
		String segDosis = "n";
		String dni = "02334562F";
		String nombre = "Arturo";
		String apellido1 = "Martin";
		String apellido2 = "Gomez";
		String grupo = "2";
		
		String userInput = String.format(menu + "\n" + tipo + "\n" + segDosis + "\n" + dni + "\n" + nombre + "\n" + apellido1 + "\n" + apellido2 + "\n" + grupo);// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);
	    
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método
	    
	    Paciente paciente = new Paciente(dni, nombre, apellido1+" "+apellido2, "Adulto", region);
	    Vacunacion expected = new Vacunacion("Pfizer", LocalDate.now(), false, paciente);

	    List<Vacunacion> vacunaciones = expected.getVacunacionDao().seleccionarVacunaciones(region);
	    Vacunacion actual = vacunaciones.get(vacunaciones.size()-1);
	    
		Assert.assertTrue(expected.equals(actual));
    }
	
	@Test
	public void testMenuEstadisticas() throws Exception {
		
		String userInput = String.format("4");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String region = "Murcia";
	    PantallaGestionSistemaRegionalSalud.menu(region);//Llamada a método

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String expected = "Bienvenido al Sistema Consulta de Estadisticas\n" + "seleccione una categoria de su interes\n"
	    		+ "1 - Consultar total vacunados\n"
				+ "2 - Consultar total vacunados por region\n"
				+ "3 - Consultar porcentajes vacunados sobre recibidas\n"
				+ "4 - Consultar porcentajes vacunados sobre recibidas en region\n"
				+ "5 - Volver";
	    Assert.assertEquals(lines, expected);	
	   }

	@Test
	public void testDatosPaciente() {
		String dni = "02334562F";
		String nombre = "Arturo";
		String apellido1 = "Martin";
		String apellido2 = "Gomez";
		String grupo = "2";
		
		String userInput = String.format(dni + "\n" + nombre + "\n" + apellido1 + "\n" + apellido2 + "\n" + grupo);// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);
	    
	    String region = "Murcia";
	    Paciente actual = PantallaGestionSistemaRegionalSalud.DatosPaciente(region);//Llamada a método
	    
	    Paciente expected = new Paciente(dni, nombre, apellido1+" "+apellido2, "Adulto", region);
	    
		Assert.assertTrue(expected.equals(actual));
	}

}
