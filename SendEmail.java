package Project;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.activation.*;

public class SendEmail {

    public static String sendMail(String recepient, int id) throws Exception {
        System.out.println("Preparing to send mail");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true"); //for gmail mandatory to use username and password
        properties.put("mail.smtp.starttls.enable", "true"); //for gmail we have to enable starttls
        properties.put("mail.smtp.host", "smtp.gmail.com"); //for gmail host
        properties.put("mail.smtp.port", "587"); // gmail port no

        String myAccountEmail = "kjhotelsystem@gmail.com"; //sending email
        String password = "kjayaratna69"; //password of the email
        

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }

        });

        Message message = prepareMessage(session, myAccountEmail, recepient, id);

        Transport.send(message);
        System.out.println("Message sent succesfully");
        return recepient;

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, int id) throws IOException {
        

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            
            message.setSubject("KJ Hotel Room Check Out Bill");
            
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Dear Customer, \n Thank You for choosing KJ Hotels. The attached file is your Bill. \nThank You! ");
            
            MimeBodyPart pdfAttachment=new MimeBodyPart();
            pdfAttachment.attachFile("D:\\SLIIT\\YEAR 02\\SEMESTER 02\\PPA\\PROJECT\\hotelCheckOut\\"+id+".pdf");
            
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(pdfAttachment);
            
            message.setContent(multipart);
            
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
