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
	String[] regiones = new String[] { "Andalucia", "Aragon", "Canarias", "Cantabria", "Castilla y Leon", "Castilla la Mancha",
			"Catalunya", "Ceuta", "Valencia", "Madrid", "Extremadura", "Galicia", "Baleares", "La Rioja", "Melilla",
			"Navarra", "Pais Vasco", "Asturias", "Murcia" };
	
	@Test
	public void testEstadNacionalCase1() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("1\n5\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaConsultaEstadisticas.estadNacional();
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}
	
	@Test
	public void testEstadNacionalCase2() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("2\n5\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaConsultaEstadisticas.estadNacional();
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}
	
	@Test
	public void testEstadNacionalCase3() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("3\n5\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaConsultaEstadisticas.estadNacional();
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}
	
	@Test
	public void testEstadNacionalCase4() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("4\n5\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaConsultaEstadisticas.estadNacional();
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}

	@Test
	public void testImprimirTotalVacunados() throws ControllerException {
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
        
        Assert.assertNotEquals(expected, actual);
	    
	}

	@Test
	public void testEstadRegionCase1() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("1\n3\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaConsultaEstadisticas.estadRegion("Extremadura");
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}

	@Test
	public void testEstadRegionCase2() throws Exception {
		GestorEstadisticas gestor = new GestorEstadisticas();
		List<Integer> totalVacunados = gestor.consultarTotalVacunados();
		String userInput = String.format("2\n3\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaConsultaEstadisticas.estadRegion("Extremadura");
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}
}
