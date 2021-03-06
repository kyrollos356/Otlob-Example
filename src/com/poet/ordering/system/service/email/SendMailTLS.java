package com.poet.ordering.system.service.email;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.poet.ordering.system.model.User;

public class SendMailTLS {

	public void sendMailCreateOrder(List<User> users, String userName, int orderRequestId) {

		final String username = "kyrom123@gmail.com";
		final String password = "kyroM_123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		for (User user : users) {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("kyrom123@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
				message.setSubject("Order Created!!");
				message.setText("hi ," + "\n\n you friend '" + userName + '"' + "just Created an Order \n http://localhost:8080/OrderRequest?id=" + orderRequestId);
				Transport.send(message);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void sendMailCancelOrder(List<User> users, String userName) {

		final String username = "kyrom123@gmail.com";
		final String password = "kyroM_123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		for (User user : users) {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("kyrom123@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
				message.setSubject("Order Cancelled!!");
				message.setText("hi ," + "\n\n you friend '" + userName + '"' + "just Cancelled an Order");
				Transport.send(message);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
