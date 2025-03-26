import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaJSON {
 public static List<Map<String, String>> leerJSON(String rutaArchivo) {
        List<Map<String, String>> datos = new ArrayList<>();
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }
             String json = contenido.toString().trim();
             json = json.substring(1, json.length() - 1); 
             String[] pares = json.split(",");
 
            Map<String, String> fila = new HashMap<>();
            for (String par : pares) {
                String[] claveValor = par.split(":");
                String clave = claveValor[0].trim().replace("\"", "");  
                String valor = claveValor[1].trim().replace("\"", ""); 
                fila.put(clave, valor);
            }
            datos.add(fila);
        } catch (IOException e) {
            System.out.println("Error al leer JSON: " + e.getMessage());
        }
        return datos;
    }
}
