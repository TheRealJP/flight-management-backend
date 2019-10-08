package com.badwitsoftware.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailGenerator {

	private static final Logger log = LoggerFactory.getLogger(EmailGenerator.class);

	@Autowired
	private JavaMailSender sender;

	@Bean
	private JavaMailSender sender() {
		return new JavaMailSenderImpl();
	}

	public void sendItineraryToEmail(String email, String filePath) {
		MimeMessage mimeMessage = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setTo(email);
			messageHelper.setSubject("Your Flight Itinerary");
			messageHelper.setText("Your itinerary is attached below.");
			messageHelper.addAttachment("Itinerary", new File(filePath));

			sender.send(mimeMessage);
		} catch (MessagingException e) {
			log.error(e.getMessage());
		}
	}
}
