package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.entitymodel.Paciente;
import dominio.entitymodel.Vacunacion;

public class VacunacionDAO implements DAO<Vacunacion> {
	final String insert = "INSERT INTO vacunacion(fecha, isSegundaDosis, nombre_tipovacuna, dniPaciente, nombre, apellidos, region, grupoPrioridad) VALUES(";
	final String update = "UPDATE vacunacion SET ";
	final String delete = "DELETE FROM vacunacion WHERE dniPaciente=";
	final String getall = "SELECT * FROM vacunacion";
	final String getregion = "SELECT * FROM vacunacion WHERE region=";
	final String getone = "SELECT * FROM vacunacion WHERE dniPaciente=";
	final String whereid = "WHERE dniPaciente=";

	public VacunacionDAO() throws Exception {

	}

	@Override
	public Vacunacion get(String dni) throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		try {
			rs = AgenteBD.select(getone + "'" + dni + "'");
			String tipoVacuna = rs.getString(3);
			Date fecha = rs.getDate(1);
			LocalDate fecha1 = fecha.toLocalDate();
			Boolean segDosis = rs.getBoolean(2);
			String nombre = rs.getString(5);
			String apellidos = rs.getString(6);
			String region = rs.getString(7);
			String grupo = rs.getString(8);
			Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
			Vacunacion vacunacion = new Vacunacion(tipoVacuna, fecha1, segDosis, paciente);

			return vacunacion;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
	}

	@Override
	public int insert(Vacunacion v) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		i = AgenteBD.iud(insert + "'" + v.getFecha() + "'" + "," + v.isSegundaDosis() + "," + "'" + v.getVacuna()
				+ "'" + "," + "'" + v.paciente.getDni() + "'" + "," + "'" + v.paciente.getNombre() + "'" + "," + "'"
				+ v.paciente.getApellidos() + "'" + "," + "'" + v.paciente.getRegion() + "'" + "," + "'"
				+ v.paciente.getGrupo() + "'" + ")");
		if (i == 0) {
			throw new DAOException("Puede que no se haya insertado.");
		}
		AgenteBD.desconectarBD();
		System.out.println("Se ha insertado una nueva vacunación con dni: "+v.paciente.getDni());
		return i;
	}

	@Override
	public Vacunacion update(Vacunacion v) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		i = AgenteBD.iud(update + "segDosis=" + true + whereid + "'" + v.getdni() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya actualizado.");
		}
		AgenteBD.desconectarBD();
		return v;
	}

	@Override
	public int delete(Vacunacion v) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		i = AgenteBD.iud(delete + v.getdni());
		if (i == 0) {
			throw new DAOException("Puede que no se haya borrado.");
		}
		AgenteBD.desconectarBD();
		return i;
	}

	public void insertarVacunacion(Vacunacion v) throws Exception {
		if (insert(v) != 0) {
			System.out.println("Registro completado con éxito");
		} else
			System.out.println("Registro no completado con éxito");
	}

	private Vacunacion convertir(ResultSet rs) throws Exception {
		String dni = rs.getString(4);
		String tipoVacuna = rs.getString(3);
		Date fecha = rs.getDate(1);
		Boolean segDosis = rs.getBoolean(2);
		LocalDate fecha1 = fecha.toLocalDate();
		String nombre = rs.getString(5);
		String apellidos = rs.getString(6);
		String region = rs.getString(7);
		String grupo = rs.getString(8);
		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
		Vacunacion vacunacion = new Vacunacion(tipoVacuna, fecha1, segDosis, paciente);

		return vacunacion;
	}

	public List<Vacunacion> seleccionarVacunaciones() throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		List<Vacunacion> vacunaciones = new ArrayList<Vacunacion>();
		try {
			rs = AgenteBD.select(getall);
			while (rs.next()) {
				vacunaciones.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		// AgenteBD.desconectarBD();
		return vacunaciones;
	}
	

	public List<Vacunacion> seleccionarVacunaciones(String region) throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		List<Vacunacion> vacunaciones = new ArrayList<Vacunacion>();
		try {
			rs = AgenteBD.select(getregion + "'" + region + "'");
			while (rs.next()) {
				vacunaciones.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		AgenteBD.desconectarBD();
		return vacunaciones;
	}
}