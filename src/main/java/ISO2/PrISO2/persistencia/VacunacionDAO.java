package ISO2.PrISO2.persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ISO2.PrISO2.dominio.entitymodel.Vacunacion;

public class VacunacionDAO implements DAO<Vacunacion> {
	final String INSERT = "INSERT INTO vacunacion(fecha, isSegundaDosis, nombre_tipovacuna, dni_paciente) VALUES(";
	final String UPDATE = "UPDATE vacunacion SET ";
	final String DELETE = "DELETE FROM vacunacion WHERE dni_paciente=";
	final String GETALL = "SELECT * FROM vacunacion";
	final String GETREGION = "SELECT * FROM vacunacion WHERE region=";
	final String GETONE = "SELECT * FROM vacunacion WHERE dni_paciente=";
	final String WHEREID = "WHERE dni_paciente=";

	private AgenteBD agente = new AgenteBD();

	public VacunacionDAO() throws Exception {

	}

	@Override
	public Vacunacion get(String dni) throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		try {
			rs = AgenteBD.select(GETONE +"'" + dni + "'");
			String tipoVacuna = rs.getString(3);
			Date fecha = rs.getDate(1);
			Boolean segDosis = rs.getBoolean(2);
			LocalDate fecha1=fecha.toLocalDate();
			Vacunacion entrega = new Vacunacion(dni, tipoVacuna, fecha1, segDosis);
			
			return entrega;
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}

	}

	@Override
	public int insert(Vacunacion v) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		try {
			i = agente.insert(INSERT +"'"+ v.getFecha() + "'"+ "," + v.isSegundaDosis()+"," + "'"+ v.getVacuna()+ "'"
					+ ","+ "'" + v.getdni()+ "'" + ")");
			if (i == 0) {
				throw new DAOException("Puede que no se haya insertado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		AgenteBD.desconectarBD();
		return i;
	}

	@Override
	public Vacunacion update(Vacunacion v) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		try {
			i = agente.update(UPDATE + "segDosis=True" + WHEREID+"'" + v.getdni()+"'" );
			if (i == 0) {
				throw new DAOException("Puede que no se haya actualizado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		AgenteBD.desconectarBD();
		return v;

	}

	@Override
	public int delete(Vacunacion v) throws Exception {
		AgenteBD.conectarBD();
		int i = 0;
		try {
			i = agente.delete(DELETE + v.getdni());
			if (i == 0) {
				throw new DAOException("Puede que no se haya borrado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error SQL", ex);
		}
		AgenteBD.desconectarBD();
		return i;

	}

	public void insertarVacunacion(Vacunacion v) throws Exception {
		if(insert(v) != 0) {
			System.out.println("Registro completado con éxito");
		} else
			System.out.println("Registro no completado con éxito");

	}

	private Vacunacion convertir(ResultSet rs) throws Exception {
		String dni = rs.getString(4);
		String tipoVacuna = rs.getString(3);
		Date fecha = rs.getDate(1);
		Boolean segDosis = rs.getBoolean(2);
		LocalDate fecha1=fecha.toLocalDate();
		Vacunacion vacunacion = new Vacunacion(dni, tipoVacuna, fecha1, segDosis);		

		return vacunacion;
	}

	public List<Vacunacion> seleccionarVacunaciones() throws Exception {
		AgenteBD.conectarBD();
		ResultSet rs = null;
		List<Vacunacion> vacunaciones = new ArrayList<Vacunacion>();
		try {
			rs = AgenteBD.select(GETALL);
			while (rs.next()) {
				vacunaciones.add(convertir(rs));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}
		//AgenteBD.desconectarBD();
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