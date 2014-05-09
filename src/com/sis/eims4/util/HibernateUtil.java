package com.sis.eims4.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil { 
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
    private static Configuration conf;        
    private static SessionFactory factory;        
    //conf只需要加載一次就可以了，如果放入openSession方法中效率會很低        
    static{        
        conf=new Configuration().configure();    
        //现在获取的方式
        factory = conf.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build());
    }    
    /**    
     * @return    
     */    
    public static Session openSession(){    
    	Session session = tl.get();
    	if(session==null){
    		session = factory.openSession();
    		tl.set(session);
    	}
        return session;
    }    
    public static void closeSession(){
    	Session session = tl.get();
    	if(session!=null){
    		session.close();
    		tl.set(null);
    	}
    }
}