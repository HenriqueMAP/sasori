package view.generate.jframes;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class CreateMainWindow extends JFrame {

        public CreateMainWindow(final String mainContainerName, final int mainContainerWidth, final int mainContainerHeight,
                                final int mainContainerPositionX, final int mainContainerPositionY) {
            setTitle(mainContainerName);
            setSize(mainContainerWidth, mainContainerHeight);
            setLocation(mainContainerPositionX, mainContainerPositionY);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            setEnabled(true);
            System.out.println("CreateMainWindow - Window has been created.");
        }
}
