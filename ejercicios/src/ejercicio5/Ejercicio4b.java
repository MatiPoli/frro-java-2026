package ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4b {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un entero: ");
        int numero = Integer.parseInt(sc.nextLine());

        System.out.println();
        System.out.println("Ingrese 20 enteros:");
        ArrayList<Integer> mayores = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int entero = Integer.parseInt(sc.nextLine());
            if (entero > numero) {
                mayores.add(entero);
            }
        }

        System.out.println();
        System.out.println("Mayores a " + numero + ":");
        for (int entero : mayores) System.out.println(entero);
        sc.close();
    }

}
