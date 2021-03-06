import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import persistencia.DAOException;

public class crearBD {

	public void main(String[] args) throws DAOException{
		try {
			crearBD();
		} catch (DAOException ex) {
			throw new DAOException("Error desconectando...", ex);
		}
	}

	public void crearBD() throws DAOException{
		String urlCreate = "jdbc:derby:directory:myDB;create=true";
		try (Connection conn = DriverManager.getConnection(urlCreate)){
			Class.forName(driver);
			crearTablas();
		} catch (SQLException | ClassNotFoundException ex) {
			throw new DAOException("Error creando la base de datos...", ex);
		}
	}
	public void crearTablas() throws DAOException {
		try (Statement stat = conn.createStatement()){
			stat.execute(
					"create table lote(id varchar(30), fecha date, cantidad int, nombre_tipoVacuna varchar(30), primary key(id))");
			stat.execute(
					"create table entrega(fecha date, cantidad int, idLote varchar(30), region varchar(30), grupoPrioridad varchar(30))");
			stat.execute(
					"create table vacunacion(fecha date, isSegundaDosis boolean, nombre_tipovacuna varchar(30), dni_paciente varchar(30), nombre varchar(30), apellidos varchar(30), region varchar(30), grupoPrioridad varchar(30))");
	
			stat.execute("insert into lote values " + "('153456', '2021-05-24', 5, 'Astrazeneca'),"
							+ "('485667', '2021-07-04', 500, 'Pfizer')," + "('194563', '2021-09-16', 300, 'Pfizer'),"
							+ "('477687', '2021-08-24', 3000, 'Moderna')");
			stat.execute("insert into entrega values " + "('2021-05-23', 5, '153456', 'Asturias', 'Anciano'),"
							+ "('2021-07-03', 500, '485667', 'CLM', 'Joven'),"
							+ "('2021-09-15', 300, '194563', 'Murcia', 'Adulto'),"
							+ "('2021-08-23', 3000, '477687', 'Andalucia', 'Anciano')");
			stat.execute("insert into vacunacion values "
					+ "('2021-05-26', False, 'Astrazeneca', '223456', 'Agustin', 'Hernando', 'Asturias', 'Anciano'),"
					+ "('2021-04-24', True, 'Pfizer', '123656', 'Rosa', 'Torrenova', 'CLM', 'Joven'),"
					+ "('2021-02-23', True, 'Moderna', '645454', 'Rocio', 'Calatrava', 'Andalucia', 'Anciano'),"
					+ "('2021-06-12', True, 'Pfizer', '534534', 'Antonio', 'Fernandez', 'Murcia', 'Adulto')");
		} catch(SQLException ex) {
			throw new DAOException("Error creando las tablas de base de datos...", ex);
		}
	}

}
