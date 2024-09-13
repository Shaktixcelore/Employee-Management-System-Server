package employee.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import employee.ems.exception.StudentAlreadyExistsException;
import employee.ems.exception.StudentNotFoundException;
import employee.ems.model.Student;
import employee.ems.repository.StudentRepository;


@Service
public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())){
            throw  new StudentAlreadyExistsException(student.getEmail()+ " already exists!");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" +id));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, student not found");
        }
        studentRepository.deleteById(id);
    }
    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

}
