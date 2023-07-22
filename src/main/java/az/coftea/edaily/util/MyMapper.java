package az.coftea.edaily.util;

import az.coftea.edaily.dto.*;
import az.coftea.edaily.model.Room;
import az.coftea.edaily.model.Subject;
import az.coftea.edaily.model.Teacher;

public interface MyMapper {
    Teacher toTeacher(NewTeacher newTeacher);

    TeacherResponse fromTeacher(Teacher teacher);

    Subject toSubject(NewSubject newSubject);

    SubjectResponse fromSubject(Subject subject);

    Room toRoom(NewRoom newRoom);

    RoomResponse fromRoom(Room room);
}
