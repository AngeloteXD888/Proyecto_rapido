import java.io.FileWriter;
import java.io.IOException;

public class Escriturajson {
    public static void main(String[] args) {
        // Crear un JSON manualmente como String
        String json = "[\n" +
                "  {\"Marca\": \"Toyota\", \"Modelo\": \"Corolla\", \"Año\": 2020, \"Color\": \"Blanco\", \"Precio\": 25000.00},\n" +
                "  {\"Marca\": \"Honda\", \"Modelo\": \"Civic\", \"Año\": 2019, \"Color\": \"Azul\", \"Precio\": 22000.00}\n" +
                "]";

        // Escribir en un archivo
        escribirJson(json, "coches_salida.json");
    }

    public static void escribirJson(String json, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(json);
            System.out.println("Archivo JSON escrito correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }
}
