package com.sakha.sms.am.utils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * <p>The class is created to create and mainatain single to session thought he application context</p>
 * 
 * creation date:22-feb-2018
 * 
 * modified date:
 * 
 * methods:
 * 
 * parameters: 
 * 
 * @author Ravindra Bankapur
 *
 */
public class HibernateUtils {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory=buildSessionFactory();
	private static ThreadLocal<Session> threadLocal;//this instance enables to create varivables that can be read and writtern by same thread
	private static final Logger log = Logger.getLogger(HibernateUtils.class);

    private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuaration=new Configuration();
			configuaration.configure("/hibernate/hibernate.cfg.xml");
			serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuaration.getProperties()).build();
			sessionFactory=configuaration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} catch (ExceptionInInitializerError ex) {
			log.error(ex.getMessage());
		}
		return null;
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void rebuildSessionFactory() {
        try {
            sessionFactory = buildSessionFactory();
        } catch (ExceptionInInitializerError e) {
           log.error(e.getMessage());
        }
    }

 
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}


