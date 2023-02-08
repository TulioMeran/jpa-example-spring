package com.tuliomeran.jpaexample;

import com.tuliomeran.jpaexample.Student.Embedables.Guardian;
import com.tuliomeran.jpaexample.Student.Student;
import com.tuliomeran.jpaexample.Student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository _studentRepository;

    @Test
    public void saveStudent() {
        var student = new Student("Tulio","Meran","rtulio@gmail.com");
        this._studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        var guardian = new Guardian("Rafael","rafael@gmail.com","8094443343");
        var student = new Student("Tulio","Meran","rtulio007@gmail.com",guardian);
        this._studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> students = this._studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = this._studentRepository.findByFirstName("Tulio");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = this._studentRepository.findByFirstNameContaining("Tu");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = this._studentRepository.findByGuardianName("Rafael");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student students = this._studentRepository.getStudentByEmailAddress("rtulio007@gmail.com");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student students = this._studentRepository.getStudentByEmailAddressNative("rtulio@gmail.com");
        System.out.println(students);
    }

    @Test
    public void updateStudentNameByEmailId() {
        this._studentRepository.updateStudentNameByEmailId("Rafael","rtulio@gmail.com");
    }

}
