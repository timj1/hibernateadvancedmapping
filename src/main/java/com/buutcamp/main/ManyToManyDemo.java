package com.buutcamp.main;

import com.buutcamp.entity.manytomany.Course;
import com.buutcamp.entity.manytomany.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

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

       //create a couple of students and courses, and add them together
       Student student1 = new Student("Mary", "Clinton");
       Student student2 = new Student("Hilary", "Johnson");
       Student student3 = new Student("Rick", "Moriarty");

       Course course1 = new Course("Hunting 1");
       Course course2 = new Course("Fishing 5");
       Course course3 = new Course("Knitting 1");

       student1.addCourse(course1);
       student1.addCourse(course3);

       student2.addCourse(course3);
       student2.addCourse(course2);

       student3.addCourse(course1);
       student3.addCourse(course2);
       student3.addCourse(course3);

       session.save(student1);
       session.save(student2);
       session.save(student3);

       session.save(course1);
       session.save(course2);
       session.save(course3);

        //close session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
