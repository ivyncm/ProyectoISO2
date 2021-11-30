package persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import dominio.entitymodel.*;

public class EntregaDAO implements DAO<EntregaVacunas> {

	static final String INSERT = "INSERT INTO entrega(fecha, cantidad, idLote, region, grupoPrioridad) VALUES(";
	static final String UPDATE = "UPDATE entrega SET ";
	static final String DELETE = "DELETE FROM entrega WHERE idLote=";
	static final String GETREGION = "SELECT * FROM entrega WHERE region=";
	static final String GETONE = "SELECT * FROM entrega WHERE idLote=";
	static final String GETALL = "SELECT * FROM entrega";
	static final String WHEREID = "WHERE id=";


	public EntregaDAO() throws Exception {

	}

	@Override
	public EntregaVacunas get(String id) throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		try {
			rs = AgenteBD.select(GETONE + "'" + id + "'");
			String region = rs.getString(4);
			String grupoPrior = rs.getString(5);
			String lote = rs.getString(3);
			Date fecha = rs.getDate(1);
			LocalDate fecha1 = fecha.toLocalDate();
			int cantidad = rs.getInt(2);

			EntregaVacunas entrega = new EntregaVacunas(grupoPrior, lote, fecha1, cantidad, region);

			return entrega;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
	}

	@Override
	public int insert(EntregaVacunas e) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		i = AgenteBD.iud(INSERT + "'" + e.getFecha() + "'" + "," + e.getCantidad() + "," + "'" + e.getLote() + "'"
				+ "," + "'" + e.getRegion() + "'" + "," + "'" + e.getGrupoPrioridad() + "'" + ")");
		if (i == 0) {
			throw new DAOException("Puede que no se haya insertado.");
		}
		AgenteBD.desconectarBD();
		return i;
	}

	@Override
	public EntregaVacunas update(EntregaVacunas e) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		i = AgenteBD.iud(UPDATE + "region=" + e.getRegion() + ",grupoPrioridad=" + e.getGrupoPrioridad() + ",lote="
				+ e.getLote() + ",fecha=" + e.getFecha() + ",cantidad=" + e.getCantidad() + WHEREID);
		if (i == 0) {
			throw new DAOException("Puede que no se haya actualizado.");
		}
		AgenteBD.desconectarBD();
		return e;
	}

	@Override
	public int delete(EntregaVacunas e) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		i = AgenteBD.iud(DELETE);
		if (i == 0) {
			throw new DAOException("Puede que no se haya borrado.");
		}
		AgenteBD.desconectarBD();
		return i;
	}

	public void insertarEntrega(EntregaVacunas entrega) throws Exception {
		insert(entrega);
		System.out.println("Se ha insertado una nueva entrega con id: "+entrega.getLote());
	}

	private EntregaVacunas convertir(ResultSet rs) throws Exception {
		String region = rs.getString(4);
		String grupoPrior = rs.getString(5);
		String lote = rs.getString(3);
		Date fecha = rs.getDate(1);
		LocalDate fecha1 = fecha.toLocalDate();
		int cantidad = rs.getInt(2);
		EntregaVacunas entrega = new EntregaVacunas(grupoPrior, lote, fecha1, cantidad, region);
		return entrega;
	}

	public List<EntregaVacunas> seleccionarcantidadTotal() throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		List<EntregaVacunas> entrega = new ArrayList<EntregaVacunas>();
		try {
			rs = AgenteBD.select(GETALL);
			while (rs.next()) {
				entrega.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		return entrega;
	}

	public List<EntregaVacunas> seleccionarEntregas(String region) throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		List<EntregaVacunas> entrega = new ArrayList<EntregaVacunas>();
		try {
			rs = AgenteBD.select(GETREGION + "'" + region + "'");
			while (rs.next()) {
				entrega.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		return entrega;
	}
}