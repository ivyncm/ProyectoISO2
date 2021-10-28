package ISO2.PrISO2.presentacion;

import java.util.Scanner;
import java.sql.*;

import ISO2.PrISO2.dominio.controller.GestorEstadisticas;

public class PantallaConsultaEstadisticas {
	public static void main(String args[]) throws Exception {
		Scanner teclado=new Scanner(System.in);
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
	        	GestorEstadisticas gestor =new GestorEstadisticas();
	        	gestor.consultarTotalVacunados();
	        	
	        	break;
	        case 2: 
	        	break;
	        case 3: 
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