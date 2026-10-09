package com.email;

import java.io.IOException;
import java.util.Properties;

import com.model.Users;
import com.util.ConstantsUtil;

import jakarta.mail.Session;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.*;

public class EmailServices {

	private final Session session;

	public EmailServices() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", ConstantsUtil.SMTP_HOST);
		props.put("mail.smtp.port", ConstantsUtil.SMTP_PORT);

		this.session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConstantsUtil.EMAIL_FROM, ConstantsUtil.EMAIL_PASSWORD);
			}
		});
	}

	public void sendOTP(Users user, int otp) {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ConstantsUtil.EMAIL_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Password Reset OTP");

			//MimeBodyPart textPart = new MimeBodyPart();
			String body = "Hello,\n\n" + user.getFullName() + " Your OTP for password reset is: " + otp + "\n\n"
					+ "This OTP is valid for 5 minutes.\n\n" + "Thank you.";
			message.setText(body);
			//message.setContent(textPart);

			Transport.send(message);
			System.out.println("OTP sent successfully!");

		} catch (Exception e) {

			throw new RuntimeException("Failed to send payslip email: " + e.getMessage(), e);
		}
	}

}
