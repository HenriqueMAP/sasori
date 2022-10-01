package view.generate.jpanels;

import javax.swing.JPanel;
import java.awt.Color;

public class CreateHeaderWindow extends JPanel {

    public CreateHeaderWindow() {
        setName("Header");
        setSize(690,100);
        setBackground(Color.BLACK);
        setLocation(0,0);
        setVisible(true);
        System.out.println("CreateHeaderWindows has been created.");
    }
}
