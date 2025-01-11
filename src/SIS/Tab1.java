package SIS;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class Tab1 {
    public static JPanel createTab(){
        JPanel si = new JPanel(null);
        si.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Temps.white,Temps.white));
        si.setOpaque(false);

        // Input panel + shape
        JPanel inputP = new JPanel(null);
        inputP.setBorder(new LineBorder(Temps.white,4,true));
        inputP.setBounds(10,10,320,350);
        inputP.setOpaque(false);

        // Heading for input panel
        JLabel label = new JLabel("Add Student Info", JLabel.CENTER);
        label.setFont(new Font("Comic Sans MS",1,15));
        label.setForeground(Temps.white);
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Temps.white, Temps.white));
        inputP.add(label);
        label.setBounds(10,10,300,30);

        //Text and Label
        JLabel nameL = new JLabel("Student Name:");
        nameL.setBorder(new LineBorder(Temps.white,1,true));
        nameL.setBounds(10,60,110,20);
        nameL.setOpaque(true);
        inputP.add(nameL);

        JTextField nameT = new JTextField("");
        nameT.setBounds(160,60,110,20);
        inputP.add(nameT);
        // Father
        JLabel fatherL = new JLabel("Father's Name");
        fatherL.setBorder(new LineBorder(Temps.white,1,true));
        fatherL.setBounds(10,110,110,20);
        fatherL.setOpaque(true);
        inputP.add(fatherL);

        JTextField fatherT = new JTextField("");
        fatherT.setBounds(160,110,110,20);
        inputP.add(fatherT);
        // Mother
        JLabel motherL = new JLabel("Mother's Name");
        motherL.setBorder(new LineBorder(Temps.white,1,true));
        motherL.setBounds(10,160,110,20);
        motherL.setOpaque(true);
        inputP.add(motherL);

        JTextField motherT = new JTextField("");
        motherT.setBounds(160,160,110,20);
        inputP.add(motherT);
        // class

        JLabel classL = new JLabel("Class");
        classL.setBorder(new LineBorder(Temps.white,1,true));
        classL.setBounds(10,210,110,20);
        classL.setOpaque(true);
        inputP.add(classL);

        JTextField classT = new JTextField("");
        classT.setBounds(160,210,110,20);
        inputP.add(classT);

        //DOB
        JLabel dobL = new JLabel("Date of birth");
        dobL.setBorder(new LineBorder(Temps.white,1,true));
        dobL.setBounds(10,260,110,20);
        dobL.setOpaque(true);
        inputP.add(dobL);

        JTextField dobT = new JTextField("");
        dobT.setBounds(160,260,110,20);
        inputP.add(dobT);

        // mobile number
        JLabel mobileL = new JLabel("Mobile Number");
        mobileL.setBorder(new LineBorder(Temps.white,1,true));
        mobileL.setBounds(10,310,110,20);
        mobileL.setOpaque(true);
        inputP.add(mobileL);

        JTextField mobileT = new JTextField("");
        mobileT.setBounds(160,310,110,20);
        inputP.add(mobileT);

        si.add(inputP);

        // Left panel
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBorder(new LineBorder(Temps.white,4,true));
        leftPanel.setOpaque(false);
        leftPanel.setBounds(340,10,920,100);
        // Left lable

        JLabel leftL = new JLabel("Enter ID", JLabel.CENTER);
        leftL.setFont(new Font("Comic Sans MS",1,15));
        leftL.setForeground(Temps.white);
        leftL.setBorder(new LineBorder(Temps.white,2,true));
        leftL.setBounds(11,5,900,40);
        leftPanel.add(leftL);
        // ID label
        JLabel idL = new JLabel("ID");
        idL.setBorder(new LineBorder(Temps.white,1,true));
        idL.setOpaque(true);
        idL.setBounds(10,60,110,20);
        leftPanel.add(idL);

        JTextField idT = new JTextField("");
        idT.setBounds(10,60,110,20);
        leftPanel.add(idT);

        si.add(leftPanel);
        return si;
    }
}
