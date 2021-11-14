package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try{

            Student theStudent = new Student("Andril","Porali","andril405.bsd.org");

            System.out.println(theStudent);

            //start a transaction
            session.beginTransaction();

            //save the student object
            session.save(theStudent);

            //commit the transaction
            session.getTransaction().commit();


        }
        finally{
            factory.close();
        }
    }
}
