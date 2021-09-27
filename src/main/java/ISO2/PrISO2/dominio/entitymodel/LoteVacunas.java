package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;
import ISO2.PrISO2.persistencia.*;

public class LoteVacunas {

	Collection<EntregaVacunas> entregas;
	TipoVacuna tipo;
	LoteVacunasDAO loteVacunasDao;
	private String id;
	private Date fecha;
	private int cantidad;
	private String farmaceutica;

}