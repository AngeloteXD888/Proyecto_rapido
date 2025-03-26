import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Coche {
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

    public String toCSV() {
        return marca + "," + modelo + "," + año + "," + color + "," + precio;
    }

}

public class EscrituraCSV {
    public static void escribirCSV(String nombreArchivo, List<Coche> coches) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.append("Marca,Modelo,Año,Color,Precio\n");
            for (Coche coche : coches) {
                writer.append(coche.toCSV()).append("\n");
            }
            System.out.println("Archivo CSV creado con éxito: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<Coche> coches = List.of(
            new Coche("Toyota", "Corolla", 2020, "Blanco", 25000.00),
            new Coche("Honda", "Civic", 2019, "Azul", 22000.00),
            new Coche("Ford", "Focus", 2018, "Gris", 20000.00),
            new Coche("Chevrolet", "Cruze", 2021, "Rojo", 26000.00)
        );

        escribirCSV("coches_salida.csv", coches);
    }
}
