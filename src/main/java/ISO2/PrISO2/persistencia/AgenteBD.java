package ISO2.PrISO2.persistencia;

import java.sql.*;

public class AgenteBD {
	protected static AgenteBD mInstancia = null;
	protected static Connection conn;
	private static String url = "jdbc:derby:directory:myDB";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	// Constructor
	public AgenteBD() throws DAOException{
		conectarBD();
	}

	public static void conectarBD() throws DAOException{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new DAOException("Error conectando...", ex);
		}
	}

	public static void main(String[] args) throws DAOException{
		try {
			crearBD();
		} catch (DAOException ex) {
			throw new DAOException("Error desconectando...", ex);
		}
	}

	public static void crearBD() throws DAOException{
		String urlCreate = "jdbc:derby:directory:myDB;create=true";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(urlCreate);
			conn.createStatement().execute(
					"create table lote(id varchar(30), fecha date, cantidad int, nombre_tipoVacuna varchar(30), primary key(id))");
			conn.createStatement().execute(
					"create table entrega(fecha date, cantidad int, idLote varchar(30), region varchar(30), grupoPrioridad varchar(30))");
			conn.createStatement().execute(
					"create table vacunacion(fecha date, isSegundaDosis boolean, nombre_tipovacuna varchar(30), dni_paciente varchar(30), nombre varchar(30), apellidos varchar(30), region varchar(30), grupoPrioridad varchar(30))");
	
			conn.createStatement()
					.execute("insert into lote values " + "('153456', '2021-05-24', 5, 'Astrazeneca'),"
							+ "('485667', '2021-07-04', 500, 'Pfizer')," + "('194563', '2021-09-16', 300, 'Pfizer'),"
							+ "('477687', '2021-08-24', 3000, 'Moderna')");
			conn.createStatement()
					.execute("insert into entrega values " + "('2021-05-23', 5, '153456', 'Asturias', 'Anciano'),"
							+ "('2021-07-03', 500, '485667', 'CLM', 'Joven'),"
							+ "('2021-09-15', 300, '194563', 'Murcia', 'Adulto'),"
							+ "('2021-08-23', 3000, '477687', 'Andalucia', 'Anciano')");
			conn.createStatement().execute("insert into vacunacion values "
					+ "('2021-05-26', False, 'Astrazeneca', '223456', 'Agustin', 'Hernando', 'Asturias', 'Anciano'),"
					+ "('2021-04-24', True, 'Pfizer', '123656', 'Rosa', 'Torrenova', 'CLM', 'Joven'),"
					+ "('2021-02-23', True, 'Moderna', '645454', 'Rocio', 'Calatrava', 'Andalucia', 'Anciano'),"
					+ "('2021-06-12', True, 'Pfizer', '534534', 'Antonio', 'Fernandez', 'Murcia', 'Adulto')");
		} catch (SQLException | ClassNotFoundException ex) {
			throw new DAOException("Error creando la base de datos...", ex);
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new DAOException("Error desconectando...", ex);
			}
		}
	}

	public static void desconectarBD() throws DAOException{
		try {
			conn.close();
		} catch (SQLException ex) {
			throw new DAOException("Error desconectando...", ex);
		}
	}

	/**
	 * 
	 * @param sql
	 * @throws DAOException 
	 */
	public static ResultSet select(String sql) throws DAOException{
		try {
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql);
			return res;
		} catch (SQLException ex) {
			throw new DAOException("Error en select SQL", ex);
		}finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new DAOException("Error desconectando...", ex);
			}
		}
	}

	/**
	 * 
	 * @param sql
	 */
	public int insert(String sql) throws DAOException{
		conectarBD();
		PreparedStatement stat;
		try {
			stat = conn.prepareStatement(sql);
			int res = stat.executeUpdate();
			stat.close();
			desconectarBD();
			return res;
		} catch (SQLException ex) {
			throw new DAOException("Error en insert SQL", ex);
		}finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new DAOException("Error desconectando...", ex);
			}
		}
	}

	/**
	 * 
	 * @param sql
	 */
	public int update(String sql) throws DAOException {
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			int res = stat.executeUpdate();
			return res;
		} catch (SQLException ex) {
			throw new DAOException("Error en update SQL", ex);
		}finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new DAOException("Error desconectando...", ex);
			}
		}
	}

	/**
	 * 
	 * @param sql
	 */
	public int delete(String sql) throws DAOException {
		conectarBD();
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			int res = stat.executeUpdate();
			stat.close();
			desconectarBD();
			return res;
		}catch (SQLException ex) {
			throw new DAOException("Error en delete SQL", ex);
		}finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new DAOException("Error desconectando...", ex);
			}
		}
		
	}
}