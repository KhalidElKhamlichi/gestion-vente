package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public class UserDAO {
	
	private SessionFactory factory;
	
	public UserDAO()
	{
		if(factory == null)
			factory = new Configuration()
					.configure()
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
	}
	
	public boolean login(String username, String password)
	{
		
		Session s = factory.getCurrentSession();
		
		try {						
			s.beginTransaction();
			
			s.createQuery("from users u where u.login='"+username+"' and u.pass='"+password+"'").list().get(0);
			
			s.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean modifier(String username, String oldPass, String newPass)
	{
		
		Session s = factory.getCurrentSession();
		
		try {						
			s.beginTransaction();
			
			User u = (User) s.createQuery("from users u where u.login='"+username+"' and u.pass='"+oldPass+"'").list().get(0);
			u.setPass(newPass);
			s.update(u);
			s.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}
