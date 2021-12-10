package ISO2.PrISO2.dominio.controller;

import java.security.SecureRandom;
import java.time.LocalDate;

import ISO2.PrISO2.dominio.entitymodel.*;

public class GestorVacunacion {

	/**
	 * 
	 * @param lote
	 * @param fecha
	 * @param cantidad
	 * @param prioridad
	 */
	public void altaEntregaVacunas(LocalDate fecha, int cantidad, String prioridad, String region)
			throws Exception {
		String lote = cadenaAleatoria();
		EntregaVacunas vacunas = new EntregaVacunas(prioridad, lote, fecha, cantidad, region);
		vacunas.getEntregaDao().insertarEntrega(vacunas);
	}

	/**
	 * 
	 * @param fecha
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param tipo
	 * @throws Exception
	 */
	public void registrarVacunacion(LocalDate fecha, String nombre, String apellidos, String dni, String tipo,
			boolean segDosis, String region, String grupo) throws Exception {
		Paciente paciente = new Paciente(dni, nombre, apellidos, region, grupo);
		Vacunacion vacunacion = new Vacunacion(tipo, fecha, segDosis, paciente);
		vacunacion.getVacunacionDao().insertarVacunacion(vacunacion);
	}

	public void actualizarVacunacion(String dni) throws Exception {
		Vacunacion vacunacion = new Vacunacion(dni);
		vacunacion.getVacunacionDao().update(vacunacion);
	}
	public static String cadenaAleatoria() {
		int length = 5;
		String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
		String CHAR_UPPER = CHAR_LOWER.toUpperCase();
		String NUMBER = "0123456789";
		String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
		SecureRandom random = new SecureRandom();
		if (length < 1)
			throw new IllegalArgumentException();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

			sb.append(rndChar);
		}
		return sb.toString();
	}
}