package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try{



            //Querying from DB

            //create session
            session = factory.getCurrentSession();
            //start the transaction
            session.beginTransaction();
            //Read from the database

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayQueryResult(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName = 'porali'").getResultList();
            displayQueryResult(theStudents);


            session.getTransaction().commit();


        }
        finally{
            factory.close();
        }
    }

    private static void displayQueryResult(List<Student> theStudents) {
        for(Student tmpStudent : theStudents)
            System.out.println(tmpStudent);
    }
}
