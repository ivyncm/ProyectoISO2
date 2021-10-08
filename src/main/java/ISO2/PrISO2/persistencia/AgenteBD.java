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
				"create table entrega(fecha date, cantidad int" //Clave foranea sin primaria??
				+ "constraint fecha foreign key references lote(fecha))");
		conn.createStatement().execute(
				"create table lote(id int, fecha date, cantidad int, farmaceutica varchar(30), primary key(id))");
		conn.createStatement().execute(
				"create table tipoVacuna(nombre varchar(30), farmaceutica varchar(30), fechaAprobacion varchar(30), primary key(nombre), "
				+ "constraint farmaceutica foreign key references lote(farmaceutica))");
		conn.createStatement().execute(
				"create table vacunacion(fecha date, isSegundaDosis int, nombre_tipovacuna varchar(30), dni_paciente varchar(30), "
				+ "constraint nombre_tipovacuna foreign key references tipoVacuna(nombre)"
				+ "constraint dni_paciente foreign key references paciente(dni))"); //Lío
		conn.createStatement().execute(
				"create table paciente(dni varchar(30), nombre varchar(30), apellidos varchar(30), primary key(dni))");
		
		
		conn.createStatement().execute("insert into entrega values "
				+ "(2021-05-23, 5),"
				+ "(2021-07-03, 500)"
				+ "(2021-09-15, 300)"
				+ "(2021-08-23, 3000)");
		conn.createStatement().execute("insert into lote values "
				+ "(153456, 2021-05-24, 5, 'Astrazeneca'),"
				+ "(485667, 2021-07-04, 500, 'Pfizer')"
				+ "(194563, 2021-09-16, 300, 'Pfizer')"
				+ "(477687, 2021-08-24, 3000, 'Moderna')");
		conn.createStatement().execute("insert into vacunacion values "
				+ "(2021-05-26, 0, 'ARM', 223456)"
				+ "(2021-04-24, 1, 'ARM', 123656)"
				+ "(2021-02-23, 1, 'ARM', 645454)"
				+ "(2021-06-12, 1, 'ARM', 534534)");
		conn.createStatement().execute("insert into tipoVacuna values "
				+ "('ARM', 'Pfizer', '2021/05/23'),"
				+ "('ARM', 'Astrazeneca', '2021/07/03')"
				+ "('ARM', 'Pfizer', '2021/06/34')"
				+ "('ARM', 'Astrazeneca', '2021/04/30')");
		conn.createStatement().execute("insert into paciente values "
				+ "(223456, 'Agustin', 'Hernando'),"
				+ "(534534, 'Antonio', 'Fernandez')"
				+ "(645454, 'Rocio', 'Calatrava')"
				+ "(123656, 'Rosa', 'Torrenova')");
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
	
	public void main (String args[]) throws Exception {
		crearBD();
		
	}

}