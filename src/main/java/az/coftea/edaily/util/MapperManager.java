package az.coftea.edaily.util;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Role;
import az.coftea.edaily.model.Teacher;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.repository.SubjectRepository;
import az.coftea.edaily.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperManager implements MyMapper {

    private final TeacherRepository teacherRepository;
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
        teacher.setSubject(subjectRepository.findByName(newTeacher.getSubject()).orElseThrow(() -> new ModelNotFoundException("Subject not found")));
        return teacher;
    }

    @Override
    public TeacherResponse fromTeacher(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacherResponse.getId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setSurname(teacher.getSurname());
        teacherResponse.setBirthday(teacher.getBirthday());
        teacherResponse.setSchool(teacher.getSchool().getName());
        teacherResponse.setCreatedAt(teacher.getCreatedAt());
        teacherResponse.setStatus(teacher.getStatus().name());
        teacherResponse.setRole(teacher.getRole().name());
        teacherResponse.setSubject(teacher.getSubject().getName());
        return teacherResponse;
    }
}
