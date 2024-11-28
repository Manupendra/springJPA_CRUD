package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
            deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting the student id: "+studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Manu"
        System.out.println("Updating student ...");
        myStudent.setFirstName("Manu");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated Student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Jain");

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get the list of students
        List<Student> theStudents = studentDAO.findAll();

        //display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating multiple student objects ...");
        Student sopanStudent = new Student("Sopan", "Palthon", "sopanpalthon@gmail.com");

        studentDAO.save(sopanStudent);

        Student myStudent = studentDAO.findById(sopanStudent.getId());

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        System.out.println("Creating multiple student objects ...");
        Student vibhorStudent = new Student("Vibhor", "Jain", "vibhorjain@gmail.com");
        Student rajStudent = new Student("Raj", "Chedda", "rajchedda@gmail.com");
        Student ankushStudent = new Student("Ankush", "Kumar", "ankushkumar@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(vibhorStudent);
        studentDAO.save(rajStudent);
        studentDAO.save(ankushStudent);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object");
        Student manuStudent = new Student("Manupendra", "Tiwari", "manupendratiwari@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(manuStudent);

        System.out.println("Saved student. Generated id: " + manuStudent.getId());
    }

}
