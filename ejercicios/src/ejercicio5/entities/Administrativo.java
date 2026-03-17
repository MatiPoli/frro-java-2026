package ejercicio5.entities;

public class Administrativo extends Empleado {

    private int hsExtra;
    private int hsMes;

    public Administrativo() {
    }

    public Administrativo(int dni, String nombre, String apellido, String email, double sueldoBase, int hsExtra, int hsMes) {
        super(dni, nombre, apellido, email, sueldoBase);
        this.hsExtra = hsExtra;
        this.hsMes = hsMes;
    }

    public int getHsExtra() {
        return hsExtra;
    }

    public void setHsExtra(int hsExtra) {
        this.hsExtra = hsExtra;
    }

    public int getHsMes() {
        return hsMes;
    }

    public void setHsMes(int hsMes) {
        this.hsMes = hsMes;
    }

    @Override
    public double getSueldo() {
        return getSueldoBase() * ((hsExtra * 1.5) + hsMes) / hsMes;
    }

    @Override
    public String getDatos() {
        return super.getDatos() + " - Hs Extra: " + hsExtra + " - Hs Mes: " + hsMes;
    }

}
