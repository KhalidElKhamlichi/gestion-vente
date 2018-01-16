package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import entity.Commande;

@Repository
public class CommandeDAO {
	
	private SessionFactory factory;
	
	public CommandeDAO()
	{
		if(factory == null)
			factory = new Configuration()
					.configure()
					.addAnnotatedClass(Commande.class)
					.buildSessionFactory();
	}
	
	public boolean save(Commande cmd)
	{
		
		Session s = factory.getCurrentSession();
		
		try {						
			s.beginTransaction();
			
			s.save(cmd);
			
			s.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Commande> getCmdsByClient(String client)
	{
		List<Commande> cmds = new ArrayList<>();
		Session s = factory.getCurrentSession();
		
		try {						
			s.beginTransaction();
			
			cmds = s.createQuery("from commandes cmd where cmd.client='"+client+"'").list();
			
			s.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cmds;
	}
}
