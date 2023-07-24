import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class brevoEmailSender {
    public static void main(String[] args) {
        // SMTP server information
        String host = "smtp-relay.sendinblue.com";
        int port = 587;

        // Sender and recipient information
        String from = "mythorganization.beta@gmail.com";
        String to = "chamakchoudhuri@gmail.com"; // Replace with the recipient's email address

        // Sender's credentials (authentication)
        String username = "mythorganization.beta@gmail.com";
        String password = "O3Jn96LSIQREczb8";

        // Set the properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS encryption
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // or "TLSv1.3" if supported by the server

        // Create a Session instance
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Test Email from Java");
            message.setText("This is a test email sent from Java using the JavaMail API.");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
