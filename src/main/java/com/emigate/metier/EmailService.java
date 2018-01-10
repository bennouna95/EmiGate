package com.emigate.metier;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Autowired
	public EmailService(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;

	}
	
	public void sendMail(String toEmail, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		javaMailSender.setUsername("emigate2017@gmail.com");
		javaMailSender.setPassword("emigate2017*");
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom("emigate2017@gmail.com");
		javaMailSender.send(mailMessage);
		System.out.println("Email Sent!");
	}
}
