import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;

public class WindowMain extends JFrame{
    private static JLabel labelTopic;
    private static JLabel labelText;
    private static JTextField textFieldTopic;
    private static JTextField textFieldText;
    private static JButton buttonConfirm;
    private static JFormattedTextField proba1;
    private static JTextPane textPaneText;

    public WindowMain() {
        labelTopic = new JLabel("Topic: ");
        labelText = new JLabel("Text: ");
        textFieldTopic = new JTextField();
        proba1 = new JFormattedTextField();
        textPaneText = new JTextPane();
        textFieldText = new JTextField();
        buttonConfirm = new JButton();
        setLayout(null);
        //JLabels
        labelTopic.setBounds(10,10,100,25);
        labelText.setBounds(10,70,100,25);
        //JTextField
        textFieldTopic.setBounds(10,40,450,25);
        //JTextPane
        textPaneText.setBounds(10,100,450,250);
        textPaneText.setContentType("text/html");
        textPaneText.getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
        //JButton
        buttonConfirm.setBounds(175,400,125,30);
        buttonConfirm.setText("Send Mail");


        //input focus
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textFieldText.requestFocusInWindow();
                textPaneText.requestFocusInWindow();
                textPaneText.setCaretPosition(0);
            }
        });

        //JFrame
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sending Mail");
        setResizable(false);
        add(labelTopic);
        add(labelText);
        add(textFieldTopic);
        add(textPaneText);
        add(buttonConfirm);
    }
}
