import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {
    public static void sendMail(String recepient){
        System.out.println("Preparing to send e-mail");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        String accountEmail = "kamil.rogowski.test@gmail.com"; // <-- Your mail
        String password ="kamiltest"; // <-- Password to your mail



        Session session = Session.getInstance(properties, new Authenticator(){
            @Override protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountEmail, password);
            }
        });

        Message message = prepareMessage(session,accountEmail,recepient);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Message sent successfully");

    }
    private static Message prepareMessage(Session session, String accountEmail,String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(accountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("here is topic");
            message.setText("Here is text inside e-mail");
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
