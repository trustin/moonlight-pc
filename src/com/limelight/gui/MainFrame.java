package com.limelight.gui;

import com.limelight.binding.PlatformBinding;
import com.limelight.nvstream.NvConnection;
import com.limelight.nvstream.http.NvHTTP;
import com.limelight.settings.PreferencesManager;
import com.limelight.settings.PreferencesManager.Preferences;
import org.xmlpull.v1.XmlPullParserException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * The main frame of Limelight that allows the user to specify the host and begin the stream.
 *
 * @author Diego Waxemberg
 *         <br>Cameron Gutman
 */
public class MainFrame {
    private JTextField hostField;
    private JButton    pair;
    private JButton    stream;
    private JFrame     limeFrame;

    /**
     * Gets the actual JFrame this class creates
     *
     * @return the JFrame that is the main frame
     */
    public JFrame getLimeFrame() {
        return limeFrame;
    }

    /**
     * Builds all components of the frame, including the frame itself and displays it to the user.
     */
    public void build() {
        limeFrame = new JFrame("Limelight");
        limeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container mainPane = limeFrame.getContentPane();

        mainPane.setLayout(new BorderLayout());

        JPanel centerPane = new JPanel();
        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));

        Preferences prefs = PreferencesManager.getPreferences();

        hostField = new JTextField();
        hostField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 24));
        hostField.setToolTipText("Enter host name or IP address");
        hostField.setText(prefs.getHost());
        hostField.setSelectionStart(0);
        hostField.setSelectionEnd(hostField.getText().length());

        stream = new JButton("Start Streaming");
        stream.addActionListener(createStreamButtonListener());
        stream.setToolTipText("Start the GeForce stream");

        pair = new JButton("Pair");
        pair.addActionListener(createPairButtonListener());
        pair.setToolTipText("Send pair request to GeForce PC");

        Box streamBox = Box.createHorizontalBox();
        streamBox.add(Box.createHorizontalGlue());
        streamBox.add(stream);
        streamBox.add(Box.createHorizontalGlue());

        Box pairBox = Box.createHorizontalBox();
        pairBox.add(Box.createHorizontalGlue());
        pairBox.add(pair);
        pairBox.add(Box.createHorizontalGlue());

        Box hostBox = Box.createHorizontalBox();
        hostBox.add(Box.createHorizontalStrut(20));
        hostBox.add(hostField);
        hostBox.add(Box.createHorizontalStrut(20));


        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalStrut(20));
        contentBox.add(hostBox);
        contentBox.add(Box.createVerticalStrut(5));
        contentBox.add(streamBox);
        contentBox.add(Box.createVerticalStrut(10));
        contentBox.add(pairBox);

        contentBox.add(Box.createVerticalGlue());

        centerPane.add(contentBox);
        mainPane.add(centerPane, "Center");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        limeFrame.setJMenuBar(createMenuBar());
        limeFrame.getRootPane().setDefaultButton(stream);
        limeFrame.setSize(300, 200);
        limeFrame.setLocation(dim.width / 2 - limeFrame.getSize().width / 2,
                              dim.height / 2 - limeFrame.getSize().height / 2);
        limeFrame.setResizable(false);
        limeFrame.setVisible(true);
    }

    /*
     * Creates the menu bar for the user to go to preferences, mappings, etc.
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem gamepadSettings = new JMenuItem("Gamepad Settings");
        JMenuItem generalSettings = new JMenuItem("Preferences");

        gamepadSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GamepadConfigFrame().build();
            }
        });

        generalSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PreferencesFrame().build();
            }
        });

        optionsMenu.add(gamepadSettings);
        optionsMenu.add(generalSettings);

        menuBar.add(optionsMenu);

        return menuBar;
    }

    /*
     * Creates the listener for the stream button- starts the stream process
     */
    private ActionListener createStreamButtonListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String host = hostField.getText();
                Preferences prefs = PreferencesManager.getPreferences();
                if (!host.equals(prefs.getHost())) {
                    prefs.setHost(host);
                    PreferencesManager.writePreferences(prefs);
                }
                // Limelight.createInstance(host);
                showApps();
            }
        };
    }

    /*
     * Creates the listener for the pair button- requests a pairing with the specified host
     */
    private ActionListener createPairButtonListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        pair();
                    }
                });
            }
        };
    }

    private void pair() {
        String macAddress;
        try {
            macAddress = NvConnection.getMacAddressString();
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        if (macAddress == null) {
            System.out.println("Couldn't find a MAC address");
            return;
        }

        NvHTTP httpConn;
        String message;
        try {
            httpConn = new NvHTTP(InetAddress.getByName(hostField.getText()),
                                  macAddress, PlatformBinding.getDeviceName());
            try {
                if (httpConn.getPairState()) {
                    message = "Already paired";
                } else {
                    int session = httpConn.getSessionId();
                    if (session == 0) {
                        message = "Pairing was declined by the target";
                    } else {
                        message = "Pairing was successful";
                    }
                }
            } catch (IOException e) {
                message = e.getMessage();
            } catch (XmlPullParserException e) {
                message = e.getMessage();
            }
        } catch (UnknownHostException e1) {
            message = "Failed to resolve host";
        }

        JOptionPane.showMessageDialog(limeFrame, message, "Limelight", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showApps() {
        String macAddress;
        try {
            macAddress = NvConnection.getMacAddressString();
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        if (macAddress == null) {
            System.out.println("Couldn't find a MAC address");
            return;
        }

        NvHTTP httpConn;
        try {
            String host = hostField.getText();
            httpConn = new NvHTTP(InetAddress.getByName(host),
                                  macAddress, PlatformBinding.getDeviceName());
            AppsFrame appsFrame = new AppsFrame(httpConn, host);
            appsFrame.build();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }


}
