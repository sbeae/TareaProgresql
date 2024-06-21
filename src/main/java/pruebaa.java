import java.sql.*;
import java.util.Scanner;

public class pruebaa {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/InventoryManager", "postgres", "123456789");

        while (true) {
            System.out.println("¿Con qué entidad desea trabajar?");
            System.out.println("1. Productos");
            System.out.println("2. Categorías");
            System.out.println("3. Proveedores");
            System.out.println("4. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    mostrarMenuProductos(conn, scanner);
                    break;
                case 2:
                    mostrarMenuCategorias(conn, scanner);
                    break;
                case 3:
                    mostrarMenuProveedores(conn, scanner);
                    break;
                case 4:
                    System.out.println("Adiós!");
                    conn.close();
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void mostrarMenuProductos(Connection conn, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("¿Qué desea hacer con los productos?");
            System.out.println("1. Insertar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Regresar al menú principal");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    InventoryManager.insertarProducto(conn, scanner);
                    break;
                case 2:
                    InventoryManager.actualizarCantidadProducto(conn, scanner);
                    break;
                case 3:
                    InventoryManager.mostrarTodosLosProductos(conn);
                    break;
                case 4:
                    System.out.println("Introduzca el ID del producto que desea eliminar:");
                    int idProducto = Integer.parseInt(scanner.nextLine());
                    InventoryManager.eliminarProducto(conn, idProducto);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void mostrarMenuCategorias(Connection conn, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("¿Qué desea hacer con las categorías?");
            System.out.println("1. Insertar categoría");
            System.out.println("2. Actualizar categoría");
            System.out.println("3. Mostrar todas las categorías");
            System.out.println("4. Eliminar categoría");
            System.out.println("5. Regresar al menú principal");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    InventoryManager.insertarCategoria(conn, scanner);
                    break;
                case 2:
                    InventoryManager.actualizarCategoria(conn, scanner);
                    break;
                case 3:
                    InventoryManager.mostrarTodasLasCategorias(conn);
                    break;
                case 4:
                    System.out.println("Introduzca el ID de la categoría que desea eliminar:");
                    int idCategoria = Integer.parseInt(scanner.nextLine());
                    InventoryManager.eliminarCategoria(conn, idCategoria);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void mostrarMenuProveedores(Connection conn, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("¿Qué desea hacer con los proveedores?");
            System.out.println("1. Insertar proveedor");
            System.out.println("2. Actualizar proveedor");
            System.out.println("3. Mostrar todos los proveedores");
            System.out.println("4. Eliminar proveedor");
            System.out.println("5. Regresar al menú principal");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    InventoryManager.insertarProveedor(conn, scanner);
                    break;
                case 2:
                    InventoryManager.actualizarProveedor(conn, scanner);
                    break;
                case 3:
                    InventoryManager.mostrarTodosLosProveedores(conn);
                    break;
                case 4:
                    System.out.println("Introduzca el ID del proveedor que desea eliminar:");
                    int idProveedor = Integer.parseInt(scanner.nextLine());
                    InventoryManager.eliminarProveedor(conn, idProveedor);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
