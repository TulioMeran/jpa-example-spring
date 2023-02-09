package com.tuliomeran.jpaexample;

import com.tuliomeran.jpaexample.Course.Course;
import com.tuliomeran.jpaexample.Teacher.Teacher;
import com.tuliomeran.jpaexample.Teacher.TeacherRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository _repository;

    @Test
    public void SaveTeacher() {
        /*
        Course courseDBA = new Course("DBA",5);
        Course courseJava = new Course("Java",8);

        Teacher teacher = new Teacher("Estrella","Lantigua", List.of(courseDBA,courseJava));

        this._repository.save(teacher);
        */
    }



}
