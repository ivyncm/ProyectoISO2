package presentacion;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Assert;

public class AuxiliaresTest {

	@Test
	public void testSegDosisS() {
		Scanner teclado = new Scanner(System.in);
		String userInput = String.format("s\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        boolean segDosis=Auxiliares.segDosis(teclado);//Llamada a método

        System.setIn(bais);		 
		boolean expected=true;
		Assert.assertEquals(expected, segDosis);
	}
	@Test
	public void testSegDosisN() {
		Scanner teclado = new Scanner(System.in);
		String userInput = String.format("n\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        boolean segDosis=Auxiliares.segDosis(teclado);//Llamada a método

        System.setIn(bais);		 
		boolean expected=false;
		Assert.assertEquals(expected, segDosis);
	}
	/*
	@Test
	public void testSegDosisDefault() {
		String userInput = String.format("a\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        boolean segDosis = Auxiliares.segDosis();//Llamada a método

        System.setIn(bais);		 
        boolean expected = false;
		Assert.assertEquals(expected, segDosis);
	}
	 */
	@Test
	public void testDniValido() {
		String dni="09086774F";
		boolean expected=false;
		Assert.assertEquals(expected, Auxiliares.dniValido(dni));
	}
	@Test
	public void testDniValidoFalseUno() {
		String dni="0908677343F";
		boolean expected=true;
		Assert.assertEquals(expected, Auxiliares.dniValido(dni));
	}
	@Test
	public void testDniValidoFalseDos() {
		String dni="0908677FF";
		boolean expected=true;
		Assert.assertEquals(expected, Auxiliares.dniValido(dni));
	}
	@Test
	public void testDniValidoFalseTres() {
		String dni="087644324";
		boolean expected=true;
		Assert.assertEquals(expected, Auxiliares.dniValido(dni));
	}
	@Test
	public void testSoloLetras() {
		boolean expected=false;
		Assert.assertEquals(expected, Auxiliares.soloLetras("hola"));
	}
	@Test
	public void testSoloLetrasTrue() {
		boolean expected=true;
		Assert.assertEquals(expected, Auxiliares.soloLetras("h2la"));
	}

	@Test
	public void testRegion() {
		String userInput = String.format("1");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String region=Auxiliares.Region();//Llamada a método

        System.setIn(bais);		 
		String expected="Andalucia";
		Assert.assertEquals(expected, region);
	}
	/*
	@Test
	public void testRegionNoValida() {
		String userInput = String.format("109");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String region=Auxiliares.Region();//Llamada a método

        System.setIn(bais);		 
		String expected="Opcion no valida\n";
		Assert.assertEquals(expected, region);
	}
	*/
	@Test
	public void testMenu3CadenasGrupoAnciano() {
        Scanner teclado = new Scanner(System.in);
		String userInput = String.format("1");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo, teclado);//Llamada a método

        System.setIn(bais);		 
		String expected="Anciano";
		Assert.assertEquals(expected, palabra);
	}
	@Test
	public void testMenu3CadenasGrupoAdulto() {
        Scanner teclado = new Scanner(System.in);
		String userInput = String.format("2");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo, teclado);//Llamada a método

        System.setIn(bais);		 
		String expected="Adulto";
		Assert.assertEquals(expected, palabra);
	}
	@Test
	public void testMenu3CadenasGrupoJoven() {
        Scanner teclado = new Scanner(System.in);
		String userInput = String.format("3");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo, teclado);//Llamada a método

        System.setIn(bais);		 
		String expected="Joven";
		Assert.assertEquals(expected, palabra);
	}
	/*
	@Test
	public void testMenu3CadenasGrupoNoValido() {
		String userInput = String.format("4");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo);//Llamada a método

        System.setIn(bais);		 
		String expected="Opcion no valida\n";
		Assert.assertEquals(expected, palabra);
	}
	*/
	@Test
	public void testMenu3CadenasTipoAnciano() {
        Scanner teclado = new Scanner(System.in);
		String userInput = String.format("1");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String palabra = Auxiliares.menu3Cadenas(Auxiliares.cadenaTipo, teclado);//Llamada a método

        System.setIn(bais);		 
		String expected="Pfizer";
		Assert.assertEquals(expected, palabra);
	}
	@Test
	public void testMenu3CadenasTipoAdulto() {
        Scanner teclado = new Scanner(System.in);
		String userInput = String.format("2");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaTipo, teclado);//Llamada a método

        System.setIn(bais);		 
		String expected="Moderna";
		Assert.assertEquals(expected, palabra);
	}
	@Test
	public void testMenu3CadenasTipoJoven() {
        Scanner teclado = new Scanner(System.in);
		String userInput = String.format("3");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaTipo, teclado);//Llamada a método

        System.setIn(bais);		 
		String expected="Astrazeneca";
		Assert.assertEquals(expected, palabra);
	}
	/*
	@Test
	public void testMenu3CadenasTipoNoValido() {
		String userInput = String.format("4");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String palabra=Auxiliares.menu3Cadenas(Auxiliares.cadenaTipo);//Llamada a método

        System.setIn(bais);		 
		String expected="Opcion no valida\n";
		Assert.assertEquals(expected, palabra);
	}
	*/
}
