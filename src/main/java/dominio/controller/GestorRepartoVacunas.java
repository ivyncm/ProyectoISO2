package dominio.controller;

import java.security.SecureRandom;
import java.util.*;

import dominio.entitymodel.*;
import persistencia.DAOException;
import persistencia.LoteVacunasDAO;
public class GestorRepartoVacunas {


	/**
	 * 
	 * @param fecha
	 * @param tipo
	 * @param cantidad
	 * @throws Exception
	 */
	public void altaNuevoLoteVacunas(LoteVacunas lote) throws ControllerException {
		try {
			lote.getLoteVacunasDao().insertarLoteVacunas(lote);
		} catch (Exception e) {
			throw new ControllerException("Error al dar de alta nuevo lote", e);
		}
	}

	public List<EntregaVacunas> calcularEntregasRegion(LoteVacunas lote, String prioridad) throws ControllerException {
		String[] regiones = new String[] { "Andalucía", "Aragón", "Canarias", "Cantabria", "Castilla y León",
				"Castilla-La Mancha", "Cataluña", "Ceuta", "Comunidad Valenciana", "Comunidad de Madrid", "Extremadura",
				"Galicia", "Islas Baleares", "La Rioja", "Melilla", "Navarra", "País Vasco", "Principado de Asturias",
				"Región de Murcia" };
		List<EntregaVacunas> entregas = new ArrayList<>();
		int cantidad = 0;
		try {
			if(lote.getCantidad() < 200) {
				cantidad = lote.getCantidad();
				Random ran = SecureRandom.getInstanceStrong();
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
		} catch (Exception e) {
			throw new ControllerException("Error al calcular las entregas por región", e);
		}
	}
	
	public List<LoteVacunas> imprimirLotes() throws DAOException {
		
		LoteVacunasDAO total = new LoteVacunasDAO();
		return total.seleccionarLote();
		
	}

	
	
}