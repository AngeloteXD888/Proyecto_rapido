import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaCSV {
 public static List<Map<String, String>> leerCSV(String rutaArchivo) {
        List<Map<String, String>> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String[] encabezados = br.readLine().split(",");
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                Map<String, String> fila = new HashMap<>();
                for (int i = 0; i < encabezados.length; i++) {
                    fila.put(encabezados[i], valores[i]);
                }
                datos.add(fila);
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer CSV: " + e.getMessage());
        }
        return datos;
}
}

