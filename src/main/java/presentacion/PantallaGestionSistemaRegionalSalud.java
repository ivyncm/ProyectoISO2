package presentacion;

import java.time.LocalDate;
import java.util.Scanner;

import dominio.controller.GestorVacunacion;
import dominio.entitymodel.Paciente;


public class PantallaGestionSistemaRegionalSalud {
	final static String noValida = "Opcion no valida\n";
	public static void main(String[] args) throws Exception {
		System.out.println("Bienvenido al Sistema de Salud Regional\n");
		String region = Region();
		menu(region);
	}

	public static void menu(String region) throws Exception {
		Scanner teclado = new Scanner(System.in);
		LocalDate fecha;
		GestorVacunacion vacunacion;
		int op1 = 0;
		String tipo = null;
		String grupo = null;
		do {
			System.out.println("1 - Dar de alta nueva entrega\n"
					+ "2 - Registrar vacunaciones\n"
					+ "3 - Consultar estadísticas\n"
					+ "4 - Salir");
			
			op1 = teclado.nextInt();
			switch (op1) {
			case 1:
				fecha = LocalDate.now();
				System.out.println("Introduce la cantidad:");
				int cantidad = teclado.nextInt();
				grupo = grupo();
				vacunacion = new GestorVacunacion();
				vacunacion.altaEntregaVacunas(fecha, cantidad, grupo, region);
				break;
			case 2:
				vacunacion = new GestorVacunacion();
				String dni, nombre, apellido1, apellido2;
				do {
					System.out.println("Introduce el DNI del paciente:");
					dni = teclado.next();
				}while(dniValido(dni));
				do {
					System.out.println("Introduce el nombre del paciente:");
					nombre = teclado.next();
				}while(soloLetras(nombre));
				do {
					System.out.println("Introduce el primer apellido del paciente:");
					apellido1 = teclado.next();
				}while(soloLetras(apellido1));
				do {
					System.out.println("Introduce el segundo apellido del paciente:");
					apellido2 = teclado.next();
				}while(soloLetras(apellido2));
				String apellidos = apellido1 + " " + apellido2;
				fecha = LocalDate.now();
				tipo = tipo();
				boolean segDosis = segDosis();
				grupo = grupo();
				Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);

				vacunacion.registrarVacunacion(fecha, tipo, segDosis, paciente);

				break;
			case 3:
				PantallaConsultaEstadisticas.estadRegion(region);
				break;
			case 4:
				System.out.println("Sesión cerrada\n");
				break;
			default:
				System.out.println(noValida);
				break;
			}
		} while (op1 < 1 || op1 > 4);
	}

	public static String Region() {
		int op = 0;
		Scanner teclado = new Scanner(System.in);
		String [] regiones = new String[] { "Andalucia", "Aragon", "Canarias", "Cantabria", "Castilla y Leon", "Castilla la Mancha",
				"Catalunya", "Ceuta", "Valencia", "Madrid", "Extremadura", "Galicia", "Baleares", "La Rioja", "Melilla",
				"Navarra", "Pais Vasco", "Asturias", "Murcia" };
		String region = null;
		do {
			System.out.println("Selecciona la region:\n");
			for (int i = 0; i < regiones.length; i++) {
				System.out.println(i + 1 + " - " + regiones[i]);
			}

			op = teclado.nextInt();
			switch (op) {
			case 1:case 2:case 3:case 4:case 5:
			case 6:case 7:case 8:case 9:case 10:
			case 11:case 12:case 13:case 14:case 15:
			case 16:case 17:case 18:case 19:
				region = regiones[op - 1];
				break;
			default:
				System.out.println(noValida);
				break;
			}
		} while (op < 1 || op > 19);
		return region;
	}

	public static String grupo() {
		String grupo = null;
		int op;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("Selecciona el grupo al que pertenece:\n"
					+ "1 - Anciano\n"
					+ "2 - Adulto\n"
					+ "3 - Joven");
			op = teclado.nextInt();
			switch (op) {
			case 1:
				grupo = "Anciano";
				break;
			case 2:
				grupo = "Adulto";
				break;
			case 3:
				grupo = "Joven";
				break;
			default:
				System.out.println(noValida);
				break;
			}
		} while (op < 1 || op > 3);
		return grupo;
	}

	public static String tipo() {
		int op2 = 0;
		Scanner teclado = new Scanner(System.in);
		String tipo = null;
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
				System.out.println(noValida);
				break;
			}
		} while (op2 < 1 || op2 > 3);
		return tipo;
	}

	public static boolean segDosis() {
		boolean segDosis = false;
		Scanner teclado = new Scanner(System.in);
		String op3;
		System.out.println("Es segunda dosis? s/n\n");
		op3 = teclado.next().toLowerCase();
		switch (op3) {
		case "s":
			segDosis = true;
			break;
		case "n":
			segDosis = false;
			break;
		default:
			System.out.println(noValida);
			segDosis();
			break;
		}
		return segDosis;
	}
	public static boolean dniValido(String dni) {
		String noValid = "DNI no valido";
        if(dni.length()!=9) {
            System.out.println(noValid);
            return true;
        }
        if(!(dni.substring(0,8).chars().allMatch(Character::isDigit))) {
            System.out.println(noValid);
            return true;
        }
        if(dni.substring(8,9).chars().allMatch(Character::isDigit)) {
            System.out.println(noValid);
            return true;
        }
		return false;
	}
	public static boolean soloLetras(String cadena) {
	    for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si no está entre a y z, ni entre A y Z, ni es un espacio
	        if (!((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z') || c == ' ')) {
	        	System.out.println("No introducir números.");
	            return true;
	        }
	    }
	    return false;
	}
}