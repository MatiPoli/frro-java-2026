import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese 10 palabras: ");
        ArrayList<String> palabras = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            palabras.add(sc.nextLine());
        }
        System.out.println();
        System.out.println("Palabras dadas vueltas:");
        for (String palabra : palabras.reversed()) {
            System.out.println(palabra);
        }
        sc.close();
    }

}
