package cn.itcast.oa.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;

//import org.jboss.weld.context.ApplicationContext;
//import org.springframework.*;

//import org.springframework.beans.factory.BeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

//import com.opensymphony.xwork2.security.AcceptedPatternsChecker;

public class SpringTest {
	
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testBean() throws Exception {
		TestAction testAction = (TestAction) ac.getBean("testAction");
		System.out.println(testAction);
	}
	
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
	
	@Test
	public void testTransaction() throws Exception {
		TestService testService = (TestService)ac.getBean("testService");
		testService.saveTwoUsers();
	}
}
