import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureConnect {
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

        // Establishing the connection
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connected to Azure SQL Database!");

            // Executing a SELECT * query on the "OrdersDemo2" table
            String query = "SELECT * FROM OrdersDemo2";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                // Process the query result
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String number = resultSet.getString("number");
                    String orders = resultSet.getString("orders");

                    System.out.println("Name: " + name + ", Number: " + number + ", Orders: " + orders);
                }
            } catch (SQLException e) {
                System.out.println("Error executing query. Error message: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection failed. Error message: " + e.getMessage());
        }
    }
}
