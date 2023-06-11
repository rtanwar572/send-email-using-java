package org.Rohit;


    import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

    public class CustomizedMailAuth extends Authenticator {

        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(MailMetaData.myMail, MailMetaData.myPasswrd);
        }

    }
