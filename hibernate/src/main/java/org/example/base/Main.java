package org.example.base;

import org.example.base.Alien;
import org.example.base.AlienName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        AlienName alienName = new AlienName();
        alienName.setFname("Arezoo");
        alienName.setLname("Alipanah");
        alienName.setMname("&");

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName(alienName);

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory factory = con.buildSessionFactory(sr);
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.save(alien);
        Alien alien1 = session.get(Alien.class, 1);
        System.out.println(alien1);
        transaction.commit();

    }
}