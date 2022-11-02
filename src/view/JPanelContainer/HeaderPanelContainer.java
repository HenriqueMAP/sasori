package view.JPanelContainer;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class HeaderPanelContainer extends JPanel {

    final JLabel lblOperator = new JLabel("Operador: ");
    final JTextField txtOperador = new JTextField();

    final JLabel lblLogPath = new JLabel("Caminho: ");
    final JTextField txtPath = new JTextField();

    final JLabel lblComPort = new JLabel("COM Port: ");
    final JComboBox<String> comboBoxSerialPorts = new JComboBox<>();

    final JLabel lblIconRefreshSerialPort = new JLabel("");
    final JLabel lblBtVersion = new JLabel("Versão do BT: ");
    final JComboBox<String> comboBoxBtVersion = new JComboBox<>();

    private JButton btnConnect;
    private int objXCoordinate;
    private int objYCoordinate;
    private int objWidth;
    private int objHeight;

    private File FolderPath = null;
    public File getFolderPath() { return FolderPath; }

    private boolean connected = false;
    public boolean isConnected() { return connected;}
    public void setConnected(boolean connected) { this.connected = connected; }

    private boolean DEBUG = true;

    private int btVersionInt = 0;

    public int getBtVersionInt() {return btVersionInt;}

    public void setBtVersionInt(int btVersionInt) { this.btVersionInt = btVersionInt; }

    private SerialPort chosenPort;

    public SerialPort getChosenPort() { return chosenPort; }

    public void setChosenPort(SerialPort chosenPort) { this.chosenPort = chosenPort; }

    SerialPortConnection serialPort = new SerialPortConnection();

    private int adjustSize(Double size, Double percent) {
        Double adjustedSize = Double.valueOf(size.doubleValue() * percent.doubleValue() / 100.0D);
        return adjustedSize.intValue();
    }

    public void showMessage(String msg, String title, int type){
        JOptionPane paneDialog = new JOptionPane(msg, type);
        JDialog dialog = paneDialog.createDialog(title);
        dialog.pack();
        dialog.setVisible(true);
    }

    public File getPath() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        fc.setFileSelectionMode(1);
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == 0){
            File Folder = fc.getSelectedFile();
            return Folder;
        }
        return null;
    }

    public HeaderPanelContainer(JFrame jfrMainWindow, Double dWindowFrWidth, Double dWindowFrHeight) {

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(3.0D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(4.45D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(10.0D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(5.4D));

        lblOperator.setFont(new Font("Tahoma",1,14));
        lblOperator.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(lblOperator);

        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(0.1D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(4.4D));

        lblLogPath.setFont(new Font("Tahoma",1,14));
        lblLogPath.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(lblLogPath);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(9.1D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(5.5D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(13.1D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(3.5D));

        txtOperador.setFont(new Font("Tahoma",1,13));
        txtOperador.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(txtOperador);

        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(0.5D));

        txtPath.setFont(new Font("Tahoma",1,13));
        txtPath.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(txtPath);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(29.0D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(1.78D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(10.6D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(6.4D));

        lblComPort.setFont(new Font("Tahoma",1,14));
        lblComPort.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(lblComPort);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(35.3D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(3.35D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(17.0D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(3.5D));

        comboBoxSerialPorts.setFont(new Font("Tahoma",1,14));
        comboBoxSerialPorts.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(comboBoxSerialPorts);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(53.0D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(3.9D));

        lblIconRefreshSerialPort.setIcon(MainContainer.class.getResource(""));
        lblIconRefreshSerialPort.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(lblIconRefreshSerialPort);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(60.5D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(1.78D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(10.6D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(6.4D));

        lblBtVersion.setFont(new Font("Tahoma",1,14));
        lblBtVersion.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(lblBtVersion);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(68.5D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(3.35D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(5.0D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(3.5D));

        comboBoxBtVersion.setFont(new Font("Tahoma",1,14));
        comboBoxBtVersion.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        comboBoxBtVersion.addItem("");
        comboBoxBtVersion.addItem("4.0");
        comboBoxBtVersion.addItem("5.0");
        jfrMainWindow.add(comboBoxBtVersion);

        objXCoordinate = adjustSize(dWindowFrWidth,Double.valueOf(81.5D));
        objYCoordinate = adjustSize(dWindowFrHeight, Double.valueOf(1.63D));
        objWidth = adjustSize(dWindowFrWidth, Double.valueOf(14.0D));
        objHeight = adjustSize(dWindowFrHeight, Double.valueOf(7.0D));

        btnConnect = new JButton("Conectar");
        btnConnect.setFont(new Font("Tahoma",1,16));
        btnConnect.setBounds(objXCoordinate, objYCoordinate, objWidth, objHeight);
        jfrMainWindow.add(btnConnect);

        SerialPort[] comPorts = SerialPort.getCommPorts();
        SerialPort[] arrayOfSerialPort1;
        int quantityCommPorts = (arrayOfSerialPort1 = comPorts).length;

        for(int indexCommPort = 0; quantityCommPorts > indexCommPort; indexCommPort++) {

            SerialPort serialPort = arrayOfSerialPort1[indexCommPort];
            comboBoxSerialPorts.addItem(serialPort.getSystemPortName());
        }

        lblIconRefreshSerialPort.addMouseListener(
                new MouseAdapter() {

                    public void mouseClicked(MouseEvent mouseEvent) {

                        comboBoxSerialPorts.removeAllItems();

                        SerialPort[] comPorts = SerialPort.getCommPorts();
                        SerialPort[] arrayOfSerialPort1;
                        int quantityCommPorts = (arrayOfSerialPort1 = comPorts).length;

                        for(int indexCommPort = 0; quantityCommPorts > indexCommPort; indexCommPort++) {

                            SerialPort serialPort = arrayOfSerialPort1[indexCommPort];
                            comboBoxSerialPorts.addItem(serialPort.getSystemPortName());
                        }

                    }

                }
        );


        this.btnConnect.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent actionEvent) {

                        if(btnConnect.getText().equals("Conectar")) {

                            if(FolderPath == null) {
                                showMessage("Caminho inválido, favor corrigir.", "Caminho do Log: ", 0);
                            } else {
                                String operador = txtOperador.getText();
                                txtOperador.setText(operador);

                                if(operador.length() > 2) {
                                    String btVersion = comboBoxBtVersion.getSelectedItem().toString();

                                    if (btVersion == null || btVersion == "") {
                                        showMessage("Versão inválida, favor selecionar uma versão de BT Válida.", "Versão de BT", 0);
                                    } else {

                                        if (btVersion.contains("4.0")) {
                                            btVersionInt = 4;
                                        } else if (btVersion.contains("5.2")) {
                                            btVersionInt = 5;
                                        }

                                        try {
                                            chosenPort = SerialPort.getCommPort(comboBoxSerialPorts.getSelectedItem().toString());
                                            System.out.println("HeaderPanelContainer - btnConnect.addActionListener - chosenPort: " + chosenPort.getSystemPortName());
                                            chosenPort.setBaudRate(9600);
                                            boolean tryOpenPort = serialPort.SerialConectar(chosenPort, 9600, "1 bits", "8", "None", "None");

                                            if (tryOpenPort) {
                                                serialPortOpen = true;
                                                comboBoxSerialPorts.setEnabled(false);
                                                btnConnect.setText("Desconectar");
                                                txtOperador.setEditable(false);
                                                connected = true;
                                            } else {
                                                showMessage("Porta serial indisponível. Possivelmente está em uso por outro software.", "Porta serial", 0);
                                            }
                                        } catch(Exception exception) {
                                            exception.printStackTrace();
                                            System.out.println("HeaderPanelContainer - btnConnect.addActionListener - exception.getMessage(): " + exception.getMessage().toString());
                                            showMessage("Erro ao conectar a porta serial.", "Porta serial", 0);
                                        }
                                    }
                                }
                            }
                        } else {
                            serialPortOpen = false;
                            comboBoxSerialPorts.setEnabled(true);
                            chosenPort.closePort();
                            btnConnect.setText("Conectar");
                            txtOperador.setEditable(true);
                        }
                    }
                }
        );

        txtPath.addMouseListener(
                new MouseAdapter() {

                    public void mouseClicked(MouseEvent mouseEvent) {
                        FolderPath = getPath();
                        if (FolderPath.exists() && FolderPath != null) {
                            txtPath.setText(FolderPath.toString());
                        }
                    }
                }
        );
    }
}
