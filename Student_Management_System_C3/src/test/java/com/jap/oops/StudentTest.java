package com.jap.oops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentTest {
    Course mathCourse;
    Course programmingCourse;
    Student[] students;
    Student student;

    @Before
    public void setUp() throws Exception {
        mathCourse = new MathCourse(201, "Calculus 101", true);
        programmingCourse = new ProgrammingCourse(301, "Java Programming", "Java");
        students = new Student[]{
                new Student(101, "John"),
                new Student(102, "Bob"),
                new Student(103, "Jenny"),
                new Student(104, "Harry"),
                new Student(105, "James"),
                new Student(106, "Thomas"),
                new Student(107, "Henry"),
                new Student(108, "Cathe"),
                new Student(109, "Coles"),
                new Student(110, "Peter")
        };
        student = new Student(110, "Alice");
    }

    @After
    public void tearDown() throws Exception {
        mathCourse = null;
        programmingCourse = null;
        students = null;
        student = null;
    }

    @Test
    public void enrollStudentInMathCourse() {
        String result = student.enrollInCourse(mathCourse);
        assertEquals("Alice has been enrolled in Calculus 101", result);
        assertTrue(student.isEnrolled(mathCourse)); // Ensure the student is enrolled in the course
    }

    @Test
    public void enrollSameStudentInMathCourse() {
        student.enrollInCourse(mathCourse);
        String result = student.enrollInCourse(mathCourse);
        assertEquals("Alice is already enrolled in Calculus 101", result);
    }

    @Test
    public void enrollStudentInProgrammingCourse() {
        student.enrollInCourse(programmingCourse);
        String result = student.enrollInCourse(programmingCourse);
        assertEquals("Alice is already enrolled in Java Programming", result);
    }

    @Test
    public void enrollSameStudentInProgrammingCourse() {
        String result = student.enrollInCourse(programmingCourse);
        assertEquals("Alice has been enrolled in Java Programming", result);
        assertTrue(student.isEnrolled(programmingCourse)); // Ensure the student is enrolled in the course
    }

    @Test
    public void isEnrolledExistingCourse() {
        student.enrollInCourse(mathCourse);
        assertTrue(student.isEnrolled(mathCourse));
    }


    @Test
    public void enrollStudentInCourseAfterMaximumCourseEnrolled() {
        student.enrollInCourse(programmingCourse);
        programmingCourse = new ProgrammingCourse(302, "Html Programming", "HTml");
        student.enrollInCourse(programmingCourse);
        programmingCourse = new ProgrammingCourse(303, "Html Programming", "HTml");
        student.enrollInCourse(programmingCourse);
        programmingCourse = new ProgrammingCourse(304, "Html Programming", "HTml");
        student.enrollInCourse(programmingCourse);
        programmingCourse = new ProgrammingCourse(305, "Html Programming", "HTml");
        student.enrollInCourse(programmingCourse);
        programmingCourse = new ProgrammingCourse(306, "Html Programming", "HTml");
        String result = student.enrollInCourse(programmingCourse);
        assertEquals("Alice has enrolled for maximum courses", result);
    }


}
