package SIS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SearchRecord {
    public static void searchRecord(JTextField nameF, JTextField fatherF, JTextField motherF, JTextField dobF, JTextField classNameF, JTextField phoneF,JTextField idF ,DefaultTableModel tableModel){
        String id = idF.getText().trim();
        String name = nameF.getText().trim();
        String fatherName = fatherF.getText().trim();
        String motherName = motherF.getText().trim();
        String dob = dobF.getText().trim();
        String className = classNameF.getText().trim();
        String phone = phoneF.getText().trim();
        try {
            Connection connection = DB.getConnection();
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM students WHERE 1=1");
            if (!id.isEmpty()) queryBuilder.append(" AND id= ?");
            if (!name.isEmpty()) queryBuilder.append(" AND student_name= ?");
            if (!fatherName.isEmpty()) queryBuilder.append(" AND father_name= ?");
            if (!motherName.isEmpty()) queryBuilder.append(" AND mother_name= ?");
            if (!dob.isEmpty()) queryBuilder.append(" AND dob= ?");
            if (!className.isEmpty()) queryBuilder.append(" AND class= ?");
            if (!phone.isEmpty()) queryBuilder.append(" AND phone_number= ?");


            PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString());
            int parameter = 1;
            if(!id.isEmpty()) preparedStatement.setString(parameter++,id);
            if(!name.isEmpty()) preparedStatement.setString(parameter++,name);
            if(!fatherName.isEmpty()) preparedStatement.setString(parameter++,fatherName);
            if(!motherName.isEmpty()) preparedStatement.setString(parameter++,motherName);
            if(!dob.isEmpty()) preparedStatement.setString(parameter++,dob);
            if(!className.isEmpty()) preparedStatement.setString(parameter++,className);
            if(!phone.isEmpty()) preparedStatement.setString(parameter++,phone);

            ResultSet resultSet = preparedStatement.executeQuery();
            tableModel.setRowCount(0);
            boolean found = false;

            while(resultSet.next()) {
                found = true;
                Vector<String> row = new Vector<>();
                row.add(resultSet.getString("id"));
                row.add(resultSet.getString("student_name"));
                row.add(resultSet.getString("father_name"));
                row.add(resultSet.getString("mother_name"));
                row.add(resultSet.getString("dob"));
                row.add(resultSet.getString("class"));
                row.add(resultSet.getString("phone_number"));
                tableModel.addRow(row);
            }
            if (!found) {
                JOptionPane.showMessageDialog(null,"No records found.","Search Result",JOptionPane.INFORMATION_MESSAGE);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage(),"Databe Error",JOptionPane.ERROR_MESSAGE);
        }
// Check all fields


    }
}
