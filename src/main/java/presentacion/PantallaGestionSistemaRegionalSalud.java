package presentacion;

import java.time.LocalDate;
import java.util.Scanner;

import dominio.controller.GestorVacunacion;
import dominio.entitymodel.Paciente;


public class PantallaGestionSistemaRegionalSalud {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Bienvenido al Sistema de Salud Regional\n");
		String region = Auxiliares.Region();
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
				grupo = Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo);
				vacunacion = new GestorVacunacion();
				vacunacion.altaEntregaVacunas(fecha, cantidad, grupo, region);
				break;
			case 2:
				vacunacion = new GestorVacunacion();
				
				fecha = LocalDate.now();
				tipo = Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo);
				boolean segDosis = Auxiliares.segDosis();
				
				Paciente paciente = DatosPaciente(region);

				vacunacion.registrarVacunacion(fecha, tipo, segDosis, paciente);

				break;
			case 3:
				PantallaConsultaEstadisticas.estadRegion(region);
				break;
			case 4:
				System.out.println("Sesión cerrada\n");
				break;
			default:
				System.out.println(Auxiliares.noValida);
				break;
			}
		} while (op1 < 1 || op1 > 4);
	}
	
	public static Paciente DatosPaciente(String region) {
		Scanner teclado = new Scanner(System.in);
		String dni, nombre, apellido1, apellido2, grupo;
		do {
			System.out.println("Introduce el DNI del paciente:");
			dni = teclado.next();
		}while(Auxiliares.dniValido(dni));
		do {
			System.out.println("Introduce el nombre del paciente:");
			nombre = teclado.next();
		}while(Auxiliares.soloLetras(nombre));
		do {
			System.out.println("Introduce el primer apellido del paciente:");
			apellido1 = teclado.next();
		}while(Auxiliares.soloLetras(apellido1));
		do {
			System.out.println("Introduce el segundo apellido del paciente:");
			apellido2 = teclado.next();
		}while(Auxiliares.soloLetras(apellido2));
		String apellidos = apellido1 + " " + apellido2;
		grupo = Auxiliares.menu3Cadenas(Auxiliares.cadenaGrupo);
		
		Paciente paciente = new Paciente(dni, nombre, apellidos, grupo, region);
		return paciente;
	}


}