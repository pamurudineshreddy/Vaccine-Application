package com.tap.vaccine.dao;

import java.util.List;

import com.tap.vaccine.entity.FamilyMemberEntity;



public interface FamilyMemberDAO {
	
	boolean saveFamilyMember(FamilyMemberEntity familyMemberEntity );
	
	 List<FamilyMemberEntity> getFamilyData();
	
}
