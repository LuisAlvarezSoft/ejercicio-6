import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Árbol Genealógico ---");
            System.out.println("1. Insertar miembro de la familia");
            System.out.println("2. Calcular edad promedio de la familia");
            System.out.println("3. Encontrar miembro más joven");
            System.out.println("4. Encontrar miembro de mayor edad");
            System.out.println("5. Contar hombres en la familia");
            System.out.println("6. Contar mujeres en la familia");
            System.out.println("7. Contar total de miembros en la familia");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese sexo (M/F): ");
                    String sexo = scanner.next().toUpperCase();
                    arbol.insertar(nombre, edad, sexo);
                    System.out.println("Miembro insertado correctamente.");
                    break;
                case 2:
                    System.out.println("Edad promedio de la familia: " + arbol.calcularEdadPromedio());
                    break;
                case 3:
                    System.out.println("Miembro más joven: " + arbol.obtenerMenorEdad());
                    break;
                case 4:
                    System.out.println("Miembro de mayor edad: " + arbol.obtenerMayorEdad());
                    break;
                case 5:
                    System.out.println("Cantidad de hombres: " + arbol.contarHombres());
                    break;
                case 6:
                    System.out.println("Cantidad de mujeres: " + arbol.contarMujeres());
                    break;
                case 7:
                    System.out.println("Total de miembros en la familia: " + arbol.contarMiembros());
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
