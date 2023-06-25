package org.example.persistencelifecycle;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.hql.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setId(50);
        laptop.setBrand("sony");
        laptop.setPrice(700);

        session.save(laptop);
        laptop.setPrice(650);

        session.remove(laptop);

        session.getTransaction().commit();
        session.detach(laptop);
        laptop.setPrice(600);


    }
}
