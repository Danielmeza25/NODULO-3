package bibliotecavirtual;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Libro biblioteca = new Libro();

        System.out.println("1. AGREGAR LIBROS");
        biblioteca.agregarLibro("Fuego y Sangre", "George R. R. Martin", 2018, "Novela");
        biblioteca.agregarLibro("Blanca Olmedo", "Lucila Gamero de Medina", 1908, "Novela romantica");
        biblioteca.agregarLibro("Don Quijote de La Mancha", "Miguel de Cervantes Saavedra", 1605, "Novela de aevntura");
        biblioteca.mostrarLibrosDisponibles();

        System.out.println("\n");
        System.out.println("2. BUSCAR LIBROS");
        System.out.print("Ingrese el título: ");
        String busqueda = scanner.nextLine();
        biblioteca.buscarLibro(scanner, "Fuego");
        
        System.out.println("\n");
        System.out.println("3. PRESTAR LIBROS");
        biblioteca.prestarLibro(scanner, "Fuego y Sangre");

        System.out.println("\n");
        System.out.println("4. DEVOLVER LIBROS");
        biblioteca.devolverLibro(scanner, "Fuego y Sangre");

        System.out.println("\n");
        System.out.println("5. MOSTRAR LIBROS");
        biblioteca.mostrarLibrosDisponibles();
    }

}
