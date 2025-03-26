import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Escriturajson {
    public static void main(String[] args) {
        // Crear un array JSON
        JSONArray cochesArray = new JSONArray();

        // Añadir coches al array
        cochesArray.put(new JSONObject()
                .put("Marca", "Toyota")
                .put("Modelo", "Corolla")
                .put("Año", 2020)
                .put("Color", "Blanco")
                .put("Precio", 25000.00));

        cochesArray.put(new JSONObject()
                .put("Marca", "Honda")
                .put("Modelo", "Civic")
                .put("Año", 2019)
                .put("Color", "Azul")
                .put("Precio", 22000.00));

        // Escribir el JSON en un archivo
        try (FileWriter file = new FileWriter("coches_salida.json")) {
            file.write(cochesArray.toString(4)); // 4 es la indentación
            file.flush();
            System.out.println("Archivo JSON creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
