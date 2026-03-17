package ejercicio5.entities;

public class Vendedor extends Empleado {

    private double porcenComision;
    private double totalVentas;

    public Vendedor() {
    }

    public Vendedor(int dni, String nombre, String apellido, String email, double sueldoBase, double porcenComision, double totalVentas) {
        super(dni, nombre, apellido, email, sueldoBase);
        this.porcenComision = porcenComision;
        this.totalVentas = totalVentas;
    }

    public double getPorcenComision() {
        return porcenComision;
    }

    public void setPorcenComision(double porcenComision) {
        this.porcenComision = porcenComision;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public double getSueldo() {
        return getSueldoBase() + (porcenComision * totalVentas / 100);
    }

    @Override
    public String getDatos() {
        return super.getDatos() + " - % Com: " + porcenComision + " - T. Ventas: " + totalVentas;
    }

}
