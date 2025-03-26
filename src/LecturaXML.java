import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaXML{
    public static void LecturaXML{
     try {
            String linea;
            String archivoEntrada;
            BufferedReader reader = new BufferedReader(new FileReader( archivoEntrada));

            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split("\\s+");

                if (valores.length > 1) {
                    String jugador = valores[1];
                    int censuradasEnLinea = 0;
                    StringBuilder nuevaLinea = new StringBuilder();

                    for (String archivo : valores) {
                        if (archivo.length() > 1 && archivo.contains(archivo.toLowerCase())) {
                        } else {
                            nuevaLinea.append(archivo).append(" ");
                        }
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
   