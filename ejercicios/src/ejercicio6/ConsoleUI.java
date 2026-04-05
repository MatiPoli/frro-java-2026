package ejercicio6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ejercicio6.data.DataProduct;
import ejercicio6.entities.Product;

public class ConsoleUI {

    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        String op = "";
        do {
            System.out.println("\nlist - Listar productos");
            System.out.println("search - Mostrar producto por id");
            System.out.println("new - Crear producto");
            System.out.println("update - Actualizar producto");
            System.out.println("delete - Eliminar producto");
            System.out.println("exit - Salir");
            op = SCANNER.nextLine();
            switch (op) {
                case "list":
                    list();
                    break;
                case "search":
                    search();
                    break;
                case "new":
                    create();
                    break;
                case "update":
                    update();
                    break;
                case "delete":
                    delete();
                    break;
                case "exit":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!op.equals("exit"));

        SCANNER.close();
    }

    private static void list() {
        List<Product> products = DataProduct.getProducts();
        System.out.println("\nProductos:");
        System.out.println("--------------------");
        if (products.isEmpty()) {
            System.out.println("No hay productos");
        } else {
            for (Product product : products) {
                printProduct(product);
                
            }
        }
        System.out.println("--------------------");
    }

    private static void search() {
        System.out.println("\nIngrese el id del producto:");
        int id = Integer.parseInt(SCANNER.nextLine());
        Product p = DataProduct.getProductById(id);
        System.out.println("--------------------");
        if (p != null) {
            printProduct(p);
        } else {
            System.out.println("Producto no encontrado");
        }
        System.out.println("--------------------");
    }

    private static void create() {
        System.out.println("\nIngrese el nombre del producto:");
        String name = SCANNER.nextLine();
        System.out.println("Ingrese la descripción del producto:");
        String description = SCANNER.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double price = Double.parseDouble(SCANNER.nextLine());
        System.out.println("Ingrese el stock del producto:");
        int stock = Integer.parseInt(SCANNER.nextLine());
        System.out.println("¿El producto incluye envío? (true/false):");
        boolean shippingIncluded = Boolean.parseBoolean(SCANNER.nextLine());
        System.out.println("Fecha de deshabilitación? (dd/MM/yyyy):");
        String disabledOnStr = SCANNER.nextLine();
        Date disabledOn = null;
        if (!disabledOnStr.isEmpty()) {
            try {
                disabledOn = new SimpleDateFormat("dd/MM/yyyy").parse(disabledOnStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Se creará sin fecha de deshabilitación.");
            }
        }
        Product p = new Product(name, description, price, stock, shippingIncluded, disabledOn);
        int id = DataProduct.createProduct(p);
        System.out.println("--------------------");
        System.out.println("Producto creado con id: " + id);
        System.out.println("--------------------");
    }

    private static void update() {
        System.out.println("\nIngrese el id del producto a actualizar:");
        int id = Integer.parseInt(SCANNER.nextLine());
        Product p = DataProduct.getProductById(id);
        if (p != null) {
            System.out.println("Ingrese el nuevo nombre del producto (actual: " + p.getName() + "):");
            String name = SCANNER.nextLine();
            System.out.println("Ingrese la nueva descripción del producto (actual: " + p.getDescription() + "):");
            String description = SCANNER.nextLine();
            System.out.println("Ingrese el nuevo precio del producto (actual: " + p.getPrice() + "):");
            double price = Double.parseDouble(SCANNER.nextLine());
            System.out.println("Ingrese el nuevo stock del producto (actual: " + p.getStock() + "):");
            int stock = Integer.parseInt(SCANNER.nextLine());
            System.out.println("El producto incluye envío? (true/false) (actual: " + (p.isShippingIncluded() ? "Sí" : "No") + "):");
            boolean shippingIncluded = Boolean.parseBoolean(SCANNER.nextLine());
            System.out.println("Fecha de deshabilitación? (dd/MM/yyyy) (actual: " + (p.getDisabledOn() != null ? new SimpleDateFormat("dd/MM/yyyy").format(p.getDisabledOn()) : "No especificada") + "):");
            String disabledOnStr = SCANNER.nextLine();
            Date disabledOn = null;
            if (!disabledOnStr.isEmpty()) {
                try {
                    disabledOn = new SimpleDateFormat("dd/MM/yyyy").parse(disabledOnStr);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha inválido. Se mantendrá la fecha de deshabilitación actual.");
                }
            }
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            p.setStock(stock);
            p.setShippingIncluded(shippingIncluded);
            p.setDisabledOn(disabledOn);
            DataProduct.updateProduct(p);
            System.out.println("--------------------");
            System.out.println("Producto actualizado");
        } else {
            System.out.println("--------------------");
            System.out.println("Producto no encontrado");
        }
        System.out.println("--------------------");
    }

    private static void delete() {
        System.out.println("\nIngrese el id del producto:");
        int id = Integer.parseInt(SCANNER.nextLine());
        DataProduct.deleteProduct(id);
        System.out.println("--------------------");
        System.out.println("Producto eliminado");
        System.out.println("--------------------");
    }

    private static void printProduct(Product p) {
        System.out.println(
            "Id: " + p.getId()
                + " | Nombre: " + p.getName()
                + " | Descripción: " + p.getDescription()
                + " | Precio: " + p.getPrice()
                + " | Stock: " + p.getStock()
                + " | Envío incluido: " + (p.isShippingIncluded() ? "Sí" : "No")
                + " | Fecha de deshabilitación: " + (p.getDisabledOn() != null ? new SimpleDateFormat("dd/MM/yyyy").format(p.getDisabledOn()) : "No especificada"));
    }

}
