package presentacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PantallaConsultaEstadisticasTest {

	@Test
	public void testEstadNacional() {
		

	}

	@Test
	public void testImprimirTotalVacunados() {
		List<Integer> totalVacunados = null;
		String userInput = String.format("4\n");// Entrada Usuario
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);

	    PantallaConsultaEstadisticas.imprimirTotalVacunados(totalVacunados);//Llamada a método
	    
	    Assert.assertTrue(true);

	}

	@Test
	public void testEstadRegion() {
		String userInput = String.format("1\n");// Entrada Usuario
		List<Integer> totalVacunados = ;
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(bais);
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);

	    PantallaConsultaEstadisticas.imprimirTotalVacunados(totalVacunados);//Llamada a método
	    
		
	}

}
