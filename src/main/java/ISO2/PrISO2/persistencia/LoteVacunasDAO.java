package ISO2.PrISO2.persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import ISO2.PrISO2.dominio.entitymodel.*;

public class LoteVacunasDAO implements DAO<LoteVacunas> {

	final String INSERT = "INSERT INTO lote(id, fecha, cantidad, nombre_tipoVacuna) VALUES(";
	final String UPDATE = "UPDATE lote SET ";
	final String DELETE = "DELETE FROM lote WHERE id=";
	final String GETALL = "SELECT * FROM lote";
	final String GETONE = "SELECT * FROM lote WHERE id=";
	final String WHEREID = "WHERE id=";

	private AgenteBD agente = new AgenteBD();

	public LoteVacunasDAO() throws Exception {

	}

	@Override
	public LoteVacunas get(String id) throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		try {
			rs = AgenteBD.select(GETONE + id);
			String tipoVacuna = rs.getString("tipoVacuna");
			Date fecha = rs.getDate("fecha");
			int cantidad = rs.getInt("cantidad");
			String farmaceutica = rs.getString("farmaceutica");

			//LoteVacunas lote = new LoteVacunas(id, fecha, cantidad, farmaceutica);

			//return lote;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		return null;

	}

	@Override
	public int insert(LoteVacunas l) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		System.out.print(INSERT + "'" + l.getId() + "'," + "'"+ l.getFecha() + "'"+"," + l.getCantidad() + ","
					+ "'"+l.getFarmaceutica()+"'" + ")");
		try {
			i = agente.insert(INSERT + "'" + l.getId() + "','"+ l.getFecha() + "'," + l.getCantidad() + ",'"+l.getFarmaceutica()+"'" + ")");
			if (i == 0) {
				throw new DAOException("Puede que no se haya insertado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		AgenteBD.desconectarBD();
		return i;
	}

//	id, tipo, fecha, cantidad, farmaceutica
	@Override
	public LoteVacunas update(LoteVacunas l) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		try {
			i = agente.update(UPDATE + "fecha=" + l.getFecha() + ",cantidad="
					+ l.getCantidad() + ",nombre_tipoVacuna=" + l.getFarmaceutica() + WHEREID + l.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya actualizado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		AgenteBD.desconectarBD();
		return l;
	}

	@Override
	public int delete(LoteVacunas l) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		try {
			i = agente.delete(DELETE + l.getId());
			if (i == 0) {
				throw new DAOException("Puede que no se haya borrado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		AgenteBD.desconectarBD();
		return i;

	}

	public void insertarLoteVacunas(LoteVacunas lote) throws Exception {
		insert(lote);

	}

}