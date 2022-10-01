package view.generate.jframes;

import view.generate.jpanels.CreateHeaderWindow;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;

public class CreateMainWindow extends JFrame implements ChangeListener {

    final GridLayout mainWindowGridLayout = new GridLayout(2,1,5,5);
    final CreateHeaderWindow createHeaderWindow = new CreateHeaderWindow();
    final CreateGroupReportTabs createGroupReportTabs = new CreateGroupReportTabs();

    final JTabbedPane generatedGroupReportTabs = createGroupReportTabs.generateGroupReportTabs();

    public CreateMainWindow(final String mainContainerName, final int mainContainerWidth, final int mainContainerHeight,
                                final int mainContainerPositionX, final int mainContainerPositionY) {
        setTitle(mainContainerName);
        setSize(mainContainerWidth, mainContainerHeight);
        setLocation(mainContainerPositionX, mainContainerPositionY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        generateGridLayout();
        setVisible(true);
        setEnabled(true);
        System.out.println("CreateMainWindow - Window has been created.");
    }

    public void generateGridLayout() {
        System.out.println("CreateMainWindow - generateGridLayout(): BEGIN");

        final int sizeGroupReportTabs = generatedGroupReportTabs.getComponents().length;
        for(int indexReportTab = 0;  sizeGroupReportTabs > indexReportTab; indexReportTab++ ) {
            generatedGroupReportTabs.addChangeListener(this);
        }

        this.setLayout(mainWindowGridLayout);
        this.add(createHeaderWindow);
        this.add(generatedGroupReportTabs);

        System.out.println("CreateMainWindow - generateGridLayout(): END");
    }


    @Override
    public void stateChanged(final ChangeEvent changeEvent) {
        final JTabbedPane reportTabClicked = (JTabbedPane) changeEvent.getSource();
        final int indexReportTab = reportTabClicked.getSelectedIndex();
        System.out.println("CreateMainWindow | ChangeListener - Tab changed to: " + indexReportTab);
        System.out.println("CreateMainWindow | ChangeListener - Tab changed to: " + reportTabClicked.getTitleAt(indexReportTab));

        switch(indexReportTab){
            case 0:
                createGroupReportTabs.managerReportTabOne();
                break;
            case 1:
                createGroupReportTabs.managerReportTabTwo();
                break;
            case 2:
                createGroupReportTabs.managerReportTabThree();
                break;
        }
    }
}
