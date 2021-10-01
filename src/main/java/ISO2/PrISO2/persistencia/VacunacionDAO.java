package ISO2.PrISO2.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ISO2.PrISO2.dominio.entitymodel.Vacunacion;

public class VacunacionDAO implements DAO<Vacunacion> {
	final String INSERT = "INSERT INTO vacunacion(id, tipoVacuna, paciente, fecha, segDosis) VALUES(";
	final String UPDATE = "UPDATE vacunacion SET ";
	final String DELETE = "DELETE FROM vacunacion WHERE id=";
	final String GETALL = "SELECT * FROM vacunacion";
	final String GETREGION = "SELECT * FROM vacunacion WHERE region=";
	final String GETONE = "SELECT * FROM vacunacion WHERE id=";
	final String WHEREID = "WHERE id=";

	private AgenteBD agente = new AgenteBD();

	public VacunacionDAO() throws Exception {

	}

	@Override
	public Vacunacion get(int id) throws Exception {
		agente.conectarBD();
		ResultSet rs = null;
		try {
			rs = agente.select(GETONE + id);
			String tipoVacuna = rs.getString("tipoVacuna");
			String paciente = rs.getString("paciente");
			Date fecha = rs.getDate("fecha");
			Boolean segDosis = rs.getBoolean("segDosis");

			Vacunacion entrega = new Vacunacion(id, tipoVacuna, paciente, fecha, segDosis);

			return entrega;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}

	}

	@Override
	public int insert(Vacunacion v) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.insert(INSERT + v.getId() + "," + v.getVacuna() + "," + v.getPaciente() + "," + v.getFecha()
					+ "," + v.isSegundaDosis() + ")");
			if (i == 0) {
				throw new DAOException("Puede que no se haya insertado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return i;
	}

	@Override
	public Vacunacion update(Vacunacion v) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.update(UPDATE + "tipoVacuna=" + v.getVacuna() + ",paciente=" + v.getPaciente() + ",fecha="
					+ v.getFecha() + ",segDosis=" + v.isSegundaDosis() + WHEREID + v.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya actualizado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return v;

	}

	@Override
	public int delete(Vacunacion v) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.delete(DELETE + v.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya borrado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return i;

	}

	public void insertarVacunacion(Vacunacion v) throws Exception {
		insert(v);

	}

	private Vacunacion convertir(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String tipoVacuna = rs.getString("tipoVacuna");
		String paciente = rs.getString("region");
		Date fecha = rs.getDate("fecha");
		Boolean segDosis = rs.getBoolean("segDosis");
		Vacunacion vacunacion = new Vacunacion(id, tipoVacuna, paciente, fecha, segDosis);

		return vacunacion;
	}

	public List<Vacunacion> seleccionarVacunaciones() throws Exception {
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
		agente.desconectarBD();
		return vacunaciones;
	}

	public List<Vacunacion> seleccionarVacunaciones(String region) throws Exception {
		agente.conectarBD();
		ResultSet rs = null;
		List<Vacunacion> vacunaciones = new ArrayList<Vacunacion>();
		try {
			rs = agente.select(GETREGION + region);
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