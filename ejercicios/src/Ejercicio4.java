import java.util.Scanner;

public class Ejercicio4 {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un entero: ");
        int numero = Integer.parseInt(sc.nextLine());

        System.out.println();
        System.out.println("Ingrese 20 enteros:");
        int[] mayores = new int[20];
        int cantidadMayores = 0;
        for (int i = 0; i < 20; i++) {
            int entero = Integer.parseInt(sc.nextLine());
            if (entero > numero) {
                mayores[cantidadMayores] = entero;
                cantidadMayores++;
            }
        }

        System.out.println();
        System.out.println("Mayores a " + numero + ":");
        if (cantidadMayores == 0) {
            System.out.println("No hay valores mayores.");
        } else {
            for (int i = 0; i < cantidadMayores; i++) {
                System.out.println(mayores[i]);
            }
        }
        sc.close();
    }
}
