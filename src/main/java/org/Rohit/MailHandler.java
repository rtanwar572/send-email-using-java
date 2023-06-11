package org.Rohit;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sndMail(){
        Properties sysProperties=System.getProperties();

        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authperm,"true");

        //Creating a session

        CustomizedMailAuth mailAuthenticator= new CustomizedMailAuth();
        Session mailSession=Session.getInstance(sysProperties,mailAuthenticator);

        //Mime message

        MimeMessage mailMess=new MimeMessage(mailSession);

        try{
            mailMess.setFrom(MailMetaData.myMail);
            mailMess.setSubject("This is a weekly test of sending email from java code");
            mailMess.setText("This is Rohit Tanwar and I am trying to send mail using java code");

            //Setting the receiver

            Address recMail=new InternetAddress(MailMetaData.recMail);
            mailMess.setRecipient(Message.RecipientType.TO,recMail);

            Transport.send(mailMess);
        }
        catch(Exception mailExc){
            System.out.println(mailExc.toString());
        }

    }
}
