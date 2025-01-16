package SIS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void insert(JTextField nameF, JTextField fatherF, JTextField motherF, JTextField dobF, JTextField classNameF, JTextField phoneF, DefaultTableModel tableModel) {
        String name = nameF.getText();
        String fatherName = fatherF.getText();
        String motherName = motherF.getText();
        String dob = dobF.getText();
        String className = classNameF.getText();
        String phone = phoneF.getText();

        if (name.isEmpty() || fatherName.isEmpty() || motherName.isEmpty() || dob.isEmpty() || className.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out all the required fields.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students(student_name, father_name, mother_name, dob, class, phone_number) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, fatherName);
            preparedStatement.setString(3, motherName);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, className);
            preparedStatement.setString(6, phone);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            DB.loadTableData1(tableModel);
            JOptionPane.showMessageDialog(null, "Record(s) added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
