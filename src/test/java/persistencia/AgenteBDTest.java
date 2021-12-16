package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class AgenteBDTest {

	@Test
	public void testConectarBD() throws DAOException, SQLException {
		AgenteBD agente = new AgenteBD();
		agente.conectarBD();

		Connection actual = agente.getConn();
		Assert.assertFalse(actual.isClosed());
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
	public void testDesconectarBD() throws DAOException, SQLException {	
		AgenteBD agente = new AgenteBD();
		agente.conectarBD();
		agente.desconectarBD();

		Connection actual = agente.getConn();
		Assert.assertTrue(actual.isClosed());
	}

	@Test
	public void testSelect() throws DAOException {
		AgenteBD agente = new AgenteBD();
		agente.conectarBD();
		ResultSet res = agente.select("SELECT * FROM entrega");
		Assert.assertNotEquals(res, null);
	}

	@Test
	public void testIudInsert() throws DAOException {
		AgenteBD agente = new AgenteBD();
		int res = agente.iud("INSERT INTO lote(id, fecha, cantidad, nombre_TipoVacuna) VALUES('sdsd515','" + LocalDate.now() + "', 50,'Pfizer')");
		Assert.assertNotEquals(res, 0);
	}
	@Test
	public void testIudUpdate() throws DAOException {
		AgenteBD agente = new AgenteBD();
		int res = agente.iud("UPDATE lote SET cantidad=50 WHERE id='sdsd515'");
		Assert.assertNotEquals(res, 0);
	}
	@Test
	public void testIudDelete() throws DAOException {
		AgenteBD agente = new AgenteBD();
		int res = agente.iud("DELETE FROM lote WHERE id='sdsd515'");
		Assert.assertNotEquals(res, 0);
	}

}
