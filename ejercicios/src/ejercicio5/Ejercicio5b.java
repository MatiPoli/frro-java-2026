package ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio5.entities.Administrativo;
import ejercicio5.entities.Empleado;
import ejercicio5.entities.Vendedor;

public class Ejercicio5b {

    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        boolean next = true;
        int cant = 0;
        sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (cant <= 20 && next) {
            System.out.println("Empleado o Administrativo? e/a");
            
            switch (sc.nextLine()) {
                case "a":
                    Administrativo adm = new Administrativo();
                    input((Empleado) adm);
                    input(adm);
                    empleados.add(adm);
                    break;
                default:
                    Vendedor ven = new Vendedor();
                    input((Empleado) ven);
                    input(ven);
                    empleados.add(ven);
                    break;
            } 

            System.out.println("Ingresar otro? si/no");
            switch (sc.nextLine()) {
                case "n":
                case "no":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
            cant++;
            System.out.println();
        }

        for (Empleado empleado : empleados) {
            System.out.println(empleado.getDatosLista());
        }
        sc.close();
    }

    private static void input(Empleado empleado) {
        System.out.println("DNI: ");
        empleado.setDni(Integer.parseInt(sc.nextLine()));
        System.out.println("Nombre: ");
        empleado.setNombre(sc.nextLine());
        System.out.println("Apellido: ");
        empleado.setApellido(sc.nextLine());
        System.out.println("Email: ");
        empleado.setEmail(sc.nextLine());
        System.out.println("Sueldo Base: ");
        empleado.setSueldoBase(Integer.parseInt(sc.nextLine()));
    }

    private static void input(Administrativo administrativo) {
        System.out.println("Horas Extra: ");
        administrativo.setHsExtra(Integer.parseInt(sc.nextLine()));
        System.out.println("Horas Mes: ");
        administrativo.setHsMes(Integer.parseInt(sc.nextLine()));
    }

    private static void input(Vendedor vendedor) {
        System.out.println("Porcentaje Comisión: ");
        vendedor.setPorcenComision(Double.parseDouble(sc.nextLine()));
        System.out.println("Total Ventas: ");
        vendedor.setTotalVentas(Integer.parseInt(sc.nextLine()));
    }

}
