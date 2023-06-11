package org.Rohit;

public class Main {
    public static void main(String[] args) {

        System.out.println("preparing to send mail---Weekly Test");

        MailHandler mailHandler=new MailHandler();
        mailHandler.sndMail();
    }
}