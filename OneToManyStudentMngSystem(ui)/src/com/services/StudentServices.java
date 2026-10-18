package com.services;

public interface StudentServices {



    // Add operations
    void addStudent();
    void addSubject();

    // Display operations
    void getAllStudents();
    void getStudentById();
    void getSubjectsByStudentId();

    // Update operations
    void updateStudent();
    void updateSubject();

    // Delete operations
    void deleteStudent();
    void deleteSubject();
}
