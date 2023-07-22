package az.coftea.edaily.util;

import az.coftea.edaily.dto.NewSubject;
import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.SubjectResponse;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.model.Subject;
import az.coftea.edaily.model.Teacher;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Role;
import az.coftea.edaily.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperManager implements MyMapper {

    private final SchoolRepository schoolRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public Teacher toTeacher(NewTeacher newTeacher) {
        Teacher teacher = new Teacher();
        teacher.setName(newTeacher.getName());
        teacher.setSurname(newTeacher.getSurname());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setSchool(schoolRepository.findById(newTeacher.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found with id")));
        teacher.setRole(Role.valueOf(newTeacher.getRole()));
        teacher.setSubject(subjectRepository.findById(newTeacher.getSubjectId()).orElseThrow(() -> new ModelNotFoundException("Subject not found")));
        return teacher;
    }

    @Override
    public TeacherResponse fromTeacher(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacherResponse.getId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setSurname(teacher.getSurname());
        teacherResponse.setBirthday(teacher.getBirthday());
        teacherResponse.setSchoolName(teacher.getSchool().getName());
        teacherResponse.setCreatedAt(teacher.getCreatedAt());
        teacherResponse.setStatus(teacher.getStatus().name());
        teacherResponse.setRole(teacher.getRole().name());
        teacherResponse.setSubjectName(teacher.getSubject().getName());
        return teacherResponse;
    }

    @Override
    public Subject toSubject(NewSubject newSubject) {
        Subject subject = new Subject();
        subject.setName(newSubject.getName());
        subject.setSchool(schoolRepository.findById(newSubject.getSchoolId()).orElseThrow(()->new ModelNotFoundException("School not found")));
        return subject;
    }

    @Override
    public SubjectResponse fromSubject(Subject subject) {
        SubjectResponse response = new SubjectResponse();
        response.setId(subject.getId());
        response.setName(subject.getName());
        response.setStatus(subject.getStatus().name());
        response.setCreatedAt(subject.getCreatedAt());
        response.setSchoolName(subject.getSchool().getName());
        response.setTeacherNames(subject.getTeachers().stream().map(t->t.getName()).collect(Collectors.toList()));
        return response;
    }
}
