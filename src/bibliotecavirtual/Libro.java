package bibliotecavirtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private List<Libro> libros;

    public Libro() {
        libros = new ArrayList<>();
    }
    
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponible;

    private Libro(String titulo, String autor, int anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = true; // Por defecto, el libro está disponible al ser creado
    }

    private String getTitulo() {
        return titulo;
    }

    private String getAutor() {
        return autor;
    }

    private boolean estaDisponible() {
        return disponible;
    }

    private void prestar() {
        disponible = false;
    }

    private void devolver() {
        disponible = true;
    }
    
    public void agregarLibro(String titulo, String autor, int anioPublicacion, String genero) {
        libros.add(new Libro(titulo, autor, anioPublicacion, genero));
    }

    public void buscarLibro(Scanner scanner, String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        if (!resultados.isEmpty()) {
            System.out.println("Resultados de la búsqueda por título:");
            for (Libro libro : resultados) {
                System.out.println(libro);
            }
        } else {
            System.out.println("No se encontraron resultados para la búsqueda por título.");
        }
    }

    public void prestarLibro(Scanner scanner, String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.estaDisponible()) {
                libro.prestar();
                System.out.println("Libro prestado: " + libro.getTitulo());
                return;
            }
        }
        System.out.println("El libro no está disponible para ser prestado.");
    }

    public void devolverLibro(Scanner scanner, String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.estaDisponible()) {
                libro.devolver();
                System.out.println("Libro devuelto: " + libro.getTitulo());
                return;
            }
        }
        System.out.println("El libro no puede ser devuelto o no existe en la biblioteca.");
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles en la biblioteca:");
        for (Libro libro : libros) {
            if (libro.estaDisponible()) {
                System.out.println(libro);
            }
        }
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
                ", autor: " + autor +
                ", año publicacion: " + anioPublicacion +
                ", genero: " + genero +
                ", disponible: " + disponible;
    }
}
