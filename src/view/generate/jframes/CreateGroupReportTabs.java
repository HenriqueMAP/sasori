package view.generate.jframes;

import view.generate.jpanels.CreateReportTab;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class CreateGroupReportTabs {

    public CreateGroupReportTabs() {
//        setName("Group Report Tabs");
//        setSize(690,250);
//        setLocation(0,250);
    }

    public JTabbedPane getGroupReportTabs() {

        CreateReportTab reportTabOne = new CreateReportTab();
        CreateReportTab reportTabTwo = new CreateReportTab();
        CreateReportTab reportTabThree = new CreateReportTab();

        JTabbedPane groupReportTabs = new JTabbedPane();

        groupReportTabs.add(reportTabOne);
        groupReportTabs.add(reportTabTwo);
        groupReportTabs.add(reportTabThree);

//        groupReportTabs.setSize(100,100);
//        groupReportTabs.setLocation(0,100);
        groupReportTabs.setVisible(true);
        groupReportTabs.setEnabled(true);
//        setVisible(true);
//        setEnabled(true);
        System.out.println("CreateGroupReportTabs - All Report tabs has been created.");

        return groupReportTabs;
    }
}
