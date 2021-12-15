package dominio.entitymodel;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Objects;

import persistencia.*;

public class EntregaVacunas {
	String region;
	String grupoprioridad;
	String lote;
	EntregaDAO entregaDao;
	private LocalDate fecha;
	private int cantidad;
	
	public EntregaVacunas(String grupoprioridad, String lote, LocalDate fecha, int cantidad,String region) throws DAOException{
		setGrupoPrioridad(grupoprioridad);
		setLote(lote);
		setFecha(fecha);
		setCantidad(cantidad);
		setRegion(region);
		try {
			setEntregaDao(new EntregaDAO());
		} catch (Exception ex) {
			throw new DAOException("Error creando objeto EntregaDAO...", ex);
		}
	}
	public EntregaVacunas(String grupoprioridad, LocalDate fecha, int cantidad,String region) throws DAOException{
		setGrupoPrioridad(grupoprioridad);
		setLote(cadenaAleatoria());
		setFecha(fecha);
		setCantidad(cantidad);
		setRegion(region);
		try {
			setEntregaDao(new EntregaDAO());
		} catch (Exception ex) {
			throw new DAOException("Error creando objeto EntregaDAO...", ex);
		}
	}
	
	@Override
	public String toString() {
		return ": region=" + region + " -- grupoprioridad=" + grupoprioridad + " -- cantidad=" + cantidad;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGrupoPrioridad() {
		return grupoprioridad;
	}
	public void setGrupoPrioridad(String grupoPrioridad) {
		this.grupoprioridad = grupoPrioridad;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public EntregaDAO getEntregaDao() {
		return entregaDao;
	}
	public void setEntregaDao(EntregaDAO entregaDao) {
		this.entregaDao = entregaDao;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntregaVacunas other = (EntregaVacunas) obj;
		return cantidad == other.cantidad && Objects.equals(fecha, other.fecha)
				&& Objects.equals(grupoprioridad, other.grupoprioridad) && Objects.equals(lote, other.lote)
				&& Objects.equals(region, other.region);
	}
	
	public static String cadenaAleatoria() {
		int length = 5;
		String charLower = "abcdefghijklmnopqrstuvwxyz";
		String charUpper = charLower.toUpperCase();
		String number = "0123456789";
		String dataForRandomString = charLower + charUpper + number;
		SecureRandom random = new SecureRandom();
		if (length < 1)
			throw new IllegalArgumentException();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int rndCharAt = random.nextInt(dataForRandomString.length());
			char rndChar = dataForRandomString.charAt(rndCharAt);

			sb.append(rndChar);
		}
		return sb.toString();
	}
}