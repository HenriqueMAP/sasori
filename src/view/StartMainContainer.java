package view;

import view.generate.jframes.CreateMainWindow;

import java.awt.*;

public class StartMainContainer extends Thread {

    public StartMainContainer() {

        final String mainContainerName = "Ferramenta-BT";
        final int mainContainerWidth = 690;
        final int mainContainerHeight = 450;
        final int mainContainerPositionX = 100;
        final int mainContainerPositionY = 100;

        System.out.println("StartMainContainer - Starting the container.");
        CreateMainWindow createMainWindow = new CreateMainWindow(mainContainerName, mainContainerWidth, mainContainerHeight,
                mainContainerPositionX, mainContainerPositionY);
        EventQueue.invokeLater(new Thread() {
            @Override
            public void run() {
                super.run();
            }
        });
    }


    public static void main(String[] args) {
        //new StartMainContainer();
    }
}
