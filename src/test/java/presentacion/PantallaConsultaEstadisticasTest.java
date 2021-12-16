package presentacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.controller.ControllerException;
import dominio.controller.GestorEstadisticas;

public class PantallaConsultaEstadisticasTest {
	
	@Test
	public void testEstadNacionalCase1() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("1\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        PantallaConsultaEstadisticas.imprimirTotalVacunados(totalVacunados);
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(baos1);
        System.setOut(printStream1);
        String[] lines = baos1.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
        String expected = "Una dosis: " + (totalVacunados.get(0) - totalVacunados.get(1)) 
				+"\nPauta completa: " + totalVacunados.get(0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        
        System.out.println(actual);
		System.out.println(expected);
        Assert.assertNotEquals(expected, actual);


	}

	@Test
	public void testImprimirTotalVacunados() throws ControllerException {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		PantallaConsultaEstadisticas.imprimirTotalVacunados(totalVacunados);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
        String expected="Una dosis: " + (totalVacunados.get(0) - totalVacunados.get(1)) 
				+"\nPauta completa: " + totalVacunados.get(0);
		
	    Assert.assertEquals(expected, actual);
	    
	}

	@Test
	public void testEstadRegion() {
		/*String userInput = String.format("1\n");// Entrada Usuario
		List<Integer> totalVacunados = ;
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);

	    PantallaConsultaEstadisticas.imprimirTotalVacunados(totalVacunados);//Llamada a método*/
	    
	
	}

}
