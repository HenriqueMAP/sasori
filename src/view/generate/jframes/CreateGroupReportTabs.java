package view.generate.jframes;

import view.generate.jpanels.CreateReportTab;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class CreateGroupReportTabs {

    CreateReportTab reportTabOne = new CreateReportTab("Report One", Color.BLUE);
    CreateReportTab reportTabTwo = new CreateReportTab("Report Two", Color.GREEN);
    CreateReportTab reportTabThree = new CreateReportTab("Report Three", Color.RED);

    public CreateGroupReportTabs() {}

    public JTabbedPane generateGroupReportTabs() {

        JTabbedPane groupReportTabs = new JTabbedPane();

        groupReportTabs.add(reportTabOne);
        groupReportTabs.add(reportTabTwo);
        groupReportTabs.add(reportTabThree);

        managerReportTabOne();

        System.out.println("CreateGroupReportTabs - All Report tabs has been created.");

        return groupReportTabs;
    }

    public void managerReportTabOne() {
        if(reportTabOne.getComponentCount() == 0) {
            final JButton confirmLoadReportTabOne = new JButton();
            confirmLoadReportTabOne.setText("Report One has been load.");
            reportTabOne.add(confirmLoadReportTabOne);
        }
        if(reportTabTwo.getComponentCount() == 1) {
            reportTabTwo.removeAll();
            System.out.println("Report Tab Two all contents: " + reportTabTwo.getComponentCount());
        }
        if(reportTabThree.getComponentCount() == 1) {
            reportTabThree.removeAll();
            System.out.println("Report Tab Three all contents: " + reportTabThree.getComponentCount());
        }
    }

    public void managerReportTabTwo() {
        if(reportTabOne.getComponentCount() == 1) {
            reportTabOne.removeAll();
            System.out.println("Report Tab One all contents: " + reportTabOne.getComponentCount());
        }
        if(reportTabTwo.getComponentCount() == 0) {
            final JButton confirmLoadReportTabTwo = new JButton();
            confirmLoadReportTabTwo.setText("Report Two has been load.");
            reportTabTwo.add(confirmLoadReportTabTwo);
        }
        if(reportTabThree.getComponentCount() == 1) {
            reportTabThree.removeAll();
            System.out.println("Report Tab Three all contents: " + reportTabThree.getComponentCount());
        }
    }

    public void managerReportTabThree() {
        if(reportTabOne.getComponentCount() == 1) {
            reportTabOne.removeAll();
            System.out.println("Report Tab One all contents: " + reportTabOne.getComponentCount());
        }
        if(reportTabTwo.getComponentCount() == 1) {
            reportTabTwo.removeAll();
            System.out.println("Report Tab Two all contents: " + reportTabTwo.getComponentCount());
        }
        if(reportTabThree.getComponentCount() == 0) {
            final JButton confirmLoadReportTabThree = new JButton();
            confirmLoadReportTabThree.setText("Report Three has been load.");
            reportTabThree.add(confirmLoadReportTabThree);
        }
    }
}
