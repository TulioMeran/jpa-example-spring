package com.tuliomeran.jpaexample.Course;

import jakarta.persistence.*;

@Entity
@Table(
        name = "tbl_course_material"
)
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

    public CourseMaterial() {}
    public CourseMaterial(String url) {
        this.url = url;
    }

    public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }

    public Long getCourseMaterialId() {
        return this.courseMaterialId;
    }

    public void setCourseMaterialId(Long id) {
        this.courseMaterialId = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
