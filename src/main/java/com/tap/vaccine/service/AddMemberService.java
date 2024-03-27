package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.FamilyMemberDAOImpl;
import com.tap.vaccine.entity.FamilyMemberEntity;

@Component
public class AddMemberService {
	
	@Autowired
	FamilyMemberDAOImpl familyMemberDAOImpl;
	

	public boolean insertData(FamilyMemberEntity familyMemberEntity) {
		
		return familyMemberDAOImpl.saveFamilyMember(familyMemberEntity);
		
		
	}
	
}
