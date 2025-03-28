import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GestorArchivos {
    private static String rutaCarpeta = "";
    private static String archivoSeleccionado = "";
    private static List<Map<String, String>> datos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Seleccionar carpeta");
            System.out.println("2. Lectura de archivo");
            System.out.println("3. Conversión a otro formato");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la ruta de la carpeta: ");
                    rutaCarpeta = scanner.nextLine();
                    if (!Files.isDirectory(Paths.get(rutaCarpeta))) {
                        System.out.println("Carpeta no encontrada.");
                        rutaCarpeta = "";
                    } else {
                        listarArchivos();
                    }
                    break;
                case 2:
                    if (rutaCarpeta.isEmpty()) {
                        System.out.println("Seleccione una carpeta primero.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del archivo: ");
                    archivoSeleccionado = scanner.nextLine();
                    if (!Files.exists(Paths.get(rutaCarpeta, archivoSeleccionado))) {
                        System.out.println("Archivo no encontrado.");
                        archivoSeleccionado = "";
                    } else {
                        leerArchivo();
                    }
                    break;
                case 3:
                    if (archivoSeleccionado.isEmpty()) {
                        System.out.println("Seleccione un archivo primero.");
                        break;
                    }
                    System.out.print("Seleccione el formato de salida (csv, json, xml): ");
                    String formato = scanner.nextLine();
                    System.out.print("Ingrese el nombre del archivo de salida: ");
                    String nombreSalida = scanner.nextLine();
                    escribirArchivo(formato, nombreSalida);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    
    private static void listarArchivos() {
        File carpeta = new File(rutaCarpeta);
        System.out.println("Contenido de la carpeta:");
        for (File archivo : Objects.requireNonNull(carpeta.listFiles())) {
            System.out.println(archivo.getName());
        }
    }
    
    private static void leerArchivo() {
        String extension = archivoSeleccionado.substring(archivoSeleccionado.lastIndexOf('.') + 1);
        switch (extension) {
            case "csv":
                datos = LecturaCSV.leerCSV(rutaCarpeta + "/" + archivoSeleccionado);
                break;
            case "json":
                datos = LecturaJSON.leerJSON(rutaCarpeta + "/" + archivoSeleccionado);
                break;
            case "xml":
                datos =LecturaXML.leerXML(rutaCarpeta + "/" + archivoSeleccionado);
                break;
            default:
                System.out.println("Formato no soportado.");
                datos.clear();
        }
    }

    private static void escribirArchivo(String formato, String nombreSalida) throws IOException {
        if (datos.isEmpty()) {
            System.out.println("No hay datos para escribir.");
            return;
        }
        
        String rutaSalida = rutaCarpeta + "/" + nombreSalida;
        switch (formato.toLowerCase()) {
            case "csv":
                EscrituraCSV.escribir(null, rutaSalida);
                break;
            case "json":
                Escriturajson.escribir(null, rutaSalida);
                break;
            case "xml":
                EscrituraXML.escribir(null, rutaSalida);
                break;
            default:
                System.out.println("Formato no soportado.");
        }
    }
}

