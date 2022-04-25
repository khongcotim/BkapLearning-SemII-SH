package com.controller.admin;

import com.entity.Teachers;
import com.implement.TeacherAccImpIAcc;
import com.security.HashPassMD5;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.crypto.spec.PBEKeySpec;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

@Controller
@RequestMapping(value = "sendMail")
public class testHashPass {
    //    @Autowired
//    private static JavaMailSender mailSender = new JavaMailSenderImpl();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập pass cần mã hóa");
        String inputPass = scanner.nextLine();
        HashPassMD5 hashPassMD5 = new HashPassMD5();
        System.out.println("Mã MD5 đã mã hóa là: " + hashPassMD5.toMD5(inputPass));
    }
//////        b3e6c0385f05a0be6b8225a5d4620613
////        System.out.println();
////        System.out.println("VUi lòng nhập mật khẩu: ");
////        String pass = scanner.nextLine();
////        System.out.println("Vui lòng nhập mã hóa: ");
////        String hashedPass = scanner.nextLine();
////        System.out.println(hashPassMD5.verifyMD5(hashedPass,pass));
////        if (hashPassMD5.verifyMD5(hashedPass,pass) == true)
////            System.out.println("Đúng");
////        else
////            System.out.println("Sai");
////        đổi mật khẩu,userName
//        //nhập mail
////        System.out.println("Vui lòng điền email mà bạn muốn đổi mật khẩu: ");
////        String email = scanner.nextLine();
////        TeacherAccImpIAcc teacherAccImpIAcc = new TeacherAccImpIAcc();
////        Teachers teacherFound = teacherAccImpIAcc.findByEmail(email);
////        if (teacherFound!= null){
////            System.out.println("Vui lòng nhập userName mới: ");
////            String newUser = scanner.nextLine();
////            System.out.println("Vui lòng nhập mật khẩu mới: ");
////            String newPass = scanner.nextLine();
////            teacherFound.setPassword(hashPassMD5.toMD5(newPass));
////            teacherFound.setUserName(newUser);
////            boolean check_update = teacherAccImpIAcc.update(teacherFound);
////            if (check_update == true)
////                System.out.println("Cập nhật tài khoản thành công !!!");
////            else
////                System.out.println("Cập nhật tài khoản thất bại !!!");
////        }else
////            System.out.println("Không tìm thấy tài khoản!!!");
//
//        //test send mail
//
//        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//        // Get a Properties object
//        Properties props = System.getProperties();
//        props.setProperty("mail.smtp.host", "smtp.gmail.com");
//        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");
//        props.setProperty("mail.smtp.port", "465");
//        props.setProperty("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
//        props.put("mail.store.protocol", "pop3");
//        props.put("mail.transport.protocol", "smtp");
//        final String username = "testSendMailSpringMvc@gmail.com";//
//        final String password = "uchiha78";
//        try{
//            Session session = Session.getDefaultInstance(props,
//                    new Authenticator(){
//                        protected PasswordAuthentication getPasswordAuthentication() {
//                            return new PasswordAuthentication(username, password);
//                        }});
//
//            // -- Create a new message --
//            Message msg = new MimeMessage(session);
//
//            // -- Set the FROM and TO fields --
//            msg.setFrom(new InternetAddress("testSendMailSpringMvc@gmail.com"));
//            msg.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("bt2892002@gmail.com",false));
//            msg.setSubject("Hello");
//            msg.setText("How are you");
//            msg.setSentDate(new Date());
//            Transport.send(msg);
//            System.out.println("Message sent.");
//        }catch (MessagingException e){
//            System.out.println("Erreur d'envoi, cause: " + e);
//        }
//    public static void main(String[] args) throws AddressException, MessagingException {
//        // sets SMTP server properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", 587);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//// *** BEGIN CHANGE
//        properties.put("mail.smtp.user", "tienbip113nit@gmail.com");
//
//        // creates a new session, no Authenticator (will connect() later)
//        Session session = Session.getDefaultInstance(properties);
//// *** END CHANGE
//
//        // creates a new e-mail message
//        Message msg = new MimeMessage(session);
//
//        msg.setFrom(new InternetAddress("tienbip113nit@gmail.com"));
//        InternetAddress[] toAddresses = { new InternetAddress("bt2892002@gmail.com") };
//        msg.setRecipients(Message.RecipientType.TO, toAddresses);
//        msg.setSubject("Demo send mail");
//        msg.setSentDate(new Date());
//        // set plain text message
//        msg.setText("Demo send mail in spring mvc");
//
//// *** BEGIN CHANGE
//        // sends the e-mail
//        Transport t = session.getTransport("smtp");
//        t.connect("tienbip113nit@gmail.com", "uchiha78");
//        t.sendMessage(msg, msg.getAllRecipients());
//        t.close();
//// *** END CHANGE
//
//    }
//
//    public static void main(String[] args) {
//        String testString = "SH - Baitaplon - 1.docx.xsd";
//        String cutString = testString.substring(testString.length()-3);
//        System.out.println(cutString);
//    }
}
