package com.util;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory session;

    private HibernateUtil() {
    }

    public static SessionFactory getSession(){
        if(session == null)
            session = new Configuration().configure().buildSessionFactory();
        return session;
    }

}
