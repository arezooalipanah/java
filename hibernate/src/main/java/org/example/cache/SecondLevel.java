package org.example.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SecondLevel {
    public static void main(String[] args) {
        Alien a = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory factory = con.buildSessionFactory(sr);


        Session session = factory.openSession();
        session.beginTransaction();
        a = session.get(Alien.class, 101);
        System.out.println(a);

        a = session.get(Alien.class, 102);
        System.out.println(a);

        a = session.get(Alien.class, 101);
        System.out.println(a);

        session.getTransaction().commit();
        session.close();

        // new session
        Session session1 = factory.openSession();
        session1.beginTransaction();

        a = session1.get(Alien.class, 101);
        System.out.println(a);

        session1.getTransaction().commit();
        session1.close();
    }
}
