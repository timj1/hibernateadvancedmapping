package com.buutcamp.main;

import com.buutcamp.entity.manytomany.Course;
import com.buutcamp.entity.manytomany.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyGetDemo {

   public static void main(String[] args) {

        //get hibernate configuration
       SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();
        //get a new session
       Session session = sessionFactory.getCurrentSession();

       session.beginTransaction();

       //course id
       int theId = 2;

       Student student = session.get(Student.class, theId);

       System.out.println("\nStudent: "+ student);
       System.out.println("\nStudent courses: "+ student.getCourses());

       theId =2;

       Course course = session.get(Course.class, theId);

       System.out.println("\nCourse: "+ course);
       System.out.println("\nCourse attendants: "+ course.getStudents());

        //close session
       session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
