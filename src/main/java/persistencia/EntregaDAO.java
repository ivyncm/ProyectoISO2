package persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import dominio.entitymodel.*;

public class EntregaDAO implements DAO<EntregaVacunas> {
	static String error="Error en SQL";
	
	static final String INSERT = "INSERT INTO entrega(fecha, cantidad, idLote, region, grupoPrioridad) VALUES(";
	static final String UPDATE = "UPDATE entrega SET ";
	static final String DELETE = "DELETE FROM entrega WHERE idLote=";
	static final String GETREGION = "SELECT * FROM entrega WHERE region=";
	static final String GETONE = "SELECT * FROM entrega WHERE idLote=";
	static final String GETALL = "SELECT * FROM entrega";
	static final String WHEREID = " WHERE idLote=";
	private AgenteBD agente;

	public EntregaDAO() {
		agente = new AgenteBD();
	}

	@Override
	public EntregaVacunas get(String id) throws DAOException{
		
		agente.conectarBD();
		ResultSet rs = null;
		EntregaVacunas entrega = null;
		try {
			rs = agente.select(GETONE + "'" + id + "'");
			while (rs.next()) {
				entrega = (convertir(rs));
			}
		} catch (Exception ex) {
			throw new DAOException(error, ex);
		}
		agente.desconectarBD();
		return entrega;
	}

	@Override
	public int insert(EntregaVacunas e) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(INSERT + "'" + e.getFecha() + "'" + "," + e.getCantidad() + "," + "'" + e.getLote() + "'"
				+ "," + "'" + e.getRegion() + "'" + "," + "'" + e.getGrupoPrioridad() + "'" + ")");
		if (i == 0) {
			throw new DAOException("Puede que no se haya insertado.");
		}
		agente.desconectarBD();
		return i;
	}

	@Override
	public EntregaVacunas update(EntregaVacunas e) throws DAOException {
		int i = 0;
		i = agente.iud(UPDATE + "region='" + e.getRegion() + "',grupoPrioridad='" + e.getGrupoPrioridad() + "',fecha='" + e.getFecha() + "',cantidad=" + e.getCantidad() + WHEREID + "'" + e.getLote() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya actualizado.");
		}
		return e;
	}

	@Override
	public int delete(EntregaVacunas e) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(DELETE + "'" + e.getLote() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya borrado.");
		}
		agente.desconectarBD();
		return i;
	}

	public void insertarEntrega(EntregaVacunas entrega) throws DAOException {
		insert(entrega);
	}

	private EntregaVacunas convertir(ResultSet rs) throws DAOException {
		String region;
		try {
			region = rs.getString(4);
			String grupoPrior = rs.getString(5);
			String lote = rs.getString(3);
			Date fecha = rs.getDate(1);
			LocalDate fecha1 = fecha.toLocalDate();
			int cantidad = rs.getInt(2);
			EntregaVacunas entrega = new EntregaVacunas(grupoPrior, lote, fecha1, cantidad, region);
			return entrega;
		} catch (SQLException ex) {
			throw new DAOException("Error en ResultSet", ex);
		}
	}

	public List<EntregaVacunas> seleccionarcantidadTotal() throws DAOException {
		agente.conectarBD();
		ResultSet rs = null;
		List<EntregaVacunas> entrega = new ArrayList<EntregaVacunas>();
		try {
			rs = agente.select(GETALL);
			while (rs.next()) {
				entrega.add(convertir(rs));
			}
		} catch (Exception ex) {
			throw new DAOException(error, ex);
		}
		return entrega;
	}

	public List<EntregaVacunas> seleccionarEntregas(String region) throws DAOException {
		agente.conectarBD();
		ResultSet rs = null;
		List<EntregaVacunas> entrega = new ArrayList<EntregaVacunas>();
		try {
			rs = agente.select(GETREGION + "'" + region + "'");
			while (rs.next()) {
				entrega.add(convertir(rs));
			}
		} catch (Exception ex) {
			throw new DAOException(error, ex);
		}
		return entrega;
	}
}