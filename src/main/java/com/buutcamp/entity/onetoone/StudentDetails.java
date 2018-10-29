package com.buutcamp.entity.onetoone;

import javax.persistence.*;

@Entity
@Table(name="student_details")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    public StudentDetails() {
    }

    public StudentDetails(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
