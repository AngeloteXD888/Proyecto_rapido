import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscrituraCSV {
    public static void escribir(List<Coche> coches, String archivoSalida) throws IOException {
        try (FileWriter writer = new FileWriter(archivoSalida)) {
            writer.write("Marca,Modelo,Año,Color,Precio\n");
            for (Coche coche : coches) {
                writer.write(String.format("%s,%s,%d,%s,%.2f\n",
                    coche.getMarca(),
                    coche.getModelo(),
                    coche.getAño(),
                    coche.getColor(),
                    coche.getPrecio()));
            }
        }
    }
}

