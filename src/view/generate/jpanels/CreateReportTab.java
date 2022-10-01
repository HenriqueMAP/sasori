package view.generate.jpanels;

import javax.swing.JPanel;
import java.awt.Color;

public class CreateReportTab extends JPanel {

    public CreateReportTab(final String reportTabName, final Color backgroundColor){
        setName(reportTabName);
        setBackground(backgroundColor);
        System.out.println("CreateReportTab has been created.");
    }
}
