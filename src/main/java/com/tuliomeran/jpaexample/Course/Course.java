package com.tuliomeran.jpaexample.Course;

import jakarta.persistence.*;

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

    public Course() {}

    public Course(String title, Integer credit){
        this.title = title;
        this.credit = credit;
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



}
