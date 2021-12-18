package persistencia;

import java.sql.*;

public class AgenteBD {
	private Connection conn = null;
	private static String url = "jdbc:derby:directory:myDB";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void conectarBD() throws DAOException{
		try {
			Class.forName(driver);
			setConn(DriverManager.getConnection(url));
		} catch (ClassNotFoundException | SQLException ex) {
			throw new DAOException("Error conectando...", ex);
		}
	}


	public void desconectarBD() throws DAOException{
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
	 * @throws SQLException 
	 */
	public ResultSet select(String sql) throws DAOException{
		ResultSet res;
		try {
			Statement stat = conn.createStatement();
			res = stat.executeQuery(sql);
			return res;
		} catch (SQLException ex) {
			throw new DAOException("Error en select SQL", ex);
		}
	}

	/**
	 * 
	 * @param sql
	 */
	//INSERT,UPDATE,DELETE
	public int iud(String sql) throws DAOException {
		conectarBD();
		try (PreparedStatement stat = conn.prepareStatement(sql)){
			int res = stat.executeUpdate();
			return res;
		}catch (SQLException ex) {
			throw new DAOException("Error en sentencia SQL", ex);
		}finally {
			desconectarBD();
		}
	}
}