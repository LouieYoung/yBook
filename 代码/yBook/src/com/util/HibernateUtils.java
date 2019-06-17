package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    static Configuration cfg =null;
    static SessionFactory sessionFactory = null;
    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }
    //返回与本地线程绑定的session
    public static Session getSessionobject(){
        return sessionFactory.getCurrentSession();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
