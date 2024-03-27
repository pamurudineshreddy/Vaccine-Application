package com.tap.vaccine.dao;

public interface NewPasswordDAO {
	
	boolean sendOtpMail(String email);
	
	boolean updatePasswordByEmail( String email,String password);

}
