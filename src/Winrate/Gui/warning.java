package Winrate.Gui;
import javax.swing.JOptionPane;

public class warning {

        public static void infoBox(String infoMessage, String titleBar)
        {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
    }

