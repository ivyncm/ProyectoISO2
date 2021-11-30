package presentacion;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.controller.GestorEstadisticas;

public class PantallaConsultaEstadisticas {
	public static void estadNacional() throws Exception {
		Boolean seguir = true;
		String regiones[] = new String[] { "Andalucia", "Aragon", "Canarias", "Cantabria", "Castilla y Leon", "Castilla la Mancha",
				"Catalunya", "Ceuta", "Valencia", "Madrid", "Extremadura", "Galicia", "Baleares", "La Rioja", "Melilla",
				"Navarra", "Pais Vasco", "Asturias", "Murcia" };

		Scanner teclado = new Scanner(System.in);
		GestorEstadisticas gestor = new GestorEstadisticas();
		int op1 = 0;
		System.out.printf(
				"Bienvenido al Sistema Consulta de Estadisticas\n" + "seleccione una categoria de su interes\n");
		do {
			System.out.println("1 - Consultar total vacunados");
			System.out.println("2 - Consultar total vacunados por region");
			System.out.println("3 - Consultar porcentajes vacunados sobre recibidas");
			System.out.println("4 - Consultar porcentajes vacunados sobre recibidas en region");
			System.out.println("5 - Volver");

			op1 = teclado.nextInt();
			switch (op1) {
			case 1:
				List<Integer> totalVacunados = new ArrayList<Integer>();
				totalVacunados = gestor.consultarTotalVacunados();
				System.out.println("Una dosis: " + (totalVacunados.get(0) - totalVacunados.get(1)));
				System.out.println("Pauta completa: " + totalVacunados.get(0));
				break;
			case 2:
				for (String i : regiones) {
					System.out.println("\n- " + i);
					gestor.consultarTotalVacunadosPorRegion(i);
				}
				break;
			case 3:
				gestor.consultarPorcentajeVacunadosSobreRecibidas();
				break;
			case 4:
				for (String i : regiones) {
					System.out.println("\n- " + i);
					gestor.consultarPorcentajeVacunadosSobreRecibidasEnRegion(i);
				}
				break;
			case 5:
				PantallaGestionSistemaSaludNacional.menu();
				seguir = false;
				break;
			default:
				System.out.println("Opción no válida\n");
				break;
			}

		} while (seguir);
		teclado.close();
	}

	public static void estadRegion(String region) throws Exception {
		Boolean seguir = true;
		Scanner teclado = new Scanner(System.in);
		GestorEstadisticas gestor = new GestorEstadisticas();
		int op1 = 0;
		System.out.printf(
				"Bienvenido al Sistema Consulta de Estadisticas\n" + "seleccione una categoria de su interes\n");
		do {
			System.out.println("\n1 - Consultar total vacunados");
			System.out.println("2 - Consultar porcentajes vacunados sobre recibidas");
			System.out.println("3 - Volver");

			op1 = teclado.nextInt();
			switch (op1) {
			case 1:
				System.out.println("\n- " + region);
				gestor.consultarTotalVacunadosPorRegion(region);

				break;
			case 2:
				System.out.println("\n- " + region);
				gestor.consultarPorcentajeVacunadosSobreRecibidasEnRegion(region);

				break;
			case 3:
				PantallaGestionSistemaRegionalSalud.menu(region);
				seguir = false;
				break;
			default:
				System.out.println("Opción no válida\n");
				break;
			}

		} while (seguir);
		teclado.close();
	}
}