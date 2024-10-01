This project is done while doing course in NIIT
This project is a Student Management System that manages student enrollments in various courses, including programming and math courses. It uses core Object-Oriented Programming (OOP) concepts:

Constructors: Initialize Student and Course objects with attributes like student name, course name, and ID.
Data Abstraction and Encapsulation: Fields such as studentID, studentName, courseID, and courseName are private and accessed via getter and setter methods to hide the internal state of objects.
Inheritance: The MathCourse and ProgrammingCourse classes extend the abstract Course class, inheriting common attributes and methods while defining specific details for each course type.
Polymorphism: The abstract method getCourseDetails() in the Course class is implemented differently in MathCourse and ProgrammingCourse to return unique course details.
The system includes features like enrolling students in courses, viewing enrolled students, and exploring course details.