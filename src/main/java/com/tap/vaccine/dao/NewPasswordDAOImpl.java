package com.tap.vaccine.dao;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class NewPasswordDAOImpl implements NewPasswordDAO {
	@Autowired
	private  JavaMailSenderImpl javaMailSenderImpl;
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	int otp;

	@Override
	public boolean sendOtpMail(String email) {
		
		Random random = new Random();

        int sixDigitNumber = 100000 + random.nextInt(900000);
        otp = sixDigitNumber;
		
		
		 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(email);
			simpleMailMessage.setSubject("Password Reset Request");
			simpleMailMessage.setText("Subject: \r\n"
					+ "\r\n"
					+ "Dear '"+email+"',\r\n"
					+ "\r\n"
					+ "We received a request to reset the password for your account. If you did not make this request, please ignore this email.\r\n"
					+ "\r\n"
					+ "To reset your password, Enter   the following OTP :  "+sixDigitNumber+"  \r\n"
					+ "[Password Reset Link]\r\n"
					+ "\r\n"
					+ "If the link above does not work, copy and paste the following URL into your browser's address bar:\r\n"
					+ "[Your Application URL]/reset-password?token=[Reset Token]\r\n"
					+ "\r\n"
					+ "Please note that this password reset link is valid for a limited time. If you don't reset your password within [expiration period], you will need to submit another password reset request.\r\n"
					+ "\r\n"
					+ "Thank you,\r\n"
					+ "[Your Company Name]\r\n"
					+ "");
		 
		
		try {
			
			javaMailSenderImpl.send(simpleMailMessage);
			return true;
			
		}
		catch (MailException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
		return false;
	}
	
	public int otpReturn() {
		return otp;

	}

	@Override
	public boolean updatePasswordByEmail(String email, String password) {
		
		String hql = "update RegisterEntity set password ='"+password+"' where email = '"+email+"' ";
		Session openSession = null;
		boolean isupdated = false;
		
		try {
			openSession = sessionFactory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			Query createQuery = openSession.createQuery(hql);
			int executeUpdate = createQuery.executeUpdate();
			if (executeUpdate==1) {
				return true;
				
			}
			
			beginTransaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(openSession != null) {
				openSession.close();
			}
		}
		
		return isupdated;
	}

}
