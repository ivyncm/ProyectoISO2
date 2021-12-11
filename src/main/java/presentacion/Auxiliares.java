package presentacion;

import java.util.Scanner;

public class Auxiliares {
	static String[] cadenaGrupo = {"grupo de prioridad", "Anciano", "Adulto", "Joven"};
	static String[] cadenaTipo = {"tipo de vacuna", "Pfizer", "Moderna", "Astrazeneca"};
	static String noValida = "Opcion no valida\n";
	
	
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
	
	public static String menu3Cadenas(String[] cadenas) {
        String grupo = null;
        int op;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.printf("Selecciona el %s%n 1 - %s%n 2 - %s%n 3 - %s%n", 
                    cadenas[0], cadenas[1], cadenas[2], cadenas[3]);
            op = teclado.nextInt();
            switch (op) {
            case 1:
                grupo = cadenas[1];
                break;
            case 2:
                grupo = cadenas[2];
                break;
            case 3:
                grupo = cadenas[3];
                break;
            default:
                System.out.println(noValida);
                break;
            }
        } while (op < 1 || op > 3);
        return grupo;
    }

	
}
