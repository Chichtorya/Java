/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class Send {

    public void SendMail(String to, String sub, String msg) {
        String user ="badaoteam09@gmail.com";
        String pass = "rmzywjymhinncydn";
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        Session s = Session.getInstance(p, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
            MimeMessage m = new MimeMessage(s);
            m.setFrom(new InternetAddress(user));
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);
            m.setContent(msg, "text/html");
            Transport.send(m);
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

//    public static void main(String[] args) {
//        String s = "Check";
//        String ms = "abc123";
//        String mess = "<!DOCTYPE html>\n"
//                + "<html>\n"
//                + "    <head>\n"
//                + "        <meta charset=\"UTF-8\">\n"
//                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
//                + "    </head>\n"
//                + "    <body>\n"
//                + "        <div>TODO write content</div>\n"
//                + "        <a href=\"https://www.google.com/\">Mail dc reset là ..... </a>\n"
//                + "    </body>\n"
//                + "</html>\n"
//                + "";
//        Send.SendMail("nguyendat280801@gmail.com", s, mess, "badaoteam09@gmail.com", "rmzywjymhinncydn");
//    }
}
