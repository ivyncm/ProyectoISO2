package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.entitymodel.Paciente;
import dominio.entitymodel.Vacunacion;

public class VacunacionDAO implements DAO<Vacunacion> {
	static final String INSERT = "INSERT INTO vacunacion(fecha, isSegundaDosis, nombre_tipovacuna, dni_Paciente, nombre, apellidos, region, grupoPrioridad) VALUES(";
	static final String UPDATE = "UPDATE vacunacion SET ";
	static final String DELETE = "DELETE FROM vacunacion WHERE dni_Paciente=";
	static final String GETALL = "SELECT * FROM vacunacion";
	static final String GETREGION = "SELECT * FROM vacunacion WHERE region=";
	static final String GETONE = "SELECT * FROM vacunacion WHERE dni_Paciente=";
	static final String WHEREID = " WHERE dni_Paciente=";

	private AgenteBD agente;
	
	public VacunacionDAO() {
		agente = new AgenteBD();
	}
	@Override
	public Vacunacion get(String dni) throws DAOException {
		agente.conectarBD();
		ResultSet rs = null;
		Vacunacion vacunacion = null;
		try {
			rs = agente.select(GETONE + "'" + dni + "'");
			while (rs.next()) {
				vacunacion = convertir(rs);
			}
		} catch (Exception ex) {
			throw new DAOException("Error en SQL", ex);
		}
		agente.desconectarBD();
		return vacunacion;
	}

	@Override
	public int insert(Vacunacion v) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(INSERT + "'" + v.getFecha() + "'" + "," + v.isSegundaDosis() + "," + "'" + v.getVacuna()
				+ "'" + "," + "'" + v.paciente.getDni() + "'" + "," + "'" + v.paciente.getNombre() + "'" + "," + "'"
				+ v.paciente.getApellidos() + "'" + "," + "'" + v.paciente.getRegion() + "'" + "," + "'"
				+ v.paciente.getGrupo() + "'" + ")");
		if (i == 0) {
			throw new DAOException("Puede que no se haya insertado.");
		}
		agente.desconectarBD();
		return i;
	}

	@Override
	public Vacunacion update(Vacunacion v) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(UPDATE + "isSegundaDosis=" + true + WHEREID + "'" + v.getdni() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya actualizado.");
		}
		agente.desconectarBD();
		return v;
	}

	@Override
	public int delete(Vacunacion v) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(DELETE + "'" + v.getdni() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya borrado.");
		}
		agente.desconectarBD();
		return i;
	}

	public void insertarVacunacion(Vacunacion v) throws DAOException {
		insert(v);
	}

	private Vacunacion convertir(ResultSet rs) throws DAOException {
		try {
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
		} catch (SQLException e) {
			throw new DAOException("Error al convertir ResultSet");
		}
	}

	public List<Vacunacion> seleccionarVacunaciones() throws DAOException {
		agente.conectarBD();
		ResultSet rs = null;
		List<Vacunacion> vacunaciones = new ArrayList<Vacunacion>();
		try {
			rs = agente.select(GETALL);
			while (rs.next()) {
				vacunaciones.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		return vacunaciones;
	}
	

	public List<Vacunacion> seleccionarVacunaciones(String region) throws DAOException {
		agente.conectarBD();
		ResultSet rs = null;
		List<Vacunacion> vacunaciones = new ArrayList<Vacunacion>();
		try {
			rs = agente.select(GETREGION + "'" + region + "'");
			while (rs.next()) {
				vacunaciones.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		agente.desconectarBD();
		return vacunaciones;
	}
}