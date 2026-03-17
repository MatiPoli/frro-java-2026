import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese 10 palabras: ");
        ArrayList<String> palabras = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            palabras.add(sc.nextLine());
        }

        System.out.println();
        System.out.print("Ingrese otra palabra: ");
        if (palabras.contains(sc.nextLine())) {
            System.out.println();
            System.out.println("La palabra se encuentra en la lista.");
        } else {
            System.out.println();
            System.out.println("La palabra no se encuentra en la lista.");
        }
        sc.close();
    }

}
