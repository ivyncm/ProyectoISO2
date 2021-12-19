package presentacion;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;

public class AuxiliaresTest {
	Scanner teclado = new Scanner(System.in);
	@Test
	public void testSegDosisS() {
		String userInput = String.format("s\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        boolean segDosis=Auxiliares.segDosis();//Llamada a método

        System.setIn(bais);		 
		boolean expected=true;
		Assert.assertEquals(expected, segDosis);
	}
	@Test
	public void testSegDosisN() {
		//Scanner teclado = new Scanner(System.in);
		String userInput = String.format("n\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        boolean segDosis=Auxiliares.segDosis();//Llamada a método

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
	
}
