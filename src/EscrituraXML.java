import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscrituraXML {
    public static void escribir(List<Coche> coches, String archivoSalida) throws IOException {
        try (FileWriter writer = new FileWriter(archivoSalida)) {
            writer.write("<coches>\n");
            for (Coche coche : coches) {
                writer.write(String.format("  <coche>\n    <marca>%s</marca>\n    <modelo>%s</modelo>\n    <año>%d</año>\n    <color>%s</color>\n    <precio>%.2f</precio>\n  </coche>\n",
                    coche.getMarca(),
                    coche.getModelo(),
                    coche.getAño(),
                    coche.getColor(),
                    coche.getPrecio()));
            }
            writer.write("</coches>");
        }
    }
}
