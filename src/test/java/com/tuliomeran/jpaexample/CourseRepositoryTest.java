package com.tuliomeran.jpaexample;

import com.tuliomeran.jpaexample.Course.Course;
import com.tuliomeran.jpaexample.Course.CourseRepository;
import com.tuliomeran.jpaexample.Teacher.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository _repository;

    @Test
    public void printAllCourses() {
        List<Course> list = this._repository.findAll();
        System.out.println(list);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = new Teacher("Estrella","Lantigua");
        Course course = new Course("Python",6,teacher);

        this._repository.save(course);

    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);

        Pageable secondPageWithThreeRecords =
                PageRequest.of(1,2);

        List<Course> courses = this._repository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println(courses);

    }

    @Test
    public void findAllSorting() {

        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,
                        2,
                        Sort.by("title").descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses = this._repository.findAll(sortByTitleAndCreditDesc).getContent();

    }

}
