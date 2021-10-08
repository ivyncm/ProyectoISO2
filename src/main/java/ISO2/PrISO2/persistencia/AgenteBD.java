package ISO2.PrISO2.persistencia;

import java.sql.*;

public class AgenteBD {
	protected static AgenteBD mInstancia = null;
	protected static Connection conn;
	private static String url = "jdbc:derby:directory:myDB";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	// Constructor
	public AgenteBD() throws Exception {
		conectarBD();
	}

	public void conectarBD() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public void crearBD() throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url);
		conn.createStatement().execute(
				"create table entrega(id int, tipoVacuna varchar(30), region varchar(30), grupoPrioridad varchar(30), lote varchar(45), fecha date, cantidad int, primary key(id))");
		conn.createStatement().execute("insert into entrega values "
				+ "(123456, 'Astrazeneca, 'Madrid', 'Ancianos', 'ADZG145', 2021-05-23, 5),"
				+ "(435667, 'Astrazeneca, 'Cataluña', 'Jovenes', 'ADRT345', 2021-07-03, 500)"
				+ "(134563, 'Pfizer, 'Andalucia', 'Niños', 'HBV123345', 2021-09-15, 300)"
				+ "(457687, 'Pfizer, 'Murcia', 'Adultos', 'HBV128745', 2021-08-23, 3000)");
		
//	!!	private static String url = "jdbc:derby:directory:myDB;create=true";
	}

	public void desconectarBD() throws Exception {
		conn.close();
	}

	/**
	 * 
	 * @param sql
	 */

	public ResultSet select(String sql) throws Exception {
		conectarBD();
		Statement stat = conn.createStatement();
		ResultSet res = stat.executeQuery(sql);
		stat.close();
		desconectarBD();
		return res;
	}

	/**
	 * 
	 * @param sql
	 */
	public int insert(String sql) throws Exception {
		conectarBD();
		PreparedStatement stat = conn.prepareStatement(sql);
		int res = stat.executeUpdate();
		stat.close();
		desconectarBD();
		return res;
	}

	/**
	 * 
	 * @param sql
	 */
	public int update(String sql) throws Exception {
		conectarBD();
		PreparedStatement stat = conn.prepareStatement(sql);
		int res = stat.executeUpdate();
		stat.close();
		desconectarBD();
		return res;
	}

	/**
	 * 
	 * @param sql
	 */
	public int delete(String sql) throws Exception {
		conectarBD();
		PreparedStatement stat = conn.prepareStatement(sql);
		int res = stat.executeUpdate();
		stat.close();
		desconectarBD();
		return res;
	}
	
	public void main (String args[]) {
		crearBD();
		
	}

}