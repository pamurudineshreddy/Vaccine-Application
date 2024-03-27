package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAOImpl;
import com.tap.vaccine.dao.NewPasswordDAOImpl;

@Component
public class ForgotPasswordService {
	
	@Autowired
	NewPasswordDAOImpl newPasswordDAOImpl;
	
	public  boolean newPassword(String email) {
		
		return newPasswordDAOImpl.sendOtpMail(email);
		

	}

	public  boolean updatePassword(String email, String password) {
		
		
		return newPasswordDAOImpl.updatePasswordByEmail(email,password);
		
		
		
	}

}
