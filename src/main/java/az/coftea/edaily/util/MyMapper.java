package az.coftea.edaily.util;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.model.Teacher;

public interface MyMapper {
    Teacher toTeacher(NewTeacher newTeacher);

    TeacherResponse fromTeacher(Teacher teacher);
}
