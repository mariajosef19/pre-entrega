
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Articulo> lista = new ArrayList<>();

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n----- Menú de Artículos -----");
            System.out.println("1. Agregar un artículo nuevo");;
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar un artículo");
            System.out.println("4. Borrar un artículo");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    modificarArticulo(); 
                    break;
                case 4:
                    eliminarArticulo();
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        teclado.close();
    }

    public static void agregarArticulo() {
        System.out.print("ID: ");
        int id = teclado.nextInt();
        teclado.nextLine();
//validación de ID y nombre
        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {
                System.out.println("Ya existe un artículo con ese ID.");
                return;
            }
        }
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        for (Articulo articulo : lista) {
            if (articulo.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ya existe un artículo con ese nombre.");
                return;
            }
        }
//validación de precio
        System.out.print("Precio: ");
        double precio = teclado.nextDouble();
        if (precio < 0) {
            System.out.println(" El precio no puede ser negativo.");
            return;
        }
// Creación del nuevo artículo que se agrega a la lista
        Articulo nuevo = new Articulo(id, nombre, precio);
        lista.add(nuevo);
        System.out.println("Artículo agregado correctamente.");
    }

    
    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos registrados.");
        } else {
            System.out.println("Lista de artículos:");
            for (Articulo articulo : lista) {
                articulo.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
    System.out.print("Ingrese el ID del artículo a modificar: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {
                System.out.print("Nuevo nombre: ");
                 String nuevoNombre = teclado.nextLine();
                articulo.setNombre(nuevoNombre);
                
      
      System.out.print("Nuevo precio: ");
                double nuevoPrecio = teclado.nextDouble();
                if (nuevoPrecio < 0) {
                    System.out.println(" El precio no puede ser negativo.");
                    return;
                }
                articulo.setPrecio(nuevoPrecio);
                System.out.println(" Artículo modificado correctamente.");
                return;
            
        }
        System.out.println(" Artículo no encontrado.");}
    }

    public static void eliminarArticulo() {
        System.out.print("Ingrese el ID del artículo a borrar: ");
        int id = teclado.nextInt();

        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {
                lista.remove(articulo);
                System.out.println(" Artículo eliminado.");
                return;
            }
        }
        System.out.println(" Artículo no encontrado.");
    }
}