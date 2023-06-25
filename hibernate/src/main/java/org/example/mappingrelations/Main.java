package org.example.mappingrelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Del");

        Student student = new Student();
        student.setName("Arezoo");
        student.setRollno(1);
        student.setMarks(80);

        laptop.getStudents().add(student);
        student.getLaptops().add(laptop);

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry rg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(rg);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(laptop);
        session.getTransaction().commit();

    }
}
