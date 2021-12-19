package presentacion;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import dominio.entitymodel.Paciente;

public class PantallaGestionSistemaRegionalSaludTest {
	Scanner teclado = new Scanner(System.in);

	@Test
	public void testMenuCase1() throws Exception {
		String userInput = String.format("1\n1000\n1\n");// Entrada Usuario
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        String region = "Murcia";
        
        int res = PantallaGestionSistemaRegionalSalud.menu(region);
        
        int expected = 0;
        
        Assert.assertEquals(expected, res);
	}

	@Test
    public void testDatosPaciente() {
        String userInput = String.format("04672354G\nGregorio\nAlvarez\nGonzalez\n2\n");
        String grupo="Adulto";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Paciente pacienteExpected=PantallaGestionSistemaRegionalSalud.DatosPaciente("Murcia");

        Paciente paciente = new Paciente("04672354G", "Gregorio", "Alvarez Gonzalez", grupo, "Murcia");
        Assert.assertEquals(paciente, pacienteExpected);
    }

}
