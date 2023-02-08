package com.tuliomeran.jpaexample.Student;

import com.tuliomeran.jpaexample.Student.Embedables.Guardian;
import jakarta.persistence.*;

@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "emailid_unique",
                        columnNames = "email_address"
                )
        }
)
public class Student {

    public Student() {}

    public Student(String name, String lastName, String email) {
        this.firstName = name;
        this.lastName = lastName;
        this.emailid = email;
    }

    public Student(String name, String lastName, String email, Guardian guardian){
        this.firstName = name;
        this.lastName = lastName;
        this.emailid = email;
        this.guardian = guardian;
    }

    public Student(Long id, String name, String lastName, String email) {
        this.studentId = id;
        this.firstName = name;
        this.lastName = lastName;
        this.emailid = email;
    }

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailid;

    @Embedded
    private Guardian guardian;



    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long id) {
        this.studentId = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmailid() {
        return this.emailid;
    }

    public void setEmailid(String email) {
        this.emailid = email;
    }

    public Guardian getGuardian() {
        return this.guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }


}
