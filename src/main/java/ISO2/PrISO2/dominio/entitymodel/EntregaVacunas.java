package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;

import ISO2.PrISO2.persistencia.*;

public class EntregaVacunas {

	TipoVacuna tipo;
	RegionEnum region;
	GrupoPrioridad grupoPrioridad;
	LoteVacunas lote;
	EntregaDAO entregaDao;
	private Date fecha;
	private int cantidad;

}