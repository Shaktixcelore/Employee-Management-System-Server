package employee.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import employee.ems.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {
    Optional<Student> findByEmail(String email);

    @Query("SELECT COUNT(s) FROM Student s")
    long countTotalEmployees();

    @Query("SELECT s.department, COUNT(s) FROM Student s GROUP BY s.department")
    List<Object[]> countEmployeesByDepartment();
}
