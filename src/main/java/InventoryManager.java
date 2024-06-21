import java.sql.*;
import java.util.Scanner;

public class InventoryManager {

    public static void insertarProducto(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Introduzca el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Introduzca la descripción del producto:");
        String descripcion = scanner.nextLine();
        System.out.println("Introduzca la cantidad del producto:");
        int cantidad = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduzca el precio del producto:");
        double precio = Double.parseDouble(scanner.nextLine());

        String sql = "INSERT INTO productos (nombre, descripcion, cantidad, precio) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, cantidad);
            pstmt.setDouble(4, precio);

            int filasInsertadas = pstmt.executeUpdate();
            System.out.println("Producto insertado correctamente. Filas afectadas: " + filasInsertadas);
        }
    }

    public static void actualizarCantidadProducto(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Introduzca el ID del producto:");
        int idProducto = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduzca la nueva cantidad:");
        int nuevaCantidad = Integer.parseInt(scanner.nextLine());

        String sql = "UPDATE productos SET cantidad = ? WHERE id = ?";

        ejecutarTransaccion(conn, scanner, sql, nuevaCantidad, idProducto);

        System.out.println("Cantidad actualizada correctamente.");
    }

    public static void mostrarTodosLosProductos(Connection conn) throws SQLException {
        String sql = "SELECT * FROM productos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Listado de Productos:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripción: " + descripcion +
                        ", Cantidad: " + cantidad + ", Precio: $" + precio);
            }
        }
    }

    public static void eliminarProducto(Connection conn, int idProducto) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);

            int filasEliminadas = pstmt.executeUpdate();
            System.out.println("Producto eliminado correctamente. Filas afectadas: " + filasEliminadas);
        }
    }

    public static void insertarCategoria(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Introduzca el nombre de la categoría:");
        String nombre = scanner.nextLine();
        System.out.println("Introduzca la descripción de la categoría:");
        String descripcion = scanner.nextLine();

        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);

            int filasInsertadas = pstmt.executeUpdate();
            System.out.println("Categoría insertada correctamente. Filas afectadas: " + filasInsertadas);
        }
    }

    public static void mostrarTodasLasCategorias(Connection conn) throws SQLException {
        String sql = "SELECT * FROM categorias";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Listado de Categorías:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripción: " + descripcion);
            }
        }
    }

    public static void eliminarCategoria(Connection conn, int idCategoria) throws SQLException {
        String sql = "DELETE FROM categorias WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCategoria);

            int filasEliminadas = pstmt.executeUpdate();
            System.out.println("Categoría eliminada correctamente. Filas afectadas: " + filasEliminadas);
        }
    }

    public static void insertarProveedor(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Introduzca el nombre del proveedor:");
        String nombre = scanner.nextLine();
        System.out.println("Introduzca la dirección del proveedor:");
        String direccion = scanner.nextLine();
        System.out.println("Introduzca el teléfono del proveedor:");
        String telefono = scanner.nextLine();

        String sql = "INSERT INTO proveedores (nombre, direccion, telefono) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, direccion);
            pstmt.setString(3, telefono);

            int filasInsertadas = pstmt.executeUpdate();
            System.out.println("Proveedor insertado correctamente. Filas afectadas: " + filasInsertadas);
        }
    }

    public static void mostrarTodosLosProveedores(Connection conn) throws SQLException {
        String sql = "SELECT * FROM proveedores";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Listado de Proveedores:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Dirección: " + direccion + ", Teléfono: " + telefono);
            }
        }
    }

    public static void eliminarProveedor(Connection conn, int idProveedor) throws SQLException {
        String sql = "DELETE FROM proveedores WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProveedor);

            int filasEliminadas = pstmt.executeUpdate();
            System.out.println("Proveedor eliminado correctamente. Filas afectadas: " + filasEliminadas);
        }
    }

    public static void actualizarProveedor(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Introduzca el ID del proveedor que desea actualizar:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduzca el nuevo nombre del proveedor:");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Introduzca la nueva dirección del proveedor:");
        String nuevaDireccion = scanner.nextLine();
        System.out.println("Introduzca el nuevo teléfono del proveedor:");
        String nuevoTelefono = scanner.nextLine();

        String sql = "UPDATE proveedores SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?";

        ejecutarTransaccion(conn, scanner, sql, nuevoNombre, nuevaDireccion, nuevoTelefono, id);

        System.out.println("Proveedor actualizado correctamente.");
    }

    public static void actualizarCategoria(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Introduzca el ID de la categoría que desea actualizar:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduzca el nuevo nombre de la categoría:");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Introduzca la nueva descripción de la categoría:");
        String nuevaDescripcion = scanner.nextLine();

        String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?";

        ejecutarTransaccion(conn, scanner, sql, nuevoNombre, nuevaDescripcion, id);

        System.out.println("Categoría actualizada correctamente.");
    }

    public static void ejecutarTransaccion(Connection conn, Scanner scanner, String sql, Object... parametros) throws SQLException {
        conn.setAutoCommit(false); // Start a transaction
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // Set transaction isolation level

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Operación realizada correctamente. Filas afectadas: " + filasAfectadas);

            conn.commit(); // Commit the transaction
        } catch (SQLException e) {
            conn.rollback(); // Rollback the transaction in case of error
            throw e;
        } finally {
            conn.setAutoCommit(true); // Restore default commit behavior
        }
    }
}