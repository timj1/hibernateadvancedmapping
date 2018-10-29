package com.buutcamp.main;

import com.buutcamp.entity.onetomany.Course;
import com.buutcamp.entity.onetomany.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneGetDemo {

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

       //course id
       int theId = 7;

       Course course = session.get(Course.class, theId);

       System.out.println("\nCourse: "+ course);

       System.out.println("\nInstructor: "+ course.getInstructor());

        //close session
        session.close();
        sessionFactory.close();
    }
}
