package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.*;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.repository.SubjectRepository;
import az.coftea.edaily.repository.TeacherRepository;
import az.coftea.edaily.util.MapperManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final MapperManager mapperManager;
    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public TeacherResponse getTeacher(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Teacher not found with id " + id));
        return mapperManager.fromTeacher(teacher);
    }

    @Override
    public List<TeacherResponse> getAll() {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        List<Teacher> teachers = teacherRepository.findAll();
        for (Teacher teacher : teachers) {
            teacherResponses.add(mapperManager.fromTeacher(teacher));
        }
        return teacherResponses;
    }


    @Override
    public TeacherResponse getDirector() {
        return mapperManager.fromTeacher(teacherRepository.findByRole(Role.DIRECTOR.name()).orElseThrow(() -> new ModelNotFoundException("Director not found")));
    }

    @Transactional
    @Override
    public String insert(NewTeacher newTeacher) {
        teacherRepository.save(mapperManager.toTeacher(newTeacher));
        return "Teacher successfully created";
    }

    @Transactional
    @Override
    public String delete(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Teacher not found with id " + id));
        teacher.setStatus(Status.DEACTIVE);
        return "Student successfully deleted";
    }

    @Transactional
    @Override
    public String update(int id, NewTeacher newTeacher) {
        School school = schoolRepository.findById(newTeacher.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found"));
        Subject subject = subjectRepository.findByName(newTeacher.getSubject()).orElseThrow(() -> new ModelNotFoundException("Subject not found"));
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Teacher not found with id " + id));
        teacher.setName(newTeacher.getName());
        teacher.setSurname(newTeacher.getSurname());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setSchool(school);
        teacher.setRole(Role.valueOf(newTeacher.getRole()));
        teacher.setSubject(subject);
        teacherRepository.save(teacher);
        return "Teacher successfully updated";
    }
}
