package com.buutcamp.main;

import com.buutcamp.entity.onetoone.Student;
import com.buutcamp.entity.onetoone.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

   public static void main(String[] args) {

        //get hibernate configuration
       SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .addAnnotatedClass(StudentDetails.class)
                                        .buildSessionFactory();
        //get a new session
       Session session = sessionFactory.getCurrentSession();

        //create new student & studentdetails
       session.beginTransaction();

       Student student = new Student("Rowan", "Atkinson", 35);
       StudentDetails studentDetails = new StudentDetails("r.atkinson@someone.com");
       student.setStudentDetails(studentDetails);

        //save them to database
       session.save(student);

        //close session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
