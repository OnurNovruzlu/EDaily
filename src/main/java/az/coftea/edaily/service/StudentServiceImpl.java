package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewStudent;
import az.coftea.edaily.dto.StudentResponse;
import az.coftea.edaily.exception.InvalidParamException;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Role;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.model.Student;
import az.coftea.edaily.repository.DailyRepository;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.repository.StudentRepository;
import az.coftea.edaily.util.MyMapper;
import az.coftea.edaily.util.ParamValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final MyMapper mapper;

    @Override
    public List<StudentResponse> getAll() {
        return studentRepository.findAll().stream().map(mapper::fromStudent).collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudent(int id) {
        return mapper.fromStudent(studentRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Student not found")));
    }

    @Override
    public StudentResponse login(String email, String password) {
        Student student=studentRepository.findByEmail(email).orElseThrow(()-> new ModelNotFoundException("Student not found"));

        if(ParamValidator.validateEmail(email)){
            throw new InvalidParamException("Email not valid");
        }
        if(ParamValidator.validatePassword(password)){
            throw new InvalidParamException("Password not valid");
        }

        if(student.getPassword().equals(password)){
            return mapper.fromStudent(student);
        }

        throw new  InvalidParamException("Password is incorrect");
    }


    @Transactional
    @Override
    public String insert(NewStudent newStudent) {
        if(ParamValidator.validateEmail(newStudent.getEmail())){
            throw new InvalidParamException("please enter valid email");
        }
        if(ParamValidator.validatePassword(newStudent.getPassword())){
            throw new InvalidParamException("Password must be 6 characters at least");
        }
        studentRepository.save(mapper.toStudent(newStudent));
        return "ok";
    }


    @Transactional
    @Override
    public String delete(int id) {
        Student student = new Student();
        student.setStatus(Status.DEACTIVE);
        studentRepository.save(student);
        return "ok";
    }


    @Transactional
    @Override
    public String update(int id, NewStudent newStudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(("Student not found")));
        student.setName(newStudent.getName());
        student.setSurname(newStudent.getSurname());
        student.setBirthday(newStudent.getBirthday());
        student.setSchool(schoolRepository.findById(newStudent.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found")));
        student.setRole(Role.valueOf(newStudent.getRole()));
        student.setEmail(newStudent.getEmail());
        student.setPassword(newStudent.getPassword());
        studentRepository.save(student);
        return "ok";
    }
}
