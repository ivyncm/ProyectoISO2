package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.entitymodel.*;

import java.time.LocalDate;

public class LoteVacunasDAO implements DAO<LoteVacunas> {

	static final String INSERT = "INSERT INTO lote(id, fecha, cantidad, nombre_TipoVacuna) VALUES(";
	static final String UPDATE = "UPDATE lote SET ";
	static final String DELETE = "DELETE FROM lote WHERE id=";
	static final String GETALL = "SELECT * FROM lote";
	static final String GETONE = "SELECT * FROM lote WHERE id=";
	static final String WHEREID = " WHERE id=";

	private AgenteBD agente;
	
	public LoteVacunasDAO() {
		agente = new AgenteBD();
	}
	@Override
	public LoteVacunas get(String id) throws DAOException  {
		agente.conectarBD();
		ResultSet rs = null;
		LoteVacunas loteVacunas = null;
		try {
			rs = agente.select(GETONE + "'" + id + "'");
			while (rs.next()) {
				loteVacunas = (convertir(rs));
			}
		} catch (Exception ex) {
			throw new DAOException("Error en SQL", ex);
		}
		agente.desconectarBD();
		return loteVacunas;
	}

	public List<LoteVacunas> seleccionarLote() throws DAOException  {
		agente.conectarBD();
		ResultSet rs = null;
		List<LoteVacunas> LoteVacunas = new ArrayList<LoteVacunas>();
		try {
			rs = agente.select(GETALL);
			while (rs.next()) {
				LoteVacunas.add(convertir(rs));
			}
		} catch (Exception ex) {
			throw new DAOException("Error en SQL", ex);
		}
		agente.desconectarBD();
		return LoteVacunas;
	}

	private LoteVacunas convertir(ResultSet rs) throws DAOException  {
		try {
			  String id = rs.getString(1);
			  Date fecha =rs.getDate(2); 
			  LocalDate fecha1 = ((java.sql.Date) fecha).toLocalDate();
			  int cantidad = rs.getInt(3); 
			  String tipoVacuna = rs.getString(4); 
			  LoteVacunas lote = new LoteVacunas(id, fecha1, cantidad, tipoVacuna);
			  return lote;
			}catch(Exception ex) {
				throw new DAOException("Error en ResultSet", ex);
			} 
	}
	
	@Override
	public int insert(LoteVacunas l) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(INSERT + "'" + l.getId() + "','" + l.getFecha() + "'," + l.getCantidad() + ",'"
				+ l.getFarmaceutica() + "'" + ")");
		if (i == 0) {
			throw new DAOException("Puede que no se haya insertado.");
		}
		agente.desconectarBD();
		return i;
	}

	@Override
	public LoteVacunas update(LoteVacunas l) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(UPDATE + "fecha='" + l.getFecha() + "',cantidad=" + l.getCantidad() + ",nombre_TipoVacuna='"
				+ l.getFarmaceutica() + "'" + WHEREID + "'" + l.getId() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya actualizado.");
		}
		agente.desconectarBD();
		return l;
	}

	@Override
	public int delete(LoteVacunas l) throws DAOException {
		agente.conectarBD();
		int i = 0;
		i = agente.iud(DELETE + "'" + l.getId() + "'");
		if (i == 0) {
			throw new DAOException("Puede que no se haya borrado.");
		}
		agente.desconectarBD();
		return i;
	}

	public void insertarLoteVacunas(LoteVacunas lote) throws DAOException {
		insert(lote);
	}
}