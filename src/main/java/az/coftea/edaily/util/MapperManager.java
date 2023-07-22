package az.coftea.edaily.util;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.model.Teacher;
import az.coftea.edaily.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperManager implements MyMapper {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher toTeacher(NewTeacher newTeacher) {
        Teacher teacher = new Teacher();
        teacher.setName(newTeacher.getName());
        teacher.setSurname(newTeacher.getSurname());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setSchool(newTeacher.getSchool());
        teacher.setRole(newTeacher.getRole());
        teacher.setSubject(newTeacher.getSubject());
        return teacherRepository.save(teacher);
    }

    @Override
    public TeacherResponse fromTeacher(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacherResponse.getId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setSurname(teacher.getSurname());
        teacherResponse.setBirthday(teacher.getBirthday());
        teacherResponse.setSchoolId(teacher.getSchool().getId());
        teacherResponse.setCreatedAt(teacher.getCreatedAt());
        teacherResponse.setStatusName(teacher.getStatus().name());
        teacherResponse.setRoleName(teacher.getRole().name());
        teacherResponse.setSubjectName(teacher.getSubject().getName());
        return teacherResponse;
    }
}
