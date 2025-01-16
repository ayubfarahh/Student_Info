package SIS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void delete(JTextField nameF, JTextField fatherF, JTextField motherF, JTextField dobF, JTextField classNameF, JTextField phoneF, JTextField idF , DefaultTableModel tableModel){
        String id = idF.getText().trim();
        String name = nameF.getText().trim();
        String fatherName = fatherF.getText().trim();
        String motherName = motherF.getText().trim();
        String dob = dobF.getText().trim();
        String className = classNameF.getText().trim();
        String phone = phoneF.getText().trim();

        boolean otherField= name.isEmpty() && fatherName.isEmpty() && motherName.isEmpty() && dob.isEmpty() && className.isEmpty();
        if(id.isEmpty()&& phone.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter either an ID or a phone number","Invalid input",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!otherField){
            JOptionPane.showMessageDialog(null,"Please clear all other fields before deleting.", "Invalid input",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement;

            if (!id.isEmpty()&& !phone.isEmpty()){
                preparedStatement = connection.prepareStatement("SELECT FROM students WHERE id =? OR phone_number = ?");
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,phone);
            }else if (!id.isEmpty()){
                preparedStatement = connection.prepareStatement("DELETE FROM students WHERE id= ?");
                preparedStatement.setString(1,id);
            }else {
                preparedStatement = connection.prepareStatement("DELETE FROM students WHERE phone_number = ?");
                preparedStatement.setString(1,phone);
            }

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            DB.loadTableData1(tableModel);

            JOptionPane.showMessageDialog(null,"record(s) deleted successfully", "Success",JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex.getMessage(),"Erorr",JOptionPane.ERROR_MESSAGE);
        }
    }
}
