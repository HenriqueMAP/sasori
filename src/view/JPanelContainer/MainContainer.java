package view.JPanelContainer;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Toolkit.getDefaultToolkit;

public class MainContainer extends JFrame implements ChangeListener {

    private int testStateMachine = 0;
    private int lastTestStateMachine = 0;
    private Double windowWidth;
    private Double windowHeight;

    public Double getWindowWidth() { return windowWidth; }

    public void setWindowWidth(final Double windowWidth) { this.windowHeight = windowWidth; }

    public Double getWindowHeight() { return windowHeight; }

    public void setWindowHeight(final Double windowHeight) { this.windowHeight = windowHeight; }

    private JTabbedPane tabbedPane = new JTabbedPane();

    public JTabbedPane getTabbedPane() { return tabbedPane; }

    public void setTabbedPane(final JTabbedPane tabbedPane) { this.tabbedPane = tabbedPane; }

    JPanel jpConfigureTab = new JPanel();
    JPanel jpSourceTestTab = new JPanel();
    JPanel jpInterfaceTestTab = new JPanel();
    JPanel jpBaudrateBTConfigTab = new JPanel();

    JButton btnChangeBTName = new JButton();
    JButton btnCheckName = new JButton("Consultar nome");
    JTextField txtDeviceName = new JTextField();
    AConfigDevice config = new ConfigDeviceBt4();

    JButton btnStartTest = new JButton("");
    JLabel lblInfoTest = new JLabel("");

    Boolean DEBUG = true;

    JList<Object> devicesList = new JList<>();
    JButton btnSearchDevices = new JButton("Buscar");
    JButton btnPair = new JButton("Parear");

    private ArrayList<String> devicesInfos = new ArrayList<>();

    BluetoothCommandsBt4 BTCmd = new BluetoothCommandsBt4();
    SerialPort chosenPort = null;
    SerialPortConnection serialPort = null;

    Boolean serialPortOpen = false;
    Logging log = new Logging();

    JLabel lblSearching = new JLabel();
    JLabel lblConnectedDevice = new JLabel();
    JLabel lblContinue = new JLabel();
    JLabel lblTextTestMeter = new JLabel();
    JLabel lblStopTest = new JLabel();

    JComboBox cbbBaudrateBT = new JComboBox();
    JButton btnBaudrateBT = new JButton();

    String getChosen[];
    String chosenBtDeviceName;
    String chosenBtDeviceMac;

    public int adjustSize(final Double size, final Double percent) {
        Double adjustedSize = size * (percent / 100.0D);
        return adjustedSize.intValue();
    }

    public void showMessage(final String msg, String title, int type) {
        JOptionPane paneDialog = new JOptionPane(msg, type);
        JDialog dialog = paneDialog.createDialog(title);
        dialog.pack();
        dialog.setVisible(true);
    }

    @Override
    public void stateChanged(final ChangeEvent changeEvent){

    }


    public MainContainer(){

        Dimension screenSize = getDefaultToolkit().getScreenSize();

        Double width = screenSize.getWidth();
        Double height = screenSize.getHeight();

        windowWidth = (width / 100.0D) * 75.0D;
        windowHeight = (height / 100.0D) * 80.0D;

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        this.setContentPane(contentPane);

        this.setSize(windowWidth.intValue(), windowHeight.intValue());
        this.setLocationRelativeTo(null);

        this.setIconImage(getDefaultToolkit().getImage(MainContainer.class.getResource("")));
        this.setTitle("Ferramenta de Configuração e Testes do Bluetooth CAS");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel jpStaticHeader = new HeaderPanelContainer(this, this.windowWidth, this.windowHeight);

        jpStaticHeader.setBorder(new EmptyBorder(5,5,5,5));
        jpStaticHeader.setLayout(null);
        jpStaticHeader.setVisible(true);
        this.getTabbedPane().add(jpStaticHeader);
        this.setVisible(true);

        tabbedPane.setVisible(false);
        tabbedPane.setFont(new Font("Tahoma", 1, 18));
        tabbedPane.setAlignmentY(0.0F);
        tabbedPane.setAlignmentX(0.0F);
        tabbedPane.setBounds(
                0, adjustSize(windowHeight, 16.1D),
                windowWidth.intValue(), adjustSize(windowHeight, 92.0D)
        );
        this.getContentPane().add(tabbedPane);

        jpConfigureTab.setLayout(null);
        tabbedPane.addTab("Configurar Bluetooth", null, jpConfigureTab, null);
        tabbedPane.setVisible(true);
        tabbedPane.setFocusable(true);

        jpSourceTestTab.setLayout(null);
        tabbedPane.addTab("Testar pela Fonte", null, jpSourceTestTab, null);

        jpInterfaceTestTab.setLayout(null);
        tabbedPane.addTab("Testar pela Interface", null, jpInterfaceTestTab, null);

        devicesList.setEnabled(false);
        devicesList.setFont(new Font("Tahoma",1,28));
        devicesList.setBounds(
                adjustSize(this.windowWidth, 18.8D),
                adjustSize(this.windowHeight, 21.5D),
                adjustSize(this.windowWidth, 60.2D),
                adjustSize(this.windowHeight, 44.73D)
        );

        devicesList.setBackground(SystemColor.menu);
        devicesList.setBorder(new BevelBorder(1,null,null,null,null));
        devicesList.setSelectionMode(0);
        devicesList.setVisible(false);
        devicesList.setAutoscrolls(true);



    }

}
