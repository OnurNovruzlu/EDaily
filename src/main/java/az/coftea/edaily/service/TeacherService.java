package az.coftea.edaily.service;

import az.coftea.edaily.dto.TeacherResponse;

import java.util.List;

public interface TeacherService {
    TeacherResponse getTeacher(int id);
    List<TeacherResponse> getAll();
    TeacherResponse getDirector();
    String insert(NewTeacher newTeacher);
    String delete(int id);
    String update(int id, NewTeacher newTeacher);
}
