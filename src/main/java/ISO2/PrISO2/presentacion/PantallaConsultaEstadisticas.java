package ISO2.PrISO2.presentacion;

import java.util.Scanner;
import java.sql.*;

import ISO2.PrISO2.dominio.controller.GestorEstadisticas;

public class PantallaConsultaEstadisticas {
	public static void main(String args[]) throws Exception {
		String region = null;
		String regiones[] = new String[] {"Andalucía", "Aragón", "Canarias", "Cantabria", "Castilla y León", "Castilla-La Mancha", "Cataluña", 
		         "Ceuta", "Comunidad Valenciana", "Comunidad de Madrid", "Extremadura", "Galicia", "Islas Baleares", 
		         "La Rioja", "Melilla", "Navarra", "País Vasco", "Principado de Asturias", "Región de Murcia"};
		
		Scanner teclado=new Scanner(System.in);
    	GestorEstadisticas gestor =new GestorEstadisticas();
		int op1=0;
        System.out.printf("Bienvenido al Sistema Consulta de Estadisticas\n"
        		+ "seleccione una categoria de su interes\n");
        do {
	        System.out.println("1 - Consultar total vacunados");
	        System.out.println("2 - Consultar total vacunados por region");
	        System.out.println("3 - Consultar porcentajes vacunados sobre recibidas");
	        System.out.println("2 - Consultar porcentajes vacunados sobre recibidas en region");
	        System.out.println("5 - Salir");

	        op1 = teclado.nextInt();
	        switch (op1){
	        case 1:
	        	gestor.consultarTotalVacunados();
	        	break;
	        case 2: 
	        	for (String i:regiones){
	        		System.out.println("\n- " +i);
	        		gestor.consultarTotalVacunadosPorRegion(i);
	        	}
	        	break;
	        case 3: 
	        	gestor.consultarVacunasTotal();
	        	break;
	        case 4:
	        	break;
	        case 5:
	        	System.out.println("Sesión cerrada\n");
	        	break;
	        default:
	        	System.out.println("Opción no válida\n");
	        	break;
	        	
				}
        
        }while(op1 < 1 || op1 > 5);
	       
	
	
	}
}