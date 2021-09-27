package ISO2.PrISO2.dominio.entitymodel;

import java.util.*;
import ISO2.PrISO2.persistencia.*;

public class Vacunacion {

	TipoVacuna vacuna;
	Paciente paciente;
	VacunacionDAO vacunacionDao;
	private Date fecha;
	private boolean isSegundaDosis;

}