package ISO2.PrISO2.persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import ISO2.PrISO2.dominio.entitymodel.*;

public class EntregaDAO implements DAO<EntregaVacunas> {

	final String INSERT = "INSERT INTO entrega(id, tipoVacuna, region, grupoPrioridad, lote, fecha, cantidad) VALUES(";
	final String UPDATE = "UPDATE entrega SET ";
	final String DELETE = "DELETE FROM entrega WHERE id=";
	final String GETREGION = "SELECT * FROM entrega WHERE region=";
	final String GETONE = "SELECT * FROM entrega WHERE id=";
	final String WHEREID = "WHERE id=";

	private AgenteBD agente = new AgenteBD();

	public EntregaDAO() throws Exception {

	}

	@Override
	public EntregaVacunas get(int id) throws Exception {
		agente.conectarBD();
		ResultSet rs = null;
		try {
			rs = agente.select(GETONE + id);
			String tipoVacuna = rs.getString("tipoVacuna");
			String region = rs.getString("region");
			String grupoPrior = rs.getString("grupoPrioridad");
			String lote = rs.getString("lote");
			Date fecha = rs.getDate("fecha");
			int cantidad = rs.getInt("cantidad");

			EntregaVacunas entrega = new EntregaVacunas(id, tipoVacuna, region, grupoPrior, lote, fecha, cantidad);

			return entrega;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
	}

	@Override
	public int insert(EntregaVacunas e) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.insert(INSERT + e.getId() + "," + e.getTipo() + "," + e.getRegion() + "," + e.getGrupoPrioridad()
					+ "," + e.getLote() + "," + e.getFecha() + "," + e.getCantidad() + ")");
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
	public EntregaVacunas update(EntregaVacunas e) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.update(UPDATE + "tipoVacuna=" + e.getTipo() + ",region=" + e.getRegion() + ",grupoPrioridad="
					+ e.getGrupoPrioridad() + ",lote=" + e.getLote() + ",fecha=" + e.getFecha() + ",cantidad="
					+ e.getCantidad() + WHEREID + e.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya actualizado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return e;
	}

	@Override
	public int delete(EntregaVacunas e) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.delete(DELETE + e.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya borrado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return i;
	}

	public void insertarEntrega(EntregaVacunas entrega) throws Exception {
		insert(entrega);
	}

	private EntregaVacunas convertir(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String tipoVacuna = rs.getString("tipoVacuna");
		String region = rs.getString("region");
		String grupoPrior = rs.getString("grupoPrioridad");
		String lote = rs.getString("lote");
		Date fecha = rs.getDate("fecha");
		int cantidad = rs.getInt("cantidad");
		EntregaVacunas entrega = new EntregaVacunas(id, tipoVacuna, region, grupoPrior, lote, fecha, cantidad);
		return entrega;
	}

	public List<EntregaVacunas> seleccionarEntregas(String region) throws Exception {
		agente.conectarBD();
		ResultSet rs = null;
		List<EntregaVacunas> entrega = new ArrayList<EntregaVacunas>();
		try {
			rs = agente.select(GETREGION + region);
			while (rs.next()) {
				entrega.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		agente.desconectarBD();
		return entrega;
	}

}