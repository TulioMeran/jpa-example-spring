package com.tuliomeran.jpaexample.Course;

import com.tuliomeran.jpaexample.Student.Student;
import com.tuliomeran.jpaexample.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "tbl_course"
)
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;


    public Course() {}

    public Course(String title, Integer credit){
        this.title = title;
        this.credit = credit;
    }

    public Course(String title, Integer credit, Teacher teacher){
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
    }

    public Course(String title, Integer credit, Teacher teacher,List<Student> students){
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
        this.students = students;
    }

    public Course(String title, Integer credit, List<Student> students){
        this.title = title;
        this.credit = credit;
        this.students = students;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long id) {
        this.courseId = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredit() {
        return this.credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



}
