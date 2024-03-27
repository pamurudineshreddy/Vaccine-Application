package com.tap.vaccine.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.FamilyMemberEntity;



@Component
public class FamilyMemberDAOImpl implements FamilyMemberDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveFamilyMember(FamilyMemberEntity familyMemberEntity) {
		Session openSession = null;
		boolean isSaved = false;
		
		try {
			openSession = sessionFactory.openSession();
			
			Transaction beginTransaction = openSession.beginTransaction();
			
			Serializable save = openSession.save(familyMemberEntity);
			isSaved = true;
			
			beginTransaction.commit();
		}
		finally {
			if(openSession != null) {
				
				System.out.println(" saveFamilyMember session closed");
				openSession.close();
			}
		}
		
		return isSaved;
	}

	

	@Override
	public java.util.List<FamilyMemberEntity> getFamilyData() {
		// TODO Auto-generated method stub
		Session openSession2 = null;
		List<FamilyMemberEntity> resultList2 = null;
		
		try {
			
			openSession2 = sessionFactory.openSession();
			String hql = "from FamilyMemberEntity";
			org.hibernate.query.Query createQuery = openSession2.createQuery(hql);
			resultList2 = createQuery.getResultList();
			
			for (FamilyMemberEntity familyMemberEntity : resultList2) {
				
				System.out.println(familyMemberEntity.getDateOfBirth()+ familyMemberEntity.getGender());
				
			}
			return resultList2;
			
			
			
		} finally {
			if(openSession2!=null) {
				System.out.println("getTableData session closed");
			}
		}
	}

}
