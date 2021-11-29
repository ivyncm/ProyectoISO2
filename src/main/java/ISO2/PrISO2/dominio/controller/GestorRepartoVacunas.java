package ISO2.PrISO2.dominio.controller;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

import ISO2.PrISO2.dominio.entitymodel.*;
import ISO2.PrISO2.persistencia.LoteVacunasDAO;
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

	public List<EntregaVacunas> calcularEntregasRegion(LoteVacunas lote, String prioridad) throws Exception {
		String[] regiones = new String[] { "Andalucía", "Aragón", "Canarias", "Cantabria", "Castilla y León",
				"Castilla-La Mancha", "Cataluña", "Ceuta", "Comunidad Valenciana", "Comunidad de Madrid", "Extremadura",
				"Galicia", "Islas Baleares", "La Rioja", "Melilla", "Navarra", "País Vasco", "Principado de Asturias",
				"Región de Murcia" };
		List<EntregaVacunas> entregas = new ArrayList<EntregaVacunas>();
		int cantidad = 0;
		if(lote.getCantidad() < 200) {
			cantidad = lote.getCantidad();
			Random ran = new Random();
			int num = ran.nextInt(19); //window.crypto.getRandomValues(typedArray)
			EntregaVacunas entrega = new EntregaVacunas(prioridad, lote.getId(), lote.getFecha(), cantidad, regiones[num]);
			entrega.getEntregaDao().insert(entrega);
			entregas.add(entrega);
		} else {
			cantidad = lote.getCantidad()/19;
			for(int i = 0; i < 19; i++) {
				EntregaVacunas entrega = new EntregaVacunas(prioridad, lote.getId(), lote.getFecha(), cantidad, regiones[i]);
				entrega.getEntregaDao().insert(entrega);
				entregas.add(entrega);
			}
		}
		return entregas;
	}
	
	public List<LoteVacunas> imprimirLotes() throws Exception {
		// TODO - implement GestorRepartoVacunas.calcularEntregasRegion
		
		LoteVacunasDAO total = new LoteVacunasDAO();
		List<LoteVacunas> lotes = total.seleccionarLote();
		
		
		return lotes;
	}

	public static String cadenaAleatoria() {
		int length = 5;
		String char_lower = "abcdefghijklmnopqrstuvwxyz";
		String char_upper = char_lower.toUpperCase();
		String number = "0123456789";
		String data_for_random_string = char_lower + char_upper + number;
		SecureRandom random = new SecureRandom();
		if (length < 1)
			throw new IllegalArgumentException();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int rndCharAt = random.nextInt(data_for_random_string.length());
			char rndChar = data_for_random_string.charAt(rndCharAt);

			sb.append(rndChar);
		}
		return sb.toString();
	}
	
}