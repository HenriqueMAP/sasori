package view.JPanelContainer;

public class ConnectThread extends Thread {

    HeaderPanelContainer myHeaderPanelContainer = null;
    MainContainer myMainContainer = null;

    public ConnectThread (final HeaderPanelContainer headerPanelContainer, final MainContainer mainContainer) {
        myHeaderPanelContainer = headerPanelContainer;
        myMainContainer = mainContainer;
    }

    public void run () {
        while(!myHeaderPanelContainer.isConnected()) {
            try{
                sleep(500);
            } catch(final InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        
        myMainContainer.getTabbedPane().setSelectedIndex(1);
        myMainContainer.getTabbedPane().setSelectedIndex(0);
    }

}
