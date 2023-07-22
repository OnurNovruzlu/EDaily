package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.exception.InvalidParamException;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.*;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.repository.SubjectRepository;
import az.coftea.edaily.repository.TeacherRepository;
import az.coftea.edaily.util.MapperManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final MapperManager mapper;
    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public TeacherResponse getTeacher(int id) {
        return mapper.fromTeacher(teacherRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Teacher not found")));
    }

    @Override
    public List<TeacherResponse> getAll() {
        return teacherRepository.findAll().stream().map(t->mapper.fromTeacher(t)).collect(Collectors.toList());
    }


    @Override
    public TeacherResponse getDirector() {
        return mapper.fromTeacher(teacherRepository.findByRole(Role.DIRECTOR.name()).orElseThrow(() -> new ModelNotFoundException("Director not found")));
    }

    @Transactional
    @Override
    public String insert(NewTeacher newTeacher) {
        Optional<Teacher> teacher = teacherRepository.findByRole(newTeacher.getRole());
        if(teacher.isPresent() && newTeacher.getRole().equals("DIRECTOR"))throw new InvalidParamException("Director already exists");
        teacherRepository.save(mapper.toTeacher(newTeacher));
        return "ok";
    }

    @Transactional
    @Override
    public String delete(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Teacher not found"));
        teacher.setStatus(Status.DEACTIVE);
        teacherRepository.save(teacher);
        return "ok";
    }

    @Transactional
    @Override
    public String update(int id, NewTeacher newTeacher) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Teacher not found"));
        teacher.setName(newTeacher.getName());
        teacher.setSurname(newTeacher.getSurname());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setSchool(schoolRepository.findById(newTeacher.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found")));
        teacher.setRole(Role.valueOf(newTeacher.getRole()));
        teacher.setSubject(subjectRepository.findById(newTeacher.getSubjectId()).orElseThrow(() -> new ModelNotFoundException("Subject not found")));
        teacherRepository.save(teacher);
        return "ok";
    }
}
