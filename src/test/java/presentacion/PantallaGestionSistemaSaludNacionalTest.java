package presentacion;

import java.io.ByteArrayInputStream;

import org.junit.Assert;
import org.junit.Test;

public class PantallaGestionSistemaSaludNacionalTest {

	@Test
	public void testMenuCase1() throws Exception {
		String userInput = String.format("1\n1\n2000\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaGestionSistemaSaludNacional.menu();
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}
	
	@Test
	public void testMenuCase2() throws Exception {
		String userInput = String.format("2\n1\n2\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        int res = PantallaGestionSistemaSaludNacional.menu();
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}

}
