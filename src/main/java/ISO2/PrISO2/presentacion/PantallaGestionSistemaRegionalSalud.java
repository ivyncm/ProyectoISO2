package ISO2.PrISO2.presentacion;

import java.time.LocalDate;
import java.util.Scanner;

import ISO2.PrISO2.dominio.controller.GestorVacunacion;

public class PantallaGestionSistemaRegionalSalud {
	public static void main(String args[]) throws Exception {
		Scanner teclado=new Scanner(System.in);
		LocalDate fecha;
		GestorVacunacion vacunacion;
		int op1=0;
		int op2=0;
		String tipo = null;
        System.out.println("Bienvenido al Sistema de Salud Regional");
        System.out.println("seleccione una categoria de su interes.");

        do {
        	
	        System.out.println("1 - Dar de alta nueva entrega");
	        System.out.println("2 - Registrar vacunaciones");
	        System.out.println("3 - Salir");

	        op1 = Integer.parseInt(teclado.nextLine());
	        
			switch (op1){
	        case 1:
	        	fecha = LocalDate.now();
		        	
	        	do {
	        		System.out.println("Introduce el tipo de vacuna:\n");
		        	System.out.println("1 - Pfizer");
		        	System.out.println("2 - Moderna");
		        	System.out.println("3 - Astrazeneca");
		        	op2 = teclado.nextInt();
	        		switch (op2){
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
				}while(op2 < 1 || op2 > 3);

	        	System.out.println("Introduce el id del lote:");
	        	String idLote = teclado.next();
	        	System.out.println("Introduce la cantidad:");
	        	int cantidad = teclado.nextInt();
	        	System.out.println("Introduce el grupo prioritario:");
	        	String grupo = teclado.next();
	        	System.out.println("Introduce la región:");
	        	String region = teclado.next();       	
	        	vacunacion = new GestorVacunacion();
	        	vacunacion.altaEntregaVacunas(idLote, fecha, cantidad, grupo, region);
	        	break;
	        case 2:
	        	vacunacion = new GestorVacunacion();
	        	System.out.println("Introduce el DNI del paciente:");
	        	String dni = teclado.next();
	        	if(vacunacion.comprobarPaciente(dni)) {
	        		vacunacion.actualizarVacunacion(dni);
	        	} else {
	        		System.out.println("Introduce el nombre del paciente:");
		        	String nombre = teclado.nextLine();
		        	System.out.println("Introduce los apellidos del paciente:");
		        	String apellidos = teclado.nextLine();
		        	fecha = LocalDate.now();
		        	do {
		        		System.out.println("Introduce el tipo de vacuna:\n");
			        	System.out.println("1 - Pfizer");
			        	System.out.println("2 - Moderna");
			        	System.out.println("3 - Astrazeneca");
			        	op2 = teclado.nextInt();
		        		switch (op2){
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
					}while(op2 < 1 || op2 > 3);
		        
		        	boolean segDosis = false;
	        
	        	
		        	String op3;
		        	do {
		        		System.out.println("Es segunda dosis? s/n\n");
			        	op3 = teclado.next().toLowerCase();
		        		switch (op3){
					        case "s":
					        	segDosis = true;
					        	break;
					        case "n":
					        	segDosis = false;
					           break;
					        default:
					        	System.out.println("Opción no válida\n");
					        	break;
						}
					}while(op3 == "s" || op3 == "n");
		        	
		        	
		        	vacunacion.registrarVacunacion(fecha, nombre, apellidos, dni, tipo, segDosis);
	        	}
	        	break;
	        case 3:
	        	System.out.println("Sesión cerrada\n");
	        	break;
	        default:
	        	System.out.println("Opción no válida\n");
	        	break;
			}
		}while(op1 < 1 || op1 > 3);
        teclado.close();
	}
	
}