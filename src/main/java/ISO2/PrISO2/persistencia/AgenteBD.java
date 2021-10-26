package ISO2.PrISO2.persistencia;

import java.sql.*;

public class AgenteBD {
	protected static AgenteBD mInstancia = null;
	protected static Connection conn;
	private static String url = "jdbc:derby:directory:myDB";//"jdbc:derby:directory:myDB;create=true";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	// Constructor
	public AgenteBD() throws Exception {
		conectarBD();
	}

	public static void conectarBD() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	
	public static void main(String[] args) throws Exception {
		crearBD();
	}
	
	public static void crearBD() throws Exception {
		Class.forName(driver);
		String urlCreate = "jdbc:derby:directory:myDB;create=true";

		Connection conn = DriverManager.getConnection(urlCreate);
		conn.createStatement().execute(
				"create table tipoVacuna(nombre varchar(30), farmaceutica varchar(30), fechaAprobacion date, primary key(farmaceutica))");
		conn.createStatement().execute(
				"create table paciente(dni varchar(30), nombre varchar(30), apellidos varchar(30), region varchar(30), grupoPrioridad varchar(30), primary key(dni))");
		conn.createStatement().execute(
				"create table lote(id varchar(30), fecha date, cantidad int, nombre_tipoVacuna varchar(30), primary key(id))");
				//+ "constraint nombre_tipoVacuna foreign key references tipoVacuna(farmaceutica))");
		conn.createStatement().execute(
				"create table entrega(fecha date, cantidad int, idLote varchar(30), region varchar(30), grupoPrioridad varchar(30))"); //Clave foranea sin primaria??
		//		+ "constraint idLote foreign key references lote(id))");
		conn.createStatement().execute(
				"create table vacunacion(fecha date, isSegundaDosis boolean, nombre_tipovacuna varchar(30), dni_paciente varchar(30))");
				//+ "constraint nombre_tipovacuna foreign key references tipoVacuna(farmaceutica), "
				//+ "constraint dni_paciente foreign key references paciente(dni))"); //Lío
		

		conn.createStatement().execute("insert into tipoVacuna values "
				+ "('BNT162b2', 'Pfizer', '2021-05-23'),"
				+ "('SPIKEVAX', 'Moderna', '2021-07-03'),"
				+ "('VAXZEVRIA', 'Astrazeneca', '2021-04-30')");
		conn.createStatement().execute("insert into paciente values "
				+ "('223456', 'Agustin', 'Hernando', 'Asturias', '>80'),"
				+ "('534534', 'Antonio', 'Fernandez', 'Murcia', '60-70'),"
				+ "('645454', 'Rocio', 'Calatrava', 'Andalucia', '>80'),"
				+ "('123656', 'Rosa', 'Torrenova', 'CLM', '50-60')");
		conn.createStatement().execute("insert into lote values "
				+ "('153456', '2021-05-24', 5, 'Astrazeneca'),"
				+ "('485667', '2021-07-04', 500, 'Pfizer'),"
				+ "('194563', '2021-09-16', 300, 'Pfizer'),"
				+ "('477687', '2021-08-24', 3000, 'Moderna')");
		conn.createStatement().execute("insert into entrega values "
				+ "('2021-05-23', 5, '153456', 'Asturias', '>80'),"
				+ "('2021-07-03', 500, '485667', 'CLM', '50-60'),"
				+ "('2021-09-15', 300, '194563', 'Murcia', '60-70'),"
				+ "('2021-08-23', 3000, '477687', 'Andalucia', '>80')");
		conn.createStatement().execute("insert into vacunacion values "
				+ "('2021-05-26', False, 'Astrazeneca', '223456'),"
				+ "('2021-04-24', True, 'Pfizer', '123656'),"
				+ "('2021-02-23', True, 'Moderna', '645454'),"
				+ "('2021-06-12', True, 'Pfizer', '534534')");
			
//	!!	private static String url = "jdbc:derby:directory:myDB;create=true";
	}

	public static void desconectarBD() throws Exception {
		conn.close();
	}

	/**
	 * 
	 * @param sql
	 */

	public static ResultSet select(String sql) throws Exception {
		try {
			conectarBD();
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql);
			stat.close();
			desconectarBD();
			return res;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		
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

}