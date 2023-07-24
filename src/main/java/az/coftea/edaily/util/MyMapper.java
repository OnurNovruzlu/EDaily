package az.coftea.edaily.util;

import az.coftea.edaily.dto.*;
import az.coftea.edaily.model.*;

public interface MyMapper {
    Teacher toTeacher(NewTeacher newTeacher);
    TeacherResponse fromTeacher(Teacher teacher);
    Subject toSubject(NewSubject newSubject);
    SubjectResponse fromSubject(Subject subject);
    School toSchool(NewSchool newSchool);
    SchoolResponse fromSchoolToAll(School school);
    SchoolResponseS fromSchoolToSimple(School school);
    Room toRoom(NewRoom newRoom);
    RoomResponse fromRoom(Room room);
    Student toStudent(NewStudent newStudent);
    StudentResponse fromStudent(Student student);

}
