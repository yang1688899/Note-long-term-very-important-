package com.yang.strutsencrypt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yang.strutsencrypt.model.UserData;

public class UserDataDaoImpl implements UserDataDao
{

	@Override
	public void insert(UserData user) {
		
		Configuration config = new Configuration().configure();
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		
		SessionFactory sessionFactory = config.buildSessionFactory(reg);
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}
}
