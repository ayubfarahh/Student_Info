package SIS;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Main {

    public Main(){
        JFrame frame = new JFrame("Student Information System");
        frame.setSize(1280,720);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Heading of the page
        // Inside frame

        JLabel topLabel = new JLabel("Student Information System");
        topLabel.setFont(new Font("Comic Sans MS",1,46));
        topLabel.setForeground(Temps.white);
        topLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Temps.white,Temps.white));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setBounds(20,10,1240,96);
        frame.getContentPane().add(topLabel);

        // Adding tabs to the main
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,110,1280,540);
        tabbedPane.addTab("Student Info", Tab1.createTab());
        tabbedPane.addTab("Fee Info", Tab2.createTab());
        frame.getContentPane().add(tabbedPane);


        //Background image

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("C:/Users/ayubf/IdeaProjects/Student/src/SIS/img21.jpg"));
        background.setBounds(0,0,1280,700);
        frame.getContentPane().add(background);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(Main::new);
    }
}
