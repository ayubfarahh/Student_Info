package SIS;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
    // Method to establish connection with the database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/sis";
            String username = "student";
            String password = "student";

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to the database: " + ex.getMessage(), "Database Connection Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }

    // Method to load data into the JTable
    public static void loadTableData1(DefaultTableModel tableModel) {
        try {
            Connection connection = getConnection();
            if (connection == null) {
                throw new RuntimeException("Database connection failed!");
            }

            // Clear the existing rows in the table model
            tableModel.setRowCount(0);

            // Query the students table
            String query = "SELECT id, father_name, dob, class, phone_number FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Populate the table model with the retrieved data
            while (resultSet.next()) {
                Object[] row = new Object[5];
                row[0] = resultSet.getInt("id");
                row[1] = resultSet.getString("father_name");
                row[2] = resultSet.getString("dob");
                row[3] = resultSet.getString("class");
                row[4] = resultSet.getString("phone_number");
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error loading table data: " + ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
