package com.buutcamp.entity.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="manytomany_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="course_name")
    private String courseName;

    @ManyToMany( fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                        CascadeType.DETACH,
                        CascadeType.REFRESH,
                        CascadeType.MERGE})
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(name="course_id"),//References THIS TABLE
            inverseJoinColumns = @JoinColumn(name="student_id")//References OTHER TABLE
    )
    private List<Student> students;

    public void addStudent(Student student) {
        if (this.students == null) {
            this.students = new ArrayList<Student>();
        }
        this.students.add(student);
    }

    /**
     *
     * no argument constructor
     * constructor with String arguments
     *
     * getters & setters for all fields
     *
     * convenience method addStudent or addCourse
     *
     * toString with everything but list of students/courses
     *
     */

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
