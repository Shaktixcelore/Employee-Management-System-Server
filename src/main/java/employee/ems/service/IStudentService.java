package employee.ems.service;

import java.util.List;
import java.util.Map;

import employee.ems.model.Student;

public interface IStudentService {
    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    Map<String, Long> getEmployeesByDepartment();
    long getTotalEmployees();
}
