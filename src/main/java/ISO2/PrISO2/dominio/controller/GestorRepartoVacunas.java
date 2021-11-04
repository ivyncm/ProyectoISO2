package ISO2.PrISO2.dominio.controller;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

import ISO2.PrISO2.dominio.entitymodel.*;

public class GestorRepartoVacunas {

	/**
	 * 
	 * @param fecha
	 * @param tipo
	 * @param cantidad
	 * @throws Exception
	 */
	public void altaNuevoLoteVacunas(LocalDate fecha, String tipo, int cantidad) throws Exception {
		String id = cadenaAleatoria();
		LoteVacunas lote = new LoteVacunas(id, fecha, cantidad, tipo);
		lote.loteVacunasDao.insertarLoteVacunas(lote);
	}

	public List<EntregaVacunas> calcularEntregasRegion() {
		// TODO - implement GestorRepartoVacunas.calcularEntregasRegion
		throw new UnsupportedOperationException();
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