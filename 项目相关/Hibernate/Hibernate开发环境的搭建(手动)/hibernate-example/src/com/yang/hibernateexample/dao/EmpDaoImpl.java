package com.yang.hibernateexample.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yang.hibernateexample.model.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public void insert(Emp emp) {
		
		//创建sessionFactory 对象
		Configuration configuration = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
									.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(reg);
		//4.0之前的创建sessionFactory方法，已过时
		//Configuration configuration = new Configuration().configure();
		//configuration.buildSessionFactory();
		
		//创建Session对象
		Session session = sessionFactory.openSession();
		
		//打开事务
		Transaction transaction = session.beginTransaction();
		
		//执行操作
		session.save(emp);
		
		//提交事务
		transaction.commit();
		
		//关闭session
		session.close();
		
		//关闭sessionFactory
		sessionFactory.close();		
		
	}

}
