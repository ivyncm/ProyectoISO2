package persistencia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class AgenteBDTest {

	@Test
	public void testConectarBD() throws DAOException {
		AgenteBD.conectarBD();
		
		String expected = "";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMain() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testCrearBD() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testCrearTablas() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDesconectarBD() throws DAOException {
		AgenteBD.desconectarBD();
		
		String expected = "";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSelect() throws DAOException {
		ResultSet res = AgenteBD.select("SELECT * FROM entrega");
		Assert.assertNotEquals(res, null);
	}

	@Test
	public void testIudInsert() throws DAOException {
		int res = AgenteBD.iud("INSERT INTO lote(id, fecha, cantidad, nombre_TipoVacuna) VALUES('sdsd515','" + LocalDate.now() + "', 50,'Pfizer')");
		Assert.assertNotEquals(res, 0);
	}
	@Test
	public void testIudUpdate() throws DAOException {
		int res = AgenteBD.iud("UPDATE lote SET cantidad=50 WHERE id='sdsd515'");
		Assert.assertNotEquals(res, 0);
	}
	@Test
	public void testIudDelete() throws DAOException {
		int res = AgenteBD.iud("DELETE FROM lote WHERE id='sdsd515'");
		Assert.assertEquals(res, 1);
	}

}
