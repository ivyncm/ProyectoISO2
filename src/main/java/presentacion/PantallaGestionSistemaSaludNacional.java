package presentacion;

import java.util.List;
import java.util.Scanner;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import persistencia.DAOException;

import java.time.LocalDate;

import dominio.controller.ControllerException;
import dominio.controller.GestorRepartoVacunas;

public class PantallaGestionSistemaSaludNacional {
	private static final String noValido = "Opción no válida\n";
	public static void main(String[] args) throws Exception {
		menu();
	}

	public static void menu() throws Exception {
		Scanner teclado = new Scanner(System.in);
		int op1 = 0;
		System.out.println("Bienvenido al Sistema de Salud Nacional\n"
				+ "seleccione una categoria de su interes.");
		
		do {
			System.out.println("1 - Dar de alta nuevo lote\n"
					+ "2 - Calcular reparto\n"
					+ "3 - Consultar estadísticas\n"
					+ "4 - Salir");

			op1 = Integer.parseInt(teclado.next());
			GestorRepartoVacunas gestor = new GestorRepartoVacunas();
			switch (op1) {
			case 1:
				altaNuevoLote(gestor);
				break;
			case 2:
				calcularReparto(gestor);
				break;
			case 3:
				PantallaConsultaEstadisticas.estadNacional();
				break;
			case 4:
				System.out.println("Sesión cerrada\n");
				break;
			default:
				System.out.println(noValido);
				break;
			}
		} while (op1 < 1 || op1 > 4);
		teclado.close();
	}
	
	public static void altaNuevoLote(GestorRepartoVacunas gestor) throws ControllerException {
		Scanner teclado = new Scanner(System.in);
		String tipo = null;
		int op2;
		do {
			System.out.println("Introduce el tipo de vacuna:\n"
					+ "1 - Pfizer\n"
					+ "2 - Moderna\n"
					+ "3 - Astrazeneca");
			op2 = teclado.nextInt();
			switch (op2) {
			case 1:
				tipo = "Pfizer";
				break;
			case 2:
				tipo = "Moderna";
				break;
			case 3:
				tipo = "Astrazeneca";
				break;
			default:
				System.out.println(noValido);
				break;
			}
		} while (op2 < 1 || op2 > 3);

		System.out.println("Introduce la cantidad:");
		int cantidad = teclado.nextInt();
		

		LocalDate fecha = LocalDate.now();

		gestor.altaNuevoLoteVacunas(fecha, tipo, cantidad);
	}
	
	public static void calcularReparto(GestorRepartoVacunas gestor) throws DAOException, ControllerException {
		Scanner teclado = new Scanner(System.in);
		LoteVacunas lote = null;
		int op2;
		List<LoteVacunas> lotes = gestor.imprimirLotes();
		System.out.println("Seleccionar lote a repartir (introducir número)");
		for(int i = 0; i<lotes.size(); i++){
			System.out.println("Lote " + (i+1) + lotes.get(i).toString());
		}
		do {
			op2 = teclado.nextInt();
			if(op2>0 && op2<lotes.size()+1) {
				lote = lotes.get(op2-1);
				System.out.println("Lote seleccionado" + lote.toString());
			}
		} while (op2<1 || op2>lotes.size());
		String prioridad = null;
		do {
			System.out.println("Introduce el grupo de prioridad:\n"
					+ "1 - Joven\n"
					+ "2 - Adulto\n"
					+ "3 - Anciano");
			op2 = teclado.nextInt();
			switch (op2) {
			case 1:
				prioridad = "Joven";
				break;
			case 2:
				prioridad = "Adulto";
				break;
			case 3:
				prioridad = "Anciano";
				break;
			default:
				System.out.println(noValido);
				break;
			}
		} while (op2 < 1 || op2 > 3);
		List<EntregaVacunas> entregas = gestor.calcularEntregasRegion(lote, prioridad);
		for(int i = 0; i<entregas.size(); i++){
			System.out.println("Entrega " + (i+1) + entregas.get(i).toString());
		}
	}
}
