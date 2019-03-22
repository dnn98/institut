package principal;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		System.out.println("Cambio realizado por Dani en la rama 'dani'");
		Menu a = new Menu();
		a.inici();
	}
	public static int seleccionarInt() {
		int n=0;
	    Scanner scanner = new Scanner(System.in);
	    while (!scanner.hasNextInt()){
	        System.out.println("Error, introdueix un número: ");
	        scanner.nextLine();
	    }
	    n = scanner.nextInt();
	    return n;
	}
	public static String seleccionarString() {
		Scanner sc = new Scanner(System.in);
		String m = sc.nextLine();
		return m;
	}
}
