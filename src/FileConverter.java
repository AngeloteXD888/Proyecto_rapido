import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class FileConverter {
    private static String selectedFolder = "";
    private static String selectedFile = "";
    private static List<Map<String, String>> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Seleccionar carpeta");
            System.out.println("2. Leer archivo");
            System.out.println("3. Convertir a otro formato");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    selectFolder(scanner);
                    break;
                case 2:
                    readFile(scanner);
                    break;
                case 3:
                    convertFile(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del menú. ¡Hasta la próxima!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void selectFolder(Scanner scanner) {
        System.out.print("Ingrese la ruta de la carpeta: ");
        String path = scanner.nextLine();
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            selectedFolder = path;
            System.out.println("Carpeta seleccionada: " + selectedFolder);
            System.out.println("Contenido:");
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                System.out.println(" - " + file.getName());
            }
        } else {
            System.out.println("La carpeta no existe o no es válida.");
        }
    }

    private static void readFile(Scanner scanner) {
        if (selectedFolder.isEmpty()) {
            System.out.println("Primero seleccione una carpeta.");
            return;
        }
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine();
        File file = new File(selectedFolder, fileName);
        if (!file.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }
        selectedFile = fileName;
        data.clear();
        
        if (fileName.endsWith(".csv")) {
            readCSV(file);
        } else if (fileName.endsWith(".json")) {
            readJSON(file);
        } else if (fileName.endsWith(".xml")) {
            readXML(file);
        } else {
            System.out.println("Formato no soportado.");
        }
    }

    private static void convertFile(Scanner scanner) {
        if (selectedFile.isEmpty() || data.isEmpty()) {
            System.out.println("Primero debe leer un archivo.");
            return;
        }
        System.out.print("Ingrese el formato de salida (csv/json/xml): ");
        String format = scanner.nextLine().toLowerCase();
        System.out.print("Ingrese el nombre del archivo de salida: ");
        String outputFile = scanner.nextLine();
        
        File output = new File(selectedFolder, outputFile + "." + format);
        if (format.equals("csv")) {
            writeCSV(output);
        } else if (format.equals("json")) {
            writeJSON(output);
        } else if (format.equals("xml")) {
            writeXML(output);
        } else {
            System.out.println("Formato no válido.");
        }
    }
    
    // Métodos de lectura 
    private static void readCSV(File file) { /* Implementación */ }
    private static void readJSON(File file) { /* Implementación */ }
    private static void readXML(File file) { /* Implementación */ }
    
    // Métodos de escritura 
    private static void writeCSV(File file) { /* Implementación */ }
    private static void writeJSON(File file) { /* Implementación */ }
    private static void writeXML(File file) { /* Implementación */ }
}
