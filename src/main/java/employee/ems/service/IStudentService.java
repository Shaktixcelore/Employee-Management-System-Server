package employee.ems.service;

import java.util.List;

import employee.ems.model.Student;

public interface IStudentService {
    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}
