package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface LoginDAO {
	
	RegisterEntity getRegisterEntityByEmail(String email);
	boolean updateLoginCount(String email);
	
	
}
