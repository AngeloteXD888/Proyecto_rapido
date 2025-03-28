import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaXML{
   public static List<Map<String, String>> leerXML(String rutaArchivo) {
        List<Map<String, String>> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            Map<String, String> fila = null;
            String clave = "", valor = "";
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("<") && !linea.startsWith("<?") && !linea.startsWith("<!--")) {
                    if (linea.startsWith("</")) {
                        if (fila != null) {
                            datos.add(fila);
                            fila = null;
                        }
                    } else if (!linea.contains("/>") && linea.contains(">")) {
                        int startTag = linea.indexOf("<") + 1;
                        int endTag = linea.indexOf(">");
                        clave = linea.substring(startTag, endTag);
                        if (fila == null) {
                            fila = new HashMap<>();
                        }
                    } else if (linea.contains("</")) {
                        int startValue = linea.indexOf(">") + 1;
                        int endValue = linea.indexOf("</");
                        valor = linea.substring(startValue, endValue);
                        if (fila != null && !clave.isEmpty()) {
                            fila.put(clave, valor);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer XML: " + e.getMessage());
        }
        return datos;
    }
}
   