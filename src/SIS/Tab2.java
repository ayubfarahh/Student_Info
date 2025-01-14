package SIS;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tab2 {
    public static JPanel createTab(){
        JPanel fi = new JPanel(null);
        fi.setBorder(new SoftBevelBorder(BevelBorder.RAISED,Temps.white,Temps.white));
        fi.setOpaque(false);

        JPanel inputP2 = new JPanel(null);
        inputP2.setBorder(new LineBorder(Temps.white,4,true));
        inputP2.setBounds(10,10,320,350);
        inputP2.setOpaque(false);

        // Label details and text

        JLabel addD = new JLabel("Add Details", JLabel.CENTER);
        addD.setFont(new Font("Comic Sans MS",1,15));
        addD.setForeground(Temps.white);
        addD.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Temps.white,Temps.white));
        addD.setBounds(10,10,300,30);
        inputP2.add(addD);
        // ID
        JLabel idL = new JLabel("ID");
        idL.setOpaque(true);
        idL.setBorder(new LineBorder(Temps.white, 2, true));
        idL.setBounds(10,60,110,20);
        inputP2.add(idL);

        JTextField idF = new JTextField("");
        idF.setBounds(160,60,110,20);
        inputP2.add(idF);

        // Submission date
        JLabel dateL = new JLabel("Submission Date");
        dateL.setBorder(new LineBorder(Temps.white,2,true));
        dateL.setOpaque(true);
        dateL.setBounds(10,110,110,20);
        inputP2.add(dateL);

        JTextField dateF = new JTextField("");
        dateF.setBounds(160,110,110,20);
        inputP2.add(dateF);

        JLabel monthL = new JLabel("Month");
        monthL.setBorder(new LineBorder(Temps.white,2,true));
        monthL.setOpaque(true);
        monthL.setBounds(10,160,110,20);
        inputP2.add(monthL);

        String[] months={"","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String>monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(160,160,110,20);
        inputP2.add(monthComboBox);
        // FEES AMOUNT
        JLabel amountL = new JLabel("Amount");
        amountL.setBorder(new LineBorder(Temps.white,2,true));
        amountL.setOpaque(true);
        amountL.setBounds(10,210,110,20);
        inputP2.add(amountL);

        JTextField amountF = new JTextField("");
        amountF.setBounds(160,210,110,20);
        inputP2.add(amountF);

        // Details panel

        JPanel detailsP = new JPanel(null);
        detailsP.setBorder(new LineBorder(Temps.white,4,true));
        detailsP.setBounds(340,10,920,150);
        detailsP.setOpaque(false);

        // Info labels and fetchers
        JLabel infoL = new JLabel("Info Tab", JLabel.CENTER);
        infoL.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Temps.white,Temps.white));
        infoL.setFont(new Font("Comic Sans MS", 1,18));
        infoL.setForeground(Temps.white);
        infoL.setBounds(11,5,900,40);
        detailsP.add(infoL);

        JLabel idInfoL = new JLabel("ID");
        idInfoL.setBorder(new LineBorder(Temps.white,1,true));
        idInfoL.setOpaque(true);
        idInfoL.setBounds(10,60,110,20);
        detailsP.add(idInfoL);

        JLabel getIDLabel = new JLabel();
        getIDLabel.setBorder(new LineBorder(Temps.white,1,true));
        getIDLabel.setOpaque(true);
        getIDLabel.setBounds(130,60,110,20);
        detailsP.add(getIDLabel);

        // Dad label
        JLabel fatherL = new JLabel("Father's Name");
        fatherL.setBorder(new LineBorder(Temps.white,1,true));
        fatherL.setOpaque(true);
        fatherL.setBounds(10,110,110,20);
        detailsP.add(fatherL);

        JLabel getFatherL = new JLabel();
        getFatherL.setBorder(new LineBorder(Temps.white,1,true));
        getFatherL.setOpaque(true);
        getFatherL.setBounds(130,110,110,20);
        detailsP.add(getFatherL);

        // Name label
        JLabel nameL = new JLabel("Name");
        nameL.setBorder(new LineBorder(Temps.white,1,true));
        nameL.setOpaque(true);
        nameL.setBounds(560,60,110,20);
        detailsP.add(nameL);

        JLabel getNameL = new JLabel();
        getNameL.setBorder(new LineBorder(Temps.white,1,true));
        getNameL.setOpaque(true);
        getNameL.setBounds(730,60,110,20);
        detailsP.add(getNameL);

        //Class label
        JLabel classL = new JLabel("Class");
        classL.setBorder(new LineBorder(Temps.white,1,true));
        classL.setOpaque(true);
        classL.setBounds(560,110,110,20);
        detailsP.add(classL);

        JLabel getClassL = new JLabel();
        getClassL.setBorder(new LineBorder(Temps.white,1,true));
        getClassL.setOpaque(true);
        getClassL.setBounds(730,110,110,20);
        detailsP.add(getClassL);

        // TABLE

        JPanel tablePanel = new JPanel(null);
        tablePanel.setBounds(340,170,920,230);

        JTable outputTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Month");
        tableModel.addColumn("Submission Date");
        tableModel.addColumn("Tuition Fee");
        tableModel.addColumn("Amount Paid");
        tableModel.addColumn("Pending");
        outputTable.setModel(tableModel);

        // adding scroll to the table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(outputTable);
        scrollPane.setBounds(0,0,920,220);
        tablePanel.add(scrollPane);


        fi.add(detailsP);
        fi.add(inputP2);
        return fi;
    }
}
