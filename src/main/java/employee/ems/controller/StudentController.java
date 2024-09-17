package employee.ems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.ems.model.Student;
import employee.ems.service.IStudentService;

@CrossOrigin("https://employee-management-system-client-lac.vercel.app/") //allowing client application to consume the backend
@RestController
@RequestMapping("/students")

public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalEmployees() {
        long total = studentService.getTotalEmployees();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<Map<String, Long>> getEmployeesByDepartment() {
        Map<String, Long> departmentCounts = studentService.getEmployeesByDepartment();
        return new ResponseEntity<>(departmentCounts, HttpStatus.OK);
    }


}
