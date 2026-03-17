public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Primeros 10 Enteros:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        int cant = 0;
        int i = 1;

        System.out.println();
        System.out.println("Primeros 10 Primos:");
        while (cant < 10) {    
            if (i % 2 != 0) {
                System.out.println(i);
                cant++;
            }
            i++;
        }
    }
}
