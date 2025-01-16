package SIS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void update(JTextField nameF, JTextField fatherF, JTextField motherF, JTextField dobF, JTextField classNameF, JTextField phoneF, JTextField idF , DefaultTableModel tableModel){
        String id = idF.getText().trim();
        String name = nameF.getText().trim();
        String fatherName = fatherF.getText().trim();
        String motherName = motherF.getText().trim();
        String dob = dobF.getText().trim();
        String className = classNameF.getText().trim();
        String phone = phoneF.getText().trim();

        int parameter =1;

        if(id.isEmpty() && phone.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter either an ID or a phone number.","Inavlid input",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement;
            StringBuilder updateQuery = new StringBuilder("UPDATE students SET");
            if(!name.isEmpty()){
                updateQuery.append(" student_name= ?,");
            }
            if(!fatherName.isEmpty()){
                updateQuery.append(" father_name= ?,");
            }
            if(!motherName.isEmpty()){
                updateQuery.append(" mother_name= ?,");
            }
            if(!dob.isEmpty()){
                updateQuery.append(" dob= ?,");
            }
            if(!className.isEmpty()){
                updateQuery.append(" class= ?,");
            }
            if(!phone.isEmpty()){
                updateQuery.append(" phone_number= ?,");
            }
            updateQuery.deleteCharAt(updateQuery.length()-1);

            if(!id.isEmpty()){
                updateQuery.append(" WHERE id= ?");
            }else{
                updateQuery.append(" WHERE phone_number = ?");
            }

            preparedStatement=connection.prepareStatement(updateQuery.toString());
            if (!name.isEmpty()){
                preparedStatement.setString(parameter++,name);
            }
            if (!fatherName.isEmpty()){
                preparedStatement.setString(parameter++,fatherName);
            }
            if (!motherName.isEmpty()){
                preparedStatement.setString(parameter++,motherName);
            }
            if (!dob.isEmpty()){
                preparedStatement.setString(parameter++,dob);
            }
            if (!className.isEmpty()){
                preparedStatement.setString(parameter++,className);
            }
            if (!phone.isEmpty()){
                preparedStatement.setString(parameter++,phone);
            }

            preparedStatement.setString(parameter,id.isEmpty()?phone:id);

            int rowsAffected = preparedStatement.executeUpdate();
            connection.close();

            if(rowsAffected==0){
                JOptionPane.showMessageDialog(null,"No matching record for the provided ID or phone number.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            DB.loadTableData1(tableModel);
            JOptionPane.showMessageDialog(null,"records updated successfully,","Success",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);

        }
    }
}
