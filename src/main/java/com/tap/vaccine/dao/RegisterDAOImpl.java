package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;


@Component
public class RegisterDAOImpl implements RegisterDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private  JavaMailSenderImpl javaMailSenderImpl;


	@Override
	public  boolean saveRegisterEntity(RegisterEntity registerEntity) {
		
		 Transaction beginTransaction = null;
		 Session openSession = null;
		 boolean isSaved = false;
		 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(registerEntity.getUserName());
			simpleMailMessage.setSubject("Welcome to Vaccine Application - Your Registration is Complete!");
			simpleMailMessage.setText("Dear "+registerEntity.getUserName()+",\r\n"
					+ "\r\n"
					+ "Thank you for choosing [Your Company Name] and completing your registration on our website. We're thrilled to welcome you to our community!\r\n"
					+ "\r\n"
					+ "To access your account and start exploring all the exciting features we have to offer, please use the following credentials:\r\n"
					+ "\r\n"
					+ "Username/Email: "+registerEntity.getUserName()
					+ "\r\n"
					+ "Password: "+registerEntity.getPassword()
					+ "\r\n"
					+ "Make sure to keep your login credentials secure and do not share them with anyone. If you ever forget your password, you can reset it on the login page by clicking on the \"Forgot Password\" link.\r\n"
					+ "\r\n"
					+ "We're confident that you'll find Vaccine App to be a valuable resource for [mention the key benefits or services]. Should you have any questions or encounter any issues, our support team is here to assist you. Feel free to contact them at dinni2803@gmail.com.\r\n"
					+ "\r\n"
					+ "Once again, thank you for joining Vaccine App. We look forward to providing you with a seamless and rewarding experience.\r\n"
					+ "\r\n"
					+ "Best regards,\r\n"
					+ "\r\n"
					+ "vaccine App\r\n"
					+ "dinni2803@gmail.com");
		 
		
		try {
			
			openSession = sessionFactory.openSession();
			beginTransaction = openSession.beginTransaction();
			openSession.save(registerEntity);
			javaMailSenderImpl.send(simpleMailMessage);
			beginTransaction.commit();
			isSaved = true;
			
		}
		catch (HibernateException | MailException e) {
			String message = e.getMessage();
			System.out.println(message);
			beginTransaction.rollback();
		}
		finally {
			if(openSession!=null) {
				openSession.close();
			}
		}
		return isSaved;
	}

}
