package com.tap.vaccine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.FamilyMemberDAOImpl;
import com.tap.vaccine.entity.FamilyMemberEntity;

@Component
public class ViewAllMembersService {
	
	@Autowired
	FamilyMemberDAOImpl familyMemberDAOImpl;

	public List<FamilyMemberEntity> getAllData() {
		
		 return  familyMemberDAOImpl.getFamilyData();
		
	}

}
