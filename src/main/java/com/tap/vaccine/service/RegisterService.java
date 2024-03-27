package com.tap.vaccine.service;

import org.springframework.stereotype.Component;


@Component
public class RegisterService {
	
	
	
	
	public boolean validateRegisterData(String username, String password, long mobilenumber,
			String dateofbirth, String gender) {
		int count =0;
		
		if(!(username=="" || username.isBlank() || username.isEmpty())){
			count++;
			
		}
		if(!(password=="" || password.isBlank() || password.isEmpty())){
			count++;
			
		}if(!(mobilenumber==0 ||mobilenumber<0 )){
			count++;
			
		}if(!(dateofbirth=="" || dateofbirth.isBlank() || dateofbirth.isEmpty())){
			
			count++;
		}if(!(gender=="" || gender.isBlank() || gender.isEmpty())){
			count++;
			
		}
		
		if(count==5) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

	
		
	
	
	


	

}
