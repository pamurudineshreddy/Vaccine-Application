package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAOImpl;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginService {
	
	@Autowired
	LoginDAOImpl loginDAOImpl;

	public boolean  validateLoginDetails(String email, String password) {
		
		if(!((email.isBlank() || email.isEmpty() || email=="")&&(password.isBlank() || password.isEmpty() || password==""))){
			return true;
			
		}
		else {
			return false;
		}
		
		
	}


	public boolean verifyLoginDetails(String email, String password) {
		RegisterEntity registerEntityByEmail = loginDAOImpl.getRegisterEntityByEmail(email);
		
		if(registerEntityByEmail==null) {
			return false;
		}
		
		if(registerEntityByEmail.getPassword().equals(password) && registerEntityByEmail.getEmail().equals(email)) {
			return true;
		}else {
			return false;
		}
	}


	
	
	

}
