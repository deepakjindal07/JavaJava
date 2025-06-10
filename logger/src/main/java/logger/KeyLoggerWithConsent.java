package logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KeyLoggerWithConsent extends JFrame implements KeyListener {

    private BufferedWriter writer;

    public KeyLoggerWithConsent() {
        // Setup UI
        setTitle("Key Logger - With User Consent");
       // setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Type here, keys will be logged...", SwingConstants.CENTER);
        add(label);
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);

        try {
            File logFile = new File("keylog.txt");
            writer = new BufferedWriter(new FileWriter(logFile, true)); // Append mode
            writer.write("\n--- New Session: " + getTimeStamp() + " ---\n");
        } catch (IOException e) {
            System.out.println("Could not create log file: " + e.getMessage());
        }
    }

    private String getTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            writer.write("[" + getTimeStamp() + "] Key Typed: " + e.getKeyChar() + "\n");
            writer.flush();
        } catch (IOException ioException) {
            System.out.println("Logging error: " + ioException.getMessage());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not logging here to avoid duplication
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not logging here to avoid duplication
    }

    public static void main(String[] args) {
        // Ask for user permission
        int consent = JOptionPane.showConfirmDialog(null,
                "This program will log your key presses for usability testing. Do you consent?",
                "User Consent Required", JOptionPane.YES_NO_OPTION);

        if (consent == JOptionPane.YES_OPTION) {
            SwingUtilities.invokeLater(KeyLoggerWithConsent::new);
        } else {
            System.out.println("User declined. Exiting.");
            System.exit(0);
        }
    }
}
