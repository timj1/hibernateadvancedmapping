package com.buutcamp.main;

import com.buutcamp.entity.onetomany.Course;
import com.buutcamp.entity.onetomany.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyGetDemo {

   public static void main(String[] args) {

        //get hibernate configuration
       SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();
        //get a new session
       Session session = sessionFactory.getCurrentSession();

       session.beginTransaction();

       int theId = 1;

       Instructor instructor = session.get(Instructor.class, theId);

       System.out.println("\nInstructor: "+ instructor);
       //create new instructor & few courses


        //save them to database


        //close session

        session.close();
        sessionFactory.close();
    }
}
