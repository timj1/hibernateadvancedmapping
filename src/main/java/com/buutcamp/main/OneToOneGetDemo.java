package com.buutcamp.main;

import com.buutcamp.entity.onetoone.Student;
import com.buutcamp.entity.onetoone.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneGetDemo {

   public static void main(String[] args) {

        //get hibernate configuration
       SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .addAnnotatedClass(StudentDetails.class)
                                        .buildSessionFactory();
        //get a new session
       Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();

       int theId = 13;

       Student student = session.get(Student.class, theId);

       System.out.println(student);

        //close session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
