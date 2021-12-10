package presentacion;

import java.util.List;
import java.util.Scanner;

import dominio.controller.GestorEstadisticas;

public class PantallaConsultaEstadisticas {
	public static void estadNacional() throws Exception {
		String porcentajeVacunados = "Porcentaje vacunados: %.3f%n";
		List<Integer> totalVacunados;
		Boolean seguir = true;
		String[] regiones = new String[] { "Andalucia", "Aragon", "Canarias", "Cantabria", "Castilla y Leon", "Castilla la Mancha",
				"Catalunya", "Ceuta", "Valencia", "Madrid", "Extremadura", "Galicia", "Baleares", "La Rioja", "Melilla",
				"Navarra", "Pais Vasco", "Asturias", "Murcia" };

		Scanner teclado = new Scanner(System.in);
		GestorEstadisticas gestor = new GestorEstadisticas();
		int op1 = 0;
		System.out.printf(
				"Bienvenido al Sistema Consulta de Estadisticas\n" + "seleccione una categoria de su interes\n");
		do {
			System.out.println("1 - Consultar total vacunados\n"
					+ "2 - Consultar total vacunados por region\n"
					+ "3 - Consultar porcentajes vacunados sobre recibidas\n"
					+ "4 - Consultar porcentajes vacunados sobre recibidas en region\n"
					+ "5 - Volver");

			op1 = teclado.nextInt();
			switch (op1) {
			case 1:
				totalVacunados = gestor.consultarTotalVacunados();
				imprimirTotalVacunados(totalVacunados);
				break;
			case 2:
				for (String i : regiones) {
					System.out.println("\n- " + i);
					totalVacunados = gestor.consultarTotalVacunadosPorRegion(i);
					imprimirTotalVacunados(totalVacunados);
				}
				break;
			case 3:
				double porcentaje = gestor.consultarPorcentajeVacunadosSobreRecibidas();
				System.out.printf(porcentajeVacunados, porcentaje * 100);
				break;
			case 4:
				List<Double> porcentajeRegion;
				for (String i : regiones) {
					System.out.println("\n- " + i);
					porcentajeRegion = gestor.consultarPorcentajeVacunadosSobreRecibidasEnRegion(i);
					if (porcentajeRegion.get(1) == 0) {
						System.out.println("Porcentaje vacunados: 0,000%");
					} else {
						System.out.printf(porcentajeVacunados, (porcentajeRegion.get(0) / porcentajeRegion.get(1)) * 100);
					}
				}
				break;
			case 5:
				PantallaGestionSistemaSaludNacional.menu();
				seguir = false;
				break;
			default:
				System.out.println(Auxiliares.noValida);
				break;
			}

		} while (seguir);
		teclado.close();
	}
	
	public static void imprimirTotalVacunados (List<Integer> totalVacunados) {
		System.out.println("Una dosis: " + (totalVacunados.get(0) - totalVacunados.get(1)) 
				+"\nPauta completa: " + totalVacunados.get(0));
	}
	
	public static void estadRegion(String region) throws Exception {
		String porcentajeVacunados = "Porcentaje vacunados: %.3f%n";
		Boolean seguir = true;
		Scanner teclado = new Scanner(System.in);
		GestorEstadisticas gestor = new GestorEstadisticas();
		int op1 = 0;
		System.out.printf(
				"Bienvenido al Sistema Consulta de Estadisticas\n" + "seleccione una categoria de su interes\n");
		do {
			System.out.println("\n1 - Consultar total vacunados"
					+ "\n2 - Consultar porcentajes vacunados sobre recibidas\n"
					+ "3 - Volver");

			op1 = teclado.nextInt();
			List<Integer> totalVacunados;
			List<Double> porcentajeRegion;
			
			switch (op1) {
			case 1:
				System.out.println("\n- " + region);
				totalVacunados = gestor.consultarTotalVacunadosPorRegion(region);
				System.out.println("Una dosis: " + (totalVacunados.get(0) - totalVacunados.get(1)) 
						+"\nPauta completa: " + totalVacunados.get(0));
				break;
			case 2:
				System.out.println("\n- " + region);
				porcentajeRegion = gestor.consultarPorcentajeVacunadosSobreRecibidasEnRegion(region);
				if (porcentajeRegion.get(1) == 0) {
					System.out.println("Porcentaje vacunados: 0,000%");
				} else {
					System.out.printf(porcentajeVacunados, (porcentajeRegion.get(0) / porcentajeRegion.get(1)) * 100);
				}
				break;
			case 3:
				PantallaGestionSistemaRegionalSalud.menu(region);
				seguir = false;
				break;
			default:
				System.out.println(Auxiliares.noValida);
				break;
			}

		} while (seguir);
		teclado.close();
	}
}