package com.tuliomeran.jpaexample;

import com.tuliomeran.jpaexample.Course.Course;
import com.tuliomeran.jpaexample.Course.CourseMaterial;
import com.tuliomeran.jpaexample.Course.CourseMaterialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository _repository;



    @Test
    public void SaveCourseMaterial() {

        Course course = new Course("DSA",6);
        CourseMaterial courseMaterial = new CourseMaterial("www.google.com",course);
        this._repository.save(courseMaterial);
    }

    @Test()
    public void printAllCourseMaterials() {
        List<CourseMaterial> materials = this._repository.findAll();
        System.out.println(materials);
    }



}
