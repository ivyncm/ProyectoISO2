package ISO2.PrISO2.presentacion;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

import ISO2.PrISO2.dominio.controller.GestorRepartoVacunas;
import ISO2.PrISO2.dominio.entitymodel.LoteVacunas;

public class PantallaGestionSistemaSaludNacional {
	public static void main(String args[]) throws Exception {
		menu();
	}

	public static void menu() throws Exception {
		Scanner teclado = new Scanner(System.in);
		int op1 = 0;
		int op2 = 0;
		String tipo = null;
		System.out.println("Bienvenido al Sistema de Salud Nacional");
		System.out.println("seleccione una categoria de su interes.");

		do {
			System.out.println("1 - Dar de alta nuevo lote");
			System.out.println("2 - Calcular reparto");
			System.out.println("3 - Consultar estadísticas");
			System.out.println("4 - Salir");

			op1 = Integer.parseInt(teclado.next());
			GestorRepartoVacunas gestor = new GestorRepartoVacunas();
			switch (op1) {
			case 1:
				do {
					System.out.println("Introduce el tipo de vacuna:\n");
					System.out.println("1 - Pfizer");
					System.out.println("2 - Moderna");
					System.out.println("3 - Astrazeneca");
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
						System.out.println("Opción no válida\n");
						break;
					}
				} while (op2 < 1 || op2 > 3);

				System.out.println("Introduce la cantidad:");
				int cantidad = teclado.nextInt();
				

				LocalDate fecha = LocalDate.now();

				gestor.altaNuevoLoteVacunas(fecha, tipo, cantidad);
				break;
			case 2:
				List<LoteVacunas> lotes = gestor.imprimirLotes();
				for(LoteVacunas lote:lotes){
					System.out.println(lote.toString());
				}
				do {
					
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
						System.out.println("Opción no válida\n");
						break;
					}
				} while (op2 < 1 || op2 > 3);

				break;
			case 3:
				PantallaConsultaEstadisticas.estadNacional();
				break;
			case 4:
				System.out.println("Sesión cerrada\n");
				break;
			default:
				System.out.println("Opción no válida\n");
				break;
			}
		} while (op1 < 1 || op1 > 4);
		teclado.close();
	}
}