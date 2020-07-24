import javax.mail.SendFailedException;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class WindowMain extends JFrame implements ActionListener {
    private static JLabel labelTopic;
    private static JLabel labelText;
    private static JLabel labelTo;
    private static JTextField textFieldTopic;
    private static JTextField textFieldTo;
    private static JTextField textFieldText;
    private static JButton buttonConfirm;
    private static JFormattedTextField proba1;
    private static JTextPane textPaneText;
    private String stringTopic;
    private String stringText;
    private String stringRecepient;
    private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


    public WindowMain() {
        labelTopic = new JLabel("Topic: ");
        labelText = new JLabel("Text: ");
        labelTo = new JLabel("To: ");
        textFieldTopic = new JTextField();
        textFieldTo = new JTextField("kamil.rogowski.test@gmail.com");
        proba1 = new JFormattedTextField();
        textPaneText = new JTextPane();
        textFieldText = new JTextField();
        buttonConfirm = new JButton();
        setLayout(null);
        //JLabels
        labelTopic.setBounds(10,40,100,25);
        labelText.setBounds(10,100,100,25);
        labelTo.setBounds(10,10,100,25);
        //JTextField
        textFieldTopic.setBounds(10,70,450,25);
        textFieldTo.setBounds(60,10,400,25);
        //JTextPane
        textPaneText.setBounds(10,130,450,250);
        textPaneText.setContentType("text/html");
        textPaneText.getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
        //JButton
        buttonConfirm.setBounds(175,400,125,30);
        buttonConfirm.setText("Send Mail");
        buttonConfirm.addActionListener(this);


        //input focus
        SwingUtilities.invokeLater(() -> {
            textFieldText.requestFocusInWindow();
            textPaneText.requestFocusInWindow();
            textPaneText.setCaretPosition(0);
        });



        //JFrame
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sending Mail");
        setResizable(false);
        add(buttonConfirm);
        add(labelTopic);
        add(labelText);
        add(labelTo);
        add(textFieldTo);
        add(textFieldTopic);
        add(textPaneText);

    }
    public void  actionPerformed(ActionEvent e){
        if (e.getSource() == buttonConfirm){
            stringTopic = textFieldTopic.getText();
            stringText = textPaneText.getText();
            stringRecepient = textFieldTo.getText();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(stringRecepient);
            if (matcher.matches())
            {
                JOptionPane.showMessageDialog(null, "Topic: \n" + stringTopic+ "\n" + "Text : \n" + stringText);
                JavaMail.sendMail(stringRecepient,stringTopic,stringText);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid mail ! \n Try again." );
            }



        }



    }
}
