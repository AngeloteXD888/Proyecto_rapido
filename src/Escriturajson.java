import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escriturajson {
    public static void escribir(List<Coche> coches, String archivoSalida) throws IOException {
        try (FileWriter writer = new FileWriter(archivoSalida)) {
            writer.write("[\n");
            for (int i = 0; i < coches.size(); i++) {
                Coche coche = coches.get(i);
                writer.write(String.format("  {\n    \"marca\": \"%s\",\n    \"modelo\": \"%s\",\n    \"año\": %d,\n    \"color\": \"%s\",\n    \"precio\": %.2f\n  }",
                    coche.getMarca(),
                    coche.getModelo(),
                    coche.getAño(),
                    coche.getColor(),
                    coche.getPrecio()));
                if (i < coches.size() - 1) writer.write(",\n");
            }
            writer.write("\n]");
        }
    }
}

