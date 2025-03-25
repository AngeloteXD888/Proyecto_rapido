import java.util.Scanner;

public class menu {
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo del menú. ¡Hasta la próxima!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

}
