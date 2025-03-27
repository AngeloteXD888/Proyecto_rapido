public class Coche {
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private double precio;

    public Coche(String marca, String modelo, int año, String color, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }
}
