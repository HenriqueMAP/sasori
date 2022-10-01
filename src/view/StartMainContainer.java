package view;

import view.generate.jframes.CreateGroupReportTabs;
import view.generate.jframes.CreateMainWindow;
import view.generate.jpanels.CreateHeaderWindow;
import view.generate.jpanels.CreateReportTab;

import javax.swing.*;
import java.awt.*;

public class StartMainContainer {

    public StartMainContainer() {

        final String mainContainerName = "Ferramenta-BT";
        final int mainContainerWidth = 690;
        final int mainContainerHeight = 450;
        final int mainContainerPositionX = 100;
        final int mainContainerPositionY = 100;

        System.out.println("StartMainContainer - Starting the container.");
        CreateMainWindow createMainWindow = new CreateMainWindow(mainContainerName, mainContainerWidth, mainContainerHeight,
                mainContainerPositionX, mainContainerPositionY);

    }

    public static void main(String[] args) {
        new StartMainContainer();
    }
}
