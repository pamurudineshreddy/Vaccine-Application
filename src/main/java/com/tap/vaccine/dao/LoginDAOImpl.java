package com.tap.vaccine.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;


@Component
public class LoginDAOImpl implements LoginDAO {
	
	
	
	 int count =0;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public RegisterEntity getRegisterEntityByEmail(String email) {
		
		 Session openSession = null;
		 RegisterEntity uniqueResult= null;
		
		try {
			
			String hql = "from RegisterEntity where email = '"+email+"'";
			
			openSession = sessionFactory.openSession();
			
			org.hibernate.query.Query query = openSession.createQuery(hql);
			uniqueResult = (RegisterEntity)query.uniqueResult();
			
			System.out.println(uniqueResult);
			
			
		} finally {
			
			if(openSession!=null) {
				openSession.close();
			}
		}
		
		return uniqueResult;
	}
	@Override
	public  boolean updateLoginCount(String email) {
		Session openSession = null;
		
		count++;
		
		String hql = "update RegisterEntity set loginAttempts = '"+count+"' where email = '"+email+"' ";
		
		try {
			 openSession = sessionFactory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			Query createQuery = openSession.createQuery(hql);
			int executeUpdate = createQuery.executeUpdate();
			beginTransaction.commit();
			if(executeUpdate==1 && count<=3) {
				return true;
				
			}
			
			
		} finally {
			if(openSession!=null) {
				openSession.close();
			}
		}
		return false;
		
	}

}
