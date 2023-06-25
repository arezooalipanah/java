package org.example.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.sql.internal.SQLQueryParser;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Random r = new Random();
//        for (int i = 0; i < 50; i++) {
//            Student student = new Student();
//            student.setRollno(i);
//            student.setName("name" + i);
//            student.setMarks(r.nextInt(100));
//            session1.save(student);
//        }
        Alien a = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Student.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory factory = con.buildSessionFactory(sr);

        Session session = factory.openSession();
        session.beginTransaction();
        Query q1 = session.createQuery("from Alien where id=101");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        session.getTransaction().commit();
        session.close();

        Session session1 = factory.openSession();
        session1.beginTransaction();
        Query query = session1.createQuery("from Student");
        List<Student> list = query.list();
//        for (Student s: list) {
//            System.out.println(s);
//        }

        Query query1 = session1.createQuery("from Student where marks > 50");
        List<Student> list1 = query1.list();
//        for (Student s: list1) {
//            System.out.println(s);
//        }

        Query query2 = session1.createQuery("from Student where rollno=7");
        Student student = (Student) query2.uniqueResult();
        System.out.println(student);

        Query query3 = session1.createQuery("select rollno, marks, name from Student where rollno=7");
        Object[] objs = (Object[]) query3.uniqueResult();
        for (Object o : objs) {
            System.out.println(o);
        }

        List<Object[]> students = (List<Object[]>) query3.list();
        for (Object[] o : students) {
            System.out.println(o[0] + "," + o[1] + "," + o[2]);
        }

        int b = 60;
//        Query q4 = session1.createQuery("select sum(marks) from Student s where s.marks>" + b);
        Query q4 = session1.createQuery("select sum(marks) from Student s where s.marks> :b");
        q4.setParameter("b", b);
        for (Object o : (List) q4.list()) {
            System.out.println(o);
        }
        // or
        Long marks = (Long) q4.uniqueResult();
        System.out.println(marks);

        NativeQuery q5 = session1.createNativeQuery("select * from S tudent where marks > 50");
        q5.addEntity(Student.class);
        List<Student> students1 = q5.list();
        for (Student s : students1) {
            System.out.println(s);
        }


        session1.getTransaction().commit();
        session1.close();
    }
}
