import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureInsert {
    public static void main(String[] args) {
        // Azure SQL Database connection details
        String server = "relailer-order-demo.database.windows.net";
        String database = "Retail_orders";
        String username = "retailer_admin@relailer-order-demo";
        String password = "asdzxc1234#";

        // Connection string
        String connectionString = String.format(
                "jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;",
                server, database, username, password);

        // Data to be inserted
        String name = "VSCodeJava";
        int number = 1111;
        String orders = "everything";

        // Establishing the connection
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connected to Azure SQL Database!");

            // Executing an INSERT query on the "OrdersDemo2" table
            String query = String.format(
                    "INSERT INTO OrdersDemo2 (name, number, orders) VALUES ('%s', %d, '%s')",
                    name, number, orders);

            try (Statement statement = connection.createStatement()) {
                int rowsAffected = statement.executeUpdate(query);

                System.out.println("Rows affected: " + rowsAffected);
            } catch (SQLException e) {
                System.out.println("Error executing query. Error message: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection failed. Error message: " + e.getMessage());
        }
    }
}
