package com.buutcamp.main;

import com.buutcamp.entity.onetomany.Course;
import com.buutcamp.entity.onetomany.Instructor;
import com.buutcamp.entity.onetoone.Student;
import com.buutcamp.entity.onetoone.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {

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

       //create new instructor & few courses
       Instructor instructor = new Instructor("Larry,", "Crimson", 46);
       Course course1 = new Course("Philosophy 1");
       Course course2 = new Course("History 3");
       instructor.addCourse(course1);
       instructor.addCourse(course2);
       course1.setInstructor(instructor);
       course2.setInstructor(instructor);

        //save them to database
       session.save(instructor);

        //close session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
