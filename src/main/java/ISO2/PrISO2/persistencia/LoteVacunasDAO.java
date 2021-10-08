package ISO2.PrISO2.persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import ISO2.PrISO2.dominio.entitymodel.*;

public class LoteVacunasDAO implements DAO<LoteVacunas> {

	final String INSERT = "INSERT INTO lote(id, tipo, fecha, cantidad, farmaceutica) VALUES(";
	final String UPDATE = "UPDATE lote SET ";
	final String DELETE = "DELETE FROM lote WHERE id=";
	final String GETALL = "SELECT * FROM lote";
	final String GETONE = "SELECT * FROM lote WHERE id=";
	final String WHEREID = "WHERE id=";

	private AgenteBD agente = new AgenteBD();

	public LoteVacunasDAO() throws Exception {

	}

	@Override
	public LoteVacunas get(int id) throws Exception {
		agente.conectarBD();
		ResultSet rs = null;
		try {
			rs = agente.select(GETONE + id);
			String tipoVacuna = rs.getString("tipoVacuna");
			Date fecha = rs.getDate("fecha");
			int cantidad = rs.getInt("cantidad");
			String farmaceutica = rs.getString("farmaceutica");

			LoteVacunas lote = new LoteVacunas(id, tipoVacuna, fecha, cantidad, farmaceutica);

			return lote;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}

	}

	@Override
	public int insert(LoteVacunas l) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.insert(INSERT + l.getId() + "," + l.getTipo() + "," + l.getFecha() + "," + l.getCantidad() + ","
					+ l.getFarmaceutica() + ")");
			if (i == 0) {
				throw new DAOException("Puede que no se haya insertado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return i;
	}

//	id, tipo, fecha, cantidad, farmaceutica
	@Override
	public LoteVacunas update(LoteVacunas l) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.update(UPDATE + "tipoVacuna=" + l.getTipo() + ",fecha=" + l.getFecha() + ",cantidad="
					+ l.getCantidad() + ",farmaceutica=" + l.getFarmaceutica() + WHEREID + l.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya actualizado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return l;
	}

	@Override
	public int delete(LoteVacunas l) throws Exception {
		agente.conectarBD();
		int i = 0;
		try {
			i = agente.delete(DELETE + l.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya borrado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		agente.desconectarBD();
		return i;

	}

	public void insertarLoteVacunas(LoteVacunas lote) throws Exception {
		insert(lote);

	}

}