package SIS;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Tab2 {
    public static JPanel createTab(){
        JPanel fi = new JPanel(null);
        fi.setBorder(new SoftBevelBorder(BevelBorder.RAISED,Temps.white,Temps.white));
        fi.setOpaque(false);
        return fi;
    }
}
