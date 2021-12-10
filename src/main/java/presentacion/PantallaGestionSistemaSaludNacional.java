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
				System.out.println(Auxiliares.noValida);
				break;
			}
		} while (op1 < 1 || op1 > 4);
		teclado.close();
	}
	
	public static void altaNuevoLote(GestorRepartoVacunas gestor) throws ControllerException {
		Scanner teclado = new Scanner(System.in);
		String tipo = Auxiliares.menu3Cadenas(Auxiliares.cadenaTipo);
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
		String prioridad = Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo);
		List<EntregaVacunas> entregas = gestor.calcularEntregasRegion(lote, prioridad);
		for(int i = 0; i<entregas.size(); i++){
			System.out.println("Entrega " + (i+1) + entregas.get(i).toString());
		}
	}
}
